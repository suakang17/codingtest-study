package swea.solvingclub;

import java.io.*;
import java.util.*;

class Node{
	int idx;
	String data;
	Node leftNode;
	Node rightNode;
	
	public Node(int idx) {
		this.idx = idx;
		this.data = " ";
		leftNode = null;
		rightNode = null;
	}
}

class Tree{
	Node root = null;
	
	public void add(int idx, String data, int leftidx, int rightidx) {
		
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
	
	public void search(Node root, int idx, String data, int leftidx, int rightidx) {	
	
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
	

	public double inOrder(Node root) {
		String oper = root.data;
		double left = 0;
		double right = 0;
		double result = 0;

		if(root.leftNode.leftNode == null) {
			left = Double.parseDouble(root.leftNode.data);
		}
		else {
			left = inOrder(root.leftNode);
		}
		

		if(root.rightNode.rightNode == null) {
			right = Double.parseDouble(root.rightNode.data);
		}
		else {
			right = inOrder(root.rightNode);
		}


		if(oper.equals("+")) {
			result = left + right;
		}
		else if(oper.equals("-")) {
			result = left - right;
		}
		else if(oper.equals("*")) {
			result = left * right;
		}
		else if(oper.equals("/")) {
			result = left / right;
		}
		return result;
	}
}

public class _1232 {
	static int N; 
	static Tree tree;
	
public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for(int t = 1; t <= 10; t++) {
        N = Integer.parseInt(br.readLine()); 	
		tree = new Tree();
		
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            String data = st.nextToken();
            int leftidx = 0;
            int rightidx = 0;

            if (st.countTokens() == 2) {
                leftidx = Integer.parseInt(st.nextToken());
                rightidx = Integer.parseInt(st.nextToken());
            }

            tree.add(i, data, leftidx, rightidx);
        }

            System.out.println("#" + t + " " + (int)tree.inOrder(tree.root));
    }
    }
}