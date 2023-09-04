package boj.graph;

import java.io.*;
import java.util.*;

public class _5014 {
    
    static int F, S, G, U, D;
    static int[] visited;
    static Queue<Integer> q;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new int[F+1];
        bfs();
        
    }

    private static void bfs() {
        q = new LinkedList<>();

        q.add(S);
        visited[S] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == G) { System.out.println(visited[cur] - 1); return; }
            if(cur + U < F+1 && visited[cur+U] == 0) {
                q.add(cur + U);
                visited[cur + U] = visited[cur] + 1;
            }
            if(cur - D >= 1 && visited[cur-D] == 0) {
                q.add(cur - D);
                visited[cur - D] = visited[cur] + 1;
            }
        }

        System.out.println("use the stairs");
    }
}


// 총 F층
// 목적지 G층
// 현위치 S층
// 건물은 1층부터 시작하고, 가장 높은 층은 F층

// 위아래로만 이동 가능

// U버튼은 위로 U층을 가는 버튼, D버튼은 아래로 D층을 가는 버튼
// 만약, U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다
// 엘리베이터를 이용해서 G층에 갈 수 없다면, "use the stairs"를 출력

// 총 이동 층 수 == u수 + d수
// greedy? -> o(백만)
// s->g 최단경로 -> bfs