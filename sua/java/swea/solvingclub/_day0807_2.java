package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _day0807_2 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1; t <= 10; t++) {
            int ret = 0;
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] buildings = new int[N];

            for(int i = 0; i < N; i++) {
                int height = Integer.parseInt(st.nextToken());
                buildings[i] = height;
            }

            for(int j = 2; j < N-2; j++) {
                int[] view = new int[4];
                view[0] = buildings[j] - buildings[j-2];
                view[1] = buildings[j] - buildings[j-1];
                view[2] = buildings[j] - buildings[j+1];
                view[3] = buildings[j] - buildings[j+2];

                
                    if(view[0] < 0 || view[1] < 0 || view[2] < 0 || view[3] < 0) {
                        continue;
                    } else {
                        Arrays.sort(view);
                        ret += view[0];
                    }
                
                }

            System.out.println("#" + t + " " + ret);
            }

            
        }
    }

