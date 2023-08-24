package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _2805 {
    
    static int T, N, ret;
    static int[][] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        

        for(int t = 0; t < T; t++){
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            for(int n = 0; n < N; n++) {
                arr.add(new ArrayList<>());
            }

            int mid = (int) (N / 2);
            int start = mid;
            int end = mid;
            int sum = 0;

            for(int n = 0; n < N; n++) {
                String[] str = br.readLine().split("");
                for(int m = 0; m < str.length; m++) {
                    arr.get(n).add(Integer.parseInt(str[m]));
                }
            }

            
            for(int row = 0; row < N; row++) {
                for(int idx = start; idx < end + 1; idx++) {
                    sum += arr.get(row).get(idx);
                }

                if(row < mid) {
                    start -= 1;
                    end += 1;
                } else {
                    start += 1;
                    end -= 1;
                }
            }
            
            
            System.out.println("#" + (t+1) + " " + sum);
            
        }
    }
}
