package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1873 {
    
    static int T, H, W, N, curH, curW;
    static char[][] map;
    static HashMap<Character, Character> view = new HashMap<>();
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        view.put('U', '^');
        view.put('D', 'v');
        view.put('L', '<');
        view.put('R', '>');

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb = new StringBuilder("#" + t + " ");
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            for(int h = 0; h < H; h++) {
                String str = br.readLine();
                for(int w = 0; w < W; w++) {
                    map[h][w] = str.charAt(w);
                    if(map[h][w] == '^' || map[h][w] == 'v' || map[h][w] == '<' || map[h][w] == '>') {
                        curH = h;
                        curW = w;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            String userInput = br.readLine();
            for(int i = 0; i < N; i++) {
                game(userInput.charAt(i), curH, curW);
            //     for(char[] each : map) {
            //         for(char x : each) {
            //             sb.append(x);
            //         }
            //         sb.append("\n");
            // }
            // System.out.println(sb);

            
            }

            for(char[] each : map) {
                for(char x : each) {
                    sb.append(x);
                }
                sb.append("\n");
            }

            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }

    private static void game(char c, int h, int w) {

        if(c == 'S') {
            shoot(h, w);
            return;
        } 
        
        switch (c) {
            case 'U':
                if(h-1 >= 0 && map[h-1][w] == '.') {
                    map[h][w] = '.';
                    h -= 1;
                }
                map[h][w] = view.get(c);
                curH = h;
                curW = w;
                break;
        
            case 'D':
                if(h+1 < H && map[h+1][w] == '.') {
                    map[h][w] = '.';
                    h += 1;
                }
                map[h][w] = view.get(c);
                curH = h;
                curW = w;
                break;

            case 'L':
                if(w-1 >= 0 && map[h][w-1] == '.') {
                    map[h][w] = '.';
                    w -= 1;
                }
                map[h][w] = view.get(c);
                curH = h;
                curW = w;
                break;

            case 'R':
                if(w+1 < W && map[h][w+1] == '.') {
                    map[h][w] = '.';
                    w += 1;
                }
                map[h][w] = view.get(c);
                curH = h;
                curW = w;
                break;
        }
        return;
    }

    private static void shoot(int h, int w) {

        char now = map[h][w];
        switch (now) {
            case '^':
                for(int d = h; d >= 0; d--) {
                    if(map[d][w] == '*') {
                        map[d][w] = '.';
                        break;
                    }
                    if(map[d][w] == '#') {
                        break;
                    }
                }
                break;
                
            case 'v':
                for(int d = h; d < H; d++) {
                    if(map[d][w] == '*') {
                        map[d][w] = '.';
                        break;
                    }
                    if(map[d][w] == '#') {
                        break;
                    }
                }
                break;

            case '<':
                for(int d = w; d >= 0; d--) {
                    if(map[h][d] == '*') {
                        map[h][d] = '.';
                        break;
                    }
                    if(map[h][d] == '#') {
                        break;
                    }
                }
                break;

            case '>':
                for(int d = w; d < W; d++) {
                    if(map[h][d] == '*') {
                        map[h][d] = '.';
                        break;
                    }
                    if(map[h][d] == '#') {
                        break;
                    }
                }
                break;
        }
        
    }
}

// 게임 맵은 H x W크기의 격자판

// 충돌하거나 맵 밖으로 나갈 때까지
// 벽돌벽: 벽 -> 평지, 포탄 소멸
// 강철벽: 아무일 x, 포탄소멸

// 물: 전차 진입 불가