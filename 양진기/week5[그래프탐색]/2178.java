import java.util.*;
import java.io.*;

class Main{
    static int[][] map;
    static int n, m;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // x방향 배열 - 상하(수학좌표랑 다름)
    static int[] dy = {0, 0, -1, 1}; // y방향 배열 - 좌우(수학좌표랑 다름)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(map[n-1][m-1]);
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {x, y});  // 초기 좌표(0,0) 배열 값 저장

        while(!q.isEmpty()){    // 다음 좌표가 없을 때까지 반복
            int now[] = q.poll(); // 맨 앞에 있는 좌표값 반환 후 삭제
            int curX = now[0]; // 좌표의 x
            int curY = now[1]; // 좌표의 y

            // 상하좌우 다 가보기
            for(int i=0; i<4; i++){
                // 다음 좌표는 현재 좌표에서 상하좌우 가보기
                /*
                    0일 때, (-1, 0) = 상
                    1일 때, (1, 0) = 하
                    2일 때, (0, -1) = 좌
                    3일 때, (0, 1) = 우
                 */
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 다음 x, y가 최소 범위(0,0) 미만이거나, 최대 범위(n,m)보다 크면 건너뛰기
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m){
                    continue;
                }

                // 다음 x, y 좌표가 벽(0)이거나, 이미 방문했던 좌표라면 건너뛰기
                if (visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }

                q.add(new int[] {nextX, nextY}); // 다음에 올 수 있는 좌표 배열 값들을 저장
                map[nextX][nextY] = map[curX][curY] + 1; // 이전 좌표에서 +1 씩 더함
                visited[nextX][nextY] = true; // 방문했음으로 체크
            }
        }
    }
}