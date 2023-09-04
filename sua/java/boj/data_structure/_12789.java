package boj.data_structure;

import java.io.*;
import java.util.*;

public class _12789 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int numbering = 1;

    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        
        String[] str = br.readLine().split(" ");

        for(int n = 0; n < N; n++) {
            int num = Integer.parseInt(str[n]);
            q.add(num);
        }
        
        while(!q.isEmpty()) {
            if(numbering == q.peek()) {
                q.poll();
                numbering++;
            } else if (!stack.isEmpty() && stack.peek() == numbering) {
                stack.pop();
                numbering++;
            }
            else {
                stack.push(q.poll());
            }
        }

        while(!stack.isEmpty()) {
            if(stack.peek() == numbering) { 
                stack.pop();
                numbering++;
            } else {
                System.out.println("Sad");
                break;
            }
        }

        if(stack.isEmpty()) { System.out.println("Nice"); }

    }
}
