package boj.solvedac;

import java.io.*;
import java.util.*;

public class _14438 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, h, size;
    static int[] arr, tree;
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        h = (int) Math.ceil(Math.log(N)/Math.log(2));
        size = (int) Math.pow(2, h+1);
        tree = new int[size];
        init(arr, tree, 1, 0, N-1);

        M = Integer.parseInt(br.readLine());
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if(cmd == 1) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                int val = Integer.parseInt(st.nextToken());
                update(arr, tree, 1, 0, N-1, idx, val);
            } else {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int min = min(tree, 1, 0, N-1, l-1, r-1);
                System.out.println(min);
            }
        }
    }
    
    private static void update(int[] arr, int[] tree, int node, int start, int end, int idx, int val) {
        if(idx < start || idx > end) return;
        if(start == end) {
            arr[idx] = val;
            tree[node] = val;
            return;
        }

        update(arr, tree, node*2, start, (start+end)/2, idx, val);
        update(arr, tree, node*2+1, (start+end)/2+1, end, idx, val);
        tree[node] = Math.min(tree[node*2], tree[node*2+1]);
    }

    private static void init(int[] arr, int[] tree, int node, int start, int end) {
        if(start == end) tree[node] = arr[start];
        else {
            init(arr, tree, node*2, start, (start+end)/2);
            init(arr, tree, node*2+1, (start+end)/2+1, end);
            tree[node] = Math.min(tree[node*2], tree[node*2+1]);
        }

    }

    private static int min(int[] tree, int node, int start, int end, int left, int right) {
        if(left > end || right < start) return 0;
        if(left <= start && end <= right) return tree[node];

        int lmin = min(tree, node*2, start, (start+end)/2, left, right);
        int rmin = min(tree, node*2+1, (start+end)/2+1, end, left, right);
        if (lmin == 0) return rmin;
        else if (rmin == 0) return lmin;
        else return Math.min(lmin, rmin);
        
    }
}

// !!! 수열의 인덱스는 1부터 시작한다.