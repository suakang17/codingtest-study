package boj.io;

import java.io.*;
import java.util.*;

public class _2941 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = 0;

        // 1
    //     for(int i = 0; i < str.length(); i++){
    //         if(str.charAt(i) == 'c'){
    //             if(str.charAt(i+1) == '='){
    //                 ret += 1;
    //                 if(i+2 <= str.length()){
    //                     i++;
    //                     continue;
    //                 }
    //             }
    //             if(str.charAt(i+1) == '-'){
    //                 ret += 1;
    //                 if(i+2 <= str.length()){
    //                     i++;
    //                     continue;
    //                 }
    //             }
    //         }
    //         if(str.charAt(i) == 'd'){
    //             if(str.charAt(i+1) == '-'){
    //                 ret += 1;
    //                 if(i+2 <= str.length()){
    //                     i++;
    //                     continue;
    //                 }
    //             }
    //             if(str.charAt(i+1) == 'z'){
    //                 if(str.charAt(i+2) == '='){
    //                     ret += 1;
    //                     if(i+3 <= str.length()){
    //                         i++;
    //                         i++;
    //                         continue;
    //                     }
    //                 }
    //             }
    //         }
    //         if(str.charAt(i) == 'l'){
    //             if(str.charAt(i+1) == 'j'){
    //                 ret += 1;
    //                 if(i+2 <= str.length()){
    //                     i++;
    //                     continue;
    //                 }
    //             }
    //         }
    //         if(str.charAt(i) == 'n'){
    //             if(str.charAt(i+1) == 'j'){
    //                 ret += 1;
    //                 if(i+2 <= str.length()){
    //                     i++;
    //                     continue;
    //                 }
    //             }
    //         }
    //         if(str.charAt(i) == 's'){
    //             if(str.charAt(i+1) == '='){
    //                 ret += 1;
    //                 if(i+2 <= str.length()){
    //                     i++;
    //                     continue;
    //                 }
    //             }
    //         }
    //         if(str.charAt(i) == 'z'){
    //             if(str.charAt(i+1) == '='){
    //                 ret += 1;
    //                 if(i+2 <= str.length()){
    //                     i++;
    //                     continue;
    //                 }
    //             }
    //         }
    //         ret += 1;
        // }
    //     System.out.printbln(ret);

    // 2
    int len = str.length();
    for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if(ch == 'c' && i < len - 1) {			// 만약 ch 가 c 라면?
                //만약 ch 다음 문자가 '=' 또는 '-' 이라면?
                if(str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {		
                    // i+1 까지가 하나의 문자이므로 다음 문자를 건너 뛰기 위해 1 증가
                    i++;		
                }
                
            }
            
            else if(ch == 'd' && i < len - 1) {
                if(str.charAt(i + 1) == '-') {	// d- 일 경우
                        i++;
                    }
                else if(str.charAt(i + 1) == 'z' && i < len - 2) {
                    
                    if(str.charAt(i + 2) == '=') {	// dz= 일 경우
                        i += 2;
                    }
                }
            }
            
            else if((ch == 'l' || ch == 'n') && i < len - 1) {
                if(str.charAt(i + 1) == 'j') {	// lj 또는 nj 일 경우
                    i++;
                }
            }
            

            else if((ch == 's' || ch == 'z') && i < len - 1) {
                if(str.charAt(i + 1) == '=') {	// s= 또는z= 일 경우
                    i++;
                }
            
            }
            
            count++;

        }

        System.out.println(count);
        }
}
