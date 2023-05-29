import java.util.*;
import java.io.*;

class Main{
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testcase = 1;

        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   // 정점
            int m = Integer.parseInt(st.nextToken());   // 간선

            if(n == 0 && m == 0) break;

            // 그래프 초기화
            graph = new ArrayList<>();
            for(int i=0; i<=n; i++){
                graph.add(new ArrayList<>());
            }

            // 그래프 구성
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 양방향 추가
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            visited = new boolean[n + 1];

            int count = 0;  // 트리 개수
            // 여러 트리가 존재할 수 있으므로 모든 노드를 검사해봄
            for(int i=1; i<=n; i++){
                if(!visited[i]){
                    count += checkTree(i);
                }
            }

            if(count == 0){
                sb.append("Case " + testcase++ + ": No trees.");
            } else if (count == 1){
                sb.append("Case " + testcase++ + ": There is one tree.");
            } else {
                sb.append("Case " + testcase++ + ": A forest of " + count + " trees.");
            }
            sb.append("\n");
        } // end of while(true)
        bw.write(sb.toString());
        bw.close();
        br.close();
    } // end of main

    /**
     트리의 경우 노드 개수 = 간선 개수 + 1을 활용
     양방향 간선으로 그래프를 구성하였으므로 간선 개수가 2배
     node = (edge / 2) + 1이면 트리이다.

     @param start 시작점
     @return 트리이면 1, 아니면 0
     */
    static int checkTree(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int node = 0;
        int edge = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            node += 1;  // 큐에 정점이 담겼으므로 +1
            visited[cur] = true;

            for(int next : graph.get(cur)){
                edge += 1;  // 다음 정점이 있다는 것은 간선이 있다는 것 +1
                if(!visited[next]){
                    queue.offer(next);
                }
            }
        }
        return (edge / 2) + 1 == node ? 1 : 0;  // 트리면 1, 아니면 0
    }
}