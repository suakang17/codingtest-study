package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _2817 {
    
    static int N, T, K, cnt;
    static int[] A;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            A = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int n = 0; n < N; n++) {
                A[n] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            dfs(0, 0);

            sb.append(cnt);
            System.out.println(sb);
        }
    }

    private static void dfs(int idx, int sum) {

        if(sum == K) { cnt++; return; }
        if(sum > K || idx >= N) { return; }
        
        dfs(idx+1, sum);
        dfs(idx+1, sum+A[idx]);

    }
}

// 최소 1개 이상 수 선택 -> 합 k 되는 경우의 수 -> dfs
// 1 이상 100 이하임이 보장, 중복 가능

// N(1 ≤ N ≤ 20) K(1 ≤ K ≤ 1000)
// 2^N -> O(백만) ok