import java.io.*;
import java.util.*;

class Main{
    static class Fireball{
        int r;  // 행
        int c;  // 열
        int m;  // 질량
        int s;  // 속력
        int d;  // 방향

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N, M, K;
    static ArrayList<Fireball> map[][];
    static ArrayList<Fireball> list = new ArrayList<>();    // 파이어볼들 모은 배열

    /*
        7 0 1       -x
        6   2   -y      +y
        5 4 3       +x

        (-1, 0) : 0 방향
        (-1, 1) : 1 방향
        (0,  1) : 2 방향
        (1,  1) : 3 방향
        (1,  0) : 4 방향
        (1, -1) : 5 방향
        (0, -1) : 6 방향
        (-1, -1) : 7 방향
     */

    static int dx[] = {-1, -1, 0, 1, 1,  1,  0, -1};
    static int dy[] = {0,   1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // N*N 격자
        M = Integer.parseInt(st.nextToken());   // 파이어볼 갯수
        K = Integer.parseInt(st.nextToken());   // 이동 횟수

        map = new ArrayList[N+1][N+1];
        for(int i=0; i<N+1; i++){
            for(int j=0; j<N+1; j++){
                map[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());  // r 행
            int c = Integer.parseInt(st.nextToken());  // c 열
            int m = Integer.parseInt(st.nextToken());  // m 질량
            int s = Integer.parseInt(st.nextToken());  // d 방향
            int d = Integer.parseInt(st.nextToken());  // s 속력

            map[r][c].add(new Fireball(r, c, m, s, d));
            list.add(new Fireball(r, c, m, s, d));
        }

        while(K-- > 0){

            move();

            for(int i=1; i<N+1; i++){
                for(int j=1; j<N+1; j++){
                    // 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
                    if(map[i][j].size() >= 2){
                        merge(i, j);    // 파이어볼 합치기
                    }
                }
            }
            makeList();
        }   // while end

        int ans = 0;
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(map[i][j].size() > 0){
                    for(Fireball cur : map[i][j]){
                        ans += cur.m;
                    }
                }
            }
        }   // i end
        System.out.println(ans);
    }   // main end

    static void move(){
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                map[i][j] = new ArrayList<>();
            }
        }

        for(Fireball cur : list){
            // 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
            // 문제 조건에 (4 <= N <= 50)인데 (1 <= S <= 1,000)으로 S가 N보다 더 크다
            // 즉, N번 이상 이동할 경우 N으로 나머지 연산한 결과와 동일하므로 (cur.s % N)을 해줍니다.
            cur.r = cur.r + dx[cur.d] * (cur.s % N);
            cur.c = cur.c + dy[cur.d] * (cur.s % N);

            if(cur.r > N) cur.r %= N;   // 행이 N을 초과하면 N으로 나머지 연산한 결과와 동일
            if(cur.c > N) cur.c %= N;   // 열이 N을 초과하면 N으로 나머지 연산한 결과와 동일
            if(cur.r <= 0) cur.r = N - Math.abs(cur.r);   // 행이 0 이하면
            if(cur.c <= 0) cur.c = N - Math.abs(cur.c);   // 열이 0 이하면

            map[cur.r][cur.c].add(cur);
        }
    }   // move end

    // 파이어볼 합치기
    static void merge(int x, int y){

        int sumM = 0, sumS = 0, sumCnt = 0, sumD = 0;
        boolean isEven = true;
        boolean isOdd = true;
        for(Fireball cur : map[x][y]){
            sumM += cur.m;
            sumS += cur.s;
            sumCnt++;
            if(cur.d % 2 == 0){
                isOdd = false;
            } else {
                isEven = false;
            }
        }

        int M = sumM / 5;       // 질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
        int S = sumS / sumCnt;  // 속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.

        map[x][y] = new ArrayList<>();

        if(M <= 0) return;  // 질량이 0인 파이어볼은 소멸되어 없어진다.

        if (isEven || isOdd) {  // 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면,
            for(int i=0; i<4; i++){ // 방향은 0, 2, 4, 6이 되고,
                map[x][y].add(new Fireball(x, y, M, S, i * 2));
            }
        } else {
            for(int i=0; i<4; i++){ // 그렇지 않으면 1, 3, 5, 7이 된다.
                map[x][y].add(new Fireball(x, y, M, S, i * 2 + 1));
            }
        }
    } // merge end

    static void makeList(){
        list = new ArrayList<>();
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(map[i][j].size() > 0){
                    for(Fireball cur : map[i][j]){
                        list.add(cur);
                    }
                }
            }
        }
    }
}