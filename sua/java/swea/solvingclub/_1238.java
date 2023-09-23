package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1238 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int L, start;
    static int[][] graph;
    static int[] visited;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        
        for(int t = 1; t <= 10; t++) {
            sb = new StringBuilder("#" + t + " ");
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            graph = new int[101][101];
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i < L/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from][to] = 1;
            }

            visited = new int[101];
            // System.out.println(start);
            System.out.println(sb .append(bfs(start)));
        }
    }

    private static int bfs(int v) {
        q = new LinkedList<>();
        q.add(v);
        // System.out.println(v + "added");
        int depth = 1;
        visited[v] = depth;

        while(!q.isEmpty()) {
            v = q.poll();

            for(int i = 1; i < 101; i++) {
                if(graph[v][i] == 1 && visited[i] == 0) {
                    q.add(i);
                    // System.out.println(i + "added");
                    visited[i] = visited[v] + 1;
                }
            }
            depth = Math.max(depth, visited[v]);
        }

        for(int i = 100; i > 0; i--){
            if(visited[i] == depth){
                return i;
            }
        }
        return -1;
    }
}

// ** goal 비상연락망, 연락 시작 당번 -> 가장 나중에 연락받는 사람 중 번호 max