package boj.solvedac;

import java.io.*;
import java.util.*;

public class _1715 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, ret;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());

        for(int n = 0; n < N; n++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        ret = 0;
        while(pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();
        
            long sum = a + b;
            ret += sum;
            pq.add(sum);
        }

        System.out.println(ret);
    }
}

// *goal 카드 묶음들 골라 합치는데 필요한 최소 비교 횟수 
// 합친 결과 포함한 우선순위큐
// 1000*100000 -> long