package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1974 {

    static int T;
    static boolean cell, col, row;
    static int[][] puzzle;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        outer : for(int t = 1; t <= T; t++) {
            puzzle = new int[9][9];
            for(int c = 0; c < 9; c++) {
                st = new StringTokenizer(br.readLine());
                for(int r = 0; r < 9; r++) {
                    puzzle[c][r] = Integer.parseInt(st.nextToken());
                }
            }

            for(int c = 0; c < 9; c++) {
                for(int r = 0; r < 9; r++) {
                    if(solve(r, c) == false) { System.out.println("#" + t + " " + 0); continue outer; }
                }
            }

            System.out.println("#" + t + " " + 1);
        }
    }

    private static boolean solve(int r, int c) {
        cell = false;
        col = false;
        row = false;

        if(r % 3 == 0 && c % 3 == 0) {
            cell = checkCell(r, c);
        } else { cell = true; }
        col = checkCol(c);
        row = checkRow(r);

        if(cell && col && row) { return true; }
        return false;
    }

    private static boolean checkRow(int R) {
        visited = new boolean[10];
        for(int c = 0; c < 9; c++) {
            if(!visited[puzzle[c][R]]) { visited[puzzle[c][R]] = true; }
            else { return false; }
        }
        return true;
        
    }

    private static boolean checkCol(int C) {
        visited = new boolean[10];
        for(int r = 0; r < 9; r++) {
            if(!visited[puzzle[C][r]]) { visited[puzzle[C][r]] = true; }
            else { return false; }
        }
        return true;
    }

    private static boolean checkCell(int r, int c) {
        visited = new boolean[10];
        for(int i = c; i < c+3; i++) {
            for(int j = r; j < r+3; j++) {
                if(!visited[puzzle[i][j]]) { visited[puzzle[i][j]] = true; }
                else { return false; }
            }
        }
        return true;
    }
}

// checkCell -> r, c가 모두 0, 3, 6번째 인덱스에 대해서만 검증