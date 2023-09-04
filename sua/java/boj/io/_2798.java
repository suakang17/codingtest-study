package boj.io;

import java.io.*;
import java.util.*;

public class _2798 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        String[] s = br.readLine().split(" ");
        int[] cards = new int[N];

        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(s[i]);
        }

        int max = -1;
        
        // 3-nested loop n^3 -> 136ms 14032kb
        for(int i = 0; i < cards.length - 2; i++){
            for(int j = i + 1; j < cards.length - 1; j++){
                for(int k = j + 1; k < cards.length - 0; k++){
                    if(cards[i] + cards[j] + cards[k] <= M){
                        max = Math.max(max, cards[i] + cards[j] + cards[k]);
                    }
                }
            }
        }
        System.out.println(max);

        // two-pointer n^2 132ms 14204kb
        // Arrays.sort(cards);

        // for(int i = 0; i < N - 2; i++){
        //     int l = i + 1;
        //     int r = N - 1;

        //     while(l < r) {
        //         int sum = cards[i] + cards[l] + cards[r];
        //         if(sum <= M) {
        //             max = Math.max(max, sum);
        //             l++;
        //         } else {
        //             r--;
        //         }
        //     }
        }

        //System.out.println(max);
        
    //}
}
