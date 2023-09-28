package boj.solvedac;

import java.io.*;
import java.util.*;

public class _14499 {
    
    static int N, M, x, y, K, cmd;
    static int[][] arr;
    static int[] diceNum;

    // EWNS
    static int[] dx = {0, 0, -1, 1};  // N r
    static int[] dy = {1, -1, 0, 0};  // M c

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        Dice curDice = new Dice(1, 6, 2, 5, 4, 3);
        diceNum = new int[7];  // 0//123456
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            ReturnVal ret = solve(Integer.parseInt(st.nextToken())-1, x, y, curDice);
            x = ret.x;
            y = ret.y;
            curDice = ret.dice;
        }
    }

    private static ReturnVal solve(int cmd, int x, int y, Dice curDice) {
        
        int nx = x + dx[cmd];
        int ny = y + dy[cmd];

        ReturnVal ret = new ReturnVal(curDice, x, y);
        if(!isValidLoc(nx, ny)) return ret;

        // roll
        int t = curDice.top;
		int u = curDice.up;
		int d = curDice.down;
		int l = curDice.left;
		int r = curDice.right;
		int b = curDice.bottom;

        Dice nextDice;
        if(cmd == 0) nextDice = new Dice(l, r, u, d, b, t);  // E
        else if(cmd == 1) nextDice = new Dice(r, l, u, d, t, b);  // W
        else if(cmd == 2) nextDice = new Dice(d, u, t, b, l, r);  // N
        else nextDice = new Dice(u, d, b, t, l, r);  // S

        // num copy
        if(arr[nx][ny] == 0) {
            arr[nx][ny] = diceNum[nextDice.bottom];
            System.out.println(diceNum[nextDice.top]);
        } else {
            diceNum[nextDice.bottom] = arr[nx][ny];
            arr[nx][ny] = 0;
            System.out.println(diceNum[nextDice.top]);
        }

        ret.dice = nextDice;
        ret.x = nx;
        ret.y = ny;
        return ret;
    }

    public static class ReturnVal {
        Dice dice;
        int x;
        int y;

        ReturnVal(Dice dice, int x, int y) {
            this.dice = dice;
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isValidLoc(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        return true;
    }

    public static class Dice {

        int top, bottom, up, down, left, right;

        Dice(int top, int bottom, int up, int down, int left, int right) {
            this.top = top;
            this.bottom = bottom;
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
        }
    }
}

// 주사위 초기상태
// 윗 면이 1 동쪽을 바라보는 방향이 3 (x, y)에 위치
// 모든 면 0

// 주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수 == 0 : 주사위의 바닥면에 쓰여 있는 수가 칸에 복사
// != 0 : 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.

// 주사위는 지도의 바깥으로 이동시킬 수 없다
// 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.

// ** goal 주사위가 이동했을 때 마다 상단에 쓰여 있는 값을 구하는 프로그램 ** //
// cmd -> checkValidLoc -> roll -> numCopy