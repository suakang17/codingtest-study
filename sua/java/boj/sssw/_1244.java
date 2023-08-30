package boj.sssw;

import java.io.*;
import java.util.*;

public class _1244 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int N = Integer.parseInt(br.readLine());
        int[] s = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++){
            s[n] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < studentNum; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int sNum = Integer.parseInt(st.nextToken());

            if(gender == 1) { // ��
				for(int j = 0; j < N; j++){ 
					if((j + 1) % sNum == 0)
						s[j] = s[j] == 0? 1: 0;
                }
			}
			else {  // ��
				s[sNum - 1] = s[sNum - 1] == 0 ? 1 : 0;
				for(int j = 1; j < N/2; j++) {
					if(sNum - 1 + j >= N || sNum - 1 - j < 0)
						break;
					if(s[sNum - 1 - j] == s[sNum - 1 + j]) {
						s[sNum - 1 - j] = s[sNum - 1 - j] == 0 ? 1 : 0;
						s[sNum - 1 + j] = s[sNum - 1 + j] == 0 ? 1 : 0;
					}
                    else break;
                }
        
            }
        }

        for(int i = 0; i < N; i++) {
			System.out.print(s[i] + " ");
			if((i+1) % 20 == 0)
				System.out.println();
        }
    }
}