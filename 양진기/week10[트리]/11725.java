import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

        // 노드 개수만큼 트리에 추가
        for(int i=0; i<=N; i++){    // 트리의 개수는 N개. ArrayList는 0, 1부터 N까지 쓸것
            tree.add(new ArrayList<>());
        }

        // 입력값을 받아 트리에 입력
        StringTokenizer st;
        for(int i=0; i<N-1; i++){ // 트리의 간선은 N-1개
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.valueOf(st.nextToken());
            int node2 = Integer.valueOf(st.nextToken());

            // 트리는 무방향이기 때문에 양쪽에 정보 추가
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }

        boolean visited[] = new boolean[N+1];   // 방문 체크 배열
        int[] parentNode = new int[N+1];        // 부모 노드 저장 배열

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);       // 루트 노드가 1이기 때문에 1부터 시작
        visited[1] = true;  // 루트 노드 방문 체크
        while(!queue.isEmpty()){    // 큐에 값이 있으면
            int v = queue.poll();   // 맨 앞의 값 가져옴(부모 노드)
            for(int node : tree.get(v)){    // v안에 있는 node는 자식 노드임 (트리는 인접한 것이 형제일 수 없다)
                if(!visited[node]){         // 방문하지 않은 노드라면
                    visited[node] = true;   // 방문한 것으로 바꾸고
                    queue.add(node);        // 큐에 노드 추가
                    parentNode[node] = v;   // 루트부터 아래 방향으로 찾으므로 v는 부모노드, node는 자식 노드
                }
            }
        }
        for(int i=2; i<=N; i++){    // 부모 노드 번호를 2번 노드부터 순서대로 출력
            System.out.println(parentNode[i]);
        }
    }
}