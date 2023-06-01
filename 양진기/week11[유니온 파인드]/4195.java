import java.io.*;
import java.util.*;

class Main{

    static int[] parent;    // 부모 저장할 배열
    static int[] count;     // 친구 관계 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            int F = Integer.parseInt(br.readLine());

            parent = new int[F * 2];
            count = new int[F * 2];
            for(int i=0; i < F*2; i++){
                parent[i] = i;  // 자신의 부모는 자기 자신으로 초기화
//                count[i] = 1;   // 최초 친구 수는 기본값으로 한 명이다.
            }
            Arrays.fill(count, 1);

            HashMap<String, Integer> map = new HashMap<>(); // 이름, 인덱스(노드번호)
            int idx = 0;
            for(int i=0; i<F; i++){
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if(!map.containsKey(a)){    // 친구 이름이 없으면 인덱스(노드) 부여
                    map.put(a, idx++);
                }

                if(!map.containsKey(b)){    // 친구 이름이 없으면 인덱스(노드) 부여
                    map.put(b, idx++);
                }

                sb.append(union(map.get(a), map.get(b)) + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 최고 부모 찾기
    static int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    // 합집합 연산
    private static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y){
            if(x < y){                  // 작은 곳에
                parent[y] = x;          // 합친다.
                count[x] += count[y];   // 최고 부모 노드에 친구 수를 누적한다.
                return count[x];
                // a 먼저 idx++한 후 , b에 idx++해서 map에 추가했으므로 x > y인 경우는 없다...
            } else {                    // 작은 곳에
                parent[x] = y;          // 합친다.
                count[y] += count[x];   // 최고 부모 노드에 친구 수를 누적한다.
                return count[y];
            }
        }

        return count[x];    // 최고 부모 노드에 친구 수가 누적되어 있다.
    }
}