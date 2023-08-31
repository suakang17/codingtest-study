package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _14229 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] A = new int[1000000];
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        int i = 0;
        while(st.hasMoreTokens()) {
            A[i++] = Integer.parseInt(st.nextToken());
        }

        tmp = new int[A.length];
        mergeSortTD(0, A.length-1);
        System.out.println(A[500000]);
    }

    // top-down
    public static void mergeSortTD(int start, int end) {
        if(start < end) {
            int mid = (start+end) / 2;
            mergeSortTD(start, mid);
            mergeSortTD(mid+1, end);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while(p <= mid || q <= end) {
                if(q > end || (p <= mid && A[p] < A[q])) {
                    tmp[idx++] = A[p++];
                } else {
                    tmp[idx++] = A[q++];
                }
            }

            for(int i = start; i <= end; i++) {
                A[i] = tmp[i];
            }
        }
    }

    // bottom-up
    public static void mergeSortBU() {

    }
}