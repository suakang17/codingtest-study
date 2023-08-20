package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1222 {
    
    static int L, ret;
    static String str, res;
    static Stack<Character> opers;
    static Stack<Integer> nums;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        for(int t = 1; t <= 10; t++) {
            L = Integer.parseInt(br.readLine());
            str = br.readLine();
            opers = new Stack<>();
            // sb = new StringBuilder();
            ret = 0;
            res = "";

            // convert
            for(int l = 0; l < L; l++) {
                char obj = str.charAt(l);
                if(obj == '+') {
                    if (opers.isEmpty()) { 
                        opers.push(obj);
                    } else {
                        res += opers.pop();
                        opers.push(obj);
                    }
                }
                else { res += obj; }
            }
            
            while(!opers.isEmpty()) {
                res += opers.pop();
            }

            // cal
            nums = new Stack<>();
            for(int i = 0; i < res.length(); i++) {
				char obj = res.charAt(i);
				if(obj - '0' >= 0 && obj - '0' <= 9) {
					nums.push(obj - '0');
				}
				else {
					int num1 = nums.pop();
					int num2 = nums.pop();
					nums.push(num1 + num2);
				}
			}

            ret = nums.pop();

            System.out.println("#" + t + " " + ret);
            }
    }
}

// 피연산자인 숫자는 0 ~ 9의 정수