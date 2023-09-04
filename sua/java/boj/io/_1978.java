package boj.io;

import java.io.*;
import java.util.*;

public class _1978 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] inputnums = new int[N];

        for (int i = 0; i < s.length; i++) {
            inputnums[i] = Integer.parseInt(s[i]);
        }
        
        int[] nums = new int[10001];

        for (int j = 2; j < nums.length; j++){
            nums[j] = j;
        }
        
        for(int k = 2; k < nums.length; k++){
            if(nums[k] == 0) { continue; }
            for(int l = 2 * k; l < nums.length; l += k){
                nums[l] = 0;
            }
        }

        int ret = 0;
        for(int i = 0; i < inputnums.length; i++){
            // System.out.println(inputnums[i]);
            // System.out.println(nums[inputnums[i]]);
            if(nums[inputnums[i]] == inputnums[i]){
                ret++;
            }
        }

        System.out.println(ret);
    }
}
