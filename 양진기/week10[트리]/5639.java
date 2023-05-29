import java.io.*;
import java.util.*;

class Main{
    static class Node{
        int num;
        Node left;
        Node right;

        public Node(int num) {
            this.num = num;
        }

        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        void insert(int n){
            if(n < this.num) {  // N보다 작으면 왼쪽 서브트리에
                if(this.left == null){          // 왼쪽 자식 노드가 없으면
                    this.left = new Node(n);    // 왼쪽 자식 노드를 생성한다.
                } else {                        // 왼쪽 자식노드가 있으면
                    this.left.insert(n);        // 왼쪽 자식노드 아래에 다시 추가한다.
                }
            } else {    // N보다 크면 오른쪽 서브 트리에 (같은 키를 가지는 노드는 없다. -> 중복 없다)
                if(this.right == null){         // 오른쪽 자식 노드가 없으면
                    this.right = new Node(n);   // 오른쪽 자식 노드를 생성한다.
                } else {                        // 오른쪽 자식노드가 있으면
                    this.right.insert(n);       // 오른쪽 자식노드 아래에 다시 추가한다.
                }
            }
        } // end of void
    } // end of Node

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine())); // 전위 순회는 루트 노드를 제일 먼저 방문한다.
        String input;
        while (true) {
            input = br.readLine();
            if(input == null || input.equals("")) break;    // 빈 값이 들어올 때까지 값을 받음

            root.insert(Integer.parseInt(input)); // 루트 노드 아래에 노드를 추가한다.
        }
        postOrder(root);
    } // end of main

    static void postOrder(Node node){
        if(node == null) return;

        // 후위 순회 (LEFT 서브트리 -> RIGHT 서브트리 -> ROOT)
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}