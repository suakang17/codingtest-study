package boj.graph;

import java.io.*;
import java.util.*;

public class _2644 {
    
    static int N, M, X, Y, p1, p2, cnt;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int n = 0; n < N+1; n++) {
            graph.add(n, new ArrayList<>());
        }

        M = Integer.parseInt(br.readLine());
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        visited = new boolean[N+1];
        cnt = 0;
        dfs(p1);

        System.out.println(-1);
    }

    // failed: 인자로 cnt 넘겨주지않고 공용으로 사용하면 p2못만나는 경우까지 cnt
    // 인자로 cnt 처리해야됨
    private static void dfs(int p) {

        if(p == p2) {
            System.out.println(cnt);
            System.exit(0); 
        }
        
        visited[p] = true;
        for(int x : graph.get(p)) {
            if(!visited[x]) {
                cnt++;
                dfs(x);
            }
        }
    }
}

// dfs
// 부모자식관계 간선으로 이어두고
// dfs로 p1, p2만날때까지 cnt++

// pass
// res = -1;
//         dfs(p1, p2, 0);
// 		System.out.println(res);
// 	}

// 	static void dfs(int start, int end, int cnt) {
// 		if(start == end) {
// 			res = cnt;
// 			return; 
// 		}
		
// 		visited[start] = true;
// 		for(int x : graph.get(start)) { 
			
// 			if(!visited[x]) {
// 				dfs(x, end, cnt+1);
// 			}
// 		}
//     }