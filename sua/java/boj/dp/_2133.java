package boj.dp;

import java.io.*;
import java.util.*;

public class _2133 {
    static Scanner sc = new Scanner(System.in);

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        
        N = sc.nextInt();
        dp = new int[N+1];
        solution();
    }

    private static void solution() {
        if(N % 2 != 0) { 
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        for(int n = 2; n <= N; n += 2) {
            dp[n] = dp[n-2]*3;
            for(int m = n-4; m >= 0; m -= 2) {
                dp[n] += dp[m] * 2;
            }
        }

        System.out.println(dp[N]);
    }
}

// ** goal 3*N크기 벽 -> 2*1, 1*2크기로 채우는 경우의 수 -> 겹치는 부분 존재, 특정 데이터셋 출현 횟수 -> dp
// dp table dp[n] == 3*n 크기일 때 경우의 수 -> n홀짝여부로 구분
// n % 2 != 0 -> n == 1인 경우 때문에 채우기 불가 
// n % 2 == 0
    // dp[2] = 3 
    // dp[4] = dp[2]*3 + 2 => 3*3 + 2 = 11
    // dp[6] = dp[4] * dp[2] + dp[2] * 2(dp[4]의 불규칙타일수) + 2(dp[6]의 불규칙타일수)
// => dp[n] = (dp[n-2]*3) + (dp[n-4]*이전의 불규칙타일수) + 2(불규칙타일수)