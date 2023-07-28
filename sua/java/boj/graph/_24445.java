package boj.graph;

import java.io.*;
import java.util.*;

public class _24445 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int trail;

    public static void main(String[] args) throws IOException{
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());


        visited = new int[N + 1];
        trail = 1;

        for(int n = 0; n < N + 1; n++){
            graph.add(new ArrayList<>());
        }

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a); 
        }

        bfs(R);

        for(int i = 1; i < N+1; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<Integer>();
        visited[node] = trail++;
        q.add(node);

        while(!q.isEmpty()) {
            int now = q.poll();
            Collections.sort(graph.get(now), Collections.reverseOrder());

            for(int i = 0; i < graph.get(now).size(); i++){
                int nextNode = graph.get(now).get(i);
                
                if(visited[nextNode] == 0) {
                    visited[nextNode] = trail++;
                    q.add(nextNode);
                }
            }
        }

    }

    // private static void bfs(int node) {
    //     Queue<Integer> q = new LinkedList<>();
    //     visited[node] = trail++;
    //     q.add(node);

    //     while(!q.isEmpty()) {
    //         int now = q.poll();
    //         Collections.reverse(graph.get(now)); // 내림차순이 아닌 리스트 뒤집기임
            
    //         for(int i = 0; i < graph.get(now).size(); i++){
    //             int nextNode = graph.get(now).get(i);

    //             if(visited[nextNode] == 0) {
    //                 visited[nextNode] = trail++;
    //                 q.add(nextNode);
    //             }
    //         }
    //     }
    // }
}

// 오답.. 모르겠음 왠지
// you are sorting the neighbors of each node before the BFS traversal starts. 
// This sorting does not affect the order in which nodes are explored during the BFS,
// leading to incorrect results.
// import java.io.*;
// import java.util.*;

// public class Main {
    
//     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     static StringBuilder sb = new StringBuilder();
//     static StringTokenizer st;

//     static List<List<Integer>> graph = new ArrayList<>();
//     static int[] visited;
//     static int trail;

//     public static void main(String[] args) throws IOException{
        
//         st = new StringTokenizer(br.readLine());
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         int R = Integer.parseInt(st.nextToken());


//         visited = new int[N + 1];
//         trail = 1;

//         for(int n = 0; n < N + 1; n++){
//             graph.add(new ArrayList<>());
//         }

//         for(int m = 0; m < M; m++){
//             st = new StringTokenizer(br.readLine());
//             int a = Integer.parseInt(st.nextToken());
//             int b = Integer.parseInt(st.nextToken());

//             graph.get(a).add(b);
//             graph.get(b).add(a); 
//         }

//         for(int i = 0; i < N; i++){
//             Collections.sort(graph.get(i), Collections.reverseOrder());
//         }

//         bfs(R);

//         // for(int i = 1; i < N+1; i++) {
//         //     sb.append(visited[i]).append("\n");
//         // }
//         for(int i=1;i<=N;i++) System.out.println(visited[i]);

//         System.out.println(sb);
//     }

//     private static void bfs(int node) {
//         Queue<Integer> q = new LinkedList<>();
//         visited[node] = trail++;
//         q.add(node);

//         while(!q.isEmpty()) {
//             node = q.poll();

//             for(int i = 0; i < graph.get(node).size(); i++){
//                 int nextNode = graph.get(node).get(i);

//                 if(visited[nextNode] == 0) {
//                     visited[nextNode] = trail++;
//                     q.add(nextNode);
//                 }
//             }
//         }

//     }
// }
