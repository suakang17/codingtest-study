package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _5356 {
    
    static int T;
    static String str;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {

            List<List<String>> arr = new ArrayList<>();
        

            for(int i = 0; i < 5; i++){
                List<String> str = Arrays.asList(br.readLine().split(""));
                arr.add(str);
            }

            int maxLength = -1;
            for(List<String> strList : arr){
                maxLength = Math.max(maxLength, strList.size());
            }

            sb = new StringBuilder();
            for(int col = 0; col < maxLength; col++) {
                for (List<String> strList : arr) {
                    if(col < strList.size()){
                        sb.append(strList.get(col));
                    }
                    
                }
            }

            System.out.println("#" + t + " " + sb.toString());
            }
    }
}
