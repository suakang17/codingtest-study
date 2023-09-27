package boj.solvedac;

import java.io.*;
import java.util.*;

public class _1074 {
    
    static int N, R, C, fullSize, cnt;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        fullSize = (int) Math.pow(2, N);
        solve(fullSize, R, C);  // size, goal
        System.out.println(cnt);

    }

    private static void solve(int size, int r, int c) {
        
        if(size == 1)
			return;
		
		if(r < size/2 && c < size/2) {  // 2
			solve(size/2, r, c);
		}
		else if(r < size/2 && c >= size/2) {  // 1
			cnt += size * size / 4;  // 2사분면치 더해주기
			solve(size/2, r, c - size/2);
		}
		else if(r >= size/2 && c < size/2) {  // 3
			cnt += (size * size / 4) * 2;  // 1, 2사분면치 더해주기
			solve(size/2, r - size/2, c);
		}
		else {  // 4
			cnt += (size * size / 4) * 3;  // 1, 2, 3사분면치 더해주기
			solve(size/2, r - size/2, c - size/2);
		}
    }
}

// [R][C]를 몇번째로 방문하는지
// 2^N x 2^N배열 -> 1 ≤ N ≤ 15

// 0 ≤ r, c < 2^N -> 순차탐색시 -> O(N) x

// 재귀 -> arr 사이즈에 대한 재귀 2^N -> size == 1일때까지 -> 재귀호출 N회
    // 기준: 몇사분면에 C R 존재하는지