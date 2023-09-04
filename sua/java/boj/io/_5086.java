package boj.io;

import java.io.*;
import java.util.*;

public class _5086 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            if(a == 0 && b == 0){ break; }

            if(a % b == 0){
                System.out.println("multiple");
            } else if(b % a == 0){
                System.out.println("factor");
            } else { System.out.println("neither");}
        }
    }
}
