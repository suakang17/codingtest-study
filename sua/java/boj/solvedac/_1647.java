package boj.solvedac;

import java.io.*;
import java.util.*;

public class _1647 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] parent, height;
    static ArrayList<Edge> edgeList;
    static PriorityQueue<Edge> pq;

    private static class Edge implements Comparable<Edge> {
        int n1;
        int n2;
        int w;

        public Edge(int n1, int n2, int w) {
            this.n1 = n1;
            this.n2 = n2;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        height = new int[N+1];
        for(int n = 1; n <= N; n++) {
            parent[n] = n;
            height[n] = 1;
        }

        edgeList = new ArrayList<>();
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(A, B, C));
        }

        System.out.println(kruskal());
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;
        if(height[x] > height[y]) {  // x higher
            parent[y] = x;
        } else {
            parent[x] = y;
        }
        if(height[x] == height[y]) height[y]++;

    }
    
    private static int kruskal() {
        pq = new PriorityQueue<>(edgeList);
        int ret = 0;
        int max = 0;
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            int n1 = cur.n1;
            int n2 = cur.n2;
            int w = cur.w;

            if(find(n1) == find(n2)) continue;
            union(n1, n2);
            ret += w;
            max = w;
        }

        ret -= max;
        return ret;
    }
}

// ** goal 없애고 남은 길 유지비 합 min

// N개의 집과 그 집들을 연결하는 M개의 길 (양방향)
// 길 -> 유지비 존재
// 모든 집 간에는 경로 항상 존재

// 1 mst 하나 만들고 가중치 높은 간선부터 빼면서 언제 마을이 두개로 분리되는지 확인
    // 크루스칼 -> 1개 MST 생성
    // 간선 가중치 MAX 빼기