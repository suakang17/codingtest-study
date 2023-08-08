package boj.data_structure;

import java.io.*;
import java.util.*;

public class _10866 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int[] deque = new int[20001];
    static int N;
    static int front = 10000;
    static int end = 10000;
    static int size = 0;
    public static void main(String[] args) throws IOException {
    
        N = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
            case "push_front":
                push_front(Integer.parseInt(st.nextToken()));
                break;
        
            case "push_back":
                push_back(Integer.parseInt(st.nextToken()));
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

            case "pop_front":
                sb.append(pop_front());
                sb.append("\n");
                break;

            case "pop_back":
                sb.append(pop_back());
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

    private static void push_back(int x) {
        end++;
        size++;
        deque[end] = x;
    }

    private static void push_front(int x) {
        deque[front] = x;
        front--;
        size++;
    }

    private static int pop_front() {
        if(size == 0) { return -1; }
        int temp = deque[front + 1];
        front++;
        size--;
        return temp;
    }

    private static int pop_back() {
        if(size == 0) { return -1; }
        int temp = deque[end];
        end--;
        size--;
        return temp;
    }

    private static int size() {
        return size;
    }

    private static int empty() {
        if(size == 0) { return 1; }
        return 0;
    }

    private static int front() {
        if(size == 0) { return -1; }
        return deque[front + 1];
    }

    private static int back() {
        if(size == 0) { return -1; }
        return deque[end];
    }
}
