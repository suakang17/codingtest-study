package boj.io;

import java.io.*;
import java.util.*;

public class _10818 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int min = 1000001;
        int max = -1000001;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int i = 0;
        
        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        

        for(i=0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }

            if(arr[i] < min){
                min = arr[i];
            }
        }
        
        System.out.println(min + " " + max);

        // 2
        Arrays.sort(arr);
        System.out.println(arr[0] + " " + arr[-1]);

        // 3
        min = Arrays.stream(arr).min().getAsInt();
        max = Arrays.stream(arr).max().getAsInt();
        System.out.println(min + " " + max);

}
}
