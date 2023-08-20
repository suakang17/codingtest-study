package boj.failed;

import java.io.*;
import java.util.*;

public class failed_2615 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] board;
    static int cnt;
    static int[] winCR;

    public static void main(String[] args) throws IOException {
        
        board = new int[19][19];
        winCR = new int[2];

        for(int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // checkDiagLR(1);
        int ret = solve();
        if(ret != 0) {
        System.out.println(solve() + "\n" + winCR[0] + " " + winCR[1]); }
        else { System.out.println(0);}
        
    }

    static private int solve() {
        if(checkCol(1) || checkRow(1) || checkDiagLR(1) || checkDiagRL(1)) {
            return 1;
        } else if (checkCol(2) || checkRow(2) || checkDiagLR(2) || checkDiagRL(2)) {
            return 2;
        } return 0;
    }

    static private boolean checkRow(int wb) {
        
        for(int c = 0; c < 19; c++) {
            cnt = 0;
            for(int r = 0; r < 19; r++) {
                if(board[c][r] != wb) {
                    if(cnt == 5) { winCR[0] = c+1; winCR[1] = r-4-1+1; return true; }
                    cnt = 0;
                } else { cnt++; }
            }
            if(cnt == 5) { winCR[0] = c; winCR[1] = 14; return true; }
        }
        return false;
    }

    static private boolean checkCol(int wb) {
        
        for(int r = 0; r < 19; r++) {
            cnt = 0;
            for(int c = 0; c < 19; c++) {
                if(board[c][r] != wb) {
                    if(cnt == 5) { winCR[0] = c-4-1+1; winCR[1] = r+1; return true; }
                    cnt = 0;
                } else { cnt++; }
            }
            if(cnt == 5) { winCR[0] = 14; winCR[1] = r-4; return true; }
        }
        return false;
    }

    static private boolean checkDiagLR(int wb) {
        for(int c = 0; c < 19; c++) {
            for(int r = 0; r < 19; r++) {
                cnt = 0;
                int tempC = c, tempR = r;
                while(tempC < 19 && tempR < 19) {
                    if(board[tempC][tempR] != wb) {
                        if(cnt == 5) { winCR[0] = tempC-4-1+1; winCR[1] = tempR-1-4+1; return true; }
                        cnt = 0;
                        tempC++;
                        tempR++;
                    } else { cnt++; tempC++; tempR++; }
                }
            }
            if(cnt == 5) { winCR[0] = 14; winCR[1] = 14; return true; }
        }
        return false;
    }
    
    static private boolean checkDiagRL(int wb) {
        for(int c = 0; c < 19; c++) {
            for(int r = 0; r < 19; r++) {
                cnt = 0;
                int tempC = c, tempR = r;
                while(tempC < 19 && tempR >= 0) {
                    if(board[tempC][tempR] != wb) {
                        if(cnt == 5) { winCR[0] = tempC; winCR[1] = tempR+2; return true; }
                        cnt = 0;
                        tempC++;
                        tempR--;
                    } else { cnt++; tempC++; tempR--; }
                }
            }
            if(cnt == 5) { winCR[0] = 14; winCR[1] = 3; return true; }
        }
        return false;
    }
    
}


// 검은색 1
// 흰색 2