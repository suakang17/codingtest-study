package boj.io;

import java.io.*;
import java.util.*;

public class _9506 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            int N = Integer.parseInt(br.readLine());
            if(N == -1){ break; }

            int sum = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(N + " = ");

            for(int i = 1; i < N; i++){
                if(N % i == 0){
                    sum += i;
                    sb.append(i + " + ");
                }
            }

            if(sum != N){ System.out.println(N + " is NOT perfect."); }
            
            else {
                String str = sb.toString();
                if(str.endsWith(" ")){ 
                    str = str.substring(0, str.length() - 2);
                    System.out.println(str); }
            }

    }
}
}
