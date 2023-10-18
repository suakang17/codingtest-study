package boj.solvedac;

import java.io.*;
import java.util.*;

public class _1916 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static ArrayList<Node>[] arr;
    static int[] dp;
    static boolean[] visited;
    static PriorityQueue<Node> pq;

    static class Node implements Comparable<Node> {
        int to;
        int fee;

        Node(int to, int fee) {
            this.to = to;
            this.fee = fee;
        }

        @Override
        public int compareTo(Node o) {
            return this.fee - o.fee;
        }

    }
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
    
        
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());

            arr[from].add(new Node(to, fee));
        }

        st = new StringTokenizer(br.readLine());
        int departure = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[departure] = 0;

        dijkstra(departure);
        System.out.println(dp[destination]);
    }

    private static void dijkstra(int departure) {

        pq = new PriorityQueue<>();
        visited = new boolean[N+1];

        pq.add(new Node(departure, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int to = cur.to;
            

            if(visited[to]) continue;
            visited[to] = true;

            for(Node n : arr[to]) {
                if(dp[n.to] > dp[to] + n.fee) {
                    dp[n.to] = dp[to] + n.fee;
                    pq.add(new Node(n.to, dp[n.to]));
                }
            }
        }
    }
}

// * goal 출발 -> 도착 최소비용 -> dijkstra
// input dep arr fee