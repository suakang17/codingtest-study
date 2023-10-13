package boj.solvedac;

import java.io.*;
import java.util.*;

public class _16637 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int N, max;
    static String str;
    static ArrayList<Character> opList;
    static ArrayList<Integer> numList;

    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        max = Integer.MIN_VALUE;

        opList = new ArrayList<>();
        numList = new ArrayList<>();
        for(int n = 0; n < N; n++) {
            char cur = str.charAt(n);
            if(cur == '+' || cur == '*' || cur == '-') {
                opList.add(cur);
            } else {
                numList.add(Character.getNumericValue(cur));
            }
        }

        dfs(0, numList.get(0));
        System.out.println(max);
    }

    private static int calc(char op, int x, int y) {
        switch (op) {
            case '+':
                return x+y;

            case '-':
                return x-y;

            case '*':
                return x*y;
        }
        return 0;
    }

    private static void dfs(int opIdx, int ret) {
        if(opIdx >= opList.size()) {
            max = Math.max(max, ret);
            return;
        }

        // 괄호 씌움
        if(opIdx+1 < opList.size()) {
            int temp = calc(opList.get(opIdx+1), numList.get(opIdx+1), numList.get(opIdx+2));
            dfs(opIdx+2, calc(opList.get(opIdx), ret, temp));
        }
        
        // 괄호 안씌움
        dfs(opIdx+1, calc(opList.get(opIdx), ret, numList.get(opIdx+1)));
    }
}


// * goal 괄호를 적절히 추가해서 얻을 수 있는 결과의 최댓값을 출력

// 여는 괄호 위치에 따라 닫는 괄호 위치는 정해져 있음 -> 이 때 max 값
// 위치 조합 -> 연산자 기준 (좌우 숫자) 괄호 추가 or not -> dfs
// 순서대로만 -> 백트래킹