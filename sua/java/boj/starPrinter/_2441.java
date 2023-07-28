package boj.starPrinter;

import java.io.*;
import java.util.*;

public class _2441 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < i; j++) {
                sb.append(" ");
            }
            for(int k = N + 1 - i; k >= 1; k--) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
