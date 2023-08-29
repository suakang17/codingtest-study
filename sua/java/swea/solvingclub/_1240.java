package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1240 {
    
    static int T, N, M;
    static String[] code, arr;
    static HashMap<String, Integer> map = new HashMap<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new String[N];
            for(int n = 0; n < N; n++) {
                arr[n] =  br.readLine();   
                }

            code = new String[8];
            outer : for(int n = 0; n < N; n++) {
                String str = arr[n];
                for(int m = M-1; m >= 0; m--) {
                    if(str.charAt(m) == '1') {
                        int start = m - 55;
                        int cnt = 0;
                        while(cnt < 8) {
                            String s = str.substring(start, start + 7);
                            code[cnt++] = s;
                            start += 7;
                        }
                        break outer;
                    }
                }
            }

            int odd = 0;
            int even = 0;
            int verify = 0;
            for(int i = 0; i < 8; i++) {
                if(i % 2 == 0) {  // 짝수
                    even += map.get(code[i]);                    
                } else {  // 홀수
                    odd += map.get(code[i]);
                }
            }

            verify = (even * 3) + odd;

            if(verify % 10 == 0) {
                sb.append(odd+even);
                System.out.println(sb);
            } else {
                sb.append(0);
                System.out.println(sb);
            }
        }
    }
}

// 암호 == 1; 이외 == 0;
// 암호 -> 숫자 1개 -> 7개 비트로 주어짐
// 올바른 암호코드: (홀수 자리의 합 x 3) + (짝수 자리의 합)이 10의 배수

// 0 제외부분 찾기
// 먼소리임/????????????????