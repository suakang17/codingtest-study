package boj.dp;

import java.io.*;
import java.util.*;

public class _11726 {
    
    static Scanner sc = new Scanner(System.in);

    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        
        N = sc.nextInt();
        dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;

        for(int n = 3; n <= N; n++) {
            dp[n] = (dp[n-1] + dp[n-2]) % 10007;
        }

        System.out.println(dp[N]);
    }
}

// * goal 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지
// 겹치는 구조, 최적 구조 -> dp
// dp table 정의 dp[n] == n일때 방법의 수
// dp[1] = 1, dp[2] = 2
// dp[3] = dp[2] + dp[1]
// dp[4] = dp[3] + dp[2]

// => dp[n] = dp[n-1] + dp[n-2]