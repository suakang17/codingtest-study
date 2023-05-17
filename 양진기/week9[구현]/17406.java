import java.io.*;
import java.util.*;

class Main{
    static int N, M, K;
    static int[][] cycle;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cycle = new int[K][3];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            cycle[i][0] = Integer.parseInt(st.nextToken()) - 1; // r
            cycle[i][1] = Integer.parseInt(st.nextToken()) - 1; // c
            cycle[i][2] = Integer.parseInt(st.nextToken());     // s
        }

        permutation(0, new int[K], new boolean[K]); // 0번부터 K번까지 순열

        System.out.println(min);
    }

    // 회전 연산은 모두 한 번씩 사용해야 하며, 순서는 임의로 정해도 된다.
    static void permutation(int cnt, int[] arr, boolean[] visited){ // 순열

        if(cnt == K){   // K번까지 순회했으면 종료, K번째에 doCycle 메서드 실행
            doCycle(arr);
            return;
        }

        for(int i=0; i<K; i++){
            if(visited[i]) continue;    // 방문 했으면 skip

            visited[i] = true;  // 방문 check
            arr[cnt] = i;       // 순회하고 난 후
            permutation(cnt+1, arr, visited);   // cnt 1씩 증가하며 재귀
            visited[i] = false; // 다음 cnt를 돌기 전에 false로 변경
        }
    }

    // 회전하기
    static void doCycle(int[] arr){
        int[][] tmp = copyMap();    // 복사한 임시 배열

        for(int i=0; i<K; i++){
            int r = cycle[arr[i]][0];
            int c = cycle[arr[i]][1];
            int s = cycle[arr[i]][2];

            for(int j=1; j<=s; j++){
                // 상
                int upTmp = tmp[r-j][c+j];  // 맨 오른쪽을 임시 배열에 담아뒀다가 swap
                for(int y = c+j; y > c-j; y--){ // 제일 오른쪽에서 제일 왼쪽까지 --
                    tmp[r-j][y] = tmp[r-j][y-1];    // 왼쪽에서 오른쪽으로 바꾸기
                }

                // 우
                int rightTmp = tmp[r+j][c+j];   // 맨 우측 아래쪽을 임시 배열에 담아뒀다가 swap
                for(int x = r+j; x > r-j; x--){ // 제일 아래쪽에서 제일 위쪽까지 --
                    tmp[x][c+j] = tmp[x-1][c+j];    // 위쪽에서 아래쪽으로 바꾸기
                }
                tmp[r-j+1][c+j] = upTmp;    // 맨 우측 위쪽에 upTmp swap

                // 하
                int leftTmp = tmp[r+j][c-j];
                for(int y = c-j; y < c+j; y++){
                    tmp[r+j][y] = tmp[r+j][y+1];
                }
                tmp[r+j][c+j-1] = rightTmp;

                // 좌
                for(int x = r-j; x < r+j; x++){
                    tmp[x][c-j] = tmp[x+1][c-j];
                }
                tmp[r+j-1][c-j] = leftTmp;
            }
        }
        getAnswer(tmp);
    }

    // 각 행의 최솟값 계산
    static void getAnswer(int[][] tmp){
        for(int i=0; i<N; i++){
            int sum = 0;
            for(int j=0; j<M; j++){
                sum += tmp[i][j];
            }
            if(min > sum) min = sum;
        }
    }

    // 원본 배열 복사하기
    static int[][] copyMap(){
        int[][] tmp = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }
}