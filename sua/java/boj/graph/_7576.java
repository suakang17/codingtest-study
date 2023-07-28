package boj.graph;

import java.io.*;
import java.util.*;

public class _7576 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int M;
    static int N;

    static int[][] graph;
    static Queue<int[]> q = new LinkedList<>();

    // E S W N
    static int[] dc = {1, 0, -1, 0};
    static int[] dr = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        
        String[] dimensions = br.readLine().split(" ");
        M = Integer.parseInt(dimensions[0]);
        N = Integer.parseInt(dimensions[1]);
        graph = new int[N][M];

        for(int r = 0; r < N; r++) {
            String[] str = br.readLine().split(" ");

            for(int c = 0; c < str.length; c++) {
                graph[r][c] = Integer.parseInt(str[c]);
                if(graph[r][c] == 1) {
                    q.add(new int[] {r, c});
                }
            }
        }

        // 최소 날짜 bfs
        System.out.println(bfs());
    }

    private static int bfs() {
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowR = now[0];
            int nowC = now[1];

            for(int i = 0; i < 4; i++) {
                int nextR = nowR + dr[i];
                int nextC = nowC + dr[i];

                if(nextC >= 0 && nextR >= 0 && nextC < M && nextR < N) {
                    if(graph[nextR][nextC] == 0) {
                        q.add(new int[] {nextR, nextC});
                        graph[nextR][nextC] = graph[nowR][nowC] + 1;
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        if(isZero()) { return -1; }
        else {
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++) {
                    if(max < graph[r][c]) {
                        max = graph[r][c];
                    }
                }
            }
        }

        return max;
    }

    private static boolean isZero() {
        for (int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(graph[r][c] == 0) { return true; }
                }
            }
        return false;
        }
}
