import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[] in, post, pre;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        in = new int[n];        // 중위
        post = new int[n];      // 후위
        pre = new int[n];       // 전위

        // inOrder (중위)
        String[] sarr = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            in[i] = Integer.parseInt(sarr[i]);
        }

        // postOrder (후위)
        sarr = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            post[i] = Integer.parseInt(sarr[i]);
        }

        getPreOrder(0, n-1, 0, n-1);    // 중위, 후위에서 가져온다.

        // 전위 순회 출력
        for(int n : pre){
            bw.write(n + " ");
        }
        bw.flush();
    }   // end of main

    // is : 인오더 시작, ie : 인오더 끝
    // ps : 포스트오더 시작 , pe : 포스트오더 끝
    static void getPreOrder(int is, int ie, int ps, int pe){

        if(is <= ie && ps <= pe){
            // 포스트오더의 마지막 노드인 루트가 프리오더의 첫번째 노드인 루트가 된다.
            pre[idx++] = post[pe];  // 포스트 오더의 가장 오른쪽은 (post[pe]) 루트 노드이다.

            int pos = is;
            for(int i = is; i <= ie; i++){  // 인오더에서 루트 노드의 위치를 찾음

                if(in[i] == post[pe]){  // 포스트오더의 마지막값인 루트를 가져와 찾는다.
                    pos = i;    // 인오더에서 루트 위치를 찾는다.
                    break;
                }
            }

            // 왼쪽 자식 트리를 가지고 다시 똑같은 과정을 반복한다.
            // 인오더 : 왼쪽 ~ 루트 -1, 포스트오더 : 왼쪽 ~ ps + pos - is
            getPreOrder(is, pos - 1, ps, ps + pos - is - 1);

            // 오른쪽 자식 트리를 가지고 다시 똑같은 과정을 반복한다.
            // 인오더 : 루트+1 ~ 오른쪽, 포스트오더 : ps + pos - is ~ 오른쪽
            getPreOrder(pos + 1, ie, ps + pos - is, pe - 1);
        }
    }
}