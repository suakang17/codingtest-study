package boj.sssw;

import java.io.*;
import java.util.*;

public class _14889 {
    
    static int N, min, sum, ttl;
    static int[][] arr;
    static boolean[] visited;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        arr = new int[N][N];
        visited = new boolean[N];  // n명

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                ttl += arr[i][j];
            }
        }

        dfs(0, 1); // 0번 idx 사람, 1명 고름 // 무조건 0 포함하는 팀것만 고려, 나머지는 etc처리
        System.out.println(min);
    }

    private static void dfs(int idx, int cnt) {

        if(cnt == 2/N) { 
            min = Math.min(min, ttl-sum);
            return; }  // 2/N명 full

        visited[idx] = true;
        for(int i = idx+1; i < N; i++) {  // i번째 사람 고름
            if(!visited[i]) {
                sum += arr[idx][i];
                sum += arr[i][idx];
                dfs(i, cnt++);
            }
            sum -= arr[idx][i];
            sum -= arr[i][idx];
        }
    }

}

// N은 짝수
// N/2 -> 스타트 팀, 링크 팀 -> 두 팀 능력치 최소 
// 사람 번호 1 ~ N
// sij == i, j 같은 팀 -> +팀 능력치
// sij sji 다를 수 있음

//-> dp? bt?
// 같은 팀인 사람끼리의 모든 조합 고려해야함 (완탐) + 순서 고려 
// 재귀로 선택 조합 타고 들어가며 max 값 갱신 -> dfs (방문표시)
