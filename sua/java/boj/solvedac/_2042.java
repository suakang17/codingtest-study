package boj.solvedac;

import java.io.*;
import java.util.*; 

public class _2042 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, K, h;
    static long[] arr, tree;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());  // 변경횟수
        K = Integer.parseInt(st.nextToken());  // 구간합 구하는 횟수

        arr = new long[N];
        for(int n = 0; n < N; n++) {
            arr[n] = Long.parseLong(br.readLine());
        }

        h = (int) Math.ceil(Math.log(N)/Math.log(2));
        int size = (int) Math.pow(2,h+1);
        tree = new long[size];
        init(arr, tree, 1, 0, N-1);

        for(int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if(a == 1) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                update(arr, tree, 1, 0, N-1, b-1, c);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long sum = sum(tree, 1, 0, N-1, b-1, c-1);
                System.out.println(sum);
            }
        }
    }

    private static void init(long[] arr, long[] tree, int node, int start, int end) {
        if(start == end) tree[node] = arr[start];
        else {
            init(arr, tree, node*2, start, (start+end)/2);
            init(arr, tree, node*2+1, (start+end)/2+1, end);
            tree[node] = tree[node*2] + tree[node*2+1];
        }
    }

    private static long sum(long[] tree, int node, int start, int end, int left, int right) {
        if(left > end || right < start) return 0;
        if(left <= start && right >= end) return tree[node];
        long lsum = sum(tree, node*2, start, (start+end)/2, left, right);
        long rsum = sum(tree, node*2+1, (start+end)/2+1, end, left, right);
        return lsum+rsum;
    }

    private static void update(long[] arr, long[] tree, int node, int start, int end, int idx, long val) {
        if(idx < start || idx > end) return;
        if(start == end) {
            arr[idx] = val; // idx번째 val로 변경
            tree[node] = val;
            return;
        }

        update(arr, tree, node*2, start, (start+end)/2, idx, val);
        update(arr, tree, node*2+1, (start+end)/2+1, end, idx, val);
        tree[node] = tree[node*2] + tree[node*2+1];
    }
}

// * goal 구간합
// N개 수 -> 막 변경되는 와중에 부분합 구하기
// a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고 update
// a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력 print sum