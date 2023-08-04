package boj.data_structure;

import java.util.*;
import java.io.*;

public class _1874 {

    static int N;
    static int num;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int n = 0; n < N; n++) {
            num = Integer.parseInt(br.readLine());
            
            if(!stack.isEmpty() && stack.peek() != num) {  // num 이전이면 
                for(int i = stack.peek() + 1; i <= num; i++) {
                    stack.add(i);
                    sb.append("+");
                    sb.append("\n");
                }  
            } else if (stack.isEmpty()) {
                for(int i = 1; i <= num; i++) {
                    stack.add(i);
                    sb.append("+");
                    sb.append("\n");
                }
            } 
            
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-");
                sb.append("\n");
            }
        }
    }
}
