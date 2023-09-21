package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1251 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int T, N;
    static int[] parent, rank;
    static double E;
    static List<Integer> X, Y;
    static List<Info> list;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");
            N = Integer.parseInt(br.readLine());
            
            X = new ArrayList<>();
            Y = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                X.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                Y.add(Integer.parseInt(st.nextToken()));
            }

            E = Double.parseDouble(br.readLine());
            list = new ArrayList<>();

            parent = new int[N+1];
            rank = new int[N+1];
            for(int n = 1; n <= N; n++) {
                parent[n] = n;
                rank[n] = 1;
            }

            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    double x = Math.abs(X.get(i) - X.get(j));
                    double y = Math.abs(Y.get(i) - Y.get(j));

                    Info info = new Info(i, j, x*x + y*y);
                    list.add(info);
                    // System.out.println(info.fee);
                }
            }

            list.sort(null);

            int n = 0;
            double ret = 0;
            for(Info info : list) {
                if(union(info.i1, info.i2)) {
                    ret += E*info.fee;
                    if(++n == N-1) break;
                }
            }

            sb.append(Math.round(ret));
            System.out.println(sb);
        }
    }

    private static class Info implements Comparable<Info> {
        int i1;
        int i2;
        double fee;

        public Info(int i1, int i2, double fee) {
            this.i1 = i1;
            this.i2 = i2;
            this.fee = fee;
        }

        @Override
        public int compareTo(Info o) {
            return Double.compare(this.fee, o.fee);
        }
    }

    private static int find(int p) {

        if(parent[p] == p) return p;
        return parent[p] = find(parent[p]);
    }

    private static boolean union(int p1, int p2) {

        p1 = find(p1);
        p2 = find(p2);

        if(p1 == p2) return false;
        if(rank[p1] > rank[p2]) {
            int temp = p1;
                p1 = p2;
                p2 = temp;
        }
        parent[p1] = p2;
        if(rank[p1] == rank[p2]) ++rank[p2];
        return true;
    }
}

// 환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L^2)만큼 지불