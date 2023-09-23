package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _5658 {
    
    
    static int T, N, K, rotateNum, numLen;
    static String str;

    static Deque<Character> dq;
    static ArrayList<Integer> arr;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            str = br.readLine();
            rotateNum = str.length() / 4;
            numLen = rotateNum;
            dq = new LinkedList<>();
            for(int c = 0; c < N; c++) {
                dq.add(str.charAt(c));
            }

            sb.append(rotate());
            System.out.println(sb);
        }
    }

    private static int rotate() {

        arr = new ArrayList<>();

        while(rotateNum-- > 0) {
            String newStr = "";
            String newNum = "";
            while(!newStr.equals(str)) {
                char c = dq.poll();
                if(newNum.length() == numLen) {
                    int nn = Integer.parseInt(newNum, 16);
                    if(!arr.contains(nn)) arr.add(nn);
                    newNum = "";
                }
                newStr += c;
                newNum += c;
                dq.addLast(c);
            }
            int nn = Integer.parseInt(newNum, 16);
            if(!arr.contains(nn)) arr.add(nn);

            char last = dq.pollLast();
            dq.addFirst(last);
            List<Character> list = new ArrayList<>(dq);
            str = "";
            for(int i = 0; i < list.size(); i++) {
                str += list.get(i);
            }
        }
        Collections.sort(arr, Collections.reverseOrder());
        return arr.get(K-1);
    }
}

// 각 변 16진수 숫자(0~F)
// 뚜껑 시계방향으로 돌릴 수 있고, 한 번 돌릴 때마다 숫자가 시계방향으로 한 칸씩 회전
// 각 변에는 동일한 개수의 숫자가 있고, 시계방향 순으로 높은 자리 숫자에 해당하며 하나의 수를 나타낸
// 비밀번호는 보물 상자에 적힌 숫자로 만들 수 있는 모든 수 중, K번째로 큰 수를 10진 수로 만든 수