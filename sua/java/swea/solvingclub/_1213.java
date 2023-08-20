package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1213 {
    
    static int T, pat, s;
    static String str, pattern;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        
        for(int t = 1; t <= 10; t++) {
            T = Integer.parseInt(br.readLine());
            pattern = br.readLine();
            str = br.readLine();

            int ret = 0;

            for(int i = 0; i <= str.length() - pattern.length(); i++) {
				if(pattern.equals(str.substring(i, i + pattern.length()))) {
					ret++;
				}
			}

            System.out.println("#" + t + " " + ret);
        }
    }
}
