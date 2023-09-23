package boj.sssw;

import java.io.*;
import java.util.*;

public class _3190 {
    
    static int N, K, L;
    static int[][] arr;
    static Deque<int[]> dq;
    static HashMap<Integer, String> map = new HashMap<>();

    // E(initial state)SWN
    static int[] dc = {0, 1, 0, -1};
    static int[] dr = {1, 0, -1, 0};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;  // apple
        }
    
        L = Integer.parseInt(br.readLine());
		for(int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());

			int X = Integer.parseInt(st.nextToken());
			String C = st.nextToken();
			map.put(X, C);
		}

        solve();
    }

    private static void solve() {
        dq = new LinkedList<>();
        int cc = 1, cr = 1;
        int time = 0;
        int d = 0;

        dq.add(new int[] {cc, cr});  // initial location

        while(true) {
            // 1. 시간
            time++;

            // 2. 이동
            int nc = cc + dc[d];
            int nr = cr + dr[d];

            // 3. 종료 체크
            if(isGameOvered(nc, nr)) { break; }

            // 4. 사과 처리
            if(arr[nc][nr] == 1) {
                arr[nc][nr] = 0;
                dq.addFirst(new int[] {nc, nr});
            } else {
                dq.addFirst(new int[] {nc, nr});
                dq.removeLast();
            }

            // 5. 방향 변경 
            if(map.containsKey(time)) {
                if(map.get(time).equals("D")) {
                    d = d + 1 == 4 ? 0 : d+1;
                } else {
                    d = d - 1 == -1 ? 3 : d-1;
                }
            }

            cc = nc;
            cr = nr;
        }
        System.out.println(time);
    }

    public static boolean isGameOvered(int nc, int nr) {

        if(nc < 1 || nr < 1 || nc > N || nr > N) { return true; }

        for (int[] seg : dq) {
            if (seg[0] == nc && seg[1] == nr) {
                return true;
            }
        }
		
        return false;
    }
}

// 사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지

// 사과를 먹으면 뱀 길이가 늘어남
// 벽, 자기자신과 부딪히면 gameover
// NxN board , 초기 길이 == 1, 초기 방향 == E, 초기 위치 == 1,1
// 매초이동

// 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
// 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다. (길이늘어서)
// 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다. (길이불변이므로)

// while(true){
//   1. 시간재기
//   2. 뱀 이동하기 
//   3. 범위를 벗어나거나, 뱀 몸통 만날 때 종료
//   4. 사과가 있을 때 없을 때 처리 
//   5. 방향을 바꿔주는 시간을 만날 때 방향 변경 
//   6. 현재값 업데이트 
// }

// q.contains로 몸에 부딪히는거 구현하면 실패
// -> contains method of the Queue interface checks for object equality using the equals method of the objects stored in the queue. 
// In your case, you are trying to check if the queue contains an array loc, but arrays in Java do not override the equals method for content-based comparison by default. 
// Therefore, q.contains(loc) will not work as expected.