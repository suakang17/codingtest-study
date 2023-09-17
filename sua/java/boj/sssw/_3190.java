package boj.sssw;

import java.io.*;
import java.util.*;

public class _3190 {
    
    static int N, K, L;
    static int[][] arr;
    static boolean[][] snake;

    // E(initial state)SWN
    static int[] dc = {0, 1, 0, -1};
    static int[] dr = {1, 0, -1, 0};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        snake = new boolean[N+1][N+1];
        snake[1][1] = true;  // initial location
        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;  // apple
        }
    }

    private static void game() throws IOException {

        int length = 1; // 초기 length
        L = Integer.parseInt(br.readLine());
        for(int l = 0; l < L; l++) {
            st = new StringTokenizer(br.readLine());  // 게임 시작 시간으로부터 X초가 끝난 뒤에 
            int X = Integer.parseInt(st.nextToken());  // L or 오른쪽(D)로 90도 방향회전
            char C = st.nextToken().charAt(0);

            move(length, snake, X, C);
        }
    }

    private static void move(int length, boolean[][] snakeState, int duration, char dir) {
        // ** 현재 머리 위치도..?
        int dirC = dc[dir];  // set head position
        int dirR = dr[dir];

        int t = 0;
        while(t < duration) {
            
            if(arr[nC][nR] == 1) {  // if apple

            }
        }
    }
}

// 사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지

// 사과를 먹으면 뱀 길이가 늘어남
// 벽, 자기자신과 부딪히면 gameover
// NxN board , 초기 길이 == 1, 초기 방향 == E, 초기 위치 == 1,1
// 매초이동

// 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
// 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다. (길이늘어서)
// 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다. (길이불변이므로)

// 맨 위 맨 좌측 (1행 1열) 에는 사과 x


// boolean t -> 뱀이 현재 위치하는 칸들