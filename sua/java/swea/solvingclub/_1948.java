package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1948 {
    
    static int T, sm, sd, em, ed, ret;
    static int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            ret = 0;

            sm = Integer.parseInt(st.nextToken());
            sd = Integer.parseInt(st.nextToken());
            em = Integer.parseInt(st.nextToken());
            ed = Integer.parseInt(st.nextToken());

            if(em == sm) {
                ret += ed - sd + 1;
            } else {
                ret += ed + 1;
                ret += months[sm] - sd;
                for(int i = 1; i < em - sm; i++) {
                    ret += months[sm + i];
                }
            }

            System.out.println(("#" + t + " " + ret));
        }
    }
}
