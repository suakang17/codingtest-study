package boj.solvedac;

import java.io.*;
import java.util.*;

public class _15651 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M;
    static int[] combList;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        combList = new int[M];
        comb(0);
        System.out.println(sb);

    }

    private static void comb(int depth) {

        if(depth == M) {
            for(int each : combList) {
                sb.append(each).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            combList[depth] = i;
            comb(depth+1);
        }
    }
}
