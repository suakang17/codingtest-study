package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _4012 {
    
    static int T, N, min;
    static int[][] S;
    static boolean[] visited;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");
            N = Integer.parseInt(br.readLine());

            visited = new boolean[N];
            S = new int[N][N];
            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < N; m++) {
                    S[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            dfs(0, 0); // 0번 idx 사람, 1명 고름 // 무조건 0 포함하는 팀것만 고려, 나머지는 etc처리
            sb.append(min);
            System.out.println(sb);
    }
}

    private static void dfs(int idx, int cnt) {

        if(cnt == N/2) { diff(); return; }  

        for(int i = idx; i < N; i++) {  
            if(!visited[i]) {
                visited[i] = true;
                dfs(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }

    private static void diff() {
        int visitedSum = 0;
        int unvisitedSum = 0;

        // visited vs. !visited
        for(int i = 0 ; i < N; i++) {
            for(int j = i; j < N; j++) {
                if(!visited[i] && !visited[j]) {
                    unvisitedSum += S[i][j];
                    unvisitedSum += S[j][i];
                } else if(visited[i] && visited[j]) {
                    visitedSum += S[i][j];
                    visitedSum += S[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(unvisitedSum - visitedSum));

        return;
    }
}


// N개의 식재료 -> N/2로 나눠 요리 두개 (N짝수보장) -> 음식 A, B -> 맛 차이 최소되도록 재료 배분

