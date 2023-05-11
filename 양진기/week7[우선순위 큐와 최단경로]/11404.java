import java.util.*;
import java.io.*;

class Main{
    static StringBuilder sb;
    static int n, m;
    static int x = 0;
    static int y = 0;
    static int map[][];
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = INF;

                if(i == j){
                    map[i][j] = 0;
                }
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken()) - 1;
            x = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());

            // 출발 도시와 도착 도시가 같지만 시간이 다른 입력값이 들어올 수 있음.
            // 예를 들어 "1 4 1"과 "1 4 2"가 입력으로 들어왔으면,
            // "1 4 1"을 택해야 함.
            map[y][x] = Math.min(map[y][x], value);
        }

        Road_Finder();

        sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == INF){
                    map[i][j] = 0;
                }
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    } // main

    static void Road_Finder(){
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    // 최단경로 초기화
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }   // j
            }   // i
        }   // k
    }
}

class Node implements Comparable<Node> {

    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
