package boj.failed;

import java.io.*;
import java.util.*;

public class failed_1874 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    static int N, num;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        
        // N = Integer.parseInt(br.readLine());
        // sb = new StringBuilder();
        
        // stack = new Stack<>();
        // int n = 0;

        // for(int i = 0; i < N; i++) {
        //     num = Integer.parseInt(br.readLine());
        //     if(num > n) {
        //         for(int j = n+1; j <= num; j++) {
        //             stack.push(j);
        //             sb.append("+").append("\n");
        //         }
        //         n = num;
        //     } else if(num != stack.peek()) {
        //         System.out.println("NO");
        //         System.exit(0);
        //     }
        //     stack.pop();
        //     sb.append("-").append("\n");
        // }

        // System.out.println(sb);

        // failed code
        // 조건처리인듯
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        
        stack = new Stack<>();
        int n = 1;
        stack.push(n++);
        sb.append("+").append("\n");

        for(int i = 0; i < N; i++) {  // input 개수
            num = Integer.parseInt(br.readLine());  // 수열 구성 숫자

            while(true) {
                if(stack.isEmpty()) { System.out.println("NO"); System.exit(0); }

                if(stack.peek() == num) {
                    stack.pop();
                    sb.append("-").append("\n");
                    break;
                } else if(stack.peek() < num) {
                    stack.push(n++);
                    sb.append("+").append("\n");
                } else {  // stack.peek() > num  // pop된 결과 == 수열이므로
                    System.out.println("NO");
                    System.exit(0);
                }
                
            }
        }

        System.out.println(sb);
    }
}
