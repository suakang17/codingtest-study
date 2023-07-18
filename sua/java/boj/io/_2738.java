package boj.io;

import java.io.*;
import java.util.*;

public class _2738 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[][] a = new int[N][M];
        int[][] b = new int[N][M];

        for(int n = 0; n < N; n++){
            String[] nnums = br.readLine().split(" ");
            for(int m = 0; m < M; m++){
                a[n][m] = Integer.parseInt(nnums[m]);
            }
            
        }

        for(int n = 0; n < N; n++){
            String[] nnums = br.readLine().split(" ");
            for(int m = 0; m < M; m++){
                b[n][m] = Integer.parseInt(nnums[m]);
            }
            
        }

        int[][] ret = new int[N][M];

        for(int n = 0; n < N; n++){
            for(int m = 0; m < M; m++){
                ret[n][m] = a[n][m] + b[n][m];
            }
            
        }

        for(int n = 0; n < N; n++){
            for(int m = 0; m < M; m++){
                System.out.print(ret[n][m]+" ");
            }
            System.out.println();
        }
    }
}
