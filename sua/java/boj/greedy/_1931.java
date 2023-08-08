package boj.greedy;

import java.io.*;
import java.util.*;

public class _1931 {
    
    static int s, e, N, t;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] timetable;
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        timetable = new int[N][2];

        for(int n = 0; n < N; n ++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            // 저장
            timetable[n][0] = s;
            timetable[n][1] = e;
            // 회의의 최대 개수가 목적 -> 안겹치고 종료시간 빠른 것만 취함
        }

        int cnt = 0;
        int end = 0;

        Arrays.sort(timetable, (o1, o2) -> {
            if(o1[1] == o2[1]) { // 종료시간이 같을 경우 시작 시간이 빠른 순
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for(int n = 0; n < N; n++) {
            if(end <= timetable[n][0]) { // 겹치지 않으면
                end = timetable[n][1];
                cnt++;
            }
        }

        System.out.println(cnt);
        
    }
}
