import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static int[] arr, map;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new boolean[n+2][40001];
        map = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);

        for(int j=0; j<m; j++){
            if(dp[n][arr[j]]){
                System.out.print("Y ");
            } else {
                System.out.print("N ");
            }
        }
    }

    static void dfs(int count, int index){
        if(dp[count][index]){
            return;
        }

        dp[count][index] = true;

        if(count == n){
            return;
        }

        dfs(count + 1, index + map[count]);       // 추 올린 경우
        dfs(count + 1, index);                           // 추 올리지 않은 경우
        dfs(count + 1, Math.abs(index - map[count]));  // 추를 구슬과 같이 올린 경우
    }
}