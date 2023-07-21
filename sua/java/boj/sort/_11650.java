package boj.sort;

import java.io.*;
import java.util.*;

public class _11650 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        // 1 traditional 


        // lambda
        int[][] arr = new int[N][2];
        
        for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());  // x
			arr[i][1] = Integer.parseInt(st.nextToken());  // y
		}
		
		Arrays.sort(arr, (e1, e2) -> {  
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i< N ; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
		}
		System.out.println(sb);
	}
    
}
