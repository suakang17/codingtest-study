import java.io.*;

class Main{

    public static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String s = br.readLine();
            System.out.println(isPalindrome(s) + " " + count);
            count = 0;
        }
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

    public static int recursion(String s, int left, int right){
        count++;
        if(left >= right) return 1;
        else if(s.charAt(left) != s.charAt(right)) return 0;
        else return recursion(s, left+1, right-1);
    }
}