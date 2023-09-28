package boj.solvedac;

import java.io.*;
import java.util.*;

public class _13460 {
    
    static int N, M, min, startRM, startRN, startBM, startBN, cnt;
    static char[][] arr;
    static Queue<int[]> q;
    static boolean[][][][] visited;

    // NESW
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for(int n = 0; n < N; n++) {
            String str = br.readLine();
            for(int m = 0; m < str.length(); m++) {
                arr[n][m] = str.charAt(m);
                if(arr[n][m] == 'R') {
                    startRN = n;
                    startRM = m;
                }
                if(arr[n][m] == 'B') {
                    startBN = n;
                    startBM = m;
                }
            }
        }

        System.out.println(solution(startRN, startRM, startBN, startBM));
    }

    private static int solution(int r, int c, int br, int bc) {
        q = new LinkedList<>();
        visited = new boolean[N][M][N][M];
        cnt = 1;  // != '#' 처리를 nr + dr[d]로 하므로

        q.add(new int[] {r, c, br, bc, cnt});
        visited[r][c][br][bc] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[4] > 10) { return -1; }

            for(int d = 0; d < 4; d++) {
                int nr = cur[0];
                int nc = cur[1];

                int nbr = cur[2];
                int nbc = cur[3];

                boolean isRedInHole = false;
				boolean isBlueInHole = false;

                while(arr[nr + dr[d]][nc + dc[d]] != '#') {  // 벽 만날 때 까지
                    nr += dr[d];
                    nc += dc[d];

                    if(arr[nr][nc] == 'O') {
                        isRedInHole = true;
                        break;
                    }
                }

                while(arr[nbr + dr[d]][nbc + dc[d]] != '#') {  // 벽 만날 때 까지
                    nbr += dr[d];
                    nbc += dc[d];

                    if(arr[nbr][nbc] == 'O') {
                        isBlueInHole = true;
                        break;
                    }
                }

                if(isBlueInHole) { continue; }  // 실패
                if(isRedInHole && !isBlueInHole) { return cur[4]; }

                // 구술 위치 겹치는 경우
                if(nr == nbr && nc == nbc) {
                    switch (d) {
                        case 0:  // N
                            if(cur[0] < cur[2]) {  // r이 더 위에 있었음
                                nbr++;
                            } else {
                                nr++;
                            }
                            break;

                        case 1:  // E
                            if(cur[1] < cur[3]) {  // r이 더 왼쪽에 있었음
                                nc--;
                            } else {
                                nbc--;
                            }
                            break;

                        case 2:  // S
                            if(cur[0] < cur[2]) {  // r이 더 위에 있었음
                                nr--;
                            } else {
                                nbr--;
                            }
                            break;

                        case 3:  // W
                            if(cur[1] < cur[3]) {  // r이 더 왼쪽에 있었음
                                nbc++;
                            } else {
                                nc++;
                            }
                            break;
                    }
                }

                if(!visited[nr][nc][nbr][nbc]) {
                    q.add(new int[] {nr, nc, nbr, nbc, cur[4]+1});
                    visited[nr][nc][nbr][nbc] = true;
                }
            }
        }
        return -1;
    }
}

// 빨간 구슬을 구멍을 통해 빼내는 게임 단, 파란 구슬이 구멍에 들어가면 안 된다.
// 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패

// 보드의 세로 크기는 N, 가로 크기는 M
// 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지
// 기울이기 NESW -> 1칸씩이 아님
// 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 // 불가시 -1 -> bfs
// '.' 빈 칸
// '#' 공이 이동할 수 없는 장애물 또는 벽
// 'O' 구멍의 위치
// 'R'은 빨간 구슬의 위치, 'B'는 파란 구슬의 위치

// RB이동 모두 q에 담기
// # 만날때까지 기울이기 이동 -> 이동 중 구멍에 빠지면 true처리
// RB bool값에 따라 처리

// visited 4d -> rr rc br bc 조합으로 처리