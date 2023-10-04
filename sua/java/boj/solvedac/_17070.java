package boj.solvedac;

import java.io.*;
import java.util.*;

public class _17070 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] graph;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        dp = new int[N+1][N+1][3]; // 가0세1대2

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][2][0] = 1;
        
        for(int r = 1; r <= N; r++) {  
            for(int c = 3; c <= N; c++) {  // 모두 끝점 기준으로 인덱싱
                if(c-1 > 0 && graph[r][c] != 1) {
                    dp[r][c][0] = dp[r][c-1][0] + dp[r][c-1][2];
                }
                if(r-1 > 0 && graph[r][c] != 1) {
                    dp[r][c][1] += dp[r-1][c][1] + dp[r-1][c][2];
                }
                if(r-1 > 0 && c-1 > 0 && graph[r][c] != 1 && graph[r-1][c] != 1 && graph[r][c-1] != 1) {
                    dp[r][c][2] += dp[r-1][c-1][0] + dp[r-1][c-1][1] + dp[r-1][c-1][2];
                }
            }
        }

        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }
}

// * goal 파이프 한 쪽 끝을 (N, N)으로 이동시키는 방법 수 
// 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있고, 방향은 가로
// 벽1 피해서 밀기

// 한정 사분면 이동 -> dp
// dp table 정의 -> dp[r][c][direction] == r,c 를 끝으로 dir방향으로 존재하는 경우 수 -> 끝점 기준 인덱싱
    // 1 dir == 0 가로 : 2가지 (r-1, c-1) -> 가대 이동 가능
    // 2 dir == 1 세로 : 2가지 (r-1, c-1) -> 세대 이동 가능
    // 3 dir == 2 대각선 : 3가지 (r-1, c-1) -> 가세대 이동 가능

// 기저조건 dp[1][2][0] = 1;