package boj.solvedac;

import java.io.*;
import java.util.*;

public class _1202 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static long ret = 0;
    static ArrayList<Gem> gems;
    static int[] bagWeights;
    static PriorityQueue<Gem> pq;

    private static class Gem {
        int w;
        int v;

        public Gem(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        gems = new ArrayList<>();
        bagWeights = new int[K];

        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            gems.add(new Gem(w, v));
        }

        Collections.sort(gems, (o1, o2) -> o1.w - o2.w);  // 1.

        for(int k = 0; k < K; k++) {
            bagWeights[k] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bagWeights);  // 2.

        int gemIdx = 0;
        pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);  // 3.

        for(int k = 0; k < K; k++) {
            while(gemIdx < N && gems.get(gemIdx).w <= bagWeights[k]) {
                Gem cur = gems.get(gemIdx);
                pq.add(new Gem(cur.w, cur.v));
                gemIdx++;
            }
            if(!pq.isEmpty()) ret += pq.poll().v;
        }

        System.out.println(ret);
    }
}

// * goal 담을 수 있는 보석 가격 합 max
// ! 가격 max == long

// 가방 k개일때 (가방 당 보석 하나만 가능) -> 어느 가방에 어떤 보석을 넣는 조합이 최고 가격인지
// 1. 보석 무게 오름차순
// 2. 가방 내구도 무게 오름차순
// 3. pq -> 보석 가격 내림차순