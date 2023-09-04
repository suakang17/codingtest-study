package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _2001 {
    
    static int N, M, T, max, sum;
    static int[][] arr, sumArr;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            
            max = Integer.MIN_VALUE;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            sumArr = new int[N+1][N+1];

            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int nn = 0; nn < N; nn++) {
                    arr[n][nn] = Integer.parseInt(st.nextToken());
                }
            }

            // 성능박살 4중포문 ~~
            // for(int i = 0; i < N-M+1; i++) {
            //     for(int j = 0; j < N-M+1; j++) {
            //         sum = 0;
            //         for(int m = 0; m < M; m++) {
            //             for(int mm = 0; mm < M; mm++) {
            //                 sum += arr[i+m][j+mm];
            //             }
            //         }
            //         max = Math.max(sum, max);
            //     }
            // }
            
            // 누적합 -> 부분합 최대값 찾기
            // 변수 == 파리 수
            // memo : 직사각형 내 겹치는 부분
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    sumArr[i][j] = arr[i-1][j-1] + sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1];
                }
            }
            
            for(int i = M; i <= N; i++) {
                for(int j = M; j <= N; j++) {
                    int ss = sumArr[i][j] - sumArr[i][j-M] - sumArr[i-M][j] + sumArr[i-M][j-M];
                    max = Math.max(ss, max);
                }
            }

            System.out.println("#" + t + " " + max);
            }
    }
}
