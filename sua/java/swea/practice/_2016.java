package swea.practice;

import java.io.*;
import java.util.*;

public class _2016 {
    public static void main(String[] args) throws IOException{
        
        Scanner sc = new Scanner(System.in);
        
        int num = 0;
        while(num != 0){
            System.out.print("숫자를 입력하세요 : ");
            num = sc.nextInt();

            System.out.println("\n");

            for(int i = 1; i < 10; i++){
                System.out.println(num + " * " + i + " = " + num*i);
            }
        }

        System.out.println("프로그램 종료");
    }
}
