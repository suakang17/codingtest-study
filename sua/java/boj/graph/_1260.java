package boj.graph;

import java.io.*;
import java.util.*;

public class _1260 {

    static int N, M, V;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static Queue<Integer> q;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
			graph.add(i, new ArrayList<Integer>());
		}

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for(ArrayList<Integer> inner : graph) {
            Collections.sort(inner);
        }

        visited = new boolean[N+1];
        sb = new StringBuilder();
        dfs(V);
        System.out.println(sb);

        visited = new boolean[N+1];
        q = new LinkedList<>();
        sb = new StringBuilder();
        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int vertex) {

        if(!visited[vertex]) {
            visited[vertex] = true;
            sb.append(vertex).append(" ");

            for(int v : graph.get(vertex)) {
                if(!visited[v]) {
                    dfs(v);
                }
            }
        }
    }

    private static void bfs(int vertex) {

        if(!visited[vertex]) {
            q.add(vertex);
            visited[vertex] = true;

            while(!q.isEmpty()) {
                vertex = q.poll();
                sb.append(vertex).append(" ");
                for(int v : graph.get(vertex)) {
                    if(!visited[v]) {
                        q.add(v);
                        visited[v] = true;
                        
                    }
                }
            }
        }
    }
}

// 정점번호 오름차순 