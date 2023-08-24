package boj.sssw;

import java.io.*;
import java.util.*;

public class _1890 {
    
    static int N;
    static int[][] board;
    static long[][] dp;  // max 2^63 - 1

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        // input
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new long[N][N];
        dp[0][0] = 1; // 시작점 도달 방법 1가지

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < N; m++) {
                board[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        // bottom-up 
        for(int c = 0; c < N; c++) {
            for(int r = 0; r < N; r++) {
                int jump = board[c][r];
                if(jump == 0) { break; }

                if(c+jump < N) dp[c+jump][r] += dp[c][r];
                if(r+jump < N) dp[c][r+jump] += dp[c][r];
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}


// 0,0 -> N-1, N-1
// board[i][j] == 현재 칸에서 갈 수 있는 거리
// c++ r++로만 이동 가능
// 0: 종착점

// dfs완탐 -> 2^63-1 -> 시간초과
// 겹치는부분, 최적부분해 존재 -> dp

// dp table 정의
// dp[i][j] i, j에 도착하는 가짓수 -> bottom-up
// 다음 이동 칸에 대한 구현은 E, S 두가지 (중간에 방향 전환 x)

// board[i][j] -> board[i+board[i][j]][j] or board[i][j+board[i][j]]
// dp[i+board[i][j]][j] += dp[i][j] && dp[i][j+board[i][j]] += dp[i][j]