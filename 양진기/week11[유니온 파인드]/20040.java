import java.util.*;
import java.io.*;

class Main{
    static int[] parent;    // 부모 노드를 저장
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 점의 개수
        int m = Integer.parseInt(st.nextToken());   // 차례 수

        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;  // 부모는 자기 자신으로 초기화
        }

        boolean check = false;
        StringBuilder sb = new StringBuilder();
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            count++;

            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            if(isCycle(p1, p2)){    // x와 y의 최고 부모가 같은지 -> 같으면 사이클 완성 가능
                check = true;       // 사이클 완성한 적 있는지 체크
                break;
            } else {                // x와 y의 최고 부모가 같은지 -> 다르면 사이클 완성 불가
                union(p1, p2);      // 다르면 합집합 연산한다
            }
        }
        if(!check) count = 0;       // 사이클 완성한 적 없다면 0

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    // 최고 부모 찾기
    static int find(int x){
        if(x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    // 합집합 연산
    static void union(int x, int y){
        x = find(x);    // 최고 부모 찾기
        y = find(y);    // 최고 부모 찾기

        if(x != y){
            if(x < y){
                parent[y] = x;  // 더 작은 값을 대입
            } else {
                parent[x] = y;  // 더 작은 값을 대입
            }
        }
    }

    // x와 y의 최고 부모가 같은지 -> 같으면 사이클 완성 가능
    static boolean isCycle(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) {    // 같으면 사이클 있다.
            return true;
        }
        return false;   // 같지 않으면 사이클 없다.
    }
}