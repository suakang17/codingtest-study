package boj.im;

import java.io.*;
import java.util.*;

public class _2567 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }

        
    }
}
