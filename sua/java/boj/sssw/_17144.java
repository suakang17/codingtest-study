package boj.sssw;

import java.io.*;
import java.util.*;

public class _17144 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R, C, T, refresher;
    static int[][] graph;
    static Queue<int[]> q;

    // ESWN dust
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int[R][C];
        refresher = -1;
        for(int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < C; c++) {
                graph[r][c] = Integer.parseInt(st.nextToken());
                if(graph[r][c] == -1 && refresher == -1) refresher = r; // 위쪽 공청기 위치
            }
        }

        solution(T);
    }

    private static void solution(int T) {

        int t = 0;
        while(t++ < T) {
            step1();
            step2();
        }

        System.out.println(calc());
    }

    private static void step1() {

        q = new LinkedList<>();  // valid dust loc
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(graph[r][c] == 0 || graph[r][c] == -1) continue;
                q.add(new int[] {r, c, graph[r][c]});  // r, c, dust
            }
        }

        while(!q.isEmpty()) {

            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dust = cur[2];

            if(graph[r][c] < 5) continue;  // no need to chk
            int spreadAmt = dust / 5;
            int spreadCnt = 0;
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(!isValid(nr, nc)) continue;
                graph[nr][nc] += spreadAmt;
                spreadCnt++;
            }
            graph[r][c] -= spreadAmt * spreadCnt;
        }
        // System.out.println("step1");
        // for(int r = 0; r < R; r++) {
        //     for(int c = 0; c < C; c++) {
        //         System.out.print(graph[r][c]);
        //         System.out.print(" ");
        //     }
        //     System.out.println();
        // }
    }

    private static boolean isValid(int r, int c) {
        if(r < 0 || c < 0 || r >= R || c >= C) return false;  // invalid loc
        if(graph[r][c] == -1) return false;
        return true;
    }

    private static void step2() {

        upper(refresher);
        under(refresher+1);
    }

    private static void upper(int top) {
        
        for(int i = top-1; i > 0; i--) 
            graph[i][0] = graph[i-1][0];
        for(int i = 0; i < C-1; i++) 
            graph[0][i] = graph[0][i+1];
        for(int i = 0; i < top; i++) 
            graph[i][C-1] = graph[i+1][C-1];
        for(int i = C-1; i > 1; i--) 
            graph[top][i] = graph[top][i-1];
        graph[top][1] = 0;
    }

    private static void under(int bottom) {

        for(int i = bottom+1; i < R-1; i++)
            graph[i][0] = graph[i+1][0];
        for(int i = 0; i < C-1; i++)
            graph[R-1][i] = graph[R-1][i+1];
        for(int i = R-1; i > bottom; i--)
            graph[i][C-1] = graph[i-1][C-1];
        for(int i = C-1; i > 1; i--) 
            graph[bottom][i] = graph[bottom][i-1];
        graph[bottom][1] = 0;
    }

    private static int calc() {

        int dust = 0;
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(graph[r][c] == -1) continue;
                dust += graph[r][c];
            }
        }
        return dust;
    }
}

// ** goal T초 후 남아있는 미세먼지 양
// 공청기 항상 1번열, 크기 두 행

// 1 미세먼지 확산 (모든칸 동시) -> ESWN 
    // 동시를 어떻게 구현??
        // 완탐 -> 1000 * 50 * 50 -> 백만
            // 미세먼지 양 5 미만 -> 확산 x
            // q에 담아서

    // 인접 방향에 공청기 있으면 확산 x
    // 확산 양 / 5 (소수점 버림)
    // 확산 주체 칸에 남은 미세먼지 양 A[r][c] - (A[r][c]/5*확산된방향수) + 확산당한먼지양
// 2 공청기 작동 == 바람 불음 -> 바람 방향대로 미세먼지 한 칸씩 회전
    // 위쪽 공청기 바람: 반시계방향
    // 아래쪽 공청기 바람: 시계방향
    // 공청기 유입된 미세먼지는 사라짐

// 공청기 작동(바람 method)
// 미세먼지 확산 method
// solution method
// 남은 미세먼지 양 계산 method