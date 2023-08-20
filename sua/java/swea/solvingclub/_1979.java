package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1979 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N, K, ret, cnt;
    static int arr[][];

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr= new int[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ret = horizontal(K) + vertical(K);
            System.out.println("#" + t + " " + ret);

        }
    }

    private static int horizontal(int k) {

        cnt = 0;
        for(int c = 0; c < N; c++) {
            int length = 0;
            for(int r = 0; r < N; r++) {
                if(arr[c][r] == 0) {
                    if(length == k) { cnt++; length = 0; }
                    length = 0;
                } else { length++; }
            }
            if(length == k) { cnt++; }
        }
        return cnt;
    }

    private static int vertical(int k) {
        
        cnt = 0;
        for(int r = 0; r < N; r++) {
            int length = 0;
            for(int c = 0; c < N; c++) {
                if(arr[c][r] == 0) {
                    if(length == k) { cnt++; length = 0; }
                    length = 0;
                }  else { length++; }
            }
            if(length == k) { cnt++; }
        }
        return cnt;
    }
}


// T = Integer.parseInt(br.readLine());

//         for(int t = 1; t <= T; t++) {
//             st = new StringTokenizer(br.readLine());
//             ret = 0;
//             cnt = 0;
//             N = Integer.parseInt(st.nextToken());
//             K = Integer.parseInt(st.nextToken());
//             arr = new int[N][N];

//             for(int n = 0; n < N; n++) {
//                 st = new StringTokenizer(br.readLine());
//                 for(int m = 0; m < N; m++) {
//                     arr[n][m] = Integer.parseInt(st.nextToken());
//                 }
//             }

//             for(int i = 0; i < N; i++) {
// 				cnt = 0;
// 				for(int j = 0; j < N; j++) {
// 					if(arr[i][j] == 0) {
// 						if(cnt == K)
// 							ret++;
// 						cnt = 0;
// 					}
// 					else
// 						cnt++;
// 				}
// 				if(cnt == K)
// 					ret++;
// 			}
			
// 			for (int j = 0; j < N; j++) {
//                 int cnt = 0;
//                 for (int i = 0; i < N; i++) {
//                     if (arr[i][j] == 0) {
//                         if (cnt == K)
//                             ret++;
//                         cnt = 0;
//                     } else
//                         cnt++;
//                 }
//                 if (cnt == K)
//                     ret++;
//             }
//             System.out.println("#" + t + " " + ret);
//         }         