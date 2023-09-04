package boj.graph;

import java.io.*;
import java.util.*;

public class _9205 {
    
    static int T, N;
    static int[][] matrix;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph; // n으로 그래프 추가
    static Queue<Integer> q;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            matrix = new int[N+2][2];

            for(int n = 0; n < N+2; n++) {  // 0 집 n+1 페스티벌
                st = new StringTokenizer(br.readLine());
                matrix[n][0] = Integer.parseInt(st.nextToken());
                matrix[n][1] = Integer.parseInt(st.nextToken());
            }

            
            graph = new ArrayList<>();
            for(int n = 0; n < N+2; n++) {
                graph.add(new ArrayList<>());
            }

            for(int n = 0; n < N+2; n++) {  //  (0 ≤ n ≤ 100)
                for(int m = n+1; m < N+2; m++) {
                    if(distance(n, m) <= 1000) { // 50 * 20
                        graph.get(n).add(m);
                        graph.get(m).add(n);
                    }
                }
            }

            bfs(0);  // 위치
        }
    }

    private static void bfs(int node) {

        visited = new boolean[N+2];
        q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            if(cur == N+1) { System.out.println("happy"); return; }
            // int curX = matrix[cur][0];
            // int curY = matrix[cur][1];

            for(int next : graph.get(cur)) {
                if(!visited[next]) {
                    q.add(next);
                }
            }
        }

        System.out.println("sad");
    }

    private static int distance(int n1, int n2) {

        int x = Math.abs(matrix[n1][0] - matrix[n2][0]);
        int y = Math.abs(matrix[n1][1] - matrix[n2][1]);
        return x+y;
    }
}

// 50미터에 한 병씩
// 빈 병은 버리고 새 맥주 병을 살 수 있다. 하지만, 박스에 들어있는 맥주는 20병을 넘을 수 없음
// 편의점을 나선 직후에도 50미터를 가기 전에 맥주 한 병을 마셔야 한다.

// 거리 50m당 맥주--;
// 두 좌표 사이의 거리는 x 좌표의 차이 + y 좌표의 차이

// 50m 내에 탐색 가능한 편의점 있는지 확인 -> 있으면 서로 그래프로 이어주기 bfs

// 플로이드 와샬 ? 