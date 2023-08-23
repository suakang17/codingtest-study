package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1231 {
    
    static class Node{
        int idx;
        char data;
        Node leftNode;
        Node rightNode;
        
        public Node(int idx) {
            this.idx = idx;
            this.data = ' ';
            leftNode = null;
            rightNode = null;
        }
    }
    
    static class Tree{
        Node root = null;
        
        public void add(int idx, char data, int leftidx, int rightidx) {
            // 트리 최초 생성 시
            if(root == null) {
                root = new Node(idx);
                root.data = data;
                if(leftidx != 0) root.leftNode = new Node(leftidx);
                if(rightidx != 0) root.rightNode = new Node(rightidx);
            }
            else {
                search(root,idx,data,leftidx,rightidx);
            }
        }
        
        public void search(Node root, int idx, char data, int leftidx, int rightidx) {	

            if(root.idx == idx) {
                root.data = data;
                if(leftidx != 0) root.leftNode = new Node(leftidx);
                if(rightidx != 0) root.rightNode = new Node(rightidx);
            }
            
            else {
                if(root.leftNode != null) search(root.leftNode,idx,data,leftidx,rightidx);
                if(root.rightNode != null) search(root.rightNode,idx,data,leftidx,rightidx);
            }
        }
        
        public void inOrder(Node root) {
            if(root.leftNode != null) inOrder(root.leftNode);
            System.out.print(root.data);
            if(root.rightNode != null) inOrder(root.rightNode);
        }
    }
    
        static int N;
        static Tree tree;

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        
    public static void main(String[] args) throws IOException{
        
        for(int t = 1; t <= 10; t++) {
            N = Integer.parseInt(br.readLine());
            tree = new Tree();

            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                char data = st.nextToken().charAt(0);
                int leftidx = 0;
                int rightidx = 0;
                
                if (st.hasMoreTokens()) {
                    leftidx = Integer.parseInt(st.nextToken());
                }
                if (st.hasMoreTokens()){
                    rightidx = Integer.parseInt(st.nextToken());
                }  
                
                tree.add(i, data, leftidx, rightidx);
            }
            
            System.out.print("#" + t + " ");
            tree.inOrder(tree.root);
            System.out.println();
        }
    }
}
