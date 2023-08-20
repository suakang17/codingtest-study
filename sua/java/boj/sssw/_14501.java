package boj.sssw;

import java.io.*;
import java.util.*;

public class _14501 {
    
    static int N;
    static int[] T, P;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int max = Integer.MIN_VALUE;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        T = new int[N]; // 완료하는데 걸리는 기간
        P = new int[N]; // 받을 수 있는 금액
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            T[n] = Integer.parseInt(st.nextToken());
            P[n] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1];
        
        for(int n = 0; n < N; n++) {
            int endDate = n + T[n];
            if(endDate <= N) {
                dp[endDate] = Math.max(dp[n] + P[n], dp[endDate]);  // n날 상담진행 vs. 안진행
            }
            dp[n+1] = Math.max(dp[n+1], dp[n]);
        }

        System.out.println(dp[N]);
    }
}


// 최대수익 조합
// max(N) == 15 -> 15! 불가 -> dp
// '수익' 테이블 정의 dp[날짜] = T날까지의 최대 수익