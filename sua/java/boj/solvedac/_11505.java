package boj.solvedac;

import java.io.*;
import java.util.*;

public class _11505 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M, K, h, size;
    static int MOD = 1000000007;
    static long[] arr, tree;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];

        h = (int) Math.ceil(Math.log(N)/Math.log(2));
        size = (int) Math.pow(2, h+1);
        tree = new long[size];

        for(int n = 0; n < N; n++) {
            arr[n] = Long.parseLong(br.readLine());
        }

        init(1, 0, N-1);

        for(int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            
            if(cmd == 1) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                int val = Integer.parseInt(st.nextToken());

                update(1, 0, N-1, idx, val);
            } else {
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;

                sb.append(product(1, 0, N-1, l, r)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void init(int node, int start, int end) {
        if(start == end) tree[node] = arr[start];
        else {
            init(node*2, start, (start+end)/2);
            init(node*2+1, (start+end)/2+1, end);
            tree[node] = tree[node*2] * tree[node*2+1] % MOD;
        }
    }

    private static long product(int node, int start, int end, int left, int right) {
        if(right < start || left > end) return 1;
        if(left <= start && end <= right) return tree[node];
        long lproduct = product(node*2, start, (start+end)/2, left, right);
        long rproduct = product(node*2+1, (start+end)/2+1, end, left, right);
        return lproduct*rproduct%MOD;
    }

    private static long update(int node, int start, int end, int idx, long val) {
        if(idx < start || idx > end) return tree[node];
        if(start == end) return tree[node] = val;
        return tree[node] = (update(node*2, start, (start+end)/2, idx, val) * update(node*2+1, (start+end)/2+1, end, idx, val)) % MOD;
    }
}
