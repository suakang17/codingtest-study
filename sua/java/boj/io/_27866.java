package boj.io;

import java.io.*;
import java.util.*;

public class _27866 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int i = Integer.parseInt(br.readLine());

        System.out.println(S.charAt(i-1));
    }
    
}
