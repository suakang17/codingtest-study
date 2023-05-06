import java.io.*;
import java.util.*;

class Main{
    static int n, m, w;
    static int[] dist;
    static ArrayList<ArrayList<Node>> a;
    static final int INF = 987_654_321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(TC-- > 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            dist = new int[n + 1];
            a = new ArrayList<>();

            for(int i=0; i<=n; i++){
                a.add(new ArrayList<>());
            }
            // M+W+1번째 줄까지
            for(int i=0; i < m + w; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                if(i < m) { // 도로는 양방향 그래프
                    a.get(start).add(new Node(end, weight));
                    a.get(end).add(new Node(start, weight));
                } else {    // 웜홀은 단방향 그래프
                    a.get(start).add(new Node(end, -weight));
                }
            }

            boolean isMinusCycle = false;
            /*
                임의의 정점을 출발점으로 하는 경우와 여러 정점을 출발점으로 하는 경우가 있다.
                아래는 여러 정점을 출발점으로 하는 경우이다.
                음수 사이클이 발생하는지 확인하는 조건을 작성할 때 주의해야 한다
             */
            for(int i=1; i<=n; i++){
                if(bellmanFord(i)){
                    isMinusCycle = true;
                    sb.append("YES\n"); // 음수 사이클이 발생하면 출발 위치로 돌아오는 것이 가능
                    break;
                }
            }

            if(!isMinusCycle){
                sb.append("NO\n"); // 음수 사이클이 발생하지 않으면 출발 위치로 돌아오는 것이 불가능
            }
        }

        System.out.println(sb);
    }

    // 벨만포드 알고리즘
    static boolean bellmanFord(int start){
        Arrays.fill(dist, INF);
        dist[start] = 0;    // 시작점은 0으로 초기화
        boolean update = false;

        // (정점의 개수 - 1)번 동안 최단거리 초기화 작업을 반복함.
        for(int i=1; i<n; i++){
            update = false;

            // 최단거리 초기화
            for(int j=1; j<=n; j++){
                for(Node node : a.get(j)){
                    // dist[i] != INF -> 아직 방문하지 않은 단절된 곳 -> 시작점이 될 수 없다
                    if(dist[j] != INF && dist[node.end] > dist[j] + node.weight){
                        dist[node.end] = dist[j] + node.weight;
                        update = true;
                    }
                }
            }

            // 더 이상 최단거리 초기화가 일어나지 않았을 경우 반복문을 종료.
            if(!update){
                break;
            }
        }

        // (정점의 개수 - 1)번까지 계속 업데이트가 발생했을 경우
        // (정점의 개수)번도 업데이트 발생하면 음수 사이클이 일어난 것을 의미함.
        if(update){
            for(int i=1; i<=n; i++){
                for(Node node : a.get(i)){
                    if(dist[i] != INF && dist[node.end] > dist[i] + node.weight){
                        return true;
                    }
                }
            }
        }
        return false;
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