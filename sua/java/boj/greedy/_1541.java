package boj.greedy;

import java.io.*;
import java.util.*;

public class _1541 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int sum = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        // 최대한 큰 수를 만들어 빼줘야함
        st = new StringTokenizer(br.readLine(), "-");

        while (st.hasMoreTokens()) {
            int temp = 0;
        
            StringTokenizer addition = new StringTokenizer(st.nextToken(), "+");
                    
            // 덧셈으로 나뉜 토큰들을 모두 더한다. 
            while (addition.hasMoreTokens()) {
                temp += Integer.parseInt(addition.nextToken());
            }
                    
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
