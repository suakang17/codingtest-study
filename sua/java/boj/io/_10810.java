package boj.io;

import java.io.*;
import java.util.*;

public class _10810 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for(int j = a - 1; j < b; j++){
                arr[j] = c;
            }
            
        }

        for(int k = 0; k < arr.length; k++) {
            bw.write(arr[k]+ " ");
        }

        br.close();
        bw.flush();
        bw.close();

    }
}