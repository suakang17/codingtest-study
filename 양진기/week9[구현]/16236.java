import java.io.*;
import java.util.*;

class Main{
    static class Node{
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int N;
    static int[][] board;   // N*N 배열
    static ArrayList<Node> fishes;

    /*
            -x
        -y      +y
            +x
        (-1, 0) : 상 / (0, 1) : 우 / (1, 0) : 하 / (0, -1) : 좌
     */
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 9){   // 9 -> 아기 상어의 위치
                    q.add(new Node(i, j, 0));
                    board[i][j] = 0;
                }
            }
        }

        int eat = 0;    // 먹었을 때. count와 비슷하다.
        int time = 0;   // 시간
        int age = 2;    // 가장 처음에 아기 상어의 크기는 2이고
        while(true){    // 더이상 먹을 수 있는 물고기 리스트가 없으면 종료
            LinkedList<Node> fish = new LinkedList<>(); // 먹을 수 있는 물고기 리스트
            int[][] dist = new int[N][N];   // 물고기를 먹으며 이동하는 배열

            while(!q.isEmpty()) {   // 큐에 차 있는 동안
                Node cur = q.poll();    // 맨 처음 꺼냄

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    // 이동에 관한 if문
                    // dist[nx][ny] == 0 : 처음부터 빈 칸이든, 먹어서 비워졌든 해야 한다.
                    // board[nx][ny] <= age : 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다.
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && dist[nx][ny] == 0 && board[nx][ny] <= age) {
                        dist[nx][ny] = dist[cur.x][cur.y] + 1;
                        q.add(new Node(nx, ny, dist[nx][ny]));  // 다음 상황 진행

                        // 사냥에 대한 if문
                        // 1 <= 6 크기의 물고기여야 한다.
                        // board[nx][ny] < age : 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.
                        if (1 <= board[nx][ny] && board[nx][ny] <= 6 && board[nx][ny] < age) {
                            fish.add(new Node(nx, ny, dist[nx][ny]));   // 먹을 수 있는 물고기 리스트에 담는다.
                        }
                    }
                }
            }

            // 더이상 먹을 수 있는 물고기 리스트가 없으면 시간 출력
            if(fish.size() == 0){
                System.out.println(time);
                return;
            }

            // 먹을 수 있는 물고기 리스트 순회
            Node currentFish = fish.get(0);
            for(int i=1; i<fish.size(); i++){
                // 거리가 가장 가까운 물고기를 먹으러 간다.
                if(currentFish.dist > fish.get(i).dist){
                    currentFish = fish.get(i);
                }
                // 거리가 가까운 물고기가 많다면 (같다면)
                else if(currentFish.dist == fish.get(i).dist){
                    // 가장 위에 있는 물고기
                    if(currentFish.x > fish.get(i).x){
                        currentFish = fish.get(i);
                    }
                    // 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
                    else if(currentFish.x == fish.get(i).x){
                        if(currentFish.y > fish.get(i).y){
                            currentFish = fish.get(i);
                        }
                    }
                }
            }

            time += currentFish.dist;   // 시간에 현재 먹은 물고기의 거리를 누적하여 더한다.
            eat++;  // 먹었다.
            board[currentFish.x][currentFish.y] = 0;    // 물고기를 먹었으면 해당 자리는 비워준다.
            // 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. (작으면 증가하지 않는다.)
            if(eat == age){
                age++;
                eat = 0;
            }
            // 현재 먹었던 지점을 큐에 추가
            q.add(new Node(currentFish.x, currentFish.y, 0));
        }   // while(true) end
    }   // main end
}