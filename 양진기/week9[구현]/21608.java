import java.io.*;
import java.util.*;

class Main{

    /*
            -x
        -y    +y
            +x
        (-1, 0) : 상
        (0,  1) : 우
        (1,  0) : 하
        (0, -1) : 좌
    */
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int sum;    // 만족도의 총 합
    static int[] students;    // 학생
    static int[][] map;        // 좌석
    static Map<Integer, Set<Integer>> preferences;

    public static void main(String[] args) throws Exception{

        // 입력
        init();

        // 실행
        solution();

        // 출력
        resultPrint();
    }

    // 입력
    static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sum = 0;                    // 만족도 총 합
        students = new int[N*N];    // 학생
        map = new int[N][N];        // 좌석
        preferences = new HashMap<>();    // 좋아하는 학생

        for(int i=0; i<N*N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i] = Integer.parseInt(st.nextToken());

            preferences.put(students[i], new HashSet<>());
            for(int j=0; j<4; j++){
                preferences.get(students[i]).add(Integer.parseInt(st.nextToken()));
            }
        }
    }    // init end

    // 실행
    static void solution(){

        // 1. 학생들 자리 배치
        for(int i=0; i<students.length; i++){
            Seat seat = findSeat(students[i]);
            map[seat.x][seat.y] = students[i];
        }

        // 2. 점수 합산
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){

                // 주변 학생 수에 따라 점수 합산
                int count = getStudentSum(i, j, map[i][j]);

                if(count > 0){
                    // 0이면 0 / 1이면 1 / 2이면 10/ 3이면 100 / 4이면 1000 (10의 제곱)
                    sum += (int) Math.pow(10, count - 1);
                }
            }
        }

    }    // solution end

    // 좌석 찾기
    static Seat findSeat(int student){
        Seat seat = null;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){

                if(map[i][j] > 0){
                    continue;
                }

                // 현재 좌석의 정보(x, y, 주위 좋아하는 학생, 주위 빈칸 수)
                Seat cur = new Seat(i, j, getStudentSum(i, j, student), getEmptySum(i, j));

                // 비교할 좌석이 null 이라면 초기화 후 skip
                if(seat == null){
                    seat = cur;
                    continue;
                }

                // 이전 좌석과 현재 좌석 비교
                // 주위 좋아하는 학생 수와 주위 빈칸 수는 이전 좌석(seat)이 현재 좌석(cur)보다 적어야 만족
                // 행과 열은 이전 좌석(seat)이 현재 좌석(cur)보다 커야 만족
                if(seat.compareTo(cur) > 0){
                    seat = cur;    // 위를 만족해야 이전 좌석은 현재 좌석으로 갱신
                }
            } // j end
        } // i end
        return seat;
    } // findSeat end

    // 주변 좋아하는 학생 수 구하기
    static int getStudentSum(int x, int y, int student){

        int count = 0;

        for(int i=0; i<4; i++){    // 상우하좌 4가지 방향 계산
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 벗어나면 skip (0 미만이거나 N 이상일 때)
            if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                continue;
            }

            // 좋아하는 학생이 인접한 좌석에 있으면 카운트
            if(preferences.get(student).contains(map[nx][ny])){
                count++;
            }
        }
        return count;
    }

    static int getEmptySum(int x, int y){

        int count = 0;

        for(int i=0; i<4; i++){

            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 벗어나면 skip (0 미만이거나 N 이상일 때)
            if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                continue;
            }

            // 주위에 빈칸있으면 카운트
            if(map[nx][ny] == 0){
                count++;
            }
        }

        return count;
    }

    static void resultPrint(){
        System.out.println(sum);
    }

    // 좌석 정보를 저장할 Seat 클래스
    static class Seat implements Comparable<Seat>{
        int x;
        int y;
        int studentSum;    // 주변 좋아하는 학생 수
        int emptySum;    // 주변 빈칸 수

        public Seat(int x, int y, int studentSum, int emptySum){
            this.x = x;
            this.y = y;
            this.studentSum = studentSum;
            this.emptySum = emptySum;
        }

        /*
            1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
            2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
            3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로,
               그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
        */
        @Override
        public int compareTo(Seat o){

            // seat.compareTo(cur) > 0

            // 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
            // 자기자신의 좋아하는 학생 수가 파라미터보다 적어야 양수를 반환한다.
            if(studentSum != o.studentSum){
                return -(studentSum - o.studentSum);
            }

            // 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
            // 자기자신의 빈칸 수가 파라미터보다 적어야 양수를 반환한다.
            if(emptySum != o.emptySum){
                return -(emptySum - o.emptySum);
            }

            // 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로,
            // 자기자신의 행(x)이 파라미터보다 커야 양수를 반환한다.
            if(x != o.x){
                return x - o.x;
            }

            // 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
            // 자기자신의 열(y)이 파라미터보다 커야 양수를 반환한다.
            return y - o.y;
        }
    }
}