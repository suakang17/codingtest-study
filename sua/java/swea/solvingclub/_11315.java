package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _11315 {
    
    static int T, N;
    static char[][] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new char[N][N];
            for(int n = 0; n < N; n++) {
                String str = br.readLine();
                for(int m = 0; m < N; m++) {
                    arr[n][m] = str.charAt(m);
                }
            }

            if(check1() || check2() || check3()) {
                System.out.println("#" + t + " " + "YES");
            } else { System.out.println("#" + t + " " + "NO"); }
        }
    }

    private static boolean check1() { // 가로
        for(int n = 0; n < N; n++) {
            int cnt = 0;
                for(int m = 0; m < N; m++) {
                    if(arr[n][m] == 'o') { 
                        cnt++; 
                        if(cnt == 5) { 
                            return true; 
                        }
                    } else {cnt = 0;}
                }
            }
            return false;
    }

    private static boolean check2() { // 세로
        for(int n = 0; n < N; n++) {
            int cnt = 0;
                for(int m = 0; m < N; m++) {
                    if(arr[m][n] == 'o') { 
                        cnt++; 
                        if(cnt == 5) { 
                            return true; 
                        }
                    } else {cnt = 0;}
                }
            }
            return false;
    }

    private static boolean check3() { // 대각선 왼->오
        for(int n = 0; n <= N-5; n++) {
            outer : for(int m = 0; m <= N-5; m++) {
                int cnt = 0;
                if(arr[n][m] == 'o') {
                    cnt++;
                    while(n < N && m < N) {
                        n += 1;
                        m += 1;
                        if(arr[n][m] == 'o') {
                            cnt++;
                            if(cnt == 5) { 
                            return true; 
                            }
                        } else if(cnt < 5) { n-=cnt; m-=cnt; continue outer; }
                    }
                }
            }
        }

        for(int a = 0; a <= N-5; a++) {  // 오->왼
            outer : for(int b = N-1; b >= 4; b--) {

                int cnt = 0;
                if(arr[a][b] == 'o') {
                    cnt++;
                    while(a < N-1 && b > 0) {
                        a += 1;
                        b -= 1;
                        if(arr[a][b] == 'o') {
                            cnt++;
                            if(cnt == 5) { 
                            return true; 
                            }
                        } else if(cnt < 5) { a-=cnt; b+=cnt; continue outer; }
                    }
                }
            }
        }
        return false;    
    }
}