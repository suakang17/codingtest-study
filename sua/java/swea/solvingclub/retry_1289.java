package swea.solvingclub;

import java.io.*;
import java.util.*;

public class retry_1289 {

    static int T, cnt;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= 10; t++) {
            String[] original = br.readLine().split("");
            String[] str = {"0", "0", "0", "0"};
            cnt = 0;

            for(int i = 0; i < str.length; i++) {
                if(original[i] != str[i]) {
                    while(i < str.length) {
                        str[i++] = "0";
                    }
                    cnt++;
                }
            }
        }
    }
}