package boj.sssw;

import java.io.*;
import java.util.*;

public class _1026 {
    
    static int N, S;
    static Integer[] A, B;
    static int[] cntB;

    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        A = new Integer[N];
        B = new Integer[N];
        cntB  = new int[101];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);  // minA -> maxA

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            cntB[B[i]]++;
        }

        int idx = 0;
        for(int i = cntB.length - 1; i >= 0; i--) {
            while(cntB[i]-- > 0) {
                S += A[idx++] * i;
            }
        }

        System.out.println(S);
    }
}

// S가 최소가 되는 A의 순서 (B는 순서 고정)
// naive -> N! (maxA minB ... -> minA maxB 가 되도록 배치) 
        // -> A정렬 O(nlogn or n^2) (Arrays.sort()) && B max -> min 찾으며 배치 O(n^2) -> ㄱㅊ -> 그리디
        // B 복사 -> 정렬 -> index로 link