import java.io.*;
import java.util.*;

class Main{

    /*
            -x
        -y      +y
            +x

        우하좌상인 이유 : 반시계 방향으로 돌기 때문에
        상단 : 오른쪽에서 왼쪽으로
        우단 : 아래쪽에서 위쪽으로
        하단 : 왼쪽에서 오른쪽으로
        좌단 : 위쪽에서 아래쪽으로

        (0, 1) 우
        (1, 0) 하
        (0, -1) 좌
        (-1, 0) 상
    */

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int group = Math.min(n, m) / 2;    // 회전하는 그룹의 갯수

        // 회전 횟수
        for(int i=0; i<r; i++){
            // 그룹 갯수
            for(int j=0; j<group; j++){
                // 각 그룹은 (0, 0), (1, 1), (2, 2) ... 에서 시작함
                int x = j;
                int y = j;

                // 각 그룹의 처음 값을 저장했다가 마지막에 넣기 위해 따로 저장 (swap할 때 temp랑 같음)
                int value = arr[x][y];

                int idx = 0;    // 방향

                while(idx < 4){    // 우, 하, 상, 좌 4방향 경우 계산
                    int nx = x + dx[idx];
                    int ny = y + dy[idx];

                    // 범위 내에 있을 경우 돌린다.
                    /*
                        nx >= j : 현재 x좌표가 현재 범위의 안쪽 범위보다 작으면 안 됨(그룹 0은 제일 바깥 쪽 범위, 그룹 1은 그다음 안 쪽 범위)
                        ny >= j : 현재 y좌표가 현재 범위의 안쪽 범위보다 작으면 안 됨(그룹 0은 제일 바깥 쪽 범위, 그룹 1은 그다음 안 쪽 범위)
                        nx < n-j : 현재 x좌표가 현재 범위에서 n의 끝점을 넘을 수 없다.
                        ny < m-j : 현재 y좌표가 현재 범위에서 m의 끝점을 넘을 수 없다.
                    */
                    if(nx >= j && ny >= j && nx < n-j && ny < m-j){
                        arr[x][y] = arr[nx][ny];    // 돌리기
                        x = nx;
                        y = ny;
                    } else {    // 범위 벗어나면 방향 전환 (우 -> 상 -> 좌 -> 하)
                        idx++;
                    }    // else end
                }    // while end
                arr[j+1][j] = value;    // 마지막 단계에서 제일 처음 값을 아래쪽 행에 넣음
            }    // j end
        }    // i end

        // 출력
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}