package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1218 {
    
    static int L;
    static String str;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        
        outer : for(int t = 1; t <= 10; t++) {
            L = Integer.parseInt(br.readLine());
            str = br.readLine();
            stack = new Stack<>();
            for(int l = 0; l < L; l++) {
                char c = str.charAt(l);
                if (c == '(' || c == '[' || c == '{' || c == '<') { stack.push(c); }
                else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        System.out.println("#" + t + " " + 0);
                        continue outer;
                    }
                    else {
                        stack.pop();
                    }
                }
                else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        System.out.println("#" + t + " " + 0);
                        continue outer;
                    }
                    else {
                        stack.pop();
                    }
                }
                else if (c == '}') {
                    if (stack.isEmpty() || stack.peek() != '{') {
                        System.out.println("#" + t + " " + 0);
                        continue outer;
                    }
                    else {
                        stack.pop();
                    }
                }
                else if (c == '>') {
                    if (stack.isEmpty() || stack.peek() != '<') {
                        System.out.println("#" + t + " " + 0);
                        continue outer;
                    }
                    else {
                        stack.pop();
                    }
                }
            }

            System.out.println("#" + t + " " + 1);
        }
    }
}
