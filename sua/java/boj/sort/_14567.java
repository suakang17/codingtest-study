package boj.sort;

import java.io.*;
import java.util.*;

public class _14567 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M;
    static int[] inNode, result;
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[N+1];
        inNode = new int[N+1];
        graph = new ArrayList<>();
        for(int n = 0; n <= N; n++) {
            graph.add(new ArrayList<>());
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            inNode[b]++;
        }

        tplgcSort();

        sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static void tplgcSort() {
        q = new LinkedList<>();
        for(int n = 1; n <= N; n++) {
            if(inNode[n] == 0) q.add(n);
            result[n] = 1; // inNode 값 0 == 1학기 수강 가능
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            ArrayList<Integer> list = graph.get(cur);

            for(int next : list) {
                inNode[next]--;
                result[next] = Math.max(result[next], result[cur] + 1);
                if(inNode[next] == 0) q.add(next);
            }
        }
    }
}

// ** goal 모든 과목에 대해 각 과목을 이수하려면 최소 몇 학기가 걸리는지 계산

// 선수과목 -> 해당과목 : 위상정렬
// inNode[i] == 0 -> 들을 수 있는 순서