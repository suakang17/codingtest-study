package boj.starPrinter;

import java.io.*;
import java.util.*;

public class _2442 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            for(int k = N - i; k >= 1 ; k--) {
                sb.append(" ");
            }
            for(int j = 1; j <= 2*(i-1) + 1; j++){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
