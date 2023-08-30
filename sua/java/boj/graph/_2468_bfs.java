package boj.graph;

import java.io.*;
import java.util.*;

public class _2468_bfs {
    
    static int N, cnt, max, H;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<int[]> q;
    // N S W E
    static int[] dc = {0, 0, -1, 1};
    static int[] dr = {-1, 1, 0, 0};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        H = 0;
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < N; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
                H = H < arr[n][m] ? arr[n][m] : H;
            }
        }

        max = Integer.MIN_VALUE;
        
        for(int h = 0; h < H; h++) {
            cnt = 0;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(arr[i][j] > h && !visited[i][j]) {
                        bfs(i, j, h);
                        cnt++;
                    }
                }
            }
            max = max < cnt ? cnt : max;
        }

        System.out.println(max);
    }

    // x == r y == c
    private static void bfs(int x, int y, int h) {

        q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dr[d];
                int ny = cur[1] + dc[d];
                
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && arr[nx][ny] > h) {
                    visited[nx][ny] = true;
                    q.add(new int[] { nx, ny });
                }
            }
        }
    }

}

// 안전한 영역의 최대 개수
// arr -> 높이정보