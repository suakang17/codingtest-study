package boj.io;

import java.io.*;
import java.util.*;

public class _10798 {
    public static void main(String[] args) throws IOException{
        
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // List<List<String>> arr = new ArrayList<>();
        

        // for(int i = 0; i < 5; i++){  // creating inner list -> add to outer list
        //     List<String> str = Arrays.asList(br.readLine().split(""));
        //     arr.add(str);
        // }
        // System.out.println(arr.toString());
        // for(int col = 0; col < arr.get(1).size(); col++) {
            
        //     // each inner list size varies -> breakpoint
        //     for (int row = 0; row < arr.size(); row++) {
        //         String value = arr.get(row).get(col);
        //         System.out.print(value);
                
        //     }
        // }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<String>> arr = new ArrayList<>();
        

        for(int i = 0; i < 5; i++){  // creating inner list -> add to outer list
            List<String> str = Arrays.asList(br.readLine().split(""));
            arr.add(str);
        }

        int maxLength = -1;
        for(List<String> strList : arr){
            maxLength = Math.max(maxLength, strList.size());
        }

        StringBuilder sb = new StringBuilder();
        for(int col = 0; col < maxLength; col++) {
            for (List<String> strList : arr) {
                if(col < strList.size()){
                    sb.append(strList.get(col));
                }
                
            }
        }

        System.out.println(sb.toString());

    }
}