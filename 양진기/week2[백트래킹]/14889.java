import java.util.*;
import java.io.*;

class Main{

    static int N;
    static int MIN = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);
        System.out.println(MIN);
    }

    static void combi(int idx, int depth){
        // 팀 조합이 완성될 경우
        if(depth == N / 2){
            // 방문한 팀과 방문하지 않은 팀을 각각 나누어
            // 각 팀의 점수를 구한 뒤 최소값을 찾는다.
            diff();
            return;
        }

        for(int i=idx; i<N; i++){
            // 방문하지 않았다면
            if(!visit[i]){
                visit[i] = true;        // 방문으로 변경
                combi(i+1, depth+1);    // 재귀 호출
                visit[i] = false;       // 방문X로 변경
            }
        }
    }

    // 두 팀의 능력치 차이를 계산하는 함수
    static void diff(){
        int team_start = 0;
        int team_link = 0;

        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){

                // i 번째 사람과 j 번째 사람이 true라면 스타트팀 +
                if(visit[i] == true && visit[j] == true){
                    team_start += map[i][j];
                    team_start += map[j][i];
                }

                // i 번째 사람과 j 번째 사람이 false라면 링크팀 +
                else if(visit[i] == false && visit[j] == false){
                    team_link += map[i][j];
                    team_link += map[j][i];
                }
            }
        }

        // 두 팀의 점수 차이 (절대값)
        int val = Math.abs(team_start - team_link);

        /*
            두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
            더이상의 탐색 필요없이 0을 출력하고 종료하면 된다.
        */
        if(val == 0){
            System.out.println(val);
            System.exit(0);
        }

        MIN = Math.min(val, MIN);
    }
}