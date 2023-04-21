import java.io.*;
import java.util.*;

class Main {

    static int m, n;
    static int[][] map;
    static int[][] dp;

    /*
        -1, 0 상
        0,  1 우
        1,  0 하
        0, -1 좌
     */
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m+1][n+1];
        dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1,1));
    }

    static int dfs(int x, int y){

        // 최종 목적지 도달
        if(x == m && y == n){
            return 1;
        }

        // 방문했을 경우
        if(dp[x][y] != -1){
            return dp[x][y];
        }

        // 방문 안 했을 경우
        else {
            dp[x][y] = 0;
            for(int i=0; i<dx.length; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어났을 경우 건너뛰기
                if(nx < 1 || ny < 1 || nx > m || ny > n){
                    continue;
                }

                // 현재 값이 더 큰 경우
                if(map[x][y] > map[nx][ny]){
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }
        return dp[x][y];
    }
}
