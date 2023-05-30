import java.io.*;
import java.util.*;

class Main{
    static int n;
    static int result = 0;
    static int max_node = 0;
    static ArrayList<Edge>[] nodes;

    static class Edge{  // 트리(그래프) 저장용
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static class Node{ // BFS 탐색용
        int idx;
        int cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        nodes = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            nodes[i] = new ArrayList<>();   // 배열이라는 최상단 폴더에 ArrayList<Edge>라는 하위폴더
        }

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fromNode = Integer.parseInt(st.nextToken());    // 먼저 정점 번호가 주어지고
            while(true){
                int toNode = Integer.parseInt(st.nextToken()); // 하나는 정점번호,
                if(toNode == -1) break; // 마지막에는 -1이 입력으로 주어진다

                int weight = Integer.parseInt(st.nextToken()); // 다른 하나는 그 정점까지의 거리이다

                nodes[fromNode].add(new Edge(toNode, weight));  // 배열이라는 최상단 폴더에 ArrayList<Edge>라는 하위폴더
            }
        }

        // 임의의 노드는 1로 지정 (1이 아니어도 됨)
        // 노드 1에서 가장 멀리 떨어진 노드와의 거리를 result에 저장
        // 노드 1에서 가장 멀리 떨어진 노드는 max_node로 저장됨
        bfs(1);

        // max_node에서 가장 멀리 떨어진 노드와의 거리를 result에 저장
        bfs(max_node);

        System.out.println(result);
    }

    static void bfs(int start){

        boolean[] visited = new boolean[n + 1]; // 방문 체크 배열

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));  // 초기값 추가
        visited[start] = true;  // 초기값 방문 true

        int max_cnt = 0;

        while(!queue.isEmpty()){
            Node now = queue.poll();    // 맨 앞의 값 가져오기

            if(now.cnt > max_cnt){
                max_cnt = now.cnt;  // 가장 멀리 떨어진 노드의 거리
                max_node = now.idx; // 가장 멀리 떨어진 노드의 번호
            }

            for(Edge e : nodes[now.idx]){   // nodes[1]에 해당하는 ArrayList<Edge>
                if(!visited[e.end]){        // toNode에 방문하지 않았다면
                    visited[e.end] = true;  // 방문했다고 바꾸고
                    // 다음 노드를 큐에 추가 (현재의 거리에 다음 노드의 가중치를 더함)
                    queue.add(new Node(e.end, now.cnt + e.weight));
                }
            }
        }
        result = Math.max(result, max_cnt);
    }
}