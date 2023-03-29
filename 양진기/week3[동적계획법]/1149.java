import java.io.*;
import java.util.*;

class Main{
    static int red = 0;
    static int green = 1;
    static int blue = 2;

    static int N;
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            cost[i][red] = Integer.parseInt(st.nextToken());
            cost[i][green] = Integer.parseInt(st.nextToken());
            cost[i][blue] = Integer.parseInt(st.nextToken());
        }

        // DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
        dp[0][red] = cost[0][red];
        dp[0][green] = cost[0][green];
        dp[0][blue] = cost[0][blue];

        System.out.println(Math.min(paint(N-1, red), Math.min(paint(N-1, green), paint(N-1, blue))));
    }

    static int paint(int N, int color){

        // 만약 탐색하지 않은 배열이라면
        if(dp[N][color] == 0){

            // color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여
            // 최소값과 현재 집의 비용을 더한다.
            if(color == red){
                dp[N][red] = Math.min(paint(N-1, green), paint(N-1, blue)) + cost[N][red];
            } else if(color == green){
                dp[N][green] = Math.min(paint(N-1, red), paint(N-1, blue)) + cost[N][green];
            } else {
                dp[N][blue] = Math.min(paint(N-1, red), paint(N-1, green)) + cost[N][blue];
            }
        }
        return dp[N][color];
    }
}