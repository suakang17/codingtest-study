package swea.practice;

import java.io.*;
import java.util.*;

public class _2006 {
    static int times;
    static int win;
    static int cnt = 0;
    static int comWin = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // public class DigitTest1 {

    // }

    // public class DigitTest2 {

    // }
    public static void main(String[] args) throws IOException {
        System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
        System.out.println();
        System.out.println("1. 5판 3승");
        System.out.println("1. 3판 2승");
        System.out.println("1. 1판 1승");
        System.out.println();
        System.out.print("번호를 입력하세요.");
        int T = Integer.parseInt(br.readLine());
        

        System.out.println();
        switch (T) {
            case 1:
                times = 5;
                win = 3;
                break;
        
            case 2:
                times = 3;
                win = 2;
                break;

            case 3:
                times = 1;
                win = 1;
                break;
        }

        for(int t = 0; t < times; t++) {
            
            System.out.print("가위바위보 중 하나 입력: ");
            int num = Integer.parseInt(br.readLine());
            switch (num) {
                case 1:
                    System.out.println("가위");
                    break;
            
                case 2:
                    System.out.println("바위");
                    break;

                case 3:
                    System.out.println("보");
                    break;
            }

            int comNum = (int) (Math.random()*3 + 1);
            

            if(comNum == num) {
                System.out.println("비겼습니다!!!");
            } else if(comNum == 1) {
                if(num == 2) {
                    System.out.println("이겼습니다!!!");
                    cnt++;
                } else {
                    System.out.println("졌습니다!!!");
                    comWin++;
                }
            } else if (comNum == 2) {
                if(num == 1) {
                    System.out.println("졌습니다!!!");
                    comWin++;
                } else {
                    System.out.println("이겼습니다!!!");
                    cnt++;
                }
            } else {
                if(num == 1) {
                    System.out.println("이겼습니다!!!");
                    cnt++;
                } else {
                    System.out.println("졌습니다!!!");
                    comWin++;
                }
            }
            
            if(cnt > comWin) {
                System.out.println("###유저 승!!!");
            } else { System.out.println("###컴퓨터 승!!!");}
    }
}
}


// 컴 유
// 1  2 유승
// 1  3 유패
// 2  1 유패
// 2  3 유승
// 3  1 유승
// 3  2 유패
// n  n 비김