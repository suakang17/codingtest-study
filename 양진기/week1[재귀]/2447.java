import java.util.*;
import java.io.*;

class Main{

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                star(i, j, N);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void star(int i, int j, int n){

        if(n == 1){
            sb.append("*");
        }

        else if((i / (n/3) % 3 == 1) && (j / (n/3) % 3 == 1)){
            sb.append(" ");
        }

        else {
            star(i, j, n/3);
        }
    }
}