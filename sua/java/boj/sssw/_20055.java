package boj.sssw;

import java.io.*;
import java.util.*;

public class _20055 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] A;
    static Map<Integer, Pair> map;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        map = new HashMap<>();
        
        for(int i = 1; i <= 2*N; i++) {
            Pair p = new Pair(Integer.parseInt(st.nextToken()), false); // durability, robot
            map.put(i, p);
            // System.out.println(i + " " + p.durability + " " + p.isRobotOn);
        }

        solution();
    }

    private static void solution() {

        int cycle = 1;

        while(true) {
            step1();
            if(!isDurabilityCntValid()) break;
            System.out.println("step1 ok");
            step2();
            if(!isDurabilityCntValid()) break;
            System.out.println("step2 ok");
            step3();
            if(!isDurabilityCntValid()) break;
            System.out.println("step3 ok");
            cycle++;
            System.out.println(cycle);
            // break;
        }

        System.out.println(cycle);
    }

    private static boolean isDurabilityCntValid() {
        
        int cnt = 0;
        for(int i = 1; i < 2*N+1; i++) {
            Pair loadingArea = map.get(i);
            if(loadingArea.durability == 0) {
                cnt++;
            }
            if(cnt >= K) return false; 
        }
        return true;
    }

    private static void step1() {  // 1.

        Pair tempPair = map.get(6);

        for(int i = 2*N; i > 1; i--) {
            Pair curPair = map.get(i);
            Pair prevPair = map.get(i-1);

            map.put(i, prevPair);
        }
        map.put(1, tempPair);

        for(int i = 1; i <= 2*N; i++) {
            System.out.print("durability: " + map.get(i).durability + " robot: ");
            System.out.println(map.get(i).isRobotOn);
        }
    }

    private static void step2() {  // 2.

        if(map.get(2*N).isRobotOn) map.get(2*N).isRobotOn = false; 
        for(int i = 2*N-1; i > 0; i--) {
            Pair curPair = map.get(i);
            Pair nextPair = map.get(i+1);
            if(curPair.isRobotOn) {
                if(!nextPair.isRobotOn && nextPair.durability > 0) { 
                    curPair.isRobotOn = false; 
                    nextPair.isRobotOn = true;
                    nextPair.durability--; }
            }
        }
    }

    private static void step3() {  //3.

        Pair loadingArea = map.get(1);
        if(!loadingArea.isRobotOn) {
            if(loadingArea.durability > 0) {
                loadingArea.isRobotOn = true;
                loadingArea.durability--;
            }
        }
        
    }

    private static class Pair {

        Integer durability;
        Boolean isRobotOn;

        public Pair(Integer durability, Boolean isRobotOn) {
            this.durability = durability;
            this.isRobotOn = isRobotOn;
        }
    }
}