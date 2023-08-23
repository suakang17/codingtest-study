package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1248 {
    
    static int T, V, E, a, b;
    static boolean[] visited;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= 10; t++) {
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            visited = new boolean[V+1];

            
        }
    }
}
