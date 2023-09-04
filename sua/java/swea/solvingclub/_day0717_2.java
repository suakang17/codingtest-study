package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _day0717_2 {
    public static void main(String[] args) throws IOException{
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++){
            String memory = sc.next();
            char init = '0';
            int cnt = 0;

            for(int i = 0; i < memory.length(); i++){
                if(init != memory.charAt(i)) {
                    init = memory.charAt(i);
                    cnt++;
                }
            }
             System.out.println("#" + t + " " + cnt);
        }
    }
}