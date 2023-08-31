package boj.graph;

import java.io.*;
import java.util.*;

public class _2573 {
    
    static int N, M, cnt, year;
    static int[][] arr;
    static Queue<int[]> q;
    static boolean[][] visited;

    // n s w e
    static int[] dc = {0, 0, -1, 1};
    static int[] dr = {-1, 1, 0, 0};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int n = 0; n < N; n++) {
            st = new  StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        
        int cnt = 0;
        int year = 0;
        while ((cnt = cntSeperated()) < 2) {
            if (cnt == 0) {
                year = 0;
                break;
            }
            melt();
            year++;
        }

        System.out.println(year);
    }

    private static int cntSeperated() {
        boolean[][] visited = new boolean[N][M];

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void melt() {  // 1년 후 arr return 
        
        q = new LinkedList<>();
        visited = new boolean[N][M];

        for(int x = 0; x < N; x++) {
            for(int y = 0; y < M; y++) {
                if(arr[x][y] != 0) {
                    q.add(new int[] {x, y});
                    visited[x][y] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cntZero = 0;
            for(int d = 0; d < 4; d++) {
                int nx = cur[0] + dr[d];
                int ny = cur[1] + dc[d];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && arr[nx][ny] == 0) {
                    cntZero++;
                }
            }
            arr[cur[0]][cur[1]] = (arr[cur[0]][cur[1]] - cntZero < 0) ? 0 : arr[cur[0]][cur[1]] - cntZero;
        }
    }

    private static void dfs(int x, int y, boolean[][] visited) {

        visited[x][y] = true;
        for(int d = 0; d < 4; d++) {
            int nx = x + dr[d];
            int ny = y + dc[d];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && arr[nx][ny] != 0) {
                dfs(nx, ny, visited);
            }
        }
    }
}

// 0 -> 바다
// 숫자 -> 빙산 높이: 일년마다 동서남북 0 수만큼 줄어들음 (대각선 x)

// 빙산이 두 덩어리 이상으로 분리되는 최초 년수 (else sysout 0)

// melt method -> 1년 변화 arr적용 -> 완탐하며 !0 만나면 사방탐색해서 0 수만큼 -- -> return meltedArr
// N과 M은 3 이상 300 이하 -> 완탐 ok
// but 방문확인없으면 녹아서 없어진 자리도 0이라고 판단 -> 필요 이상으로 많은 값을 -- -> bfs

// 완탐 -> 시작점 -> 덩어리 수 cntSeperated
// dfs -> cnt update
// if cnt == 1 -> melt적용 후 다시 cntSeperated