package boj.starPrinter;

import java.io.*;
import java.util.*;

public class _2440 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());

        for(int n = 1; n <= N; n++) {
            for(int i = N + 1 - n; i >= 1; i--) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
