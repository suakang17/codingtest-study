package boj.sssw;

import java.io.*;
import java.util.*;

public class _16926 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M, R, group;
    static int[][] arr;

    // w n e s
    static int[] dc = {0, 1, 0, -1}; 
	static int[] dr = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int r = 0; r < R; r++) {
            rotate();
        }

        for(int[] inner : arr) {
            for(int x : inner) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static private void rotate() {

        group = Math.min(N, M) / 2;
        
        for(int g = 0; g < group; g++) {
            int c = g;
            int r = g;
            
            int temp = arr[c][r];  // start c r of each group

            int idx = 0;
            while(idx < 4) {
                int nc = c + dc[idx];
                int nr = r + dr[idx];

                if(nc >= c && nr >= r && nc < N - c && nr < M) {
                    arr[c][r] = arr[nc][nr];
                    c = nc;
                    r = nr;
                } else {
                    idx++;
                }
            }
            
        }

    }
}


// 회전 그룹
// 그룹별로 회전 r회 -> main서 구현
// 회전 그룹 별 시작, 종료 인덱스 +1, -1
// 그룹별 시작 값은 밀리므로 따로 저장 -> 후에 회전 후 자리에 삽입 -> 그룹수만큼 있음