import java.util.*;
import java.io.*;

class Main{
    static int N, M, V;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] isVisit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        isVisit = new boolean[N + 1];
        sb = new StringBuilder();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){ // 간선 연결 상태 저장
            st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());

            // 무방향이기 때문에 양쪽으로 정보를 추가
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        for (int i=1; i<=N; i++){
            Collections.sort(graph.get(i));
        }

        dfs(V);

        isVisit = new boolean[N + 1];
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int vertex){
        isVisit[vertex] = true;
        sb.append(vertex + " ");    // 현재 방문한 값 저장

        for(int i : graph.get(vertex)){ // i의 변수에 현재 방문한 노드에 해당하는 리스트에 담겨있는 값들을 하나씩 할당
            if(!isVisit[i]){
                dfs(i); // 다음 방문할 노드 값으로 바꾸어 재귀 함수 실행
            }
        }
    }

    static void bfs(int vertex){
        isVisit[vertex] = true;

        // 시작점도 Queue에 넣어줘야 한다.
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);

        // Queue가 empty가 될 때까지 반복하고 방문 정점을 확인, 출력 후 Queue에 넣어 순서대로 확인
        while(!q.isEmpty()){
            int a = q.poll();
            sb.append(a + " ");
            for(int i : graph.get(a)){
                if(!isVisit[i]){
                    q.add(i);
                    isVisit[i] = true;
                }
            }
        }
    }
}