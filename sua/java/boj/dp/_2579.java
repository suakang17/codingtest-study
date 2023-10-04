package boj.dp;

import java.io.*;
import java.util.*;

public class _2579 {
    
    static Scanner sc = new Scanner(System.in);

    static int N;
    static int[] dp, val;
    static Integer[] dpTD;

    public static void main(String[] args) throws IOException {
        
        N = sc.nextInt();
        val = new int[N+1];
        dp = new int[N+1];
        dpTD = new Integer[N+1];

        for(int n = 1; n <= N; n++) {
            val[n] = sc.nextInt();
        }

        // dp[1] = val[1];

        // if (N >= 2) {
		// 	dp[2] = val[1] + val[2];
		// }

        // for(int n = 3; n <= N; n++) {
        //     dp[n] = Math.max(dp[n-2], dp[n-3] + val[n-1]) + val[n];
        // }

        // System.out.println(dp[N]);

        dpTD[0] = 0;
        dpTD[1] = val[1];
        if(N >= 2) {
            dpTD[2] = val[1] + val[2];
        }
        System.out.println(find(N));
    }

    private static int find(int n) {
        if(dpTD[n] == null) {
            dpTD[n] = Math.max(find(n-2), find(n-3) + val[n-1]) + val[n];
        }
        return dpTD[n];
    }
}

// * goal 총점 최댓값
// 누적합의 최댓값 -> dp
// dp[n] = Math.max(dp[n-2], dp[n-3] + val[n-1]) + val[n]