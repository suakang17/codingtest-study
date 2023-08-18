package swea.solvingclub;

import java.io.*;
import java.util.*;

public class re_1223 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int L, ret;
    static String res, str;
    static Stack<Character> opers;
    static Stack<Integer> nums;

    public static void main(String[] args) throws IOException {
        
        for(int t = 1; t <= 10; t++) {
            L = Integer.parseInt(br.readLine());
            str = br.readLine();
            opers = new Stack<>();
            nums = new Stack<>();
            res = "";
            ret = 0;

            // convert 
            for(int l = 0; l < L; l++) {
                char obj = str.charAt(l);

                if(obj == '+') {
                    if(!opers.isEmpty()) {
                        opers.push('+');
                    } else {
                        
                    }
                } else if(obj == '*') {
                    if(!opers.isEmpty()) {
                        
                    } else {
                        
                    }
                } else {
                    res += obj;
                }
            }
        }
    }
}
