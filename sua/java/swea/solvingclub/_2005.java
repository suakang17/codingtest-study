package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _2005 {
    
    static int T, N;
    static int[][] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            pascal(t ,N);
        }
    }

    private static void pascal(int T, int n) {
        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i+1; j++) {
                arr[i][j] = 1;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int ni = i - 1;
                int nj1 = j - 1;
                int nj2 = j;
                if(ni >= 0 && nj1 >= 0) {
                    arr[i][j] = arr[ni][nj1] + arr[ni][nj2];
                }
            }
        }

        sb = new StringBuilder();

        for(int[] each : arr) {
            for(int x : each) {
                if(x != 0) {
                    sb.append(x).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println("#" + T);
        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb);
    }
}
