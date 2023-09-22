package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1267 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int V, E;
    static Queue<Integer> q;
    static int[] inDegree;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        
        for(int t = 1; t <= 10; t++) {
            sb = new StringBuilder("#" + t + " ");
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            inDegree = new int[V+1];
            graph = new ArrayList<>();
            for(int v = 0; v < V+1; v++) {
                graph.add(v, new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph.get(from).add(to);
                inDegree[to]++;
            }

            topologicalSort();
            System.out.println(sb);
        }
    }

    private static void topologicalSort() {
        q = new LinkedList<>();
        for(int i = 1; i < inDegree.length; i++) {
            if(inDegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            List<Integer> l = graph.get(cur);

            for(int i = 0; i < l.size(); i++) {
                inDegree[l.get(i)]--;
                if(inDegree[l.get(i)] == 0) q.add(l.get(i));
            }
        }
    }
}
