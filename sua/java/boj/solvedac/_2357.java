package boj.solvedac;

import java.io.*;
import java.util.*;

public class _2357 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M;
    static long[] arr, minTree, maxTree;
    public static void main(String[] args) throws IOException {
        
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        for(int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        minTree = new long[N*4];
        maxTree = new long[N*4];

        initMin(minTree, 1, 0, N-1);
        initMax(maxTree, 1, 0, N-1);
        
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            sb.append(min(minTree, 1, 0, N-1, a, b)).append(" ").append(max(maxTree, 1, 0, N-1, a, b)).append("\n");
        }

        System.out.println(sb);
    }

    

    private static long max(long[] tree, int node, int start, int end, int left, int right) {
        if(left > end || right < start) return 0;
        if(left <= start && right >= end) return tree[node];

        long lmax = max(tree, node*2, start, (start+end)/2, left, right);
        long rmax = max(tree, node*2+1, (start+end)/2+1, end, left, right);
        return Math.max(lmax, rmax);
    }



    private static long min(long[] tree, int node, int start, int end, int left, int right) {
        if(left > end || right < start) return 0;
        if(left <= start && right >= end) return tree[node];

        long lmin = min(tree, node*2, start, (start+end)/2, left, right);
        long rmin = min(tree, node*2+1, (start+end)/2+1, end, left, right);
        if(lmin == 0) return rmin;
        if(rmin == 0) return lmin;
        return Math.min(lmin, rmin);
    }



    private static void initMin(long[] tree, int node, int start, int end) {
        if(start == end) tree[node] = arr[start];
        else {
            initMin(tree, node*2, start, (start+end)/2);
            initMin(tree, node*2+1, (start+end)/2+1, end);
            tree[node] = Math.min(tree[node*2], tree[node*2+1]);
        }
    }

    private static void initMax(long[] tree, int node, int start, int end) {
        if(start == end) tree[node] = arr[start];
        else {
            initMax(tree, node*2, start, (start+end)/2);
            initMax(tree, node*2+1, (start+end)/2+1, end);
            tree[node] = Math.max(tree[node*2], tree[node*2+1]);
        }
    }
}

// * goal M개 구간이 주어졌을때 N개의 정수 중에서 최대, 최솟값 구하기
// O(NM) -> 초과 -> segmentTree