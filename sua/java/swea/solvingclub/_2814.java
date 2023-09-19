package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _2814 {
    
    static int T, N, M, max;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for(int n = 0; n < N+1; n++) {
                graph.add(n, new ArrayList<Integer>());
            }

            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }

            max = Integer.MIN_VALUE;
            for(int n = 1; n < N+1; n++) {
                visited = new boolean[N+1];
                dfs(n, 1);
            }

            sb.append(max);
            System.out.println(sb);
        }
    }

    public static void dfs(int node, int len) {

        visited[node] = true;
        for(int nextNode : graph.get(node)) {
            if(!visited[nextNode]) {
                dfs(nextNode, len+1);
                visited[nextNode] = false;
            }
        }
        max = Math.max(max, len);
    }
}
