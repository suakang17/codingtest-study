package boj.data_structure;

import java.io.*;
import java.util.*;

public class failed_28278 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int num;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++) {
            String[] inputNum = br.readLine().split(" ");
            solution(inputNum);
        }

    }

    private static void solution(String[] ipn) {
        String cmd = ipn[0];

        switch (cmd) {
            case "1":
                stack.push(Integer.parseInt(ipn[1]));
                break;
        
            case "2":
                if(!stack.isEmpty()) {
                    int node = stack.pop();
                    System.out.println(node);
                } else {
                    System.out.println(-1);
                }
                break;
            
            case "3":
                System.out.println(stack.size());
                break;

            case "4":
                if(!stack.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
                break;

            case "5":
                if(!stack.isEmpty()) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }
                break;
        }
    }
}
