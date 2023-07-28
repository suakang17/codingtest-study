package boj.graph;

import java.io.*;
import java.util.*;

public class _2606 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] parent;

    static List<List<Integer>> graph = new ArrayList<>();;
    

    // union find
    // public static void main(String[] args) throws IOException{
        
    //     int N = Integer.parseInt(br.readLine());
    //     int M = Integer.parseInt(br.readLine());

    //     parent = new int[N+1];
    //     for(int i = 1; i < parent.length; i++){
    //         parent[i] = i;
    //     }

    //     for(int m = 0; m < M; m++){
    //         st = new StringTokenizer(br.readLine());
    //         int c1 = Integer.parseInt(st.nextToken());
    //         int c2 = Integer.parseInt(st.nextToken());

    //         merge(c1, c2);
    //     }
    //     int root = find(1);
    //     int cnt = 0;

    //     for(int i = 2; i <= N; i++){
    //         if(find(i) == root){ cnt++; }
    //     }

    //     System.out.println(cnt);

    // }

    // private static int find(int x) {
    //     if (x == parent[x])
	// 		return x;

	// 	int root = find(parent[x]);
	// 	parent[x] = root;
	// 	return root;

    //     // if(parent[x] != x){ 
    //     //     parent[x] = find(parent[x]); 
    //     // }
    //     // return parent[x];
    // }

    // private static void merge(int a, int b) {
    //     a = find(a);
    //     b = find(b);

    //     if(a != b){ parent[b] = a; }
    // }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for(int n = 0; n < N + 1; n++){
            graph.add(new ArrayList<>());
        }

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            graph.get(c1).add(c2);
            graph.get(c2).get(c1);
        }
    }
}
