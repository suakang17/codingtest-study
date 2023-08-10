package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1209 {

    static int T;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        
        for(int t = 1; t <= 10; t++) {
            T = Integer.parseInt(br.readLine());

            
            arr = new int[100][100];

            for(int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int[] sums = {horizontal(), vertical(), diagonalL(), diagonalR()};
            Arrays.sort(sums);
            System.out.println("#" + t + " " + sums[3]);

        }
    }

    private static int horizontal() {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 100; i++) {
            int sum = 0;
            for(int j = 0; j < 100; j++) {
                sum += arr[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    private static int vertical() {  // 세로
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 100; i++) {
            int sum = 0;
            for(int j = 0; j < 100; j++) {
                sum += arr[j][i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    private static int diagonalL() {
        int i = 0;
        int j = 0;
        int sum = 0;
        while(i > 100 && j > 100) {
            sum += arr[i++][j++];
        }
        return sum;
    }

    private static int diagonalR() {
        int i = 0;
        int j = 99;
        int sum = 0;
        while(i > 100 && j <= 0) {
            sum += arr[i++][j--];
        }
        return sum;
    }
}