package boj.io;

import java.io.*;
import java.util.*;

public class _2675 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 0; t < T; t++){
            String[] str = br.readLine().split(" ");
            int R = Integer.parseInt(str[0]);
            String S = str[1];

            for(int i = 0; i < S.length(); i++){
                for(int j = 0; j < R; j++){
                    System.out.print(S.charAt(i));
                }
                
            }
            System.out.println();
        }
    }
}
