package boj.graph;

import java.io.*;
import java.util.*;

public class _7562 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;
    static int[][] graph;
    static boolean[][] visited;
    static int l;

    // [0]: y, [1]: x
    static int[] cur = new int[2];
    static int[] des = new int[2];

    static int[][] moves = {{-1, -2}, {-2, -1}, {2, 1}, {1, 2}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}};
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
            l = Integer.parseInt(br.readLine());
            graph = new int[l][l];
            visited = new boolean[l][l];
            
            st = new StringTokenizer(br.readLine());
            cur[1] = Integer.parseInt(st.nextToken());
            cur[0] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            des[1] = Integer.parseInt(st.nextToken());
            des[0] = Integer.parseInt(st.nextToken());

            // 최소이동 bfs
            bfs(cur[1], cur[0]);
            System.out.println(graph[des[0]][des[1]]);

            // cnt 사용 ver.
            // int cnt = bfs(cur[1], cur[0]);
            // System.out.println(cnt);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[] {x, y});

        while(!q.isEmpty()) {
            int nowX = q.peek()[0];
            int nowY = q.peek()[1];
            q.poll();


            for(int i = 0; i < moves.length; i++) {
                int nextX = nowX + moves[i][1];
                int nextY = nowY + moves[i][0];

                if(nextX >= 0 && nextX < l && nextY >= 0 && nextY < l) {
                    if(!visited[nextY][nextX]) {
                        q.add(new int[] {nextX, nextY});
                        visited[nextY][nextX] = true;
                        graph[nextY][nextX] = graph[nowY][nowX] + 1;
                    }
                }
            }
        }
        
    }

    // private static int bfs(int x, int y) {
    //     Queue<int[]> q = new LinkedList<>();
    //     visited[y][x] = true;
    //     q.add(new int[] {x, y, 0});

    //     while(!q.isEmpty()) {
    //         int nowX = q.peek()[0];
    //         int nowY = q.peek()[1];
    //         int cnt = q.peek()[2];
    //         q.poll();

    //         if(nowX == des[1] && nowY == des[0]) { return cnt; }


    //         for(int i = 0; i < moves.length; i++) {
    //             int nextX = nowX + moves[i][1];
    //             int nextY = nowY + moves[i][0];

    //             if(nextX >= 0 && nextX < l && nextY >= 0 && nextY < l) {
    //                 if(!visited[nextY][nextX]) {
    //                     q.add(new int[] {nextX, nextY, cnt + 1});
    //                     visited[nextY][nextX] = true;
    //                     graph[nextY][nextX] = graph[nowY][nowX] + 1;
    //                 }
    //             }
    //         }
    //     } return 0;
        
    // }
}
