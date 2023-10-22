package boj.solvedac;

import java.io.*;
import java.util.*;

public class _9466 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, cnt;
    static int[] people;

    static boolean[] visited, finished;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            people = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int n = 1; n <= N; n++) {
                people[n] = Integer.parseInt(st.nextToken()); // people[from] = to
            }

            cnt = 0;
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                dfs(i);
            }

            System.out.println(N - cnt);
        }
    }

    private static void dfs(int now) {
        if(visited[now]) return;

        visited[now] = true;
        int next = people[now];

        if(!visited[next])
            dfs(next);
        else {
            if(!finished[next]) {
                cnt++;
                for (int i = next; i != now; i = people[i])
                    cnt++;
            }
        }
        finished[now] = true;
    }
}

// * goal 프로젝트 팀에 속하지 못한 학생수 -> cycle 형성 못하는 노드 수
// dfs
    // naive -> O(N^2) -> 시간초과
    // pruning: cycle 하나 만들면 포함된 모든 노드 finished => true