package boj.solvedac;

import java.io.*;
import java.util.*;
public class _17471 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, min;
    static int[] populations, area;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        populations = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int n = 1; n <= N; n++) {
            populations[n] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();
        for(int n = 0; n <= N; n++) {
            graph.add(new ArrayList<>());
        }
        // for(int n = 1; n <= N; n++) {
        //     st = new StringTokenizer(br.readLine());
        //     while(st.hasMoreTokens()) {
        //         int x = Integer.parseInt(st.nextToken());
        //         graph.get(n).add(x);
        //         graph.get(x).add(n);
        //     }
        // }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                graph.get(i).add(temp);
            }
        }
        solution();
    }

    private static void solution() {
        min = Integer.MAX_VALUE;
        area = new int[N+1];
        comb(1);
        int ret = (min == Integer.MAX_VALUE) ? -1 : min;
        System.out.println(ret);
    }

    private static void comb(int idx) {
        if(idx == N+1) {  // idx n까지 탐색완료
            int area1 = 0;
            int area2 = 0;
            for(int i = 1; i <= N; i++) {
                if(area[i] == 1) area1 += populations[i];
                else area2 += populations[i];
            }
            
            visited = new boolean[N+1];
            int parentCnt = 0; // 부모수
            for(int i = 1; i <= N; i++) {
                if(!visited[i]) {
                    bfs(i, area[i]);
                    parentCnt++;
                }
            }
            if(parentCnt == 2) min = Math.min(min, Math.abs(area1 - area2)); 
            return;
        } 

        area[idx] = 1;
        comb(idx+1);
        area[idx] = 2;
        comb(idx+1);
    }

    public static void bfs(int idx, int areaNum) {
        Queue<Integer> q = new LinkedList<>();
        visited[idx] = true;
        q.add(idx);

        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                if(area[next] == areaNum && !visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}

// * goal 두 선거구의 인구 차이의 최솟값
// 1 unionFind + comb
// 2 bf + bfs | comb
    // 조합 형성
    // 부모가 2개인지 확인