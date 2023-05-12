import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);   // 오름차순 정렬

        int start = 0;
        int end = n-1;

        int ans1 = 0;
        int ans2 = 0;

        int gap = Integer.MAX_VALUE;
        int temp, sum;
        while(start < end){ // 왼쪽 포인터가 오른쪽 포인터보다 작을 때까지
            sum = arr[start] + arr[end];    // 합 구하기
            temp = Math.abs(sum);           // 합의 절대값 구하기
            if(temp < gap){                 // 방금 구한 절댓값이 이전에 저장한 차이값보다 작은가
                gap = temp;                 // 최소 차이값 갱신
                ans1 = arr[start];          // 정답1 갱신
                ans2 = arr[end];            // 정답2 갱신
            }
            if(sum > 0){    // 둘의 차이가 양수면 오른쪽 포인터를 왼쪽으로 움직여 0에 가깝게
                end--;
            } else {        // 둘의 차이가 음수면 왼쪽 포인터를 오른쪽으로 움직여 0에 가깝게
                start++;
            }
        }
        System.out.println(ans1 + " " + ans2);

    }
}