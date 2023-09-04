package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1208 {
    
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] box;

    public static void main(String[] args) throws IOException {
        
        for(int tc = 1; tc <= 10; tc++) {
            int dump = Integer.parseInt(br.readLine());
            box = new int[100];
            int i = 0;

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                box[i++] = (Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(box);

            while(dump != 0) {
                    box[99]--;  // 가장 높은
                    box[0]++;  // 가장 낮은
                    Arrays.sort(box);
                    dump--;
                    if(dump == 0) { break; }
                }

            System.out.println("#" + tc + " " + (box[99] - box[0]));
            }
        }
    
}
