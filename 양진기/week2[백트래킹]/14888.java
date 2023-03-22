import java.util.*;
import java.io.*;

class Main{

    static int N;
    static int[] arr;
    static int[] operator = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){

            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        cal(arr[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void cal(int num, int idx){

        if(idx == N){
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for(int i=0; i<4; i++){
            // 연산자 개수가 1개 이상인 경우
            if(operator[i] > 0){

                // 해당 연산자를 1 감소시킨다.
                operator[i]--;

                switch(i){
                    case 0: cal(num + arr[idx], idx + 1);    break;
                    case 1: cal(num - arr[idx], idx + 1);    break;
                    case 2: cal(num * arr[idx], idx + 1);    break;
                    case 3: cal(num / arr[idx], idx + 1);    break;
                }

                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                operator[i]++;
            }
        }
    }
}