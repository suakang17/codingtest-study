package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _3289 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int T, N, M;
    static int[] parent, rank;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder("#" + t + " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parent = new int[N+1];
            rank = new int[N+1];

            for(int n = 0; n <= N; n++) {
                parent[n] = n;
                rank[n] = 1;
            }

            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                switch (cmd) {
                    case 1:
                        if(find(n1) == find(n2)) sb.append("1");
                        else sb.append("0");
                        break;
                
                    case 0:
                        union(n1, n2);
                        break;
                }
            }
            System.out.println(sb);
        }
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
    
    public static void union(int x, int y) {
            x = find(x);
            y = find(y);
    
            if(x == y) return;
            if(rank[x] > rank[y]) {
                int temp = x;
                x = y;
                y = temp;
            }

            parent[x] = y;  // x의 부모 == y
            if(rank[x] == rank[y]) ++rank[y];  // y height ++
    }
}

// union 0 // find 1