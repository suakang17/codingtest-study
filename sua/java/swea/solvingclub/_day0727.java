package swea.solvingclub;

import java.io.*;
import java.util.*; 

public class _day0727 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;
    static int N;
    static int peopleNum = 0;

    static int[][] graph;
    static int pOnStair;
    static Queue<int[]> q;

    static ArrayList<P> pList;
    static ArrayList<S> sList;

    public static class P {
        int r;
        int c;
        int total;

        public P(int r, int c){
            this.r = r;
            this.c = c;
        }

        
    }

    public static class S {
        int r;
        int c;
        int l;

        public S(int r, int c, int l){
            this.r = r;
            this.c = c;
            this.l = l;
        }

        public int getD(int rr, int cc) {
            return (int) (Math.abs(this.r - rr) + Math.abs(this.c - cc));
        }
    }

    

    
// 1은 사람을, 2 이상은 계단의 입구를 나타내며 그 값은 계단의 길이
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            q = new LinkedList<>();
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];

            for(int r = 0; r < N; r++) {
                String[] str = br.readLine().split(" ");

                for(int c = 0; c < N; c++) {
                    graph[r][c] = Integer.parseInt(str[c]);
                    if(graph[r][c] == 1) {
                        pList.add(new P(r, c));
                    }

                    else if(graph[r][c] != 0) {
                        sList.add(new S(r, c, graph[r][c]));
                    }
                }
            }

            for(P p : pList) {
                for(S s : sList) {
                    p.total = Math.min(p.total, s.getD(p.c, p.r) + s.l);
                }
            }

            for(P p : pList) {
                int time = 0;
                time += p.total;
            }

            


            // 출력
            System.out.println("#" + t + " ");
        }
    }

    private static void combin() {
        int caseNum = (int) Math.pow(sList.size(), pList.size());

        for(int cn = 0; cn < caseNum; cn++) {
            
        }

    }
}



// 1. 사람들 모두 최단시간에 계단으로 나가게 
    // 1-1. 각사람에 대한 각각의 최단경로 적용 (각각 어느 계단 이용하는지 기록 -> 3.에 적용)
    // 1-2. 계단별로 내려가는 시간 다름
    // -> 이동시간 + 내려가는 시간 더 적은걸로
// 2. 계단에 올라갈 수 있는 사람 사이즈 고려
// 3. 계단 내려가는 시간 고려