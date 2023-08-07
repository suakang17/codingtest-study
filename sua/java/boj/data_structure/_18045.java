package boj.data_structure;

import java.io.*;
import java.util.*;

class _18045 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int[] q = new int[10000];
    static int N;
    static int front = 0;
    static int end = 0;
    static int size = 0;
    
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    
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

                case "front":
                    sb.append(front());
                    sb.append("\n");
                    break;

                case "back":
                    sb.append(back());
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    private static void push(int x) {
        q[end] = x;
        end++;
        size++;
    }

    private static int pop() {
        if(size == 0) {
            return -1;
        }
        int temp = q[front];
        front++;
        size--;
        return temp;
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

    private static int front() {
        if(size == 0) {
            return -1;
        } else {
            return q[front];
        }
    }

    private static int back() {
        if(size == 0) {
            return -1;
        } else {
            return q[end-1];
        }
    }
}