import java.io.*;
import java.util.*;

class Main{
    static int n, m;
    static ArrayList<ArrayList<Node>> a;
    static long[] dist; // 자료형을 int로 할 경우 오버플로우 발생
    static final int INF = 987_654_321;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 도시의 개수
        m = Integer.parseInt(st.nextToken());   // 버스 노선의 개수

        a = new ArrayList<>();  // 인접 리스트
        dist = new long[n + 1]; // 최단거리 배열

        for(int i=0; i<=n; i++){
            a.add(new ArrayList<>());
            dist[i] = INF;
        }

        // 단방향 인접리스트 구현
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            a.get(A).add(new Node(B, C));
        }

        StringBuilder sb = new StringBuilder();
        if (bellmanFord()) {    // 음의 사이클 발생시 -1 출력
            sb.append("-1\n");
        } else{ // 음의 사이클 발생 안 할 시 값 출력
            for(int i=2; i<=n; i++){
                if(dist[i] == INF){ // 최단거리 배열에 INF가 들어가 있을 경우 INF 대신 -1 출력
                    sb.append("-1\n");
                } else {
                    sb.append(dist[i] + "\n");
                }
            }
        }
        System.out.println(sb);
    }

    static boolean bellmanFord(){   // 음의 사이클 있다면 false, 없다면 true 리턴
        dist[1] = 0;    // 시작점은 0으로 초기화
        boolean update = false;

        // (정점의 개수 - 1)번 동안 최단거리 초기화 작업을 반복함.
        for(int i=1; i<n; i++){
            update = false;

            // 최단거리 초기화
            for(int j=1; j<=n; j++){
                for(Node node : a.get(j)){
                    if(dist[j] == INF){
                        break;
                    }

                    if(dist[node.end] > dist[j] + node.weight){
                        dist[node.end] = dist[j] + node.weight;
                        update = true;
                    }
                }
            }

            // 더 이상 최단거리 초기화가 일어나지 않았을 경우 반복문을 종료
            if(!update) break;
        }

        // (정점의 개수 - 1)번까지 계속 업데이트가 발생했을 경우
        // (정점의 개수)번도 업데이트 발생하면 음수 사이클이 일어날 것을 의미함
        if(update){
            for(int i=1; i<=n; i++){
                for(Node node : a.get(i)){
                    if(dist[i] == INF){
                        break;
                    }

                    if(dist[node.end] > dist[i] + node.weight){
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