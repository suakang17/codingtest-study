package boj.graph;

import java.io.*;
import java.util.*;

public class _2468_dfs {
    
    static int N, cnt, max, H;
    static int[][] arr;
    static boolean[][] visited;
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
                        dfs(i, j, h, 0);
                        cnt++;
                    }
                }
            }
            max = max < cnt ? cnt : max;
        }

        System.out.println(max);
    }

    private static void dfs(int x, int y, int h, int cnt) {

        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dr[d];
            int ny = y + dc[d];
            
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && arr[nx][ny] > h) {
                visited[nx][ny] = true;
                dfs(nx, ny, h, cnt++);
            }
        }
    }
}

// dfs