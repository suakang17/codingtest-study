package boj.graph;

import java.io.*;
import java.util.*;

public class _1697 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N;
    static int K;
    static int[] graph;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        graph = new int[100001];

        // 최단 시간 bfs
        bfs(N);
        System.out.println(graph[K]);
    }

    private static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        cnt = 0;

        while(!q.isEmpty()) {
            int now = q.poll();

            int next1 = now + 1;
            int next2 = now - 1;
            int next3 = now * 2;

            int[] next = {next1, next2, next3};

            for(int i = 0; i < 3; i++) {
                if(next[i] >= 0 && next[i] < graph.length) {
                    if(!visited[next[i]]) {
                        visited[next[i]] = true;
                        q.add(next[i]);
                        graph[next[i]] = graph[now] + 1;
                    }
                }
            }
        }
    }
}
