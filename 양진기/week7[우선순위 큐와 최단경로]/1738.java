import java.util.*;
import java.io.*;

class Main{
    static int n, m;
    static ArrayList<Node>[] node;
    static long[] costs;
    static int[] previous;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        node = new ArrayList[n + 1];
        for(int i=1; i<n+1; i++){
            node[i] = new ArrayList<>();
        }

        previous = new int[n + 1];
        ans = new int[n + 1];
        costs = new long[n + 1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            node[u].add(new Node(v, -w));
        }

        for(int i=1; i<n+1; i++){
            costs[i] = Long.MAX_VALUE;
        }

        bellmanFod();

        StringBuilder sb = new StringBuilder();
        if(costs[n] == Long.MIN_VALUE || costs[n] == Long.MAX_VALUE){
            sb.append("-1");
        } else {
            Stack<Integer> queue = new Stack<>();
            queue.add(n);
            while(true){
                int peek = queue.peek();
                queue.add(previous[peek]);
                if(peek == 1) break;
            }
            while(!queue.isEmpty()){
                int popValue = queue.pop();
                if(popValue != 0){
                    sb.append(popValue + " ");
                }
            }
        }
        System.out.println(sb);
    } // main

    static void bellmanFod(){
        costs[1] = Long.valueOf(0);
        for(int z=1; z <= n+1; z++){
            for(int i=1; i < n+1; i++){
                for(int k=0; k < node[i].size(); k++){
                    Node node1 = node[i].get(k);
                    int end = node1.end;
                    int weight = node1.weight;

                    if(costs[i] == Long.MAX_VALUE) continue;
                    if(costs[i] == Long.MIN_VALUE) costs[end] = Long.MIN_VALUE;

                    if(costs[end] > costs[i] + weight){
                        costs[end] = costs[i] + weight;
                        previous[end] = i;
                        if(z == n+1){
                            costs[end] = Long.MIN_VALUE;
                        }
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node> {

    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
