package boj.io;

import java.io.*;
import java.util.*;

public class _2563 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<int[]> paper = new ArrayList<>();  // 2darr using nested loop and a primitive int array
        for(int i = 1; i < 101; i++){           // can avoid overheads of using wrapper objects && save memory
            int[] arr = new int[101];
            paper.add(arr);

            for(int j = 1; j < 101; j++){       // arr[i][j] -> i: За j: ї­
                arr[j] = 0;
            }
        }

        // input 
        int N = Integer.parseInt(br.readLine());

        for(int n = 0; n < N; n++) {
            String[] str = br.readLine().split(" ");

            int start1 = Integer.parseInt(str[0]);
            int start2 = Integer.parseInt(str[1]);

            for(int s1 = start1; s1 < start1 + 10; s1++){
                for(int s2 = start2; s2 < start2 + 10; s2++){
                    if(paper.get(s1)[s2] == 0){  // no pprs on
                        paper.get(s1)[s2] = 1;
                    }
                }
            }
        }
        
        int targetVal = 1;
        int ret = 0;

        for(int[] row : paper) {
            for(int e : row) {
                if (e == targetVal){
                    ret++;
                }
            }
        }

        System.out.println(ret);

        
    }    
}
