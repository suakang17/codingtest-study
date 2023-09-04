package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _3499 {
    
    static int T, N, size;
    static Queue<String> upper, under;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            upper = new LinkedList<>();
            under = new LinkedList<>();

            size = (N % 2 == 0) ? N/2 : N/2 + 1;  // even or odd

            for(int up = 0; up < size; up++) {
                upper.add(st.nextToken());
            }

            for(int un = 0; un < N-size; un++) {
                under.add(st.nextToken());
            }

            sb = new StringBuilder("#" + t + " ");
            while(!under.isEmpty() || !upper.isEmpty()) {
                if(!upper.isEmpty()) { sb.append(upper.poll()).append(" "); }
                if(!under.isEmpty()) { sb.append(under.poll()).append(" "); }
            }

            System.out.println(sb);
        }
    }
}
