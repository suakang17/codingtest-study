package boj.sssw;

import java.io.*;
import java.util.*;

public class _13460 {
    
    static int N, M;
    static char[][] arr;
    static int[] dr = {};
    static int[] dc

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int n = 0; n < N; n++) {
            String str = br.readLine();
            for(int m = 0; m < str.length(); m++) {
                arr[n][m] = str.charAt(m);
            }
        }

        
    }
}

// 빨간 구슬을 구멍을 통해 빼내는 게임 단, 파란 구슬이 구멍에 들어가면 안 된다.
// 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패

// 보드의 세로 크기는 N, 가로 크기는 M
// 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지
// 기울이기 NESW
// 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 // 불가시 -1
// '.' 빈 칸
// '#' 공이 이동할 수 없는 장애물 또는 벽
// 'O' 구멍의 위치
// 'R'은 빨간 구슬의 위치, 'B'는 파란 구슬의 위치