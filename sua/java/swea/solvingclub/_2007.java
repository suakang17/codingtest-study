package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _2007 {
    
    static int T, cnt;
    static String str;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            str = br.readLine();

            // 문자열 길이 고정이라 가능
            for (int j = 1; j <= 10; j++) {
                if (str.substring(0, j).equals(str.substring(j, j * 2))) {
                    System.out.println("#" + t + " " + j);
                    break;
                }
            }
        }
    }
}
