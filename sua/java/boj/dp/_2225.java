package boj.dp;

import java.io.*;
import java.util.*;

public class _2225 {
    
    static Scanner sc = new Scanner(System.in);

    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        
        N = sc.nextInt();
        K = sc.nextInt();

        dp = new int[K+1][N+1];
        Arrays.fill(dp[1], 1);
        for (int k = 1; k <= K; k++) dp[k][0] = 1;

        for(int n = 1; n <= N; n++) {
            for(int k = 2; k <= K; k++) {
                dp[k][n] = (dp[k][n-1] + dp[k-1][n]) % 1000000000;
            }
        }
        System.out.println(dp[K][N]);

    }
}

// * goal 0~N까지 정수 K개 더해서 합이 N이 되는 경우의 수 % 1000000000
// 덧셈 순서 다르면 다른 경우, 한 수 여러번 사용 가능
// dp table 정의 dp[k][n] == k개 수 합해 n 만드는 경우의 수
// dp[k][n] = 시그마(dp[k-1][0~n]) = dp[k-1][n] + dp[k][n-1]