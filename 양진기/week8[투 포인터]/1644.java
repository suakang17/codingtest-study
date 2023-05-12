import java.io.*;
import java.util.*;

class Main{
    static boolean prime[];
    static ArrayList<Integer> prime_numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 소수 구하기
        prime = new boolean[n+1];

        prime[0] = prime[1] = true; // 0과 1은 소수가 아니다 -> true
        for(int i=2; i*i <= n; i++){
            if(!prime[i]){      // 소수 중에서 (false)
                for(int j=i*i; j<=n; j += i){   // 소수 자기 자신의 배수는 소수가 아니다.
                    prime[j] = true;    // 소수가 아니다 -> true
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(!prime[i]){
                prime_numbers.add(i);
            }
        }

        // 연속합으로 주어진 정수 구할 수 있는지 판별
        int start = 0, end = 0, sum = 0, count = 0;
        while(true){
            if(sum >= n) {  // sum 감소해야 됨 -> start 오른쪽 이동
                sum -= prime_numbers.get(start);
                start++;
            } else if(end == prime_numbers.size()){ // end >= 소수 사이즈 시 종료
                break;
            } else {    // sum 증가해야 됨 -> end 오른쪽 이동
                sum += prime_numbers.get(end);
                end++;
            }

            if(n == sum) {
                count++;
            }
        }
        System.out.println(count);
    }
}