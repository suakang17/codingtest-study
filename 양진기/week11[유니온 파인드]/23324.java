import java.io.*;
import java.util.*;

class Main{
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        Arrays.fill(parents, -1);   // 부모 배열은 -1로 초기화
        int a = 0, b = 0;
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (i == K){    // 가중치가 1인 K번째 간선은 union 제외 시킨다.
                a = u;
                b = v;
                continue;
            }

            union(u, v);    // K번째 간선을 제외한 나머지 간선은 union한다.
        }

        /*
            가중치가 1인 간선을 기준으로 그룹이 1개 or 2개 생긴다.

            같은 그룹 내에 있는 정점들은 정점 간 이동할 때 가중치가 0이 된다.
            다른 그룹 간 정점들은 이동할 때 가중치가 1이 된다.

            그룹이 1개라면 모든 정점 쌍의 최단 거리는 0이 된다.
            그룹이 2개라면 모든 정점 쌍의 최단 거리는 (그룹 1의 정점 개수) * (그룹 2의 정점 개수)
        */

        a = find(a);    // 제외시킨 간선의 정점의 최고 부모 찾기
        b = find(b);    // 제외시킨 간선의 정점의 최고 부모 찾기

        // 최고 부모가 같다면 -> 그룹이 1개
        if(a == b){
            System.out.println(0);  // 최단 거리는 0
            return;
        }

        // 그룹이 2개라면 모든 정점 쌍의 최단 거리는 (그룹 1의 정점 개수) * (그룹 2의 정점 개수)
        int aCnt = 0 , bCnt = 0;
        for(int i=1; i<=N; i++){
            int cur = find(i);
            if(cur == a){
                aCnt++;
            } else if (cur == b){
                bCnt++;
            }
        }
        System.out.println(1l * aCnt * bCnt);

    }

    // 최고 부모 찾기
    static int find(int x){
        if(parents[x] < 0) return x;    // 부모 배열은 -1로 초기화 했었다.
        else return parents[x] = find(parents[x]);
    }

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

        if(x == y) return;
        int hi = parents[x] < parents[y] ? x : y;   // 작은 값(x)
        int lo = parents[x] < parents[y] ? y : x;   // 큰 값(y)
        parents[hi] += parents[lo];
        parents[lo] = hi;
    }
}