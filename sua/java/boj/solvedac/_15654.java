package boj.solvedac;

import java.io.*;
import java.util.*;

public class _15654 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M;
    static int[] combList, nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        visited = new boolean[N];
        combList = new int[M];
        comb(0);
        System.out.println(sb);

    }

    private static void comb(int depth) {

        if(depth == M) {
            for(int e : combList) {
                sb.append(e).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combList[depth] = nums[i];
                comb(depth+1);
                visited[i] = false;
            }
        }
    }
}
