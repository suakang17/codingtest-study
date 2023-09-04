package boj.sssw;

import java.io.*;
import java.util.*;

public class _14888 {

    static int N, max, min;
    static int[] nums, opers;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }

        opers = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < 4; n++) {  // + - x %
            opers[n] = Integer.parseInt(st.nextToken());
        }

        solve(nums[0], 1);  // num, 다음 num 지시 idx
        System.out.print(max + "\n" + min);
    }

    private static void solve(int x, int idx) {
        if(idx == N) {
            max = Math.max(max, x);
            min = Math.min(min, x);
            return;
        }
        for(int i = 0; i < 4; i++) {
            if(opers[i] > 0) {
                opers[i]--;
                switch (i) {
                    case 0:  // plus
                        solve(x+nums[idx], idx+1);
                        break;
                
                    case 1:  // minus
                        solve(x-nums[idx], idx+1);
                        break;

                    case 2:  // multiply
                        solve(x*nums[idx], idx+1);
                        break;

                    case 3:  // divide
                        solve(x/nums[idx], idx+1);
                        break;
                }
                opers[i]++;
            }
        }
    }
}

// 우선순위 무시 -> 앞에서부터 계산 => 이 모든게 백트래킹 구현을 위한 조건 (백트래킹을 위한 문제)
// 나눗셈 몫만 취함
// 음수 / 양수 -> c++

// 양수 n개 , 연산자 n-1 -> 배열 두개 교차 o
// 완탐 불가 -> 백트래킹 pruning
