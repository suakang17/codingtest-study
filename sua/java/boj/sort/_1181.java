package boj.sort;

import java.io.*;
import java.util.*;

public class _1181 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> strList = new ArrayList<>();

        for(int n = 0; n < N; n++){
            String str = br.readLine();
            int strlen = str.length();
            
            hashMap.put(str, hashMap.getOrDefault(str, strlen));
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(hashMap.entrySet());
		entryList.sort(Map.Entry.comparingByKey());
		entryList.sort(Map.Entry.comparingByValue());
		
		for(Map.Entry<String, Integer> entry : entryList) {
			System.out.println(entry.getKey());
        }
    }
}
