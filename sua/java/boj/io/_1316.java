package boj.io;

import java.io.*;
import java.util.*;

public class _1316 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ret = 0;

        for (int n = 0; n < N; n++) {
            String word = br.readLine();
            boolean[] visited = new boolean[26]; 
            boolean isGroupWord = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (visited[c - 'a']) { 
                    isGroupWord = false;
                    break;
                }
                visited[c - 'a'] = true; 

                while (i + 1 < word.length() && word.charAt(i + 1) == c) {
                    i++;
                }
            }

            if (isGroupWord) {
                ret++;
            }
    }
        System.out.println(ret);
    }
}
