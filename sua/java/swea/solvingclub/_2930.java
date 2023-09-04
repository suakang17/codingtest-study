package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _2930 {
	static int[] heap;
	static int size;
	static StringBuilder ret;

	public static void add(int n) {
		int idx = ++size; 
		heap[idx] = n;
		while (idx > 1) { 
			if (n > heap[idx/2]) {
				heap[idx] = heap[idx/2]; 
				idx = idx / 2; 
			} else {
				break;
			}
		}
		heap[idx] = n; 
	}

	public static void remove() {
		if (size < 1) { 
			ret.append("-1 ");
			return;
		}
		ret.append(heap[1]);
		ret.append(" ");
		
		int target = heap[size];
		heap[size--] = 0; 

		int idx = 1; 
		while (idx*2 <= size) {
			int smallIdx = (heap[idx*2] > heap[idx*2 + 1]) ? idx*2 : idx*2 + 1; 
			if (target < heap[smallIdx]) { 
				heap[idx] = heap[smallIdx]; 
				idx = smallIdx; 
			} else {
				break;
			}
		}
		heap[idx] = target; 
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			heap = new int[N+1]; 
			size = 0; 
			ret = new StringBuilder(); 

			for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
				switch (Integer.parseInt(st.nextToken())) {
				case 1:
					// 삽입
					add(Integer.parseInt(st.nextToken()));
					break;
				case 2:
					remove();
					break;
				}
				
			}
			System.out.printf("#%d %s\n", t, ret);
		}
	}
}

// 최대힙 구현 -> 부모 노드의 키 값 ≥ 자식 노드의 키 값 
