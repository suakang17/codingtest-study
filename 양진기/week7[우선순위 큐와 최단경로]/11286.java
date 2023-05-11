import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){    // return 값이 음수면 자리 바꾼다. (차이가 작아야 위로 감)
                // 절대값 기준으로 o1(입력값)이 o2(부모값) 보다 크다면 자리를 바꾸지 않는다.
                if(Math.abs(o1) > Math.abs(o2)){
                    /*
                        o1 : -2, o2 : 1  # 2 - 1 = 1 (양수)
                        o1 : 2,  o2 : -1 # 2 - 1 = 1 (양수)
                        차이값이 양수다 -> 바꾸지 않는다.
                    */
                    return Math.abs(o1) - Math.abs(o2); // 양수
                } else if (Math.abs(o1) == Math.abs(o2)){
                    /*
                        o1 : -1, o2 : 1  # -1 - 1 = -2 (음수)
                        o1 : 1 , o2 : -1 # 1 - (-1) = 2 (양수)

                        o1 값이 음수일 때 리턴은 음수 -> 값을 바꾼다.
                        o1 값이 양수일 때 리턴은 양수 -> 값을 바꾸지 않는다.
                    */
                    return o1 - o2;
                } else {    // 절대값 기준으로 o2(입력값의 부모값)이 더 크다면 자리를 바꾼다.(최소 힙이기 때문)
                    return -1;    // 음수면 값을 바꾼다.
                }
            }
        });

        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());

            if(x == 0){    // 입력값이 0 이라면
                if(!pq.isEmpty()){
                    System.out.println(pq.poll());
                } else {
                    //  만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력
                    System.out.println(0);
                }
            } else {    // 입력값이 0이 아니라면
                //  배열에 x라는 값을 넣는다.
                pq.add(x);
            }
        }
    }
}