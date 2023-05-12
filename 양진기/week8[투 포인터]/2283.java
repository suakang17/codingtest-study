import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[1_000_002];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            arr[left]++;
            arr[right]--;
        }

        for(int i=1; i<arr.length; i++){
            arr[i] += arr[i-1];
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        while(true){
            if(sum < k) {
                sum += arr[end];
                end++;
            } else if(sum > k){
                sum -= arr[start];
                start++;
            } else {
                System.out.println(start + " " + end);
                return;
            }
            if(end == 1_000_001) break;
        }
        System.out.println("0 0");
    }
}