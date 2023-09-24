package boj.graph;

import java.io.*;
import java.util.*;

public class _1238 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, X;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static boolean[] visited;

    static PriorityQueue<Node> pq;

    private static class Node implements Comparable<Node> {
        int n;
        int w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        visited = new boolean[N+1];
        graph = new ArrayList<>();
        for(int n = 0; n <= N; n++) {
            graph.add(new ArrayList<>());
        }
        
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(n1).add(new Node(n2, w));
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, dijkstraPQ(i, X) + dijkstraPQ(X, i));
        }

        System.out.println(max);
    }

    private static int dijkstra(int n1, int n2) {

        Arrays.fill(dist, 0, N+1, Integer.MAX_VALUE);
        dist[n1] = 0;

        for(int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int idx = 0;

            for(int j = 1; j <= N; j++) {
                if(!visited[j] && min > dist[j]) {
                    min = dist[j];
                    idx = j;
                }
            }
            visited[idx] = true;

            for(int j = 0; j < graph.get(idx).size(); j++) {
                Node n = graph.get(idx).get(j);
                dist[n.n] = Math.min(dist[n.n], dist[idx] + n.w);
            }
        }

        return dist[n2];
    }

    private static int dijkstraPQ(int n1, int n2) {

        Arrays.fill(dist, 0, N+1, Integer.MAX_VALUE);
        dist[n1] = 0;

        pq = new PriorityQueue<>();
        pq.add(new Node(n1, dist[n1]));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(dist[cur.n] < cur.w) continue;
            for(int i = 0; i < graph.get(cur.n).size(); i++) {
                Node next = graph.get(cur.n).get(i);

                if(dist[next.n] > dist[cur.n] + next.w) {
                    dist[next.n] = dist[cur.n] + next.w;
                    pq.add(new Node(next.n, dist[next.n]));
                }
            }
        }
        return dist[n2];
    }
}

// ** goal 오고 가는데 가장 오래 걸리는 학생의 소요시간

// 가중치 그래프, 최단시간, 양수 가중치 -> 다익스트라