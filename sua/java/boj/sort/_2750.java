package boj.sort;

import java.io.*;
import java.util.*;

public class _2750 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int n = 0; n < N; n++){
            int num = Integer.parseInt(br.readLine());
            arr[n] = num;
        }

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
