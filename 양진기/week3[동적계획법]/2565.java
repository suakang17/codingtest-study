import java.io.*;
import java.util.*;

class Main{
    static int N;
    static int[][] wire;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        wire = new int[N][2];
        dp = new int[N];

        for(int i=0; i<N; i++){
            dp[i] = -1;
        }

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        // 첫 번째 원소(A전봇대)를 기준으로 오름차순으로 정렬
        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 0;

        /*
            i번째 A전봇대를 기준으로 연결가능한 개수 탐색,
            최대값 찾기
         */
        for(int i=0; i<N; i++){
            max = Math.max(recur(i), max);
        }

        // 전선 개수 - 최대값
        System.out.println(N - max);
    }

    static int recur(int N){

        // 탐색하지 않았던 위치라면
        if(dp[N] == -1){
            dp[N] = 1;  // 최소값 1로 초기화

            // A의 N번째와 이후의 전봇대들 비교
            for(int i=N+1; i<dp.length; i++){

                /*
                    A전봇대의 N번째 전선이 연결되어있는 B전봇대보다
                    A의 i번째 전봇대의 전선이 이어진
                    B전봇대가 뒤에 있을 경우 전선을 설치할 수 있음
                 */
                if(wire[N][1] < wire[i][1]){
                    // 연결 가능한 전선의 경우의 수 중 큰 값을 dp에 저장한다.
                    dp[N] = Math.max(dp[N], recur(i) + 1);
                }
            }
        }
        return dp[N];
    }
}