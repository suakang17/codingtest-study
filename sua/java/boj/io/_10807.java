package boj.io;

import java.io.*;
import java.util.*;

public class _10807 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        // 1
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        // 2
//        for (i = 0; i < arr.length; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }

        int v = Integer.parseInt(st.nextToken(br.readLine()));

        int cnt = 0;
        for (i = 0; i < arr.length; i++){
            if(arr[i] == v){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
