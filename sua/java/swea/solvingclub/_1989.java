package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1989 {
    
    static int T;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // aabbaa len 6 mid 3 -> 두번째b
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        outer: for(int t = 1; t <= T; t++) {
            String str = br.readLine();

            if(str.length() % 2 == 0) {  // 길이 짝수
                int mid = str.length() / 2;
                int vs = mid - 1;
                while(mid < str.length() && vs >= 0) {
                    if(str.charAt(mid++) != str.charAt(vs--)) {
                        System.out.println("#" + t + " " + 0);
                        continue outer;
                    }
                }
                System.out.println("#" + t + " " + 1);
            }

            else {  // 길이 홀수
                int mid = str.length() / 2;
                for(int i = 1; i <= mid; i++) {
                    if(str.charAt(mid-i) != str.charAt(mid+i)) {
                        System.out.println("#" + t + " " + 0);
                        continue outer;
                    }
                }
                System.out.println("#" + t + " " + 1);
            }
        }
    }
}
