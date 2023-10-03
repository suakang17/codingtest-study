package boj.dp;

import java.io.*;
import java.util.*;

public class _2096 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] dpMin, dpMax;

    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        dpMax = new int[N+1][3];
        dpMin = new int[N+1][3];

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(n == 1) {
                dpMax[n][0] = a;
                dpMin[n][0] = a;
                dpMax[n][1] = b;
                dpMin[n][1] = b;
                dpMax[n][2] = c;
                dpMin[n][2] = c;
            } else {
                dpMax[n][0] = Math.max(dpMax[n-1][0], dpMax[n-1][1]) + a;
                dpMin[n][0] = Math.min(dpMin[n-1][0], dpMin[n-1][1]) + a;
                
                dpMax[n][1] = Math.max(dpMax[n-1][0], Math.max(dpMax[n-1][1], dpMax[n-1][2])) + b;
                dpMin[n][1] = Math.min(dpMin[n-1][0], Math.min(dpMin[n-1][1], dpMin[n-1][2])) + b;
                
                dpMax[n][2] = Math.max(dpMax[n-1][2], dpMax[n-1][1]) + c;
                dpMin[n][2] = Math.min(dpMin[n-1][2], dpMin[n-1][1]) + c;
            }
        }

        int max = Math.max(dpMax[N][0], Math.max(dpMax[N][1], dpMax[N][2]));
        int min = Math.min(dpMin[N][0], Math.min(dpMin[N][1], dpMin[N][2]));
        System.out.print(max + " " + min);
    }
}

// * goal 점수 min, max
// 1 dfs -> 시간초과
// 2 dp -> 고정 사분면 방향 이동
    // dp table 정의 dp[n][m] == (n,m) 위치서 max or min
    // m -> l c r 위치 정보 hold