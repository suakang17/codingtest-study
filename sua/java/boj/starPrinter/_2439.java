package boj.starPrinter;

import java.io.*;
import java.util.*;

public class _2439 {
    
    static Scanner sc = new Scanner(System.in);
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N-i; j++) {
                sb.append(" ");
            }
            for(int k = 1; k <= i; k++) {
                sb.append("*");
            }
                sb.append("\n");
        }

        System.out.println(sb);

    }
}