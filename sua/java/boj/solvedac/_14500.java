package boj.solvedac;

import java.io.*;
import java.util.*;

public class _14500 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, max;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<int[]> q;

    // ESWN
    static int[] dn = {0, 1, 0, -1};  // r
    static int[] dm = {1, 0, -1, 0};  // c

    // T ㅏ ㅗ ㅓ
    static int[][] Tdn = {{0, 0, 1, 0}, {0, 1, 1, 2}, {0, 0, -1, 0}, {0, 1, 1, 2}};  // r
    static int[][] Tdm = {{0, 1, 1, 2}, {0, 0, 1, 0}, {0, 1, 1, 2}, {0, 0, -1, 0}};  // c
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // r
        M = Integer.parseInt(st.nextToken());  // c

        visited = new boolean[N][M];
        arr = new int[N][M];
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
                checkT(i, j);
            }
        }

        // max = bfs();
        // for(int i = 0; i < N; i++) {
        //     for(int j = 0; j < M; j++) {
        //         checkT(i, j);
        //     }
        // }
        System.out.println(max);
    }

    // private static int bfs() {  // ㅗ 탐색불가
    //     q = new LinkedList<>();
    //     q.add(new int[] {0, 0, 1, arr[0][0]});
    //     visited[0][0][1] = true;
        

    //     while(!q.isEmpty()) {
    //         int[] cur = q.poll();
    //         int r = cur[0];
    //         int c = cur[1];
    //         int cnt = cur[2];
    //         int sum = cur[3];

    //         if(cnt == 4) {
    //             max = Math.max(sum, max);
    //             continue;
    //         }

    //         for(int d = 0; d < 4; d++) {
    //             int nr = r + dn[d];
    //             int nc = c + dm[d];

    //             if(!isValid(nr, nc)) continue;
    //             if(visited[nr][nc][cnt+1]) continue;
    //             q.add(new int[] {nr, nc, cnt+1, sum+arr[nr][nc]});
    //             visited[nr][nc][cnt+1] = true;
    //         }
    //     }
    //     return max;
    // }

    private static boolean isValid(int r, int c) {
        if(r < 0 || c < 0 || r >= N || c >= M) return false;
        return true;
    }

    private static void dfs(int r, int c, int depth, int sum) {

        if(depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int d = 0; d < 4; d++) {
            int nr = r + dn[d];
            int nc = c + dm[d];

            if(!isValid(nr, nc) || visited[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(nr, nc, depth+1, sum+arr[nr][nc]);
            visited[nr][nc] = false;

        }
    }

    private static void checkT(int r, int c) {  // 하나의 시작점에 대해

        
        for(int d = 0; d < 4; d++) {
            int sum = 0;
            boolean isBreaked = false;
            for(int i = 0; i < 4; i++) {
                int nr = r + Tdn[d][i];
                int nc = c + Tdm[d][i];
                
                if(!isValid(nr, nc)) {
                    isBreaked = true;
                    break;
                }
                sum += arr[nr][nc];
            }
            if(!isBreaked) max = Math.max(sum, max);
        }
    }
}


// ** goal 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값
// 테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램
// 회전, 대칭 가능

// 1 테트로미노 모양 그래프 탐색 
    // 네 칸 탐색 -> max값 갱신

// 4개 1 * 1 -> 테트로미노
    // 정사각형은 서로 겹치면 안 된다.
    // 도형은 모두 연결되어 있어야 한다.
    // 정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
