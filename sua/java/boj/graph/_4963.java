package boj.graph;

import java.io.*;
import java.util.*;

public class _4963 {
    static int w, h, row, col, count;
    static int[][] arr;
    static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
    static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            if( w == 0 && h == 0) break;
            
            arr = new int[h][w];
            visited = new boolean[h][w];
            
            count = 0;
            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
//            int cnt = 0;
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(arr[i][j] == 1 && !visited[i][j]) {
                            row = i;
                            col = j;
                            bfs(row, col);
//                            cnt++;
//                            System.out.println(cnt);
                    }
                }
            }
            bw.write(String.valueOf(count) + "\n");
        }//while
        bw.close();
        br.close();
    }// main

    public static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        visited[row][col] = true;
        queue.offer(new int[] {row, col});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc] && arr[nr][nc] == 1) {
                    // visited[row - dr[i]][col - dc[i]] = false;
                    // System.out.println("row: " + row + " col: " + col);
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
        count++;
    }
}