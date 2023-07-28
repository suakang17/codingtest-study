package boj.starPrinter;

import java.io.*;
import java.util.*;

public class _2444 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
    
        N = Integer.parseInt(br.readLine());

        for(int n = 1; n <= N; n++) {
            for(int i = N - n - 1; i >= 0; i--) {
                sb.append(" ");
            }
            for(int j = 2*n - 1; j >= 1; j--) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for(int n = 1; n <= N; n++) {
            for(int j = 0; j < n; j++) {
                sb.append(" ");
            }
            for(int k = 2*(N-n) - 1; k >= 1; k--) {
                sb.append("*");
            }
            sb.append("\n");
        }
        
        
        System.out.println(sb);
    }
}
