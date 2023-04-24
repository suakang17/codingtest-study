import java.util.*;
import java.io.*;

class Main {

    static int T;
    static int[] novel;
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0; i<T; i++){
            int K = Integer.parseInt(br.readLine());

            novel = new int[K+1];
            sum = new int[K+1];
            dp = new int[K+1][K+1];

            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=K; j++){
                novel[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j - 1] + novel[j];
            }

            for (int n=1; n<=K; n++){
                for(int from=1; from+n <= K; from++) {
                    int to = from + n;
                    dp[from][to] = Integer.MAX_VALUE;
                    for(int divide = from; divide < to; divide++){
                        dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide+1][to] + sum[to] - sum[from-1]);
                    }
                }
            }

            System.out.println(dp[1][K]);
        }
    }
}
