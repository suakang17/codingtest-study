import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] seq = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;

        while(start <= end && end <= n){

            if(sum >= s){

                sum -= seq[start];
                start++;
                count = end - start + 1;
                min = Math.min(min, count);
            } else if(sum < s) {
                sum += seq[end];
                end++;
            }
//            if(sum >= s){
//                min = Math.min(min, count);
//                sum -= seq[start];
//                start++;
//                count--;
//            } else if(sum < s) {
//                sum += seq[end];
//                end++;
//                count++;
//            }

//            if(sum > s){
//                sum -= seq[start];
//                start++;
//                count--;
//            } else if(sum < s){
//                sum += seq[end];
//                end++;
//                count++;
//            } else if(sum == s){
//                min = Math.min(min, count);
//                sum -= seq[start];
//                start++;
//                count = 0;
//            }
        }

        if(min == Integer.MAX_VALUE){
            System.out.println("0");
        } else {
            System.out.println(min);
        }
    }
}