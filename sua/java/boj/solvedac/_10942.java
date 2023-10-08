package boj.solvedac;

import java.io.*;
import java.util.*;

public class _10942 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M, start, end;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        arr = new int[N+1];
        dp = new int[N+1][N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){  // E
            arr[i] = Integer.parseInt(st.nextToken());
            for(int j = 1; j <= i; j++) {  // S
                if(i == j) dp[i][j] = 1;  // 범위 길이 == 1
                else if(i-j == 1) {
                    dp[j][i] = (arr[i] == arr[j]) ? 1 : 0;
                }  // 범위 길이 == 2
                else {  // 범위 길이 >= 3
                    dp[j][i] = (arr[i] == arr[j] && dp[j+1][i-1] == 1) ? 1 : 0;
                }
            }
        }
        M = Integer.parseInt(br.readLine());
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            sb.append(dp[start][end]).append("\n");
        }

        System.out.println(sb);
    }
}

// * goal 질문에 대한 답 출력 (isPalin 1, else 0)
// 자연수 n개 -> 질문 M개
// 질문 [S E] isPalindrome -> t1 / f0

// 1 naive 시간복잡도 어마무시 -> x
// arr 크기 짝수인 경우 while 탈출 불가 -> 넘어가버림
// while(l != r) {
//             if(!arr.get(l).equals(arr.get(r))) return 0; 
//             l++;
//             r--;
//         }
//         return 1;
//     }

// 2 부분 구조 겹치는 구조 존재 -> bt
    // 동일한 arr에 대한 범위만 다른 질문이므로
    // 3 1 2 1 4 -> 3 3인 경우 true -> 2 3 인 경우 하나만 더 확인하면 됨(인덱스차이만큼)
    // dp[start][end] = t / f