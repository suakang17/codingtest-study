package boj.sort;

import java.io.*;
import java.util.*;

public class _1005 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, K, W;
    static int[] inNode, result, time;
    static Queue<Integer> q;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            inNode = new int[N+1];
            result = new int[N+1];
            time = new int[N+1];

            st = new StringTokenizer(br.readLine());  // delays

            q = new LinkedList<>();
            for(int n = 1; n <= N; n++) {
                time[n] = Integer.parseInt(st.nextToken());
                result[n] = time[n];
            }

            graph = new ArrayList<>();
            for(int n = 0; n <= N; n++) {
                graph.add(new ArrayList<>());
            }

            for(int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());  // graph
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph.get(x).add(y);
                inNode[y]++;
            }

            W = Integer.parseInt(br.readLine());  // goal

            tpologicalSort();
        }
    }

    private static void tpologicalSort() {

        for(int i = 1; i <= N; i++) {
            if(inNode[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                inNode[next]--;
                result[next] = Math.max(result[next], result[cur] + time[next]);  // 가장 max 로 갱신해야 inNode 모두 built
                if(inNode[next] == 0) q.add(next);
            }
        }

        System.out.println(result[W]);
    }
}

// ** goal 건물 W를 건설완료 하는데 드는 최소시간
// 건설 시작 ~ 완성 delay 존재
// 건설 순서 규칙에 따라 건설 가능

// 선후관계 정의된 그래프 정렬 -> 위상정렬
// 결과 여러개 중 max값 갱신 -> inNode 방문이 모두 이루어져야 cur 방문 가능하므로