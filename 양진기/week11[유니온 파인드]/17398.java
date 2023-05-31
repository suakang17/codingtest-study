import java.util.*;
import java.io.*;

class Main{
    static int[] parents;
    static long[] groupSize;    // 각 정점의 사이즈
    static Connection[] connections;    // 통신망 (통신탑들의 집합)

    static class Connection{ // 통신탑 간의 연결 정보
        int a, b;

        public Connection(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 부모는 자기 자신으로 초기화
        parents = new int[N+1];
        for(int i=1; i<=N; i++){
            parents[i] = i;
        }

        // 각 정점의 사이즈는 1로 초기화
        groupSize = new long[N+1];
        Arrays.fill(groupSize, 1);

        connections = new Connection[M + 1];
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            // 통신탑 간의 연결 정보를 담는다.
            connections[i] = new Connection(X, Y);
        }

        /**
         *  제거 예정인 간선을 저장해 두고 나머지 간선을 모두 연결한 상태로
         *  제거 역순으로 그래프를 Union 작업하여 문제를 해결한다.
         *  Union-Find 기법은 그래프를 분리하는 상황에서 쓰지 못하기 때문에
         *  문제를 거꾸로 생각해 해결한다. -> 스택?
         */

        boolean[] cutLine = new boolean[M + 1];
        Stack<Integer> stack = new Stack<>();
        while(Q-- > 0){
            int idx = Integer.parseInt(br.readLine());
            cutLine[idx] = true;    // 제거될 지점
            stack.push(idx);        // 거꾸로
        }

        for(int i=1; i<=M; i++){
            if(cutLine[i]) continue;    // 제거될 지점이면 스킵
            // 제거될 지점이 아니면
            int a = connections[i].a;
            int b = connections[i].b;

            union(a, b);    // 제거될 지점이 아닌 통신망을 union한다.
        }

        long ans = 0L;

        while(!stack.isEmpty()){    // 스택에 원소가 있으면
            Connection now = connections[stack.pop()];  // 위에서부터 꺼냄
            int a = find(now.a);    // 최고 부모 찾기
            int b = find(now.b);    // 최고 부모 찾기

            // 서로 다른 그룹이라면 제거 비용을 구하여 합함
            // 최고 부모가 같지 않다 -> 다른 그룹이다. -> (그룹 1의 정점 개수) * (그룹 2의 정점 개수)
            if(a != b) ans += groupSize[a] * groupSize[b];

            // 최고 부모가 같다. -> 같은 그룹이다. -> 비용은 0
            union(a, b);
        }
        System.out.println(ans);
    }

    // 최고 부모 찾기
    static int find(int x){
        if(parents[x] == x) return x;
        else return parents[x] = find(parents[x]);
    }

    // 합집합 연산
    static void union(int x, int y){
        x = find(x);
        y = find(y);

//        if(x != y){
//            if(x < y){
//                parents[y] = x;
//            } else {
//                parents[x] = y;
//            }
//        }

        if(x > y){  // 들어오는 값은 x < y가 default라서 반대로 들어올 경우 swap한다.
            int temp = x;
            x = y;
            y = temp;
        }

        if(x != y){
            groupSize[x] += groupSize[y];   // 그룹의 개수를 누적한다.
            parents[y] = x; // 작은 쪽으로 합치는 union 연산
        }
    }
}