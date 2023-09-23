package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1249 {
    
    static int T, N, min;
    static int[][] graph;
    static int[][] visited;
    static Queue<int[]> q;
    
    // ESWN
    static int[] dc = {1, 0, -1, 0};
    static int[] dr = {0, 1, 0, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");
            N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;

            graph = new int[N][N];
            visited = new int[N][N];

            for(int n = 0; n < N; n++) {
                String str = br.readLine();
                for(int m = 0; m < N; m++) {
                    graph[n][m] = str.charAt(m) - '0';
                    visited[n][m] = Integer.MAX_VALUE;
                }
            }
            bfs();
            System.out.println(sb.append(visited[N-1][N-1]));
        }
    }

    private static void bfs() {
        q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(!isValid(nr, nc)) continue;
                if(visited[r][c] + graph[nr][nc] < visited[nr][nc]) {
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = visited[r][c] + graph[nr][nc];
                }
            }

            // for(int i = 0; i < 4; i++) {
            //     int nr = r + dr[i];
            //     int nc = c + dc[i];

            //     if(!isValid(nr, nc) || visited[nr][nc] != Integer.MAX_VALUE) continue;
            //     if(visited[r][c] + graph[nr][nc] > visited[nr][nc]) continue;
            //     q.add(new int[] {nr, nc});
            //     visited[nr][nc] = visited[r][c] + graph[nr][nc];
            // }
        }
    }

    private static boolean isValid(int r, int c) {
        if(r < 0 || c < 0 || r >= N || c >= N) return false;
        return true;
    }
}

// ** 출발지에서 도착지까지 가는 경로 중에 복구 작업에 드는 시간이 가장 작은 경로의 복구 시간
// visited[r][c][복구시간]