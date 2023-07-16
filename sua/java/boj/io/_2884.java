package boj.io;

import java.io.*;
import java.util.*;

public class _2884 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (H > 0){
            if (M >= 45){ // M >= 45 , H > 0
                M -= 45;
                System.out.println(H + " " + M);

            }
            else {  // M < 45 , H > 0
                H -= 1;
                M = (60 - (45 - M));
                if (M == 60) {
                    M = 0;
                }
                System.out.println(H + " " + M);

            }
        }
        else { // M < 45 , H == 0

            if (M < 45){
                H = 23;
                M = 60 - (45 - M);
                if (M == 60){
                    M = 0;
                }
                System.out.println(H + " " + M);
            }
            else { // M > 45, H == 0
                M -= 45;
                System.out.println(H + " " + M);
            }
        }
    }
}
