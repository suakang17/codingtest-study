package boj.solvedac;

import java.io.*;
import java.util.*;

public class _11659 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M;
    static int[] sum;
    public static void main(String[] args) throws IOException {
        
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sum = new int[N+1];
        for(int n = 1; n <= N; n++) {
            sum[n] = sum[n-1] + Integer.parseInt(st.nextToken());
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken());

            sb.append(sum[j]-sum[i]).append("\n");
        }

        System.out.println(sb);

    }
}
