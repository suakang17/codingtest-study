package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _day0726 {
    
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static int N;
    static int[][] snail;

    // 우 하 좌 상
    static int[] dx = {0, 1, 0, -1};  // 상하
    static int[] dy = {1, 0, -1, 0};  // 좌우
    public static void main(String[] args) throws IOException{
        
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            snail = new int[N][N];

            int x = 0, y = 0, d = 0;
            int num = 1;

            while(num <= N*N) {
                snail[x][y] = num++;
                
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || snail[nx][ny] != 0) {
                    d = (d + 1) % 4;
                    nx = x + dx[d];
                    ny = y + dy[d];
                }
                x = nx;
                y = ny;
            }

            // 출력
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
        }

            
            }
            }

