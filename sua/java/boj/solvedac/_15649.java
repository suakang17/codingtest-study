package boj.solvedac;

import java.io.*;
import java.util.*;

public class _15649 {
    
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
        visited = new boolean[N+1];
        comb(N, 0);
        System.out.println(sb);
        
    }
    private static void comb(int n, int depth) {  // n개중 M개 선택, 현재 1 to n 숫자 어떤건지 idx

        if(depth == M) {
            for(int i : combList) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combList[depth] = i;
                comb(n, depth+1);
                visited[i] = false;
            }
        }

    }
}

// * goal N C M 모두 구하기