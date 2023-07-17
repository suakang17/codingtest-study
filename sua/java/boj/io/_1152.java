    package boj.io;

    import java.io.*;
    import java.util.*;

    public class _1152 {
        public static void main(String[] args) throws IOException{
            
            // sc
            Scanner in = new Scanner(System.in);
            String S = in.nextLine();
            in.close();

            StringTokenizer st = new StringTokenizer(S," ");
            
            // countTokens() 는 토큰의 개수를 반환한다
            System.out.println(st.countTokens());	

            // br
            // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            // StringTokenizer st = new StringTokenizer(br.readLine()," ");
            // System.out.print(st.countTokens()); 
        }
    }
