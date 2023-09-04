package boj.graph;

import java.io.*;
import java.util.*;

public class _14503 {
    
    static int N, M, curN, curM, curD, ret;
    static int[][] arr;
    static boolean[][] isCleaned;
    static Queue<int[]> q;

    // nesw
    static int[] dn = {-1, 0, 1, 0};
    static int[] dm = {0, 1, 0, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        curN = Integer.parseInt(st.nextToken());
        curM = Integer.parseInt(st.nextToken());
        curD = Integer.parseInt(st.nextToken());

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        ret = 0;
        bfs(curN, curM, curD);
        System.out.println(ret);
    }

    private static void bfs(int n, int m, int d) {
        q = new LinkedList<>();
        isCleaned = new boolean[N][M];

        q.add(new int[] {n, m});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(arr[now[0]][now[1]] == 0 && !isCleaned[now[0]][now[1]]) {  // 1
                isCleaned[now[0]][now[1]] = true;
                ret++;
            }

            // 주변 칸 돌며 확인 후 step 2, 3 진행 -> 진행하며 방문할 칸 q에 담기
            // int dChecked = 0;
            int uncleaned = 0;
            for(int i = 0; i < 4; i++) {  
                // if(dChecked < 4) { i = (i+1) % 4; continue; }
                // if(dChecked == 4) {
                //     break;
                // }

                int nn = now[0] + dn[i];
                int nm = now[1] + dm[i];

                if(nn < 0 || nm < 0 || nn >= N || nm >= M) {
                    continue;
                }

                if(!isCleaned[nn][nm] && arr[nn][nm] == 0) { uncleaned++; }
            }

            if(uncleaned > 0) {  // step 3
                while(true) {
                    d = (d-1 < 0) ? 3 : d-1;  // 3-1
                    int nn = now[0] + dn[d];  // 바라보는 방향 기준 앞 칸
                    int nm = now[1] + dm[d];

                    if(nn >= 0 && nm >= 0 && nn < N && nm < M && arr[nn][nm] == 0 && !isCleaned[nn][nm]) {
                        q.add(new int[] {nn, nm});
                        break;
                    }
                }
            } else {
                // step 2
                int nn = now[0] - dn[d];  // 2-1
                int nm = now[1] - dm[d];

                if(nn < 0 || nm < 0 || nn >= N || nm >= M || arr[nn][nm] == 1) {
                    return; // 작동 stop
                } else {
                    q.add(new int[] {nn, nm});  // 가능하면 후진
                }
            }
        }
    }
}

// 방의 상태가 주어졌을 때, 청소하는 영역의 개수 
// 방 N * M
// 벽 1, 빈칸 0 
// 처음에 빈 칸은 전부 청소되지 않은 상태

// 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.

// 2. 현재 칸의 주변 4칸이 모두 청소된 경우
// 2-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
// 2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.

// 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
// 3-1. 반시계 방향으로 90도 회전
// 3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
// 3-3. 1번으로 돌아간다.