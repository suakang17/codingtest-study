import java.io.*;
import java.util.*;

class Main{
    static int n, e;
    static ArrayList<ArrayList<Node>> a; // 인접리스트
    static int[] dist;  // 시작점에서 각 정점으로 가는 최단거리
    static boolean[] check; // 방문 확인
    static final int INF = 200_000_000; // 간선 최대 개수 200,000, 가중치 최대값 1,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        a = new ArrayList<>();
        dist = new int[n + 1];
        check = new boolean[n + 1];

        Arrays.fill(dist, INF);

        for(int i=0; i<=n; i++){
            a.add(new ArrayList<>());
        }

        // 양방향 인접 리스트로 구현
        for(int i=0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // start에서 end로 가는 weight (가중치)
            a.get(start).add(new Node(end, weight));

            // end에서 start로 가는 weight (가중치)
            a.get(end).add(new Node(start, weight));
        }

        // 반드시 거쳐야 하는 정점
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> n 으로 가는 경우
        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, n);

        // 1 -> v2 -> v1 -> n으로 가는 경우
        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, n);

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

        System.out.println(ans);

    }

    // 다익스트라 알고리즘
    static int dijkstra(int start, int end){
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[n + 1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;

            if(check[cur]) continue;
            check[cur] = true;

            for(Node node : a.get(cur)){
                if(!check[node.end] && dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
        return dist[end];
    }
}

class Node implements Comparable<Node> {

    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
