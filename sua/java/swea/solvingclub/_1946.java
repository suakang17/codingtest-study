package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1946 {
    
    static int T, N, Ki, Lcnt, Kcnt;
    static char Ci;
    // static Character[][] doc;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            // doc = new Character[N][10];
            sb = new StringBuilder();
            
            Lcnt = 0;
            Kcnt = 0;
            outer : for(int n = 0; n < N; n++) {
                
                st = new StringTokenizer(br.readLine());

                Ci = (st.nextToken()).charAt(0);
                Ki = Integer.parseInt(st.nextToken());
                
                while(true) {
                    if(Lcnt == 10 && Kcnt < Ki) { sb.append("\n"); Lcnt = 0; continue; }
                    else if(Lcnt == 10 && Kcnt == Ki) { sb.append("\n"); Lcnt = 0; Kcnt = 0; continue outer; }
                    else if(Lcnt < 10 && Kcnt == Ki) { Kcnt = 0; continue outer; }
                    sb.append(Ci);
                    Lcnt++;
                    Kcnt++;
                }
            }
            System.out.println("#" + t + "\n" + sb);
        }

            
        }
    }

