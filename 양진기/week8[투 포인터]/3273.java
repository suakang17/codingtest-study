import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        int start = 0;
        int end = n-1;
        int count = 0;

        Arrays.sort(seq);

        while(start < end) {
            int sum = seq[start] + seq[end];
            if(sum == x) {
                count++;
            }

            if(sum < x) {
                start++;
            }
            else {
                end--;
            }
        }
        System.out.println(count);
    }
}