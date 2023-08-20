package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1216 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] arr;
    static int T;
    static int max;

    public static void main(String[] args) throws IOException {
        
        for(int t = 1; t <= 10; t++) {
            T = Integer.parseInt(br.readLine());
            arr = new char[100][100];

            for(int c = 0; c < 100; c++) {
                String str = br.readLine();
                for(int r = 0; r < 100; r++) {
                    arr[c][r] = str.charAt(r);
                }
            }

            for(int i = 100; i > 0; i--) {  // 임의의 회문 길이 i
				if(solve(i)) {
					System.out.println("#"+ t + " " + i);
					break;
				}	
			}
        }
    }

    public static boolean solve(int l) {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j <= (100 - l); j++) {
				if(horizontal(i, j, l) || vertical(j, i, l) ) return true;
			}
		}
		
		return false;
	}

    // private static boolean horizontal(int i, int j, int l) {
    //     String tmp = "";
	// 	int count = 0;
		
	// 	while(count < l) {
	// 		tmp += arr[i][j+count];
	// 		count++;
	// 	}
		
	// 	// 문자열 뒤집기
	// 	StringBuffer bf = new StringBuffer(tmp);
	// 	String reverse = bf.reverse().toString();

	// 	// 회문 여부 검사
	// 	if(tmp.equals(reverse)) {
	// 		return true;
	// 	}
		
	// 	return false;
        
    // }

    // private static boolean vertical(int i, int j, int l) {
    //     String tmp = "";
	// 	int count = 0;
		
	// 	while(count < l) {
	// 		tmp += arr[i+count][j];
	// 		count++;
	// 	}
		
	// 	// 문자열 뒤집기
	// 	StringBuffer bf = new StringBuffer(tmp);
	// 	String reverse = bf.reverse().toString();

	// 	// 회문 여부 검사
	// 	if(tmp.equals(reverse)) {
	// 		return true;
	// 	}
		
	// 	return false;
    // }

    // 직접 매칭
    // 가로 탐색
    public static boolean horizontal(int i, int j, int l) {
        for (int k = 0; k < l / 2; k++) {
            if(arr[i][j + k] != arr[i][j + l - 1 - k]) return false;
        }
        return true;
    }
    
    // 세로 탐색
    public static boolean vertical(int i, int j, int l) {
        for (int k = 0; k < l / 2; k++) {
            if(arr[i + k][j] != arr[i + l - 1 - k][j]) return false;
        }
        return true;
    }
}
