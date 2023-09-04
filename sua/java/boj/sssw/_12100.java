package boj.sssw;

import java.io.*;
import java.util.*;

public class _12100 {
    
    static int N, cnt;
    static int[][] arr;

    // NESW
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < N; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(arr, 0);
    }

    private static int getMax(int[][] board) {

        int max = Integer.MIN_VALUE;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                max = (max < board[r][c]) ? board[r][c] : max;
            }
        }

        return max;
    }

    private static void dfs(int[][] nextState, int cnt) {

        if(cnt == 6) { getMax(nextState); return; }

        for(int d = 0; d < 4; d++) {
                
            switch (d) {
                case 0:  // N
                    for(int c = 0; c < N; c++) {
                        nextState[0][c] = verticalSum(c);
                        for(int i = 1; i < N; i++) {
                            nextState[i][c] = 0;
                        }

                        dfs(nextState, cnt++);
                    }
                    break;
                    
                case 1:  // E
                    for(int r = 0; r < N; r++) {
                        nextState[r][N-1] = horizontalSum(r);
                        for(int i = 1; i < N; i++) {
                            nextState[r][i] = 0;
                        }

                        dfs(nextState, cnt++);
                    }
                    break;

                case 2:  // S
                    for(int c = 0; c < N; c++) {
                        nextState[N-1][c] = verticalSum(c);
                        for(int i = 1; i < N; i++) {
                            nextState[i][c] = 0;
                        }

                        dfs(nextState, cnt++);
                    }
                    break;

                case 3:  // W
                    for(int r = 0; r < N; r++) {
                        nextState[r][0] = horizontalSum(r);
                        for(int i = 1; i < N; i++) {
                            nextState[r][i] = 0;
                        }

                        dfs(nextState, cnt++);
                    }
                    break;
            }
        }
    }

    private static int verticalSum(int c) {
        
        int sum = 0;
        for(int i = 0; i < N; i++) { 
            sum += arr[i][c];
        }
        return sum;
    }

    private static int horizontalSum(int r) {
        int sum = 0;
        for(int i = 0; i < N; i++) { 
            sum += arr[r][i];
        }
        return sum;
    }
}


// 0은 빈 칸을 나타내며, 이외의 값은 모두 블록
// 최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록

// 분기 존재 dfs bfs
// 전체 판의 상태를 기억해야함 -> 매개변수 arr, cnt

// 0 아닌 수 or 경계 만날때까지 방향 이동 -> 각 칸에 대해 완탐 -> 20*20*4  ok
// 무조건 맨 끝으로 보내되 행, 열단위 총합으로

// ** todo d에 대해 visited 처리하기 ** //