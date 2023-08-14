package boj.sssw;

import java.io.*;
import java.util.*;

public class _13458 {
    
    static int N, B, C;
    static int[] A;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());  // 총감독관이 감시가능한 응시자수
        C = Integer.parseInt(st.nextToken());  // 부감독관이 감시가능한 응시자수

        long cnt = 0;
        // for(int i = 0; i < N; i++) {
        //     A[i] -= B;
        //     cnt++;
        //     while(A[i] > 0) {
        //             A[i] -= C;
        //             cnt++;
        //         }
        //     }
        for(int i = 0; i < N; i++) {
            A[i] -= B;
            cnt++;
            if(A[i] <= 0) continue;
            cnt += A[i] / C;
            if(A[i] % C > 0) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}


// int MAX == 20억
// int MIN == -20억
// 그 밖으로 나가면 long