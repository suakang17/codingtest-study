package boj.failed;

import java.io.*;
import java.util.*;

public class _1194 {
    
    static int n, m;
    static char[][] graph;
    static Node start;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        for(int i = 0; i < n; i++) {
            str = br.readLine();
            for(int j = 0; j < m; j++) {
                char c = str.charAt(j);
                graph[i][j] = c;
                if(c == '0') start = new Node(i, j, 0, 0);
            }
        }
        System.out.println(bfs());
    }   

    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][64]; 
        q.offer(start);
        visited[start.x][start.y][0] = true;

        while(!q.isEmpty()) {
            Node current = q.poll();
            if(graph[current.x][current.y] == '1') return current.cost;

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny][current.key] || graph[nx][ny] == '#') continue;
                
                if(graph[nx][ny] >= 'a' && graph[nx][ny] <= 'f') {  // 열쇠
                    int next_key = 1 << (graph[nx][ny] - 'a');
                    next_key = current.key | next_key;
                    visited[nx][ny][next_key] = true;
                    q.offer(new Node(nx, ny, current.cost + 1, next_key));
                }
                else if(graph[nx][ny] >= 'A' && graph[nx][ny] <= 'F') {  // 문
                    if((current.key & 1 << (graph[nx][ny] - 'A')) == (int)Math.pow(2, graph[nx][ny] - 'A')) { //해당 비트가 켜져있는지 확인
                        visited[nx][ny][current.key] = true;
                        q.offer(new Node(nx, ny, current.cost + 1, current.key));
                    }
                } else {
                    visited[nx][ny][current.key] = true;
                    q.offer(new Node(nx, ny, current.cost + 1, current.key));
                }
            }
        }
        return -1;
    }

    public static class Node {
        int x, y, cost, key;

        public Node(int x, int y, int cost, int key) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.key = key;
        }
    }
}

// ** goal 미로를 탈출하는데 드는 이동 횟수의 최솟값
// bfs + simulation
// 열쇠 유무, 종류 -> q에 담을 수 있는지 없는지 달라짐 
    // 열쇠 있, 열쇠 없 이 온 케이스 분기
    // q -> n, m, key

    // 열쇠 집으면 빈칸으로 바꿔야
    // 집은 열쇠 여러번 사용 가능 (사용해도 그대로)
    // 큐에 남아있는 (다른 경로로 온) 경우 처리 -> visited3차원 (열쇠 갖고왔는지 안갖고왔는지~)
    // 출구 == '1'

// 열쇠 -> 비트마스킹
// 모든 열쇠를 다 가지면 63
// 열쇠 종류에 따라 쉬프트 연산 1