package boj.sort;

import java.io.*;
import java.util.*;

public class _3665 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int T, N, M;
    static int[] prevRank, inNode;
    static Queue<Integer> q;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            prevRank = new int[N+1];
            inNode = new int[N+1];

            graph = new ArrayList<>();
            for(int n = 0; n <= N; n++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for(int n = 1; n <= N; n++) {
                prevRank[n] = Integer.parseInt(st.nextToken());  // prevRank[n] == 작년 n위 팀
            }

            for(int n = 1; n <= N; n++) {  // rank 1 to rank N
                for(int i = n+1; i <= N; i++) {  // rank N+1 ~~
                        graph.get(prevRank[n]).add(prevRank[i]);  // n등한 팀 -> to
                        inNode[prevRank[i]]++;  // 앞에 존재하는 팀 수 만큼
                }
            }

            // for(int i = 1; i < graph.size(); i++) {
            //     System.out.println("graph"+i);
            //     for(int j = 0; j < graph.get(i).size(); j++) {
                    
            //         System.out.print(graph.get(i).get(j) + " ");
            //     }
            //     System.out.println();
            // }

            M = Integer.parseInt(br.readLine());  // 상대 순위 변경
            for(int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());  // h || l
                int b = Integer.parseInt(st.nextToken());  // l || h

                if(graph.get(a).contains(b)) {  // h l
                    inNode[a]++;
                    inNode[b]--;

                    graph.get(a).remove(Integer.valueOf(b));
                    graph.get(b).add(a);
                } else {  // l h
                    inNode[a]--;
                    inNode[b]++;

                    graph.get(b).remove(Integer.valueOf(a));
                    graph.get(a).add(b);

                }
            //     for(int i = 1; i < graph.size(); i++) {
            //     System.out.println("swifted graph"+i);
            //     for(int j = 0; j < graph.get(i).size(); j++) {
                    
            //         System.out.print(graph.get(i).get(j) + " ");
            //     }
            //     System.out.println();
            // }
            }

            System.out.println(tplgcSort());
        }
    }

    private static String tplgcSort() {
        q = new LinkedList<>();
        sb = new StringBuilder();

        for(int i = 1; i < inNode.length; i++) {
            if(inNode[i] == 0) q.add(i);
        }

        for(int n = 1; n <= N; n++) {
            if(q.size() == 0) return "IMPOSSIBLE";  // inNode == 0이 없음
            if(q.size() > 1) return "?";  // q에 동시에 두개 이상 값 존재 (경우의 수가 여러가지 존재)

            int cur = q.poll();
            sb.append(cur).append(" ");
            ArrayList<Integer> list = graph.get(cur);

            for(int i = 0; i < list.size(); i++) {
                int next = list.get(i);
                inNode[next]--;
                if(inNode[next] == 0) q.add(next);
            }
        }
        return sb.toString();
    }
}

// ** goal 작년 순위와 상대적인 순위가 바뀐 모든 팀의 목록 -> 올해 순위

// (i, j) -> 순서는 무조건 i -> *** -> j 포함해야함 -> 위상정렬
// IMPOSSIBLE (일관성 x -> cycle 존재)
// ? (확실 순위 x == 순위 여러개 존재 ?)

// "상대" 순위 구현
    // 1. prevRank을 graph에 담기 (하나의 선후관계가 아닌 선후에 존재하는 모든 노드 추가)
    // 2. 바뀐 i, j에 대해 inNode ++, --
    // 3. graph의 포함관계 변경하기

// ! note
// ArrayList.remove() work 2-Ways
    // 1. public E remove​(int index) removes idx
    // 2. public boolean remove​(Object o) removes specific first value 