package boj.data_structure;

import java.io.*;
import java.util.*;

public class _2164 {
    
    static Scanner sc = new Scanner(System.in);
    static int N;

    static int[] q;
    static int s, e, size;
    public static void main(String[] args) throws IOException {
        
        N = sc.nextInt();
        q = new int[2*N+1];
        s = 0;
        e = N - 1;
        size = N;

        for(int i = 0; i < N; i++) {
            q[i] = i+1;
        }

        while(size >= 1) {
            if(size == 1) {
                System.out.println(q[e]);
                break;
            }
            pop();
            swap();
            
        }
    }

    private static void pop() {
        q[s] = -1;
        s++;
        size--;
    }

    private static void swap() {
        int temp = q[s++];
        e++;
        q[e] = temp;
    }
}
