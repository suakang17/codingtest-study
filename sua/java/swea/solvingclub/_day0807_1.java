package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _day0807_1 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static int[] arr;
    static int max;
    static int min;
    static int maxIdx;
    static int minIdx;
    static int sum;
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            minIdx = -1;
            maxIdx = -1;
            double sum = 0.0;
            arr = new int[10];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
                if(arr[i] > max) { max = arr[i]; }
                if(arr[i] < min) { min = arr[i]; }
            }

            for(int i = 0; i < 10; i++) {
                if(i != maxIdx && i != minIdx) {
                    sum += arr[i];
                }
            }
            sum -= max + min;
            int ret = (int) Math.round(sum/8);

            System.out.println("#" + t + " " + ret); // ? convert?
        }
    }
}




// T = Integer.parseInt(br.readLine());

//         for(int t = 1; t <= T; t++) {
//             min = Integer.MAX_VALUE;
//             max = Integer.MIN_VALUE;
//             // minIdx = -1;
//             // maxIdx = -1;
//             double sum = 0.0;
//             arr = new int[10];

//             st = new StringTokenizer(br.readLine());
//             for(int i = 0; i < 10; i++) {
//                 arr[i] = Integer.parseInt(st.nextToken());
//                 sum += arr[i];
//                 if(arr[i] > max) { max = arr[i]; }
//                 if(arr[i] < min) { min = arr[i]; }
//             }

//             // for(int i = 0; i < 10; i++) {
//             //     if(i != maxIdx && i != minIdx) {
//             //         sum += arr[i];
//             //     }
//             // }
//             sum -= max + min;
//             int ret = (int) Math.round(sum/8);

//             System.out.println("#" + t + " " + ret);