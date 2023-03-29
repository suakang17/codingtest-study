import java.io.*;
import java.util.*;

class Main{

    static int N;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    static void nQueen(int depth){

        // depth를 다 순회하였다면 경우의 수가 나온 것이므로 카운트하고 리턴
        if(depth == N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){

            /*
                왼쪽(열행)을 보기 편하게 오른쪽(행열)로 바꿈
                하나의 열(depth)씩 행(i=0~N)을 돌아가며 검사
                [0]=0, [1]=0, [2]=0, [3]=0      0=[0], 0=[1], 0=[2], 0=[3]
                [0]=1, [1]=1, [2]=1, [3]=1      1=[0], 1=[1], 1=[2], 1=[3]
                [0]=2, [1]=2, [2]=2, [3]=2      2=[0], 2=[1], 2=[2], 2=[3]
                [0]=3, [1]=3, [2]=3, [3]=3      3=[0], 3=[1], 3=[2], 3=[3]
            */
            arr[depth] = i;

            // 놓을 수 있는 위치일 경우 재귀 호출
            if(Possibility(depth)){
                nQueen(depth+1);
            }
        }
    }

    static boolean Possibility(int col){
        /*
            arr[0] = 0      arr = [0, 0, 0, 0]      return true;
                arr[1] = 0  arr = [0, 0, 0, 0]      return false;   arr[1] == arr[0]
                arr[1] = 1  arr = [0, 1, 0, 0]      return false;   (1-0) == arr[1] - arr[0]
                arr[1] = 2  arr = [0, 2, 0, 0]      return true;
                    arr[2] = 0  arr = [0, 2, 0, 0]  return false;   arr[2] == arr[0]
                    arr[2] = 1  arr = [0, 2, 1, 0]  return false;   (2-1) == arr[2] - arr[1]
                    arr[2] = 2  arr = [0, 2, 2, 0]  return false;   (2-0) == arr[2] - arr[0]
                    arr[2] = 3  arr = [0, 2, 3, 0]  return false;   (2-1) == arr[2] - arr[1]
        */
        for(int i=0; i<col; i++){
            // 해당 열의 행과 i열의 행이 일치할 경우 == 같은 행에 존재하는 경우
            // arr[1] = 0    arr[1] == arr[0]
            if(arr[col] == arr[i]){
                return false;
            }

            // 열의 차와 행의 차가 같을 경우 == 대각선에 놓여있는 경우
            // arr[1] = 1    (1-0) == arr[1] - arr[0]
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])){
                return false;
            }
        }

        // 같은 행이나 대각선에 없는 경우 true 리턴
        return true;
    }
}