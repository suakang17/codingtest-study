import java.util.*;
import java.io.*;

class Main{
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 방문한 정점이 최대 정점의 개수만큼 있기 때문에, 정점의 개수만큼의 크기로 배열 생성
        // index 혼란을 방지하고자 0번 인덱스를 더미 데이터로 활용
        visited = new int[N+1];

        // graph의 index를 정점의 개수만큼 만들어줌
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());

            // 무방향이기 때문에 양쪽으로 정보를 추가
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        // 오름차순 정렬
        for(int i=1; i<=N; i++){
            Collections.sort(graph.get(i));
        }

        // 너비 우선 탐색 재귀 시작
        bfs(R);

        for(int i=1; i<=N; i++){
            System.out.println(visited[i]);
        }
    }

    static void bfs(int vertex){
        Queue<Integer> q = new LinkedList<>();

        int count = 1;

        q.offer(vertex);    // 큐에 정점 추가
        visited[vertex] = count++;

        while(!q.isEmpty()){    // 큐가 비어있을때까지
            int a = q.poll();   // 첫번째 값 반환 후 삭제

            // 정점 리스트 순회
            for(int i=0; i<graph.get(a).size(); i++){
                int nextV = graph.get(a).get(i);

                // 방문했던 정점이면 건너뛰기
                if(visited[nextV] != 0) continue;

                q.offer(nextV); // 다음 정점을 큐에 추가
                visited[nextV] = count++;   // 카운트 추가
            }
        }
    }
}