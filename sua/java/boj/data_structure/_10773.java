package boj.data_structure;

import java.io.*;
import java.util.*;

public class _10773 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int K;
    static int[] stack;
    static int top = -1;
    static int total;

    static Stack<Integer> stack2 = new Stack<Integer>();
    public static void main(String[] args) throws IOException {

    // 1 list로 구현
    //     K = Integer.parseInt(br.readLine());
    //     stack = new int[K];

    //     for(int k = 0; k < K; k++) {
    //         int num = Integer.parseInt(br.readLine());
            
    //         if(num == 0) {
    //             // pop
    //             stack[top--] = 0;
    //         } else {
                
    //             stack[++top] = num;
    //         }
    //     }

    //     for(int i = 0; i < stack.length; i++) {
    //         total += stack[i];
    //     }

    //     System.out.println(total);

    // 2 stack module

    K = Integer.parseInt(br.readLine());
    for(int k = 0; k < K; k++) {
        int num = Integer.parseInt(br.readLine());

        if(num == 0) {
            stack2.pop();
        } else {
            stack2.push(num);
        }
    }
    for(int o : stack2) {
            total += o;
        }

        System.out.println(total);
    }
    
}
