package boj.starPrinter;

import java.io.*;
import java.util.*;

public class _2447 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
    }

    private static String printer(int number) {

        int size = number / 3;
        for(int i = 1; i <= size; i++) {
            if(i % 2 == 0) {  // * *
                for(int j = 1; j <= i; j++) {
                    sb.append(printer(size));
                }
            } else {          // ***
                printer(size);
            }
        }

        return sb.toString();
    }
}