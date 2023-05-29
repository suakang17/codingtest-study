import java.util.*;
import java.io.*;

class Main{
    static class Node{
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static int N;
    static List<Node> list[];
    static boolean visited[];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<Node>();
        }

        for(int i=0; i<N-1; i++){    // 트리의 간선 수는 정점 - 1개
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fromNode = Integer.parseInt(st.nextToken());
            int toNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 무방향이므로 양방향에 추가
            list[fromNode].add(new Node(toNode, weight));
            list[toNode].add(new Node(fromNode, weight));
        }

        for(int i=1; i<=N; i++){
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(ans);
    }

    static void dfs(int num, int dim){
        for(Node node : list[num]){ // 시작노드에 인접한 노드를 가져온다.
            if(!visited[node.idx]){ // 방문하지 않았다면
                visited[node.idx] = true;   // 방문한 것으로 바꾸고
                dfs(node.idx, dim + node.cost); // 거리를 누적한다.
            }
        }
        ans = (ans < dim) ? dim : ans;
    }
}