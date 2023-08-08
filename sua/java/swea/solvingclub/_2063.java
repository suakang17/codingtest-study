package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _2063 {

    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int i = 0;

        while(st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(arr[N/2]);
        
    }
}