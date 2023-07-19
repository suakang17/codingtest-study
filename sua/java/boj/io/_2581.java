package boj.io;

import java.io.*;
import java.util.*;

public class _2581 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[10001];

        for(int i = 2; i < nums.length; i++){
            nums[i] = i;
        }

        for(int i = 2; i < nums.length; i++){
            if(nums[i] == 0){
                continue;
            }
            for(int j = 2*i; j < nums.length; j += i){
                nums[j] = 0;
            }
        }

        List<Integer> arr = new ArrayList<>();
        int sum = 0;

        for(int i = M; i <= N; i++){
            if(nums[i] == i){
                arr.add(i);
                sum += i;
            }
        }

        if(arr.isEmpty()) {System.out.println(-1);}
        else { 
            System.out.println(sum);
            System.out.println(Collections.min(arr));
        }
    }
}
