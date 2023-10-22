package boj.solvedac;

import java.io.*;
import java.util.*;

public class _13549 {

    static class Node{
        int idx;
        int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k;
    static int[] visited;
    static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); 
        k = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        bfs();
        System.out.println(visited[k]-1);
    }

    private static void bfs() {
        q = new LinkedList<>();
        q.add(new Node(n, 1)); 
        visited[n] = 1; 

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if(isValid(cur.idx*2)){  // 순간이동 (시간 그대로)
                if(visited[cur.idx*2] == 0 || visited[cur.idx*2] > cur.time) {
                    visited[cur.idx*2] = cur.time;
                    q.add(new Node(cur.idx*2, cur.time));
                }
            }

            if(isValid(cur.idx+1)){ 
                if(visited[cur.idx+1] == 0 || visited[cur.idx+1] > cur.time+1){
                    visited[cur.idx+1] = cur.time+1;
                    q.add(new Node(cur.idx + 1, cur.time + 1));
                }
            }

            if(isValid(cur.idx-1)){ 
                if(visited[cur.idx-1] == 0 || visited[cur.idx-1] > cur.time+1) {
                    visited[cur.idx - 1] = cur.time + 1;
                    q.add(new Node(cur.idx - 1, cur.time + 1));
                }
            }
        }
    }

    private static boolean isValid(int i) {
        if(i < 0 || i > 100000) return false;
        return true;
    }
}

// * goal 동생 찾는 가장 빠른 시간
// 2d arr bfs -> OOM...
