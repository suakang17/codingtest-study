package boj.failed;

import java.io.*;
import java.util.*;

public class _17071 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static Queue<Integer> q;
    static boolean[][] visited = new boolean[500001][2];

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());

    }

    private static int bfs() {
        q = new LinkedList<>();
        q.add(N);
        int time = 0;
        visited[N][0] = true;

        while (!q.isEmpty()) {
            
            int size = q.size();

            if(!isValid(K)) return -1;
            if(visited[K][time%2]) return time;
            
            for(int i = 0; i < size; i++) {
                int cur = q.poll();
                int nt = (time+1) % 2;
                if(isValid(cur*2)) {
                    if(!visited[cur*2][nt]) {
                    visited[cur*2][nt] = true;
                    q.add(cur*2);
                    }
                }

                if(isValid(cur+1)) {
                    if(!visited[cur+1][nt]) {
                    visited[cur+1][nt] = true;
                    q.add(cur+1);
                }
                }

                if(isValid(cur-1)) {
                    if(!visited[cur-1][nt]) {
                    visited[cur-1][nt] = true;
                    q.add(cur-1);
                }
            }
            }
            time++;
            K += time;
        }
        return -1;
    }

    private static boolean isValid(int x) {
        if (x < 0 || x > 500000) return false;
        return true;
    }

}

// * goal 동생 만나는 최단시간
// 동생은 걷기만 함, 동생이 이동하는 거리는 이전에 이동한 거리보다 1을 더한 만큼

// 1 naive bfs 완탐 -> 시간 초과
// 2 bfs visited..? -> 기준?
    // +1 -1 || -1 +1 -> 2초 후 제자리
    // 와리가리가 최적인 경우
    // 17 16 17 16 15
    // 5 6   8  11 15

// 동생 x에 짝수시간도착 && 수빈 x에 짝수시간도착 
// 동생 x에 홀수시간도착 && 수빈 x에 홀수시간도착