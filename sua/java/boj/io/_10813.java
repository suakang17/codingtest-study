package boj.io;

import java.io.*;
import java.util.*;

public class _10813 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1]; // 인덱싱 편하게 +1

        for(int i = 1; i < N+1; i++){ 
            arr[i] = i; 
        }

        for(int j = 0; j < M; j++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int temp;
            temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        for(int k = 1; k < arr.length; k++){
            bw.write(arr[k] + " ");
        }

        bw.flush();
        bw.close();

    }
}
