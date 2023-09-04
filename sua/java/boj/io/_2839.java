package boj.io;

import java.io.*;
import java.util.*;

public class _2839 {
    public static void main(String[] args) throws IOException{
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;

        while(N >= 0){
            if(N % 5 == 0){
                System.out.println(cnt + N/5);
                return;
            }
            N -= 3;
            cnt++;
        }
        System.out.println(-1);
    }
        
}
