package boj.solvedac;

import java.io.*;
import java.util.*;

public class _1655 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    static int N;
    static PriorityQueue<Integer> minpq, maxpq;
    public static void main(String[] args) throws IOException {
        
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        minpq = new PriorityQueue<>();
        maxpq = new PriorityQueue<>((o1, o2) -> o2-o1);

        for(int n = 0; n < N; n++) {
            
            if(maxpq.size() == minpq.size()) maxpq.add(Integer.parseInt(br.readLine()));
            else minpq.add(Integer.parseInt(br.readLine()));

            swap();
            sb.append(maxpq.peek()).append("\n");
        }

        System.out.println(sb);
    }

    private static void swap() {
        if(minpq.size() == 0 || maxpq.size() == 0) return;
        
        if(minpq.peek() < maxpq.peek()) {
            int temp = minpq.poll();
            minpq.add(maxpq.poll());
            maxpq.add(temp);
        }
    }
}

// *goal 지금까지 말한 수 중 중간값
// minpq && maxpq 