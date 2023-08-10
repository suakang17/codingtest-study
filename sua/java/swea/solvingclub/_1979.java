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
            ret = 0;
            cnt = 0;
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][N];

            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < N; m++) {
                    arr[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++) {
				cnt = 0;
				for(int j = 0; j < N; j++) {
					if(arr[i][j] == 0) {
						if(cnt == K)
							ret++;
						cnt = 0;
					}
					else
						cnt++;
				}
				if(cnt == K)
					ret++;
			}
			
			for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i][j] == 0) {
                        if (cnt == K)
                            ret++;
                        cnt = 0;
                    } else
                        cnt++;
                }
                if (cnt == K)
                    ret++;
            }
            System.out.println("#" + t + " " + ret);
        }            

    }
}
