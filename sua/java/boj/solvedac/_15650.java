package boj.solvedac;

import java.io.*;
import java.util.*;

public class _15650 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M;
    static int[] combList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        combList = new int[M];
        comb(1, 0);
        System.out.println(sb);

    }

    private static void comb(int idx, int depth) {  // 현재 idx, depth
        
        if(depth == M) {
            for(int each : combList) {
                sb.append(each).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = idx; i <= N; i++) {
            combList[depth] = i;
            comb(i+1, depth+1);
        }
    }
}

// * goal asc comb of NCM