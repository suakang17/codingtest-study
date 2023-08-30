package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1247 {
    
    static int T, N, min;
    static int[][] matrix;
    static boolean[] visited;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");
            N = Integer.parseInt(br.readLine());

            matrix = new int[N+2][2];
            st = new StringTokenizer(br.readLine());
            
            visited = new boolean[N+2];
            min = Integer.MAX_VALUE;
            for(int n = 0; n < N+2; n++) {
                matrix[n][0] = Integer.parseInt(st.nextToken());  // n == 0 work n == 1 home
                matrix[n][1] = Integer.parseInt(st.nextToken());
            }
            

            dfs(0, 0, 0);
            sb.append(min);
            System.out.println(sb);
        }
    }

    private static void dfs(int n, int cnt, int dis) {

        if(cnt == N) { 
            dis += distance(1, n); 
            min = min > dis ? dis : min;
            return; }

            for (int i = 2; i < N+2; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(i, cnt+1, dis + distance(n, i));  // dfs에서의 cnt++ vs. cnt+1
                    visited[i] = false;
                }
            }
    }

    private static int distance(int n1, int n2) {

        int dx = Math.abs(matrix[n1][0] - matrix[n2][0]);
        int dy = Math.abs(matrix[n1][1] - matrix[n2][1]);

        return dx+dy;
    }
}

// 회사 좌표 -> N명 고객 좌표 방문 -> 집 좌표
// 총 이동경로 min값 찾기

// 순열완탐 dfs
// Nmax 10 -> O(n) ok