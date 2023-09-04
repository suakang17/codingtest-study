package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1926 {
    
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int n = 1; n <= N; n++) {
            String charN = Integer.toString(n);
            

            int cnt = 0;
            for(int i = 0; i < charN.length(); i++) {
                if((charN.charAt(i) == '3') || (charN.charAt(i) == '6') || (charN.charAt(i) == '9')) {
                    cnt++;
                }
            }

            if(cnt == 0) {
                sb.append(charN);
            } else {
                while(cnt-- > 0) {
                    sb.append("-");
                }
            }

            sb.append(" ");
        }

        System.out.println(sb);
    }
}
