package boj.greedy;

import java.io.*;
import java.util.*;

public class _11047 {

    static int N;
    static int K;
    static int val;
    static int[] values;
    static int sum = 0;
    static int cnt = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
    
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        values = new int[N];

        for(int n = N - 1; n >= 0; n--) {
            val = Integer.parseInt(br.readLine());

            values[n] = val; // 내림차순 가치
        }

        outer: while (sum <= K) {
            for(int i = 0; i < values.length; i++) {
                while (K - sum >= values[i]) {
                    sum += values[i];
                    cnt++;

                    if(sum == K) { break outer; }
                }
            }
        }

        System.out.println(cnt);
    }
}
