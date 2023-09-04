package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1984 {
    
    static int T, num, max, min, sum, ret;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            sum = 0;
            ret = 0;
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            while(st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
                sum += num;
                if(num > max) { max = num; }
                if(num < min) { min = num; }
            }

            ret = (int) Math.round((sum - max - min) / 8.0);

            System.out.println("#" + t + " " + ret);
        }
    }
}
