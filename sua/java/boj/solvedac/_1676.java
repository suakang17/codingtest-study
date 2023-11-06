package boj.solvedac;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class _1676 {
    
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        
        N = sc.nextInt();

        // BigInteger num = new BigInteger("1");  // 초기화

        // for(int i = 1; i <= N; i++) {
        //     num = num.multiply(BigInteger.valueOf(i));  // N!
        // }

        // String str = num.toString();
        // for(int i = str.length()-1; i > 1; i--) {
        //     if(str.charAt(i) - '0' == 0) cnt++;
        //     else break;
        // }

        while (N >= 5) {
            cnt += N / 5;
            N /= 5;
        }

        System.out.println(cnt);
    }
}

// BigInteger은 문자열 형태로 이루어져 있어 숫자의 범위가 무한
// java.math안에 있음
// BigInteger을 초기화하기 위해서는 문자열을 인자 값으로 넘겨주어야 
// **(BigDecimal도 동일)

// 뒷자리가 0이 n개 있다는 의미는 2와 5가 n개씩 짝지어 존재한다는 것 -> 5의 개수에 따라 값이 변화한다고 보면 된다. 그리고 5의 n승에 따라 카운트 값을 한 개 더 추가