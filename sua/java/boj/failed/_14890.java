package boj.failed;

import java.io.*;
import java.util.*;

public class _14890 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, L, ret;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < N; m++) {
                graph[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i=0; i<N; i++) {
            if(solution(i, 0, 'r')) cnt++;
            if(solution(0, i, 'c')) cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean solution(int x, int y, char dir) {
        int[] height = new int[N];
        boolean[] isRunway = new boolean[N];
        for(int i = 0; i < N; i++) {
            switch (dir) {
                case 'r':
                    height[i] = graph[x][y+i];
                    break;
            
                case 'c':
                    height[i] = graph[x+i][y];
                    break;
            }
        }

        for(int i = 0; i < N-1; i++) {
            int dif = height[i] - height[i+1];
            if(Math.abs(dif) >= 2) return false;  // con2
            if(dif == 0) continue;  // 길 O
            
            if(dif == 1) {  // 내리막
                for(int j = i+1; j <= i+L; j++) {
                    if(!isValid(j) || height[i+1] != height[j] || isRunway[j]) return false;  // con1, 3
                    isRunway[j] = true;
                }
                i += L-1;
            } else if(dif == -1) {  // 오르막
                for(int j = i; j > i-L; j--) {
                    if(!isValid(j) || height[i] != height[j] || isRunway[j]) return false;  // con1, 3
                    isRunway[j] = true;
                }
            }
        }

        return true;
    }

    public static boolean isValid(int x) {  // con4
        return x >= 0 && x < N;
    }
}

// ** goal 지나갈 수 있는 길의 개수
// 길: 길에 속한 칸의 높이 모두 동일해야 -> 경사로 만들어서 높이 맞출 수 o
// 경사로: 높이 1, 길이 L 
// 경사로 길이 연달아 높->낮 or 낮->높 만 가능
    // 1. 가능한 범위 탐색 (가로, 세로) - 연달아 증가, 감소
    // 2. 길 개수 증가