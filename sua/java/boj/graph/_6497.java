package boj.graph;

import java.io.*;
import java.util.*;

public class _6497 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int M, N, ret, ttl;
    static PriorityQueue<Edge> pq;
    static int[] parent, rank;
    public static void main(String[] args) throws IOException {
        
        sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if(M == 0 && N == 0) { 
                System.out.println(sb.substring(0, sb.length()-1));
                System.exit(0);
            }

            parent = new int[M+1];
            rank = new int[M+1];
            for(int m = 1; m <= M; m++) {
                parent[m] = m;
                rank[m] = 1;
            }

            int ttl = 0;
            pq = new PriorityQueue<>();
            for(int n = 1; n <= N; n++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                ttl += z;
                pq.add(new Edge(x, y, z));
            }

            ret = ttl - kruskal();
            sb.append(ret).append("\n");
        }
    }

    private static int kruskal() {
        int min = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            int p1 = find(cur.start);
            int p2 = find(cur.end);

            if(p1 != p2) {
                union(p1, p2);
                min += cur.w;
            }
        }

        return min;
    }

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int w;

        public Edge(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    private static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return; 
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            if (rank[x] == rank[y]) {
                rank[x]++;
            }
        }
    }
}

// ** goal 절약할 수 있는 최대 비용
// 하루에 길의 미터 수만큼 돈이 들어가는데, 일부를 소등하여 그만큼의 돈을 절약
// 도시에 있는 모든 두 집 쌍에 대해, 불이 켜진 길만으로 서로를 왕래할 수 있어야 -> MST