import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 시작지점과 도착지점이 같을 경우!
        if(N-1 == 0 && M-1 == 0){
            System.out.print(1);
            System.exit(0);
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        char[][] miro = new char[N][M];  // 미로 배열
        int[][] dist = new int[N][M];    // 거리 측정 배열
        boolean[][][] visit = new boolean[2][N][M];    // 벽을 부순 여부에 따라 방문 여부 기록
        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = s.charAt(j);
            }
        }

        // 시작점 세팅 (x좌표, y좌표, crash 여부)
        qu.offer(new int[]{0, 0, 0});

        while (!qu.isEmpty()) {
            int[] cur = qu.poll();  // 현재 위치 뽑기

            // 상,하,좌,우 탐색
            for(int i=0; i<4; i++){
                int nX = cur[0] + dx[i];
                int nY = cur[1] + dy[i];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                // 다음 칸에 벽이 있을 때 -> (1) 벽을 부순적이 있는지 체크
                //                        (2) 그 벽을 방문한적이 있는지 체크
                if (miro[nX][nY] == '1') {
                    if(cur[2] == 0 && !visit[1][nX][nY]){
                        visit[cur[2]][nX][nY] = true;    // 방문 처리
                        dist[nX][nY] = dist[cur[0]][cur[1]] + 1; // 거리 측정
                        qu.offer(new int[]{nX, nY, 1});    // 다시 큐에 넣어줘서 BFS!
                    }
                }
                // 벽이 아닐 경우 -> 벽을 "부순 여부"에 따른 방문을 했는지 체크!
                else{
                    if(!visit[cur[2]][nX][nY]){
                        // 해당 칸을 방문을 안했을 때!
                        visit[cur[2]][nX][nY] = true;    // 방문 처리
                        dist[nX][nY] = dist[cur[0]][cur[1]] + 1; // 거리 측정
                        qu.offer(new int[]{nX, nY, cur[2]}); // 다시 큐에 넣어줘서 BFS!
                    }
                }
                // 도착지점에 도달 했을 때 출력하고 종료!
                if(nX == N-1 && nY == M-1){
                    System.out.print(dist[nX][nY] + 1);
                    System.exit(0);
                }
            }
        }
        // 도달을 못했으므로 -1 출력!
        System.out.print(-1);
    }
}