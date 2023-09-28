package boj.solvedac;

import java.io.*;
import java.util.*;

public class _1987 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R, C;
    static char[][] graph;

    // ESWN
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];

        for(int r = 0; r < R; r++) {
            String str = br.readLine();
            for(int c = 0; c < C; c++) {
                graph[r][c] = str.charAt(c);
            }
        }


    }
}


// ** goal 말이 지날 수 있는 최대 칸 수

// 지나온 모든 칸에 있는 적힌 알파벳과 달라야함
// dfs