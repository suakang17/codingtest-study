import java.util.*;
import java.io.*;

class Main{

    static int[] parent;
    static int[] plan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    // 총 정점 갯수
        int M = Integer.parseInt(br.readLine());    // 여행에 포함된 정점 갯수

        parent = new int[N+1];
        for(int i=1; i<=N; i++){    // 1부터 N까지
            parent[i] = i;  // 부모는 자기 자신으로 초기화
        }

        StringTokenizer st;
        for(int i=1; i<=N; i++){ // N개의 줄에는 N개의 정수가 주어진다.
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++){
                int num = Integer.parseInt(st.nextToken());

                // i번째 줄의 j번째 수는 i번 도시와 j번 도시의 연결 정보를 의미한다.
                if(num == 1){   // 1이면 연결된 것이고 0이면 연결이 되지 않은 것이다.
                    union(i, j);
                }
            }
        }

        // 마지막 줄에는 여행 계획이 주어진다.
        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken())); // 여행 계획의 첫 지점
        plan = new int[N+1];
        for(int i=1; i<M; i++){

            int now = Integer.parseInt(st.nextToken()); // 여행 계획의 첫 지점 이후의 지점들이 순차적으로

            // 각 노드의 "최고" 부모 노드가 전부 같으면, 노드가 전부 연결 돼있다는 의미
            // 첫 지점과 다음 지점들의 최고 부모 노드가 같은지 비교한다.
            if(start != find(now)){ // 하나라도 다르면 연결 되어 있지 않다.
                bw.write("NO\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }

        bw.write("YES\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 부모 찾기
    static int find(int x){

        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // 합치기
    static void union(int x, int y){

        int a = find(x);
        int b = find(y);

        if(a != b){
            if(a < b){
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }
}