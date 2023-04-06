import java.util.*;
import java.io.*;

class Main{

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){

            int key = Integer.parseInt(st.nextToken());

            // upperBound와 lowerBound의 차이 값을 구한다.
            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(" ");;
        }
        System.out.println(sb);

    }

    // key 이상의 값(포함)
    static int lowerBound(int[] arr, int key){
        int low = 0;            // 왼쪽 끝 인덱스
        int high = arr.length;  // 오른쪽 끝 인덱스

        // low가 high랑 같아질 때까지 반복
        while(low < high){

            int mid = low + ((high - low) / 2);     // 중간 위치를 구한다.

            // key 값이 중간 위치의 값보다 작거나 같을 경우
            // (중복 원소에 대해 왼쪽으로 탐색하도록 상한을 내린다.)
            if(key <= arr[mid]){
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    // key 초과한 값
    static int upperBound(int[] arr, int key){
        int low = 0;
        int high = arr.length;

        // low가 high랑 같아질 때까지 반복
        while(low < high){

            int mid = low + ((high - low) / 2);    // 중간 위치를 구한다.

            // key값이 중간 위치의 값보다 작을 경우
            if(key < arr[mid]){
                high = mid;
            }
            // 중복원소의 경우 else에서 처리된다.
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}