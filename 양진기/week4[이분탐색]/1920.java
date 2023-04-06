import java.io.*;
import java.util.*;

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

        // 배열은 반드시 정렬되어 있어야 한다.
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){

            // 찾고자 하는 값이 있을 경우 1, 없을 경우 0을 출력해야 한다.
            if(binarySearch(Integer.parseInt(st.nextToken())) >= 0){
                sb.append(1).append("\n");
            }
            else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int binarySearch(int key){
        int low = 0;                // 탐색 범위의 왼쪽 끝 인덱스
        int high = arr.length - 1;  // 탐색 범위의 오른쪽 끝 인덱스

        // low가 high보다 커지기 전까지 반복한다.
        while(low <= high){

            int mid = (low + high) / 2;     // 중간 위치를 구한다.

            // key 값이 중간 위치의 값보다 작을 경우
            if(key < arr[mid]){
                high = mid - 1;
            }
            // key 값이 중간 위치의 값보다 클 경우
            else if(key > arr[mid]){
                low = mid + 1;
            }
            // key 값이 중간 위치의 값과 같을 경우
            else {
                return mid;
            }
        }

        // 찾고자 하는 값이 존재하지 않을 경우
        return -1;
    }
}