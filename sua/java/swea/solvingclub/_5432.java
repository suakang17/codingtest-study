package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _5432 {
    
    static int T, cnt, idx;
    static String str;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            stack = new Stack<>();
            str = br.readLine();
            cnt = 0;
            idx = 1;
            for(int s = 0; s < str.length(); s++) {
                char c = str.charAt(s);
                if (c == '(') { stack.push(idx); }
                else {
                    if(idx - stack.peek() == 1) {  // lazer
                        stack.pop();
                        cnt += stack.size();
                    } else {
                        stack.pop();
                        cnt+=1;
                    }
                }
                idx++;
            }

            System.out.println("#" + t + " " + cnt);
        }
    }
}
