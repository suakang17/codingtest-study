package boj.sort;

import java.io.*;
import java.util.*;

public class failed_1920 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] arr1, arr2;

    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        arr1 = new int[N];
        arr2 = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int n = 0; n < N; n++) {
            arr1[n] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int m = 0; m < M; m++) {
            arr2[m] = Integer.parseInt(st.nextToken());
        }

        // m이 arr1에 있나 없나 -> 결정 문제의 답이 이분법 => 이분탐색
        // 특정 수 m에 대해 arr1에 m이 있나 없나 -> arr1을 m에 대한 t/f로 변환해서 생각가능
        // how? arr1 정렬 후 m보다 크거나 같으면 t 아니면 f -> t/f의 경계 찾기 (경계 == 답)

        Arrays.sort(arr1);

        for(int m = 0; m < M; m++) {
            int target = arr2[m];
            int lo = 0; // 탐색할 범위 내에 경계가 있어야하므로 dummy data 포함 위함
            int hi = N-1;

            while(lo + 1 < hi) {
                int mid = (lo + hi) / 2;
                
                if(arr1[mid] == target ) { System.out.println("1"); break; }
                else if (arr1[mid] > target) { hi = mid; } 
                else if (arr1[mid] < target) { lo = mid; } 
                else { System.out.println("0"); break; }
            }
            
            if(lo > hi) { System.out.println("0");}
            if(hi != N - 1 && arr1[hi] == target || (N == 1 && arr1[0] == target)) { 
                System.out.println("1");
            }else {
                System.out.println("0");
            }
        }
    }
}
