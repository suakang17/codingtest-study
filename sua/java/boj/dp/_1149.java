package boj.dp;

import java.io.*;
import java.util.*;

public class _1149 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][3];  // 0 r 1 g 2 b

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(n == 1) {
                dp[n][0] = r;
                dp[n][1] = g;
                dp[n][2] = b;
            } else {
                dp[n][0] = Math.min(dp[n-1][1], dp[n-1][2]) + r;
                dp[n][1] = Math.min(dp[n-1][0], dp[n-1][2]) + g;
                dp[n][2] = Math.min(dp[n-1][1], dp[n-1][0]) + b;
            }
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}

// * goal 모든 집을 칠하는 비용 min값
// dp table 정의 dp[n] == n번 집까지 칠하는 최솟값