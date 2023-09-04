package boj.data_structure;

import java.io.*;
import java.util.*;

public class _9012 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static Stack<Character> stack;
    static int size = 0;
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            stack = new Stack<>();
            String str = br.readLine();

            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == '(') {
                    stack.push(c);
                } else if(c == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    } else {
                        stack.push(c);
                    }
                } 
                }

                if(stack.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
        }
        }
    
}
