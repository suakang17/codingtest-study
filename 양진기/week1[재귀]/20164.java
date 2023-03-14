import java.util.*;
import java.io.*;

class Main{

    static int min, max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        min = Integer.MAX_VALUE;
        max = 0;

        odd(N, getOddCnt(N));
        System.out.println(min + " " + max);
    }

    static void odd(int N, int cnt){

        if(N <= 9){
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
            return;
        }

        if(N <= 99){
            int next = (N / 10) + (N % 10);
            odd(next, getOddCnt(next) + cnt);
        }

        String s = Integer.toString(N);

        for(int i=0; i<s.length()-2; i++){
            for(int j=i+1; j<s.length()-1; j++){
                String x1 = s.substring(0, i+1);
                String x2 = s.substring(i+1, j+1);
                String x3 = s.substring(j+1, s.length());

                int nx = Integer.parseInt(x1) + Integer.parseInt(x2) + Integer.parseInt(x3);
                odd(nx, getOddCnt(nx) + cnt);
            }
        }
    }

    static int getOddCnt(int N){
        int ret = 0;
        while(N > 0){
            int temp = N % 10;
            if(temp % 2 == 1) ret++;
            N = N / 10;
        }

        return ret;
    }
}