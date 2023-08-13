package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1954 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N;
    static int snail[][];

    // 우 하 좌 상
    static int[] dc = {0, 1, 0, -1};
    static int[] dr = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            snail = new int[N][N];

            int r = 0;
            int c = 0;
            int d = 0;
            int num = 1;

            while(num <= N*N) {
                snail[c][r] = num++;
                int nc = c + dc[d];
                int nr = r + dr[d];

                if(nc < 0 || nr < 0 || nc >= N || nr >= N || snail[nc][nr] != 0) {
                    d = (d + 1) % 4;
                    nc = c + dc[d];
                    nr = r + dr[d];
                }
                c = nc;
                r = nr;
            }

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
