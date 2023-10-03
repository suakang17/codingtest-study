package boj.dp;

import java.io.*;
import java.util.*;

public class _12865 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] weight, val;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weight = new int[N+1];
        val = new int[N+1];
        dp = new int[K+1][N+1];

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            weight[n] = Integer.parseInt(st.nextToken());
            val[n] = Integer.parseInt(st.nextToken());
        }

        // bottom-up
        for(int k = 0; k <= K; k++) {
            for(int i = 0; i <= N; i++) {
                if(k == 0 || i == 0) dp[k][i] = 0;
                else if(weight[i] > k) {  // 여유 무게 x
                    dp[k][i] = dp[k][i-1];
                } else {
                    dp[k][i] = Math.max(dp[k-weight[i]][i-1] + val[i], dp[k][i-1]);
                } 
            }
        }

        System.out.println(dp[K][N]);
    }
}

// ** goal 가치합 max -> dp
// dp table 정의 dp[w][i] == 무게 리밋 w, 보석 i개일때 최적 이익