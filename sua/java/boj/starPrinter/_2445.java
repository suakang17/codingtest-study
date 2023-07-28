package boj.starPrinter;

import java.io.*;
import java.util.*;

public class _2445 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for(int n = 1; n <= N; n++) {
            for(int i = 1; i <= n; i++) {
                sb.append(("*"));
            }
            for(int j = 2*(N-n); j >= 1; j--) {
                sb.append((" "));
            }
            for(int k = 1; k <= n; k++) {
                sb.append(("*"));
            }
            sb.append("\n");
        }
        for(int n = 1; n <= N; n++) {
            for(int i = N-n; i >= 1; i--) {
                sb.append(("*"));
            }
            for(int j = 1; j <= 2*n; j++) {
                sb.append((" "));
            }
            for(int k = N-n; k >= 1; k--) {
                sb.append(("*"));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}