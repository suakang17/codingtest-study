package boj.data_structure;

import java.io.*;
import java.util.*;

public class _10815 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");

        int N = Integer.parseInt(br.readLine());

        String[] temp = br.readLine().split(" ");
        HashSet<Integer> cards = new HashSet<>();

        for(int n = 0; n < N; n++){
            cards.add(Integer.parseInt(temp[n]));
        }

        int M = Integer.parseInt(br.readLine());

        String[] temp2 = br.readLine().split(" ");

        for(int m = 0; m < M; m++){
            if(cards.contains(Integer.parseInt(temp2[m]))){
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString().trim());

        
    }    
}
