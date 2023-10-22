package boj.solvedac;

import java.io.*;
import java.util.*;

public class _1941 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] arr;
    static int[] chilgongju = new int[7];
    static boolean[] visited = new boolean[25];
    static int ret;
    static Queue<Integer> q;

    // ESWN
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        
        arr = new char[5][5];
        for(int i = 0; i < 5; i++) {
            String str = br.readLine();
            for(int j = 0; j < 5; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0);
        System.out.println(ret);
    }

    private static void dfs(int idx, int depth) {
        if(depth == 7) {
            if(check()) ret++;
            return;
        }

        for(int i = idx; i < 25; i++) {
            if(!visited[i]) {
                visited[i] = true;
                chilgongju[depth] = i;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    private static boolean check() {
        // System.out.println("in check");
        int Ycnt = 0;
        for(int i : chilgongju) {
            if(arr[i/5][i%5] == 'Y') Ycnt++;
        }
        if(Ycnt > 3) return false;

        ArrayList<Integer> temp = new ArrayList<>();
        for(int a:chilgongju)temp.add(a);

        q= new LinkedList<>();
        q.add(chilgongju[0]);
        while(!q.isEmpty()) {
            int i = q.poll();
            for(int d = 0; d < 4; d++) {
                int nx = i/5 + dx[d];
                int ny = i%5 + dy[d];
                if(isValid(nx, ny)){
                    if(temp.contains(nx*5+ny)) {
                        temp.remove(Integer.valueOf(nx*5+ny));
                        q.add(nx*5+ny);
                    }
                }
            }
        }
        if(!temp.isEmpty())return false;
        return true;
    }

    private static boolean isValid(int x, int y) {
        if(x < 0 || y < 0 || x >= 5 || y >= 5) return false;
        return true;
    }
    
}


// * goal 칠공주 결성 모든 경우의 수
// S가 4이상일때 가로세로 7개 인접한 경우의 수
// 자리 7개 뽑고 -> 조건 만족하는지 여부 -> cnt ++ or not