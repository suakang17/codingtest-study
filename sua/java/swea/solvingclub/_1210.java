package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1210 {
    
    static int[][] arr;
    static boolean[][] visited;
    static int col, row, next;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        for(int t = 1; t <= 10; t++) {
            arr = new int[100][100];
            visited = new boolean[100][100];
            int T = Integer.parseInt(br.readLine());
            
            for(int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if(num == 2) {
                        col = i;
                        row = j;
                    }
                    arr[i][j] = num;
                }
            }

            next = 0;
            while(col > 0) {

                if(row-1 >= 0 && arr[col][row-1] == 1 && !visited[col][row-1]) {
                    next = -1;
                } else if (row+1 < 100 && arr[col][row+1] == 1 && !visited[col][row+1]) {
                    next = 1;
                } else {
                    next = 0;
                }

                if(next == -1) {  // 왼쪽
                    row--;
                    visited[col][row] = true;
                } else if (next == 1) { // 오른쪽
                    row++; 
                    visited[col][row] = true;
                } else if (next == 0) {
                    col--;
                    visited[col][row] = true;
                }
            }
        
            System.out.println("#" + t + " " + row);
            }    
    }
}
