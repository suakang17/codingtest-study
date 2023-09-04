package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1860 {
    
    static int T, N, M, K, b;
    static int[] eta;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            eta = new int[N];
			b = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < eta.length; i++) {
                eta[i] = Integer.parseInt(st.nextToken());
            }

			Arrays.sort(eta);  // 빨리 온 순
			check(t);
		}
	}
	public static void check(int t) {
		
		for(int i = 0; i < eta.length; i++) {
			b = (eta[i] / M) * K; // i초의 b개수
			if(b-(i+1) < 0 ) { // i+1 == 앞사람수
				System.out.println("#" + t + " Impossible");
				return;
			}
		}
		System.out.println("#" + t + " Possible");
	}
}


// M초 -> K개 붕어빵 (M*K개)


// 991 / 1000
// T = Integer.parseInt(br.readLine());
//         outer : for(int t = 1; t <= T; t++) {
//             st = new StringTokenizer(br.readLine());

//             N = Integer.parseInt(st.nextToken());
//             M = Integer.parseInt(st.nextToken());
//             K = Integer.parseInt(st.nextToken());

//             eta = new int[N];

//             st = new StringTokenizer(br.readLine());
//             for(int i = 0; i < N; i++) {  // eta[i] == sec
//                 eta[i] = Integer.parseInt(st.nextToken());
//             }

//             int b = 0;
//             cnt = new int[11112];
//             for(int i = 0; i < 11112; i++) {  // i == sec
//                 if(i / M > 0 && i % M == 0) {
//                     b += K;
//                 }
//                 cnt[i] = b;  // i초에 존재하는 붕어빵 개수
//             }

//             for(int i = 0; i < N; i++) {  // i == sec
//                 if(cnt[eta[i]] - (i+1) < (i+1)) {  // 앞에 사람 수 만큼 빼야됨
//                     System.out.println("#" + t + " Impossible");
//                     continue outer;
//                 }
//             }

//             System.out.println("#" + t + " Possible");
//         }