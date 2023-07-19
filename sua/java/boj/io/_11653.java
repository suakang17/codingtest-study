package boj.io;

import java.io.*;
import java.util.*;

public class _11653 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1){ return; }
        for(int n = 2; n <= N; n++){
            while(N % n == 0){
                N /= n;
                System.out.println(n);
            }
        }
    }
}