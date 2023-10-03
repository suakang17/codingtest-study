package boj.dp;

import java.io.*;
import java.util.*;

public class _11048 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N+1][M+1];
        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 1; m <= M; m++) {
                if(n == 1 && m == 1) dp[n][m] = Integer.parseInt(st.nextToken());
                else dp[n][m] = Math.max(dp[n-1][m-1], Math.max(dp[n][m-1], dp[n-1][m])) + Integer.parseInt(st.nextToken()); 
            }
        }

        System.out.println(dp[N][M]);
    }
}

// * goal (1,1) to (N,M) 일때 가져갈 수 있는 사탕 max개수
// 1 bfs -> 완탐 O(10^7) x
// 2 갱신 방향으로만 이동 -> dp -> 시간 줄이기
    // 1,1 부터 시작해서 해당 방향 사탕수 중 max 가져와 갱신 
    // dp table 정의 dp[n][m] = (n,m)에서 가질 수 있는 max개수
    // dp[r][c] = Math.max(dp[r][c-1]+dp[r][c], dp[r-1][c-1]+dp[r][c], dp[r-1][c]+dp[c])