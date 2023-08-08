package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1966 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int T, N;
    static int[] arr;
    static int[] original;
    static int[] retArr;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());  // 5 <= N <= 50
            arr = new int[51];
            original = new int[51];
            retArr = new int[51];
            st = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                original[i] = num;
                arr[num]++;
            }


            for(int j = 1; j < arr.length; j++) {  // 누적합
                arr[j] += arr[j-1];
            }

            for(int k = arr.length - 1; k >= 0; k--) {
                retArr[arr[original[k]]] = original[k];
                arr[k]--;
            }

            sb = new StringBuilder();

            for(int l : retArr) {
                if(l != 0) {
                sb.append(l);
                sb.append(" ");
                }
            }

            System.out.println("#" + t + " " + sb);

        }
    }
}
