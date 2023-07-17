package boj.io;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class _10811 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        // initializing via stream 
        arr = IntStream.range(0, N+1).toArray();

        // traditional loop
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while(a < b){
                int temp = arr[a];
                arr[a++] = arr[b];
                arr[b--] = temp;
            }
        }


        // print via StringBuffer
        StringBuffer str = new StringBuffer();
        for(int j = 1; j <= N; j++)
            str.append(arr[j]).append(" ");

        System.out.println(str);
        
    }
}
