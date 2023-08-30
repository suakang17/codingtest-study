package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _5215 {
    
    static int T, N, L;
    static int[] Tarr, Karr;
    static int[][] dp;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            Tarr = new int[N+1];
            Karr = new int[N+1];
            for(int n = 1; n < N+1; n++) {
                st = new StringTokenizer(br.readLine());

                Tarr[n] = Integer.parseInt(st.nextToken());
                Karr[n] = Integer.parseInt(st.nextToken());
            }

            dp = new int[N+1][L+1];
            for(int i = 1; i <= N; i++) { 
                for(int j = 1; j <= L; j++) {  
                    if(Karr[i] > j){
                        dp[i][j] = dp[i-1][j]; 
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-Karr[i]] + Tarr[i]);
                    }
			    }
            }

            sb.append(dp[N][L]);
            System.out.println(sb);
        }
    }
}

// L칼로리 이하 Tmax -> dp
// N가지 재료 조합 (일회성 pick)
// dp bottom-up
// dp[n][k] == n개 재료 선택했을때의 L칼로리 이하 *최고 점수t*
