package swea.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _2019 {
    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ttl = 0;

        for(int n = 1; n <= num; n++) {
            if(n % 2 == 0) {ttl += n;}
        }

        System.out.println(ttl);
    }
}
