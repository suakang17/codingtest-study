package boj.io;

import java.io.*;
import java.util.*;

public class _10809 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];

        for(int i = 0; i < arr.length; i++){
            arr[i] = -1;
        }

        for(int j = 0; j < s.length(); j++){
            char ch = s.charAt(j);
            if(arr[ch - 'a'] == -1){
            arr[ch - 'a'] = j;
            }
        }

        for(int val : arr) {	// 배열 출력
			System.out.print(val + " ");
		}
    }    
}
