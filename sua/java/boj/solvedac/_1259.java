package boj.solvedac;

import java.io.*;
import java.util.*;

public class _1259 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static StringBuffer sf;
    public static void main(String[] args) throws IOException {

        sb = new StringBuilder();
        sf = new StringBuffer();
        outer : while (true) {
            String str = br.readLine();
            if(str.equals("0")) break;

            int l = str.length();
            for(int i = 0; i < l/2; i++) {
                if(str.charAt(i) != str.charAt(l-1-i)) {
                    sb.append("no").append("\n");
                    continue outer;
                }
            }
            sb.append("yes").append("\n");
        }
        System.out.println(sb);
    }
}
