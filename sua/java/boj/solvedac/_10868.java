package boj.solvedac;

import java.io.*;
import java.util.*;

public class _10868 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M, h, size;
    static long[] arr, tree;
    public static void main(String[] args) throws IOException {
        
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N];
        for(int n = 0; n < N; n++) {
            arr[n] = Long.parseLong(br.readLine());
        }

        h = (int) Math.ceil(Math.log(N)/Math.log(2));
        size = (int) Math.pow(2, h+1);
        tree = new long[size];

        init(tree, 1, 0, N-1);
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;

            sb.append(min(tree, 1, 0, N-1, l, r)).append("\n");
        }

        System.out.println(sb);
    }

    private static Long min(long[] tree, int node, int start, int end, int left, int right) {
        if(left > end || right < start) return 0L;
        if(left <= start && end <= right) return tree[node];
        
        long lmin = min(tree, node*2, start, (start+end)/2, left, right);
        long rmin = min(tree, node*2+1, (start+end)/2+1, end, left, right);
        if(lmin == 0) return rmin;
        if(rmin == 0) return lmin;
        return Math.min(lmin, rmin);
    }

    private static void init(long[] tree, int node, int start, int end) {
        if(start == end) tree[node] = arr[start];
        else {
            init(tree, node*2, start, (start+end)/2);
            init(tree, node*2+1, (start+end)/2+1, end);
            tree[node] = Math.min(tree[node*2], tree[node*2+1]);
        }
    }
}