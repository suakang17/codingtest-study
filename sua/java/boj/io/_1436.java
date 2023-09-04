package boj.io;

import java.io.*;
import java.util.*;

public class _1436 {
    public static void main(String[] args) throws IOException{
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int n = 666;
        int cnt = 0;

        // System.out.println(N % 1000);
        
        // 1 나머지 이용 240ms
        // while(true){
            
        //     int temp = n;
        //     while(temp >= 666){
        //         if(temp % 1000 == 666){
        //             cnt++;
        //             if(cnt == N){ System.out.println(n); return; }
        //             break;  // 대상 숫자(n) 하나당 cnt를 올릴수 있는 기회는 한번이므로 if 문 이후에는 반드시 break 포함되어야
        //         } 
        //         temp /= 10; 
        //     }
        //     n++;
        // }
        
        // 2 String.valueOf 384ms
        while (true) {
            if (String.valueOf(n).contains("666")) {
                cnt++;
                if (cnt == N) {
                    System.out.println(n);
                    break;
                }
            }
            n++;
        }
    }
    
}
