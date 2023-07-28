package boj.graph;

import java.io.*;
import java.util.*;

public class _2667 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[] aparts = new int[25*25];
    private static int townNum = 0; // 아파트 단지 번호의 수

    static boolean[][] visited;
    static int N;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];


        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // dfs
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == 1 && !visited[i][j]) {
                    townNum++;
                    // dfs(i, j);
                    bfs(i, j);
                    }
                }
            }

        Arrays.sort(aparts);
        System.out.println(townNum);
        
        for(int i = 0; i < aparts.length; i++) {
            if(aparts[i] != 0) {
                System.out.println(aparts[i]);
            }
        }


    }

    private static void dfs(int x, int y) {

        if(!visited[x][y]) {
            visited[x][y] = true;
            aparts[townNum]++; 

            for(int idx = 0; idx < 4; idx++) {
                if(y + dy[idx] >= 0 && y + dy[idx] < N && x + dx[idx] >= 0 && x + dx[idx] < N) {
                    int nextX = x + dx[idx];
                    int nextY = y + dy[idx];
                    if(!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                        dfs(nextX, nextY);
                    }
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[] {x, y});
        aparts[townNum]++;

        while(!q.isEmpty()) {
            int nowX = q.peek()[0];
            int nowY = q.peek()[1];
            q.poll();

            for(int idx = 0; idx < 4; idx++) {
                if(nowY + dy[idx] >= 0 && nowY + dy[idx] < N && nowX + dx[idx] >= 0 && nowX + dx[idx] < N) {
                    int nextX = nowX + dx[idx];
                    int nextY = nowY + dy[idx];

                    if(graph[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        q.add(new int[] {nextX, nextY});
                        aparts[townNum]++;
                        visited[nextX][nextY] = true;

                    }
                }
            }
        }
    }
}
