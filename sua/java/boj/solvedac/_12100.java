package boj.solvedac;

import java.io.*;
import java.util.*;

public class _12100 {
    
    static int N, answer;
    static int[][] arr;

    // NSWE
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < N; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        game(0);
        System.out.println(answer);
    }
    
    public static void game(int count) {
        if(count == 5) {
            findMax();
            return;
        }
        int copy[][] = new int[N][N];
        for(int i = 0; i < N; i++)
            copy[i] = arr[i].clone();
        
        for(int i = 0; i < 4; i++) {
            move(i);
            game(count+1);
            for(int a = 0; a < N; a++)
                arr[a] = copy[a].clone();
        }
    }
    
    public static void move(int dir) {
        switch(dir) {
            // N
            case 0:
                for(int i = 0; i < N; i++) {
                    int idx = 0;  // 값 넣을 위치
                    int block = 0;  // 최근 블록의 수 (!= 0)
                    for(int j = 0; j < N; j++) {
                        if(arr[j][i] != 0) {
                            if(block == arr[j][i]) {
                                arr[idx - 1][i] = block * 2;
                                block = 0;
                                arr[j][i] = 0;
                            }
                            else {
                                block = arr[j][i];
                                arr[j][i] = 0;
                                arr[idx][i] = block;
                                idx++;
                            }
                        }
                    }
                }
                break;
            // S
            case 1:
                for(int i = 0; i < N; i++) {
                    int idx = N - 1;
                    int block = 0;
                    for(int j = N - 1; j >= 0; j--) {
                        if(arr[j][i] != 0) {
                            if(block == arr[j][i]) {
                                arr[idx + 1][i] = block * 2;
                                block = 0;
                                arr[j][i] = 0;
                            }
                            else {
                                block = arr[j][i];
                                arr[j][i] = 0;
                                arr[idx][i] = block;
                                idx--;
                            }
                        }
                    }
                }
                break;
            // W
            case 2:
                for(int i = 0; i < N; i++) {
                    int idx = 0;
                    int block = 0;
                    for(int j = 0; j < N; j++) {
                        if(arr[i][j] != 0) {
                            if(block == arr[i][j]) {
                                arr[i][idx - 1] = block * 2;
                                block = 0;
                                arr[i][j] = 0;
                            }
                            else {
                                block = arr[i][j];
                                arr[i][j] = 0;
                                arr[i][idx] = block;
                                idx++;
                            }
                        }
                    }
                }
                break;
            // E
            case 3:
                for(int i = 0; i < N; i++) {
                    int idx = N - 1;
                    int block = 0;
                    for(int j = N - 1; j >= 0; j--) {
                        if(arr[i][j] != 0) {
                            if(block == arr[i][j]) {
                                arr[i][idx + 1] = block * 2;
                                block = 0;
                                arr[i][j] = 0;
                            }
                            else {
                                block = arr[i][j];
                                arr[i][j] = 0;
                                arr[i][idx] = block;
                                idx--;
                            }
                        }
                    }
                }
                break;
        }
    }
    
    public static void findMax() {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                answer = Math.max(answer, arr[i][j]);
    }
}


// 0은 빈 칸을 나타내며, 이외의 값은 모두 블록
// 최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록

// 분기 존재 dfs bfs
// 전체 판의 상태를 기억해야함 -> 매개변수 arr, cnt

// 0 아닌 수 or 경계 만날때까지 방향 이동 -> 각 칸에 대해 완탐 -> 20*20*4  ok
// 무조건 맨 끝으로 보내되 행, 열단위 합 -> 총합 아닌 같은값 두개 연달아 만날때만

// ** todo d에 대해 visited 처리하기 ** //
// ** todo2 한 번의 이동에서 이미 합쳐진 블록은 또 합쳐질 수 없기 때문 !! ** //
// 똑같은 수가 세 개가 있는 경우에는 이동하려고 하는 쪽의 칸이 먼저 합쳐짐 -> 가에 있을수록 먼저 -> 가에 따라 인덱스 크 vs. 작을수록 먼저 합쳐지게
// 이동했는데 이전 판과 상태 동일시 return.

// 이동할 방향 선택
// 각 행 or 열 완탐하며 같은수 2개 이상 연달아 존재시 합치기