package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1216 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] arr;
    static int T;
    static int max;

    public static void main(String[] args) throws IOException {
        
        for(int t = 1; t <= 10; t++) {
            T = Integer.parseInt(br.readLine());
            arr = new char[100][100];

            for(int c = 0; c < 100; c++) {
                String str = br.readLine();
                for(int r = 0; r < 100; r++) {
                    arr[c][r] = str.charAt(r);
                }
            }

            for(int i = 0; i < 100; i++) {
                for(int j = 0; j < 100; j++) {
                    arr[i][j]
            }
        }
        }
    }

    private static boolean horizontal(int i, int j, int l) {
        
        
    }

    private static boolean vertical(int i, int j, int l) {

    }
}
