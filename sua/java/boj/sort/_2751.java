package boj.sort;

import java.io.*;
import java.util.*;

public class _2751 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        
        int N = Integer.parseInt(br.readLine());

        // 1 arrays.sort 1512ms 114508kb -> 시간초과 가능성 -> wrapper 써서 Collections.sort() 쓰기
        // int[] nums = new int[N];

        // for(int i = 0; i < N; i++){
        //     nums[i] = Integer.parseInt(br.readLine());
        // }

        // Arrays.sort(nums);
        // for(int val : nums){
        //     sb.append(val).append('\n');
        // }

        // System.out.println(sb);

        // 2 counting sort ver. boolean 736ms 94076kb
        // boolean[] countedNums = new boolean[2000001]; // 수 중복 x
        
        // for(int i = 0; i < N; i++){
        //     countedNums[Integer.parseInt(br.readLine()) + 1000000] = true;
        // }

        // for(int i = 0; i < countedNums.length; i++){
        //     if(countedNums[i]){
        //         sb.append((i - 1000000)).append('\n');
        //     }
        // }
        // System.out.println(sb);

        // 3 counting sort ver. int 748ms 99780kb
        int[] countedNums = new int[2000001]; // 수 중복 x
        
        for(int i = 0; i < N; i++){
            countedNums[Integer.parseInt(br.readLine()) + 1000000]++;
        }

        for(int i = 0; i < countedNums.length; i++){
            if(countedNums[i]-- > 0){  // 수 중복시 while로 switch 1644ms 333956kb
                sb.append((i - 1000000)).append('\n');
            }
        }
        System.out.println(sb);
    }
}
