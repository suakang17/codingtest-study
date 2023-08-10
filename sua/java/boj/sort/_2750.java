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

        // Arrays.sort(arr);

        // bubble
        // for(int j = arr.length; j > 0; j--) {
        //     for(int i = 1; i < j; i++) {
        //         if(arr[i] < arr[i-1]) {
        //             int temp = arr[i];
        //             arr[i] = arr[i-1];
        //             arr[i-1] = temp;
        //         }
        //     }
        // }

        // insertion
        // for(int i = 1; i < arr.length; i++) {
        //     for(int j = 0; j < i; j++) {
        //         if(arr[i] < arr[j]) {
        //             int temp = arr[i];
        //             arr[i] = arr[j];
        //             arr[j] = temp;
        //         }
        //     }
        // }

        // selection
        for(int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
