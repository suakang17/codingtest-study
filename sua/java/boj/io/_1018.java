package boj.io;

import java.io.*;
import java.util.*;

public class _1018 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] strNM = br.readLine().split(" ");
        int N = Integer.parseInt(strNM[0]);
        int M = Integer.parseInt(strNM[1]);

        String[][] board = new String[N][M];

        for(int n = 0; n < N; n++){
            String str = br.readLine();
            for(int m = 0; m < M; m++){
                if (str.charAt(m) == 'W'){
                    board[n][m] = "W";
                } else {
                    board[n][m] = "B";
                }
            }
        }

        int min = 64;
        // solution
        // 자르기 시작하는 인덱스를 옮겨가며 칠해야하는 수 갱신 -> 최솟값 출력
        // 시작 인덱스는 board 크기에 따라 고정
        for(int i = 0; i < N - 7 ; i++){
            for(int j = 0; j < M - 7; j++){
                min = Math.min(min, paint(i, j, board));
            }
        }
        System.out.println(min);

    }
    // board[x][y]서 시작해서 칠해야하는 수 return
        public static int paint(int x, int y, String[][] arr){
            
            int cnt = 0;
            // board[x][y]가 B W 에 따라 달라짐

            String color = "W"; // 첫번째 칸이 W인걸 기준으로 잡음
		
            for(int i = x ; i < x + 8 ; i++) { 
                for(int j = y ; j < y + 8 ; j++) {
                    
                    // color는 정상적인 체스판이고 WB[i][j]와 비교
                    if(!arr[i][j].equals(color)) {
                        cnt++;
                    }
                    
                    if(color.equals("W")) { // 컬러 변경 -> 이전 color와 반대로 switch
                        color = "B";
                    }else {
                        color = "W";
                    }
                }
                
                if(color.equals("W")) { // 줄이 바뀌면 바로 윗칸과 색깔이 달라야 함
                    color = "B";
                }else {
                    color = "W";
                }
            }

            cnt = Math.min(cnt, 64 - cnt);

            return cnt;
    }
}
