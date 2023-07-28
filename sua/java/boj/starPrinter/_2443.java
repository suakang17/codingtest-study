package boj.starPrinter;

import java.io.*;
import java.util.*;

public class _2443 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
    
        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            for(int k = 1; k < i; k++) {
                sb.append(" ");
            }
            for(int j = 2*(N-i); j >= 0; j--) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
