package boj.failed;

import java.io.*;
import java.util.*;

public class failed_1406 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String str, cmd;
    static Character obj;
    static Queue<Character> q = new LinkedList<>();
    static int M, cursor;

    public static void main(String[] args) throws IOException {
        
        str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            q.add(str.charAt(i));
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();

            switch (cmd) {
                case "L":
                    if(cursor != 0) { cursor--; }
                    break;
            
                case "D":
                    if(cursor != q.size()) { cursor++; }
                    break;
                
                case "B":
                    if(cursor != 0) {
                        q.remove(cursor-1);
                        cursor--;
                    }
                    break;
                
                case "P":
                    obj = st.nextToken().charAt(0);
                    q.add(cursor, obj);
                    cursor++;
                    break;
            }
        }
    }
}


// 시간초과
// str = br.readLine();
//         for(int i = 0; i < str.length(); i++) {
//             q.add(str.charAt(i));
//         }
//         cursor = q.size();

//         M = Integer.parseInt(br.readLine());

//         for(int m = 0; m < M; m++) {
//             st = new StringTokenizer(br.readLine());
//             cmd = st.nextToken();

//             switch (cmd) {
//                 case "L":
//                     if(cursor != 0) { cursor--; }
//                     break;
            
//                 case "D":
//                     if(cursor != q.size()) { cursor++; }
//                     break;
                
//                 case "B":
//                     if(cursor != 0) {
//                         q.remove(cursor-1);
//                         cursor--;
//                     }
//                     break;
                
//                 case "P":
//                     obj = st.nextToken().charAt(0);
//                     q.add(cursor, obj);
//                     cursor++;
//                     break;
//             }
//         }

//         for(char c : q) {
//             sb.append(c);
//         }
//         System.out.println(sb);