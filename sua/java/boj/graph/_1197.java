package boj.graph;

import java.io.*;
import java.util.*;

public class _1197 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int V, E;
    static PriorityQueue<Node> pq;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        st =  new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visited = new boolean[V+1];
        graph = new ArrayList<>();
        for(int v = 0; v <= V; v++) {
            graph.add(new ArrayList<>());
        }

        for(int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
        }

        System.out.println(prim());
    }

    private static int prim() {
        pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        int ret = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int to = cur.a;
            int w = cur.w;

            if(visited[to]) continue;
            visited[to] = true;
            ret += w;

            for(Node next : graph.get(to)) {
                if(!visited[next.a]) pq.add(next);
            }
        }

        return ret;
    }

    private static class Node implements Comparable<Node> {
        int a;
        int w;

        public Node(int a, int w) {
            this.a = a;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}

// ** goal 그래프 주어졌을 때 최소 스패닝 트리의 가중치