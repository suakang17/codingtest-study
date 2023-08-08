package boj.im;

import java.io.*;
import java.util.*;

public class _1592 {
    
    static int N, M, L, cnt;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N+1]; // idx번 사람이 공을 받은 횟수 arr[idx]

        cnt = 0;
        arr[1]++;
        gotBall(1);  
        
    }

    private static void gotBall(int x) { 
        while(true) {
            if(arr[x] == M) { System.out.println(cnt); break; }
            if(arr[x] % 2 != 0) { // 홀수면
                if(x+L < N) {
                    x += L;
                    arr[x]++;
                    cnt++;
                } else {
                    x = L-(N-x);
                    arr[x]++;
                    cnt++;
                }
                
            } else {  // 짝수면
                if(x-L >= 0) {
                    x -= L;
                    arr[x]++;
                    cnt++;
                } else {
                    x = N-(L-x);
                    arr[x]++;
                    cnt++;
                }
                
            }
        }
    }
}
