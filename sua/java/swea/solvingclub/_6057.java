package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _6057 {
    
    static int T, N, M, tri;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[][][] visited;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for(int n = 0; n < N+1; n++) {
                graph.add(n, new ArrayList<>());
            }

            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                graph.get(n1).add(n2);
                // graph.get(n2).add(n1);  // 동일 삼각형 제외 위해 방향으로
            }

            tri = 0;
            sb.append(solve());
            System.out.println(sb);
        }


    }

    private static int solve() {

        for(int i = 1; i < N+1; i++) {
            for(int j = i+1; j < N+1; j++) {
                if(!graph.get(i).contains(j)) continue;
                for(int k = j+1; k < N+1; k++) {
                    if(!graph.get(j).contains(k) || !graph.get(i).contains(k)) continue;
                    tri++;
                }
            }
        }
        return tri;
    }

    private static void dfs(int nextNode, int cnt) {

        if(cnt == 3) {
            
        }
    }
}

// 세개 방문시 사이클 -> 삼각형
// 조합 // solve()

// bfs