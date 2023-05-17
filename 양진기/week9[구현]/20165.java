import java.io.*;
import java.util.*;

class Main{
    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, R;
    static int[][] map;
    static char[][] domino;

    /*
            -x
        -y      +y
            +x

        (-1, 0) : 상 / (1, 0) : 하 / (0, -1) : 좌 / (0, 1) : 우
     */
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        domino = new char[N+1][M+1];

        // 도미노 초기화
        for(int i=1; i<=N; i++){
            Arrays.fill(domino[i], 'S');
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(R-- > 0){
            st = new StringTokenizer(br.readLine());
            int atkX = Integer.parseInt(st.nextToken());
            int atkY = Integer.parseInt(st.nextToken());
            int dir = getDir(st.nextToken().charAt(0)); // 동 3, 서 2, 남, 1, 북 0

            st = new StringTokenizer(br.readLine());
            int defX = Integer.parseInt(st.nextToken());
            int defY = Integer.parseInt(st.nextToken());

            // 서있는 도미노를 선택했다면 공격
            if(domino[atkX][atkY] == 'S'){
                domino[atkX][atkY] = 'F';
                answer += attack(atkX, atkY, dir);
            }

            // 수비
            domino[defX][defY] = 'S';
        }   // while end

        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                sb.append(domino[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }   // main end

    static int attack(int x, int y, int dir){
        Queue<Point> q = new LinkedList<>();    // 선입선출
        q.add(new Point(x, y)); // 공격 지점 add

        int res = 1;
        while(!q.isEmpty()){    // 큐에 담겨 있을 때
            Point cur = q.poll();   // 맨 처음 꺼낸다.

            // 도미노의 높이
            int curH = map[cur.x][cur.y];

            // 높이 -1개 만큼 쓰러짐
            int nx = cur.x;
            int ny = cur.y;

            for(int i=1; i<curH; i++){
                nx += dx[dir];
                ny += dy[dir];

                // 범위를 벗어나면, 더이상 진행할 필요 x
                if(nx < 1 || ny < 1 || nx > N || ny > M) break;
//                if(!isValid(nx, ny)) break;

                // 이미 넘어져있다면 다음 반복(break X), 높이에 따라 더 진행할 수도 있기 때문
                if(domino[nx][ny] == 'F') continue;

                domino[nx][ny] = 'F';   // 넘어뜨리기
                res++;  // 공격점수 +
                q.add(new Point(nx, ny));   // 다음 넘어질 지점 큐에 넣기
            }
        }
        return res;
    }

    static int getDir(char c){
        if(c == 'E') return 3;
        else if(c == 'W') return 2;
        else if(c == 'S') return 1;
        else return 0;
    }

    static boolean isValid(int x, int y)
    {
        return x > 0 && y > 0 && x <= N && y <= M;
    }
}