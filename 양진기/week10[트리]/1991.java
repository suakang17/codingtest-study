import java.util.*;
import java.io.*;

class Main{
    static class Node{
        char value; // 값
        Node left;  // 왼쪽 자식 노드
        Node right; // 오른쪽 자식 노드

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static int N;
    static Node head = new Node('A', null, null);   // 항상 A가 루트 노드가 된다

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            char parentNode = st.nextToken().charAt(0);   // 노드
            char left = st.nextToken().charAt(0);   // 왼쪽 자식 노드
            char right = st.nextToken().charAt(0);  // 오른쪽 자식 노드

            insertNode(head, parentNode, left, right);    // head (root부터 시작)
        }

        preOrder(head);     // 전위
        System.out.println();
        inOrder(head);      // 중위
        System.out.println();
        postOrder(head);    // 후위
        System.out.println();
    }

    static void insertNode(Node temp, char parentNode, char left, char right){

        // 현재 노드는 head부터 시작해서 내려간다.
        if(temp.value == parentNode){ // 현재 노드가 부모 노드여야 자식 노드를 추가한다.
            temp.left = (left == '.') ? null : new Node(left, null, null);      // .이 아니면 왼쪽 자식 노드 생성
            temp.right = (right == '.') ? null : new Node(right, null, null);   // .이 아니면 오른쪽 자식 노드 생성
        }
        else { // 현재 노드가 부모 노드가 아니면
            // 재귀

            // 루트의 왼쪽부터 시작.
            // 현재 노드의 왼쪽 자식노드의 자식 노드가 없다면
            if(temp.left != null) {
                insertNode(temp.left, parentNode, left, right); // 현재 노드의 왼쪽 자식노드를 입력한다.
            }

            // 루트의 오른쪽부터 시작.
            // 현재 노드의 오른쪽 자식노드의 자식 노드가 없다면
            if(temp.right != null) {
                insertNode(temp.right, parentNode, left, right); // 현재 노드의 오른쪽 자식노드를 입력한다.
            }
        }

    }

    // 전위
    static void preOrder(Node node){
        if(node == null) return;
        // ROOT -> LEFT -> RIGHT
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위
    static void inOrder(Node node){
        if(node == null) return;
        // LEFT -> ROOT -> RIGHT
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    // 후위
    static void postOrder(Node node){
        if(node == null) return;
        // LEFT -> RIGHT -> ROOT
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
}