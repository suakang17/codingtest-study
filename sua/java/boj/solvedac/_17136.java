package boj.solvedac;

import java.io.*;
import java.util.*;

public class _17136 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int min = Integer.MAX_VALUE;
    static int[][] arr;

    static int[] paper = {0, 5, 5, 5, 5, 5};
    public static void main(String[] args) throws IOException {
        
        arr = new int[10][10];

        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        min = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(min);
    }

    public static void dfs(int r, int c, int cnt) {

        if(r >= 9 && c > 9) {
            min = Math.min(min, cnt);
            return;
        }
        if(min <= cnt) return;
        if(c > 9) {
            dfs(r+1, 0, cnt);
            return;
        }

        if(arr[r][c] == 1) {
            for(int size = 5; size > 0; size--) {
                if(isAttachable(r, c, size) && paper[size] > 0) {
                    paper[size]--;
                    flip(size, r, c);
                    dfs(r, c+size, cnt+1);
                    paper[size]++;
                    flip(size, r, c);
                }
            }
        } else dfs(r, c+1, cnt);
    }

    private static boolean isAttachable(int r, int c, int size) {
        for(int i = r; i < r+size; i++) {
            for(int j = c; j < c+size; j++) {
                if(!isValid(i, j) || arr[i][j] == 1) return false;
            }
        }
        return true;
    }

    private static boolean isValid(int r, int c) {
        if(r < 0 || c < 0 || r >= 10 || c >= 10) return false;
        return true;
    }

    public static void flip(int size, int r, int c) {
        for(int i = r; i < r+size; i++) {
            for(int j = c; j < c+size; j++) {
                arr[r][c] ^= 1;
            }
        }
    }
}

// * goal 모든 1을 덮는데 필요한 색종이수 min
// 사이즈 1x1 ~ 5x5 -> 다섯개씩

// 1 완탐 -> 큰거부터 붙였다 떼었다 -> dfs (이전 상태로 돌아가야)
// 색종이끼리 겹치면 x


// public class Main {

//     static int[][] paper;
//     static int[] colored = new int[]{0, 5, 5, 5, 5, 5};
//     static int answer = Integer.MAX_VALUE;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//         paper = new int[10][10];
//         for(int i=0; i<10; i++) {
//             String[] in = br.readLine().split(" ");
//             for(int j=0; j<10; j++)
//                 paper[i][j] = Integer.parseInt(in[j]);
//         }
//         dfs(0, 0, 0);
//         bw.write((answer == Integer.MAX_VALUE? -1: answer)+ "\n");

//         bw.flush();
//         bw.close();
//     }
//     public static void dfs(int x, int y, int count) {
//         if(x >= 9 && y > 9) {
//             answer = Math.min(answer, count);
//             return;
//         }
//         if(answer <= count)
//             return;
//         if(y > 9) {
//             dfs(x + 1, 0, count);
//             return;
//         }
        
//         if(paper[x][y] == 1) {
//             for(int size=5; size>0; size--) {
//                 if(colored[size] > 0 && attachable(x, y, size)) {
//                     colored[size]--;
//                     flip(x, y, size);
//                     dfs(x, y + 1, count + 1);
//                     flip(x, y, size);
//                     colored[size]++;
//                 }
//             }
//         } else {
//             dfs(x, y + 1, count);
//         }
//     }
//     public static boolean attachable(int x, int y, int size) {
//         for(int i=x; i<x+size; i++) {
//             for(int j=y; j<y+size; j++) {
//                 if(!(i < 10 && j < 10 && paper[i][j] == 1))
//                     return false;
//             }
//         }
//         return true;
//     }
//     public static void flip(int x, int y, int size) {
//         for(int i=x; i<x+size; i++) {
//             for(int j=y; j<y+size; j++) {
//                 paper[i][j] ^= 1;
//             }
//         }
//     }
// }
