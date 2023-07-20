package boj.sort;

import java.io.*;
import java.util.*;

public class _2751 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        
        int N = Integer.parseInt(br.readLine());

        // 1 arrays.sort
        int[] nums = new int[N];

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);
        for(int val : nums){
            sb.append(val).append('\n');
        }

        System.out.println(sb);

        // 2 counting sort
        
    }
}
