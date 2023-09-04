package swea.solvingclub;

import java.util.*;
import java.io.*;

public class _8931 {
    
    static int TC, K, num, sum;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> s;
    public static void main(String[] args) throws IOException {
        
        TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++) {
            K = Integer.parseInt(br.readLine());
            s = new Stack<>();
            sum = 0;
            
            for(int k = 0; k < K; k++) {
                num = Integer.parseInt(br.readLine());
                if(num == 0) {
                    s.pop();
                } else {
                    s.push(num);
                }
            }

            while(!s.isEmpty()) {
                int tmp = s.pop();
                sum += tmp;
            }

            System.out.println("#" + tc + " " + sum);
        }        
    }
}

