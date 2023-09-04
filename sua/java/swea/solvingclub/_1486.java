package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1486 {
    
    static int T, N, B, min;
    static int[] H;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            H = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int n = 0; n < N; n++) {
                H[n] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;
            dfs(0, 0);

            sb.append(min - B);
            System.out.println(sb);
        }
    }

    private static void dfs(int idx, int sum) {

        if(sum >= B) { min =  Math.min(sum, min); return; }
        if(idx == N) {
            if(sum >= B) {
                min =  Math.min(sum, min); return;
            }
            return;
        }
        dfs(idx+1, sum);
        dfs(idx+1, sum+H[idx]);
    }
}

// 높이가 B 이상인 탑 중에서 높이가 가장 낮은 탑