import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        long max = 0;

        // 입력과 동시에 해당 랜선의 길이가 최대값인지를 확인하고 max를 갱신
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]){
                max = arr[i];
            }
        }

        // upperbound에서 리턴하는 상한값은 인덱스 범위를 1 초과하기 때문에 +1 해준다.
        max++;

        long min = 0;
        long mid = 0;

        while(min < max){

            // 범위 내에서 중간 길이를 구한다.
            mid = min + ((max - min) / 2);

            long count = 0;

            for(int i=0; i<arr.length; i++){
                count += (arr[i] / mid);
            }

            /*
                upper bound 형식

                mid 길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
                자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
                그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
             */
            if(count < N){
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        // upper bound로 얻어진 값(min)에 -1이 최대 길이가 된다.
        System.out.println(min - 1);
    }
}