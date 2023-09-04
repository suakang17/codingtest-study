package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1966 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int T, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        // insertion sort
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());  // 5 <= N <= 50
            
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int n = 0; n < N; n++) {
                arr[n] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i < arr.length; i++) {
                for(int j = 0; j < i; j++) {
                    if(arr[j] > arr[i]) {
                        int temp =  arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }

            sb = new StringBuilder();
            for(int x : arr) {
                sb.append(x).append(" ");
            }

            System.out.println("#" + t + " " + sb);

        }
    }
}

// counting sort
// T = Integer.parseInt(br.readLine());

//         for(int t = 1; t <= T; t++) {
//             N = Integer.parseInt(br.readLine());  // 5 <= N <= 50
//             arr = new int[51];
//             original = new int[51];
//             retArr = new int[51];
//             st = new StringTokenizer(br.readLine());
            
//             for(int i = 0; i < N; i++) {
//                 int num = Integer.parseInt(st.nextToken());
//                 original[i] = num;
//                 arr[num]++;
//             }


//             for(int j = 1; j < arr.length; j++) {  // 누적합
//                 arr[j] += arr[j-1];
//             }

//             for(int k = arr.length - 1; k >= 0; k--) {
//                 retArr[arr[original[k]]] = original[k];
//                 arr[k]--;
//             }

//             sb = new StringBuilder();

//             for(int l : retArr) {
//                 if(l != 0) {
//                 sb.append(l);
//                 sb.append(" ");
//                 }
//             }

//             System.out.println("#" + t + " " + sb);

//         }