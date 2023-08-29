package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _10726 {

    static int TC, N, M;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++) {
            sb = new StringBuilder("#" + tc + " ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int X = (1 << N) - 1;  // 마지막 1 N개
            if ((M & X) == X) System.out.printf("#%d ON\n", tc);
            else System.out.printf("#%d OFF\n", tc);
        }
    }
}

// bitmasking
