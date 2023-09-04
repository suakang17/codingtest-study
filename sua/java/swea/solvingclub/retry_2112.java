package swea.solvingclub;

import java.io.*;
import java.util.*;

public class retry_2112 {
    
    static int T, D, W, K;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");
            st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            for(int d = 0; d < D; d++) {
                st = new StringTokenizer(br.readLine());

                for(int w = 0; w < W; w++) {
                    
                }
            }
        }
    }
}
