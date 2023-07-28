package boj.graph;

import java.io.*;
import java.util.*;

public class _24480 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int trail;
    public static void main(String[] args) throws IOException{
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        trail = 1;

        for(int n = 0; n < N + 1; n++){
            graph.add(new ArrayList<>());
        }

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());        

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1; i < graph.size(); i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        dfs(R);

        for(int i = 1; i < visited.length; i++){
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);

    }

    private static void dfs(int node) {
        visited[node] = trail++;
        
        for(int i = 0; i < graph.get(node).size(); i++) {
            if(visited[graph.get(node).get(i)] == 0) {
                dfs(graph.get(node).get(i));
            }
        }
    }
}
