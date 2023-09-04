package swea.solvingclub;

import java.io.*;
import java.util.*; 
public class _2105 {
    
    static int T, N, startR, startC, ret, max;
    static int[][] arr;

    static Queue<int[]> q;
    static boolean[][] visited;
    static boolean[] visitedNum;

    // N(시작)ESW
    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {1, -1, -1, 1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < N; m++) {
                    arr[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            max = Integer.MIN_VALUE;

            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    // startR = r;
                    // startC = c;
                    visited = new boolean[N][N];
                    visitedNum = new boolean[101];
                    // dfs(r, c, -1, -1, 0, 0);
                    int ret = route(r, c);
                    max = Math.max(ret, max);
                }
            }

            sb.append(max);
            System.out.println(sb);
        }
    }

    private static void dfs(int r, int c, int prevX, int prevY, int cnt, int dir) {

        for (int d = dir; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
        
            if(nr < 0 || nc < 0 || nr >= N || nc >= N || visitedNum[arr[nr][nc]] || visited[nr][nc]) continue;
            if(nr == startR && nc == startC) {
                ret = Math.max(ret, cnt + 1);
                if(ret < 4) { ret = -1; }
                return;
            }
            
            visitedNum[arr[nr][nc]] = true;
            visited[nr][nc] = true;
            dfs(nr, nc, r, c, cnt + 1, d);
            visitedNum[arr[nr][nc]] = false;
            visited[nr][nc] = false;
        }
    }
}

// 사각형 모양을 그리며 출발한 위치 돌아와야
// 같은 숫자 중복 x
// max sum

// 분기 존재 -> dfs or bfs