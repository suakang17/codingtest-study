package boj.data_structure;

import java.io.*;
import java.util.*;

public class _10828 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] stack;
    static int size = 0;
    static int N;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        stack = new int[N];

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch(st.nextToken()) {
                case "push":
                    push(st.nextToken());
                    
                    break;

                case "pop":
                    sb.append(pop());
                    sb.append("\n");
                    break;

                case "size":
                    sb.append(size());
                    sb.append("\n");
                    break;

                case "empty":
                    sb.append(empty());
                    sb.append("\n");
                    break;
                
                case "top":
                    sb.append(top());
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    private static void push(String num) {
        int item = Integer.parseInt(num);
        stack[size++] = item;
    }

    private static int pop() {
        if(size == 0) {
            return -1;
        } else {
            int item = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return item;
        }
    }

    private static int size() {
        return size;
    }

    private static int empty() {
        if(size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int top() {
        if(size == 0) {
            return -1;
        } else {
            return stack[size - 1];
        }
    }
}
