package boj.starPrinter;

import java.io.*;
import java.util.*;

public class _2438 {
    
    static Scanner sc = new Scanner(System.in);
    static int N;
    public static void main(String[] args) {
        
        N = sc.nextInt();

        for(int n = 1; n <= N; n++) {
            for(int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
