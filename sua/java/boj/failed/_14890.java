package boj.failed;

import java.io.*;
import java.util.*;

public class _14890 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, L;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int n = 0; n < N; n++) {
            graph.add(new ArrayList<>());
        }

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < N; m++) {
                graph.get(n).add(Integer.parseInt(st.nextToken()));
            }
        }


    }
}

// ** goal 지나갈 수 있는 길의 개수