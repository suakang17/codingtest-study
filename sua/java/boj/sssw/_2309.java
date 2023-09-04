package boj.sssw;

import java.io.*;
import java.util.*;

public class _2309 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] height = new int[9];
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        
        for(int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }

        Arrays.sort(height);

        outer: for(int i = 0; i < 9; i++) {
            for(int j = i+1; j < 9; j++) {
                int sumOfTwo = height[i] + height[j];
                if(sum - sumOfTwo == 100) {
                    for(int k = 0; k < height.length; k++) {
                        if(k != i && k !=j) {
                            sb.append(height[k]);
                            sb.append("\n");
                        }
                    }
                    break outer;
                }
            }
        }

        System.out.println(sb);
    }
}
