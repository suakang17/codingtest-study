package boj.graph;

import java.io.*;
import java.util.*;

public class _1012 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int T;
    static int N;
    static int M;
    static int K;

    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] territory;
    static int areaNum;
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            areaNum = 0;
            st = new StringTokenizer(br.readLine());
            
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            territory = new int[N*M];
            visited = new boolean[N][M];

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br. readLine());

                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());

                graph[cy][cx] = 1;
                }
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(graph[i][j] == 1 && !visited[i][j]) {
                        areaNum++;
                        dfs(j, i);
                    }
                }
            }
            System.out.println(areaNum);
        }
    }
    
    private static void dfs(int x, int y) {

        if(!visited[y][x]) {
            visited[y][x] = true;

            for(int i = 0; i < 4; i++) {
                if(x + dx[i] >= 0 && x + dx[i] < M && y + dy[i] >= 0 && y + dy[i] < N) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];

                    if(!visited[nextY][nextX] && graph[nextY][nextX] == 1) {
                        dfs(nextX, nextY);
                    }
                }
            }
        }
    }
}
