package boj.solvedac;

import java.io.*;
import java.util.*;

public class _2294 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] vals, dp;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        vals = new int[N];
        for(int n = 0; n < N; n++) {
            vals[n] = Integer.parseInt(br.readLine());
        }

        dp = new int[K+1];
        for(int k = 1; k <= K; k++) {
            dp[k] = 100001;
        }

        for(int i = 0; i < N; i++) {  // 동전 n개 하나씩 
            for(int j = vals[i]; j <= K; j++) {  // 사실상 table값 갱신되는 부분은 j == vals[i]부터
                dp[j] = Math.min(dp[j], dp[j-vals[i]] + 1);
            }
        }

        // System.out.println(dp[0]);
        System.out.println(dp[K] == 100001 ? -1 : dp[K]);
    }
}


// ** goal 동전 개수 최소로 사용 -> 합 k원 만들기
// 사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우

// dp table 정의 -> dp[k] == k원 만드는 동전 수 min

// ! 동전의 가치는 100,000보다 작거나 같은 자연수 