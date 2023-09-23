package boj.sssw;

import java.io.*;
import java.util.*;
public class _1662 {
    
    static int[] rightIdxs = new int[51];
	static String[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
        String S = br.readLine();
		input = S.split("");
		
		for(int i=0; i< input.length; i++) {
			String value = input[i];
			if(value.equals("(")) stack.add(i); // ( 위치
			if(value.equals(")")) rightIdxs[stack.pop()] = i; // 짝 매칭
		}
		
		System.out.println(getLength(0, input.length));
	}
	
	private static int getLength(int start, int end) {
		int len = 0;
		for(int i = start; i < end; i++) {
			if(input[i].equals("(")) {
				len += Integer.parseInt(input[i-1]) * getLength(i+1, rightIdxs[i]) - 1 ;
				i = rightIdxs[i];
			} else {
				len++;
			}
		}
		return len;
	}

}

// 압축된 문자열 S -> 부분 문자열에 대해 K(Q)와 같이 압축가능
// K == 한자리 정수, Q == 0자리 이상 문자열
// K(Q) == Q라는 문자열이 K번 반복됨

// goal: unzip String

// 아예 거꾸로 거슬러오며 처리
// ** 반례 한 괄호 내에 괄호 여닫 여러개인경우 ** //
// -> 괄호 짝매칭하도록

// ** 재귀 ->  ( 만나면 마지막 ) 만날때까지의 내부를 재귀로
// 기저상태 == 가장 내부 () 까지 재귀타고 들어감