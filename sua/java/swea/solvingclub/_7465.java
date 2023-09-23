package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _7465 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int T, N, M;
    static int[] parent, rank;
    static List<Integer> ret;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parent = new int[N+1];
            rank = new int[N+1];
            for(int n = 1; n <= N; n++) {
                parent[n] = n;
                rank[n] = 1;
            }

            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());

                union(p1, p2);
            }

            ret = new ArrayList<>();
            for(int n = 1; n <= N; n++) {
                int p = find(n);
                if(!ret.contains(p)) ret.add(p);
            }

            sb.append(ret.size());
            System.out.println(sb);
        }
    }

    private static int find(int p) {

        if(parent[p] == p) return parent[p];
        return parent[p] = find(parent[p]);
    }

    private static void union(int p1, int p2) {

        p1 = find(p1);
        p2 = find(p2);

        if(p1 == p2) return;
        if(rank[p1] > rank[p2]) {
            int temp = p1;
                p1 = p2;
                p2 = temp;
        }
        parent[p1] = p2;
        if(rank[p1] == rank[p2]) ++rank[p2];
    }
}
