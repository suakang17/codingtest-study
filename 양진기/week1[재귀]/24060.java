import java.io.*;
import java.util.*;

class Main{

    static int[] a;
    static int[] temp;
    static int count = 0;
    static int K;
    static int result = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        a = new int[N];
        temp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(a, 0, N-1);
        System.out.println(result);
    }

    public static void merge_sort(int[] a, int left, int right){

        if(left == right) return;

        int mid = (left + right) / 2;

        merge_sort(a, left, mid);
        merge_sort(a, mid+1, right);

        merge(a, left, mid, right);
    }

    public static void merge(int[] a, int left, int mid, int right){
        int part1 = left;
        int part2 = mid+1;
        int idx = 0;

        while(part1 <= mid && part2 <= right){
            if(a[part1] <= a[part2]){
                temp[idx++] = a[part1++];
            } else {
                temp[idx++] = a[part2++];
            }
        }

        if(part1 > mid){
            while(part2 <= right){
                temp[idx++] = a[part2++];
            }
        } else {
            while(part1 <= mid){
                temp[idx++] = a[part1++];
            }
        }

        int j=0;
        for(int i=left; i<=right; i++){
            count++;
            a[i] = temp[j++];
            if(count == K){
                result = a[i];
                break;
            }
        }
    }
}