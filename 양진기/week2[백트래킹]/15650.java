import java.util.*;
import java.io.*;

class Main{

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        dfs(1, 0);
        System.out.println(sb);
    }

    static void dfs(int at, int depth){

        if(depth == M){
            for(int n : arr){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=at; i<=N; i++){
            arr[depth] = i;
            dfs(i+1, depth+1);
        }
    }
}