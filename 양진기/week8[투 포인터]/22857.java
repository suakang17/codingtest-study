import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;  // 왼쪽 포인터
        int r = 0;  // 오른쪽 포인터
        int odd = 0;
        int even = 0;

        if(arr[0] % 2 == 0) even++; // 첫번째 인덱스가 짝수
        else odd++; // 첫번째 인덱스가 홀수

        int answer = even;
        // R, L의 사이에 홀수의 갯수가 K개 초과면 L증가, 반대는 R증가
        while(r >= l){
            if(odd > k){    // 홀수의 개수가 k보다 초과하면 왼쪽 포인터 증가
                if(arr[l] % 2 == 0) even--; // 왼쪽 포인터가 짝수
                else odd--; // 왼쪽 포인터가 홀수
                l++;    // 왼쪽 포인터 이동
            } else {    // 홀수의 개수가 k보다 작거나 같으면 오른쪽 포인터 증가
                r++;    // 오른쪽 포인터 이동
                if(r >= n) break;   // 오른쪽 포인터가 수열 크기 이상이면 종료
                if(arr[r] % 2 == 0) even++;
                else odd++;
                answer = Math.max(answer, even);
            }
        }
        System.out.println(answer);
    }
}