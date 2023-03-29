import java.io.*;
import java.util.*;

class Main{

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];

        for(int i=1; i<N+1; i++){
            arr[i] = -1;
        }

        // [0, 1, 2, -1, -1]
        arr[0] = 0;
        arr[1] = 1;
        if(N >= 2) arr[2] = 2;

        System.out.println(bio(N));
    }

    static int bio(int N){

        // bio(3) + bio(2)
        // bio(2) + bio(1) + bio(2)
        // 1 + 1 + 1
        if(arr[N] == -1){
            arr[N] = (bio(N-1) + bio(N-2)) % 15746;
        }
        return arr[N];
    }
}