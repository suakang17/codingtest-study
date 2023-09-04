package boj.graph;

import java.io.*;
import java.util.*;

public class _2178 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] graph;
    static boolean[][] visited;
    static int N;
    static int M;
    static int cnt = 0;

    // 상 우 하 좌
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int n = 0; n < N; n++) {
            String str = br.readLine();

            for(int i = 0; i < str.length(); i++) {
                graph[n][i] = str.charAt(i) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(graph[N-1][M-1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[y][x] = true;

        while(!q.isEmpty()) {
            int nowX = q.peek()[0];
            int nowY = q.peek()[1];
            q.poll();

            for(int d = 0; d < 4; d++) {
                int nextX = nowX + dx[d];
                int nextY = nowY + dy[d];

                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                    if(!visited[nextY][nextX] && graph[nextY][nextX] == 1) {
                        visited[nextY][nextX] = true;
                        q.add(new int[] {nextX, nextY});
                        graph[nextY][nextX] = graph[nowY][nowX] + 1;    // queue의 동작 방식을 보면 최단경로가 구해짐을 알 수 있다.
                    }
                }

            }
        }
    }
}
