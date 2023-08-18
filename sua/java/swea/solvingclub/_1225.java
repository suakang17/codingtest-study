package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1225 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int T;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        
        for(int t = 1; t <= 10; t++) {
            T = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            int[] arr = new int[8];

            for(int i = 0; i < arr.length; i++) {
                while(arr[i] > 0) {
                    arr[i] // 
                }
            }
        }
    }
}


// for(int t = 1; t <= 10; t++) {
//             T = Integer.parseInt(br.readLine());
            
//             q = new LinkedList<>();
//             st = new StringTokenizer(br.readLine());

//             while(st.hasMoreTokens()) {
//                 q.add(Integer.parseInt(st.nextToken()));
//             }

//             int val = 1;
//             while(val != 0) {
//                 // cycle
//                 for(int i = 1; i < 6; i++) {
//                     val = q.poll() - i;
//                     if(val < 0) { val = 0; }
//                     q.add(val);
//                     if(val == 0) { break; }
//                 }
//             }

//             sb = new StringBuilder();
//             while(!q.isEmpty()) {
//                 sb.append(q.poll()).append(" ");
//             }

//             System.out.println("#" + T + " " + sb);
//         }