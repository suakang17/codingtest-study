package boj.greedy;

import java.io.*;
import java.util.*;

public class _11399 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] time;
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        time = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            time[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time); // 오름차순

        int ret = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                ret += time[j];
            }
        }

        System.out.println(ret);
    }
}
// int sum = 0;
//         int ret = 0;

//         for(int i = 0; i < N; i++) {
//                 sum += time[i];
//                 ret += sum;
//         }