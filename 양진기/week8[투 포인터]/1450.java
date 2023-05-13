import java.io.*;
import java.util.*;

class Main{
    /*
        물건을 넣거나 넣지 않는다. -> 2가지
        물건이 최대 30개이므로 2^30 -> 시간 초과

        반으로 잘라 2^15 + 2^15로 계산한다.
        weight1에 왼쪽 반, weight2에 오른쪽 반을 입력받는다.

        weight1에서 각 물건을 넣고 넣지 않는 경우의 수 리스트를 sum1에 담는다.
        weight2에서 각 물건을 넣고 넣지 않는 경우의 수 리스트를 sum2에 담는다.

        결국엔 sum1 + sum2이 C가 되는 경우를 찾아야 한다.
        여기서 sum1 리스트와 sum2 리스트를 모두 비교하자니 시간이 많이 걸린다.

        다른 방향에서 생각하면 C - sum1 = sum2 이다.
        sum2를 찾아보자. -> 이분 탐색으로 시간을 줄인다.
        이분 탐색의 bound를 이용해서 sum2 값의 길이를 찾는다. -> 길이만큼 더해서 경우의 수를 누적한다.
     */

    static int n, c;

    // sum2가 들어온다.
    public static int binarySearch(ArrayList<Integer> sum , int target){
        int left = 0, right = sum.size()-1, mid, answer = -1;

        while(left <= right){
            mid = (left + right) / 2;
            if(sum.get(mid) <= target){ // 중간값이 target보다 작거나 같다면 -> 오른쪽에 있다.
                answer = mid; // 작거나가 포함되어 있기 때문에 target이 되는 가장 마지막 인덱스를 담는다.
                left = mid + 1;
            } else {    // 중간값이 target보다 크다면 -> 왼쪽에 있다.
                right = mid - 1;
            }
        }
        return answer;
    }

    public static void dfs(int idx, int sum, ArrayList<Integer> weight, ArrayList<Integer> answer){

        // 3. 탈출 조건
        if(sum > c) return;
        if(idx == weight.size()){
            answer.add(sum);    // 마지막에 sum1/sum2에 담는다.
            return;
        }

        // 1. 물건을 넣는 경우
        dfs(idx + 1, sum + weight.get(idx), weight, answer); // weight의 인덱스번째를 sum에다 더해줌
        // 2. 물건을 넣지 않는 경우
        dfs(idx + 1, sum, weight, answer); // 물건을 넣지 않았으니 sum을 증가시키지 않음
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 물건을 반으로 나누기
        ArrayList<Integer> weight1 = new ArrayList<>();
        ArrayList<Integer> weight2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            // 반은 weight1에 넣기
            if(i < n/2) weight1.add(Integer.parseInt(st.nextToken()));
                // 나머지 반은 weight2에 넣기
            else weight2.add(Integer.parseInt(st.nextToken()));
        }

        // 1. DFS로 sum1, sum2 만들기
        ArrayList<Integer> sum1 = new ArrayList<>();
        ArrayList<Integer> sum2 = new ArrayList<>();

        dfs(0, 0, weight1, sum1); // 0번째 인덱스의 값을 weight1에서 가져와서 sum(0)을 sum1에 담는다.
        dfs(0, 0, weight2, sum2); // 0번째 인덱스의 값을 weight2에서 가져와서 sum(0)을 sum2에 담는다.

        // 2. sort 및 binary search
        Collections.sort(sum2); // sum2만 정렬한다. -> 이분탐색해서 (c - sum1 = 0)의 값이 몇개(bound) 있는지 찾기 위해
        int answer = 0;
        for(int i=0; i < sum1.size(); i++){
            int searchValue = c - sum1.get(i);  // c - sum1의 현재값을 하면 sum2에서 찾아야될 값을 구할 수 있다.
            answer += binarySearch(sum2, searchValue) + 1;    // sum2에서 c - sum1이 값을 찾는다. 인덱스값을 반환하면 +1로 카운팅
        }

        bw.write(String.valueOf(answer));
        bw.flush();

        bw.close();
        br.close();
    }
}