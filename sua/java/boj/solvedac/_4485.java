package boj.solvedac;

import java.io.*;
import java.util.*;

public class _4485 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, min, cnt;
    static int[][] arr;

    static Queue<int[]> q;
    static boolean[][][] visited;

    // ESWN
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        
        cnt = 0;
        while (true) {
            sb = new StringBuilder("Problem " + cnt++ + ": ");
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            arr = new int[N][N];
            visited = new boolean[N][N][9*125*125+1];

            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < N; m++) {
                    arr[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            bfs();
            sb.append(min);
        }
        
    }

    private static void bfs() {
        min = Integer.MAX_VALUE;
        q = new LinkedList<>();
        q.add(new int[] {0, 0, 0});
        int sum = 0;
        visited[0][0][0] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            sum = cur[2];

            if(r == N-1 && c == N-1) {
                min = Math.min(min, sum);
                continue;
            }

            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(!isValid(nr, nc)) continue;
                int nsum = sum + arr[nr][nc];
                if(!visited[nr][nc][nsum]) {
                    q.add(new int[] {nr, nc, nsum});
                    visited[nr][nc][nsum] = true;
                }
            }
        }
    }

    private static boolean isValid(int r, int c) {
        if(r < 0 || c < 0 || r >= N || c >= N) return false;
        return true;
    }
}


// * goal 잃는 최소 금액 => 합의 최소값
// 도둑루피의 크기가 k면 이 칸을 지나면 k루피를 잃는다는 뜻이다. 
// 주어지는 모든 정수는 0 이상 9 이하인 한 자리 수