package boj.dp;

import java.io.*;
import java.util.*;

public class _1463 {
    
    static Scanner sc = new Scanner(System.in);

    static int N;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        
        N = sc.nextInt();
        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;

        System.out.println(calc(N));
    }

    private static int calc(int n) {
        
        if(dp[n] == null) {
            if(n % 6 == 0) {
                dp[n] = Math.min(calc(n-1), Math.min(calc(n/3), calc(n/2))) + 1;
            } else if(n % 3 == 0) {
                dp[n] = Math.min(calc(n/3), calc(n-1)) + 1;
            } else if(n % 2 == 0) {
                dp[n] = Math.min(calc(n/2), calc(n-1)) + 1; // 호출 순서 반대로 하면 시간초과
            } else {
                dp[n] = calc(n-1) + 1;
            }
        }

        return dp[n];
    }
}

// * goal 연산 횟수 최소값
// % 6, % 3, % 2, else 인 경우

// dp table 정의 dp[n] == n -> 1 최소 연산
// dp[n] = Math.min(calc(n-1), calc(n/3), calc(n/2)) + 1

// 같은코든데 왜 시간초과? 아래는 통과
// 자바의 함수 호출은 depth가 깊어질수록 매우 비효율적이 되는 것으로 보입니다. n-1을 먼저 호출하면 100만이 입력된 경우 재귀 깊이가 100만이 되지만 n/3이나 n/2가 먼저 호출되면 빠르게 1까지 도달하기 때문에 크게 깊어지지 않습니다.

// 예를 들어, dynamic(x)를 호출하기 전에 다음과 같은 코드를 넣는 것만으로도 매우 빨라집니다.

// 1
//         for (int i = 1; i <= x; i++)
// 2
//             dynamic(i);
// import java.util.Scanner;
// public class Main {
 
// 	static Integer[] dp;
 
// 	public static void main(String[] args) {
 
// 		Scanner in = new Scanner(System.in);
 
// 		int N = in.nextInt();
 
// 		dp = new Integer[N+1];
// 		dp[0] = dp[1] = 0;
 
// 		System.out.print(recur(N));
 
// 	}
 
// 	static int recur(int N) {
 
// 		if (dp[N] == null) {
// 			if (N % 6 == 0) {
// 				dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
// 			} else if (N % 3 == 0) {
// 				dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
// 			} else if (N % 2 == 0) {
// 				dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
// 			} else dp[N] = recur(N - 1) + 1;
			
// 		}
// 		return dp[N];
// 	}
 
// }