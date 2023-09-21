package boj.graph;

import java.io.*;
import java.util.*;

public class _1600 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int K, W, H;
    static int[][] graph;
    static boolean visited[][][];
    static Queue<int[]> q;

    // ESWN
    static int[] dwM = {1, 0, -1, 0};  // EW
    static int[] dhM = {0, 1, 0, -1};  // NS

    // NE -> NW clockWise
    static int[] dwH = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dhH = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        
        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[H+1][W+1];
        visited = new boolean[H+1][W+1][K+1];
        for(int h = 1 ; h <= H; h++) {
            st = new StringTokenizer(br.readLine());
            for(int w = 1; w <= W; w++) {
                graph[h][w] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    private static void bfs() {
        q = new LinkedList<>();
        q.add(new int[] {1, 1, 0, 0});
        visited[1][1][0] = true;
        // int k = 0;
        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            int h = cur[0];
            int w = cur[1];
            int cnt = cur[2];
            int k = cur[3];
            
            if(h == H && w == W) min = Math.min(cnt, min);
            

            if(k < K) {
                for(int d = 0; d < 8; d++) {
                    int nwH = w + dwH[d];
                    int nhH = h + dhH[d];
                    // System.out.println("W: " + nwH + " H: " + nhH + " cnt: " + cnt);
                    if(!isValid(nhH, nwH)) continue;
                    if(visited[nhH][nwH][k+1] || graph[nhH][nwH] == 1) continue;  // visited[nhH][nwH][k+1]에 해당하는 경우를 걸러줘야 메모리 초과 안남

                    visited[nhH][nwH][k+1] = true;
                    q.add(new int[] {nhH, nwH, cnt+1, k+1});
                    // System.out.println("********added********");
                    // System.out.println("k: " + k);
                }
            }

            for(int d = 0; d < 4; d++) {
                int nwM = w + dwM[d];
                int nhM = h + dhM[d];
                // System.out.println("W: " + nwM + " H: " + nhM + " cnt: " + cnt);
                if(!isValid(nhM, nwM)) continue;
                if(visited[nhM][nwM][k] || graph[nhM][nwM] == 1) continue;

                visited[nhM][nwM][k] = true;
                q.add(new int[] {nhM, nwM, cnt+1, k});
                // System.out.println("********added********");
            }
        }
        int ret = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(ret);
    }

    private static boolean isValid(int h, int w) {
        if(w <= 0 || h <= 0 || w > W || h > H) return false;
        return true;
    }
}


// 1,1 -> H,W 최소 이동 && K번 말, 그 외에는 인접칸
// 0 평지, 1 장애물

// bfs
// 말로 언제 움직일건지
// k가 K 이내인 경우 dwH dhH 함께 체크