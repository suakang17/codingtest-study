import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[N + 1];
        long sum = arr[0];
        int left = 0;
        int right = 1;

        while(right <= N){
            if(sum >= K){
                while(sum >= K){
                    dp[right] = Math.max(dp[right], dp[left] + sum - K);
                    sum -= arr[left++];
                }
            } else {
                dp[right] = Math.max(dp[right], dp[right - 1]);

                if(right == N) break;

                sum += arr[right++];
            }
        }

        System.out.println(dp[N]);
    }
}