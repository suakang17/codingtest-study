package boj.sort;

import java.io.*;
import java.util.*;

public class _1427 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");

        String strN = br.readLine();
        int[] nums = new int[10];

        for(int i = 0; i < strN.length(); i++){
            nums[strN.charAt(i) - '0']++;
        }

        for(int i = nums.length - 1; i >= 0; i--){
            while(nums[i]-- > 0){
                sb.append(i);
            }
        }

        System.out.println(sb);
    }
}
