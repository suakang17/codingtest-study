package boj.solvedac;

import java.io.*;
import java.util.*;

public class _15652 {
    
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
        comb(1, 0);
        System.out.println(sb);

    }

    private static void comb(int idx, int depth) {

        if(depth == M) {
            for(int e : combList) {
                sb.append(e).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = idx-1; i <= N; i++) {
            if(i == 0) continue;
            combList[depth] = i;
            comb(i+1, depth+1);
        }
    }
}
