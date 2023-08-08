package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1204 {

    static int T;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] score;
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            score = new int[101];
            int tc = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            while(st.hasMoreTokens()) {
                int sc = Integer.parseInt(st.nextToken());
                score[sc] += 1;
            }

            int max = Integer.MIN_VALUE;
            int idx = -1;

            for(int i = 0; i < score.length; i++) {
                if(score[i] >= max) {
                    max = score[i];
                    idx = i;
                }
            }

            System.out.println("#" + tc + " " + idx);
            
        }
    }
}