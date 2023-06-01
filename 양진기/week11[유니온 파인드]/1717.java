import java.io.*;
import java.util.*;

class Main{

    static int[] parent;    // 부모를 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 원소의 갯수
        int M = Integer.parseInt(st.nextToken());   // 연산의 갯수

        parent = new int[N+1]; // 원소는 0부터 N까지 N+1개이다.
        for(int i=1; i<=N; i++){
            parent[i] = i;      // 자기 자신으로 초기화
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0){
                union(a, b);    // 유니온 진행
            } else if (command == 1){
                sb.append((isSameParent(a, b) ? "YES" : "NO") + "\n");  // 두 원소가 같은 집합(->부모)에 포함되어 있는지를 확인
            } else {
                continue;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // x의 부모를 찾는 연산
    public static int find(int x){
        if(x == parent[x]){ // 부모가 자기 자신이면 x 반환
            return x;
        }
        return parent[x] = find(parent[x]); // 아니면 부모의 부모를 재귀적으로 찾음
    }

    // y의 부모를 x의 부모로 치환하는 연산 (x > y일 경우 반대)
    public static void union(int x, int y){
        x = find(x);    // x의 최종 부모를 찾음
        y = find(y);    // y의 최종 부모를 찾음

        if(x != y){     // x와 y가 최종 부모가 다르면
            if(x < y) { // 더 작은 값으로 합친다
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    // x와 y의 부모가 같은지 확인
    public static boolean isSameParent(int x, int y){
        x = find(x);    // x의 최종 부모를 찾음
        y = find(y);    // y의 최종 부모를 찾음

        if(x == y){     // 최종 부모가 같다면 true
            return true;
        }
        return false;
    }
}