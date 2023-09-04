package boj.data_structure;

import java.io.*;
import java.util.*;

public class _11866 {
    
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder("<");
    static int N, K;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        
        N = sc.nextInt();
        K = sc.nextInt();

        for(int n = 0; n < N; n++) {
            q.add(n+1);
        }

        int k = 1;
        while(!q.isEmpty()) {
            if(k == K) {
                sb.append(q.poll());
                if(q.size() > 0) {
                sb.append(", ");
                k = 1;
                }
            } else {
                q.add(q.poll());
                k++;
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}
