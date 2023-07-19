package boj.io;

import java.io.*;
import java.util.*;

public class _2501 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int cnt = 0;

        for(int i = 1; i <= N+1; i++){
            if(i == N+1){ System.out.println(0); }
            if(N % i == 0){
                cnt++;
                if(cnt == K){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
