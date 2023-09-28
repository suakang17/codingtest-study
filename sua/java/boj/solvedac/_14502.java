package boj.solvedac;

import java.io.*;
import java.util.*;

public class _14502 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, maxDepth, min, initWallCnt;
    static int[][] graph;
    static Queue<int[]> virusLoc;

    // ESWN
    static int[] dr = {0, 1, 0, -1};  // N
    static int[] dc = {1, 0, -1, 0};  // M

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        virusLoc = new LinkedList<>();
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                graph[n][m] = Integer.parseInt(st.nextToken());
                if(graph[n][m] == 2) virusLoc.add(new int[] {n, m});
                if(graph[n][m] == 1) initWallCnt++;
            }
        }

        min = Integer.MAX_VALUE;
        dfs(0);
        System.out.println(N*M - initWallCnt - min - 3);
    }

    private static void dfs(int depth) {

        if(depth == 3) {  // 벽 다 세움
            min = Math.min(min, bfs());  // 퍼진 범위 -> min이 되는 값
            return;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(depth+1);  // 벽세움
                    graph[i][j] = 0;
                }
            }
        }
    }

    private static int bfs() {  // 그래프 이미 확정 -> cnt(퍼지는 칸 수)는 정해져 있음
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for(int[] v : virusLoc) {
            q.add(new int[] {v[0], v[1], 1});  // r c virus칸수
            visited[v[0]][v[1]] = true;
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(!isValid(nr, nc) || visited[nr][nc]) continue;
                q.add(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }

        int ret = 0;  // 바이러스 퍼진 칸
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j]) ret++;
            }
        }
        return ret;
    }

    private static boolean isValid(int r, int c) {
        if(r < 0 || c < 0 || r >= N || c >= M || graph[r][c] == 1) return false;
        return true;
    }
}

// ** goal 얻을 수 있는 안전 영역의 최대 크기
// 0은 빈 칸, 1은 벽, 2는 바이러스
// 바이러스 모든 빈칸으로 퍼짐
    // 새로 세울 수 있는 벽의 개수는 반드시 3개

// 벽 3개 위치 -> 안전 영역 크기 max값 -> 바이러스 퍼지는 영역 크기 min 값

// 1 dfs로 바이러스 위치 기준 최대한 깊이 탐색 -> depth max 순인 방향 첫 칸에 벽 -> 방향 기억 어케?
// 2 dfs로 벽 세우기 -> 로 max값 갱신

// (3 ≤ N, M ≤ 8)
// 안전지대 == 벽 제외!

// ! note 변수 초기화를 제발제발제발 까먹지 말자