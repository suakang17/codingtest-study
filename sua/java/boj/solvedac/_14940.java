package boj.solvedac;

import java.io.*;
import java.util.*;

public class _14940 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M, R, C;
    static int[][] arr, ret;

    // ESWN
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static Queue<int[]> q = new LinkedList<>();;
    public static void main(String[] args) throws IOException{
        
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        ret = new int[N][M];
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
                if(arr[n][m] == 2) {
                    ret[n][m] = 0;
                    q.add(new int[] {n, m});
                } else if (arr[n][m] == 0) {
                    ret[n][m] = 0;
                } else ret[n][m] = -1;
            }
        }

        bfs();


        for(int n = 0; n < N; n++) {
            for(int m = 0; m < M; m++) {
                sb.append(ret[n][m]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];

            for(int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(!isValid(nr, nc) || ret[nr][nc] >= 0) continue;
                ret[nr][nc] = ret[cr][cc] + 1;
                q.add(new int[] {nr, nc});
            }
        }
    }

    private static boolean isValid(int r, int c) {
        if(r < 0 || c < 0 || r >= N || c >= M) return false;
        return true;
    }
}

// *goal 모든지점 to 목표지점 거리
