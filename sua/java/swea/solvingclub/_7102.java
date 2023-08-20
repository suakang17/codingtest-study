package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _7102 {
    
    static int T, N, M;
    static int[] sum;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sum = new int[N+M+1];

            for(int n = 1; n <= N; n++) {
                for(int m = 1; m <= M; m++) {
                    sum[n+m]++;
                }
            }

            int max = Integer.MIN_VALUE;
            sb = new StringBuilder("#" + t + " ");
            
            for(int i = 1; i < sum.length; i++) {
                max = Math.max(max, sum[i]);
            }

            for(int i = 1; i < sum.length; i++) {
                if(sum[i] == max) {
                    sb.append(i).append(" ");
                }
            }

            System.out.println(sb);
        }
    }
}


// 완탐? 가능
// 4 ≤ N, M ≤ 20 -> 20 ** 4 ==