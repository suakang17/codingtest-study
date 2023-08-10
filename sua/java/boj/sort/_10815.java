package boj.sort;

import java.io.*;
import java.util.*;

public class _10815 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, lo, hi, mid;
    static ArrayList<Integer> arr1, arr2;

    public static void main(String[] args) throws IOException { 

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr1 = new ArrayList<>();
        while(st.hasMoreTokens()) {
            arr1.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr2 = new ArrayList<>();
        while(st.hasMoreTokens()) {
            arr2.add(Integer.parseInt(st.nextToken()));
        }

        // 가지고 있는지 아닌지 -> 이분법 해답 -> 이분탐색
        Collections.sort(arr1);

        lo = 0;
        hi = N;
        for(int num : arr2) {
            while(lo + 1 < hi) {
                mid = (lo + hi) / 2;
                
                if(num == arr2.get(mid)) {
                    System.out.println("1");
                    break;
                } else if (arr2.get(mid) > )
            }
        }
    }
}
