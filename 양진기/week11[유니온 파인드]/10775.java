import java.io.*;
import java.util.*;

class Main{
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parents = new int[G+1];
        for(int i=1; i<=G; i++){
            parents[i] = i; // 부모는 자기 자신으로 초기화
        }
        int ans = 0;
        for(int i=0; i<P; i++){
            int g = Integer.parseInt(br.readLine());
            int emptyGate = find(g);    // 최고 부모 노드를 찾는다.

            if(emptyGate != 0){ // 게이트에 도킹이 가능한 경우
                ans++;
                // emptyGate와 emptyGate -1 을 합친다.
                // 최고 부모 노드를 1씩 누적해서 줄인다. (해당 노드는 도킹을 했기 때문에 해당 노드 미만의 것들만 도킹 가능)
                union(emptyGate, emptyGate - 1);
            } else {
                break;
            }
        }
        System.out.println(ans);
    }

    // 최고 부모 찾기
    static int find(int x){
        if(parents[x] == x) return x;
        else return parents[x] = find(parents[x]);
    }

    // 합집합 연산
    static void union(int x, int y){
        x = find(x);    // 최고 부모 찾기
        y = find(y);    // 최고 부모 찾기

        if(x != y){
            if(x < y){  // 작은 쪽으로 합친다.
                parents[y] = x;
            } else {
                parents[x] = y;
            }
        }
    }
}