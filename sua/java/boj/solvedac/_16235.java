package boj.solvedac;

import java.io.*;
import java.util.*;

public class _16235 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, K;
    static int[][] A, nut;
    static Deque<Tree> trees;
    static Queue<Tree> gones;

    // E -> clockWise
    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};

    private static class Tree implements Comparable<Tree> {
        int r;
        int c;
        int age;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // area size
        M = Integer.parseInt(st.nextToken());  // init tree num
        K = Integer.parseInt(st.nextToken());

        A = new int[N+1][N+1];
        nut = new int[N+1][N+1];
        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 1; m <= N; m++) {
                A[n][m] = Integer.parseInt(st.nextToken());
                nut[n][m] = 5;
            }
        }

        gones = new LinkedList<>();

        trees = new ArrayDeque<>();
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());  // r
            int x = Integer.parseInt(st.nextToken());  // c
            int z = Integer.parseInt(st.nextToken());  // 나이

            trees.add(new Tree(x, y, z));
        }

        solution();
    }

    private static void solution() {
        int k = 0;
        while(k++ < K) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(trees.size());
    }

    // private static void spring() {  // arrrayilst remove -> o(N)이 문제
    //     PriorityQueue<Tree> pq = new PriorityQueue<>(trees);
    //     while(!pq.isEmpty()) {
    //         Tree t = pq.poll();
    //         if(nut[t.c][t.r] >= t.age) {
    //             nut[t.c][t.r] -= t.age;
    //             t.age++;
    //         } else {
    //             trees.remove(t);
    //             gones.add(t);
    //         }
    //     }
    // }

    private static void spring() {

		for (int i = 0; i < trees.size();) {
			Tree cur = trees.poll();
			if (nut[cur.r][cur.c] >= cur.age) {
				nut[cur.r][cur.c] -= cur.age;
				cur.age++;
				i++;
				trees.add(cur);
			} else {
				gones.add(cur);
			}
		}
    }

    private static void summer() {
        while(!gones.isEmpty()) {
            Tree t = gones.poll();
            nut[t.c][t.r] += t.age / 2;
        }
    }

    // private static void fall() {
    //     int size = trees.size();
    //     for(int i = 0; i < size; i++) {
    //         Tree t = trees.get(i);
    //         if(t.age % 5 == 0) {
    //             for(int d = 0; d < 8; d++) {
    //                 int nr = t.r + dr[d];
    //                 int nc = t.c + dc[d];
    //                 if(!isValid(nr, nc)) continue;
    //                 trees.add(new Tree(nr, nc, 1));
    //             }
    //         }
    //     }
    // }
        private static void fall() {
            LinkedList<Tree> temp = new LinkedList<>();
                for (Tree tree : trees) {
                    int r = tree.r;
                    int c = tree.c;
                    if (tree.age % 5 != 0) continue;
                    for (int d = 0; d < 8; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (!isValid(nr, nc)) continue;
                        temp.add(new Tree(nr, nc, 1));
                    }
                    }
                    /* LinkedList에서 addAll : O(1) */
                    trees.addAll(temp);
        }

    private static void winter() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                nut[i][j] += A[i][j];
            }
        }
    }

    private static boolean isValid(int r, int c) {
        if(r <= 0 || c <= 0 || r > N || c > N) return false;
        return true;
    }
}

// ** goal K년이 지난 후 살아남은 나무의 수

// 최초 땅 양분 -> all 5
// spring 나이 적은 나무부터 자기 나이만큼 양분 먹고, 나이 ++, 양분 부족해서 못먹으면 죽음
// summer 봄에 죽은 나무 나이 / 2 만큼 땅에 양분으로 추가 (2살미만 고려x)
// fall 나이가 5의 배수인 나무 번식 -> 인접 8칸에 나이 1인 나무 생성
// winter 땅에 양분 A[r][c]씩 추가

// 나무 -> r, c, age -> List<Tree>
// nut[][] -> only nutrition

// ** debug 덜나옴 -> 더 죽임 or 덜 심음

// ! note for(Tree t : treelist) -> forEach문 중에 객체 변경하면 x  java.util.ConcurrentModificationException 에러