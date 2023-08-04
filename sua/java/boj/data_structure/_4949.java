package boj.data_structure;

import java.io.*;
import java.util.*;

public class _4949 {

    static Stack<Character> stack;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        
        while(true) {
            String str = br.readLine();
            if(str.equals(".")) {
                break;
            } else
            System.out.println(solution(str));
        }
    }

    private static String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[')
                stack.push(c);

            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(')
                    return "no";
                else
                    stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[')
                    return "no";
                else
                    stack.pop();
            }
        }

        if (stack.isEmpty())
            return "yes";
        else
            return "no";
    }
}
