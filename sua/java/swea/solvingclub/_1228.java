package swea.solvingclub;

import java.io.*;
import java.util.*;

public class _1228 {
    
    static int N, position, cmdNum, cnt;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    private static class Node {
        private Object data;
        private Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
    }

    public static class LinkedList1 {
        private Node head;
        private Node tail;
        private int size; 

        public Node findNode(int idx) {
                Node x = head;
                for(int i = 0; i < idx; i++) { 
                    x = x.next;
                }
                return x;
            }
            
        public void addFirst(Object input) {
                Node newNode = new Node(input);
                newNode.next = head;
                head = newNode;
                size++;
                if(head.next == null) { 
                    tail = head; 
                }
            }
            
        public void addLast(Object input) {
                Node newNode = new Node(input);
            
                if(size == 0) {
                    addFirst(input);
                } else {
                    tail.next = newNode;
                    tail = newNode;
                    size++;
                }
            }

        public void addMiddle(int k, Object input) {
            if(k == 0) {
                addFirst(input);
            } else if (k == (size - 1)){
                addLast(input);
            } else {
                Node newNode = new Node(input); 
            
                Node temp1 = findNode(k-1); 
                Node temp2 = temp1.next;
            
                temp1.next = newNode; 
                newNode.next = temp2; 
                size++; 
            }
        }

        public Object removeFirst() {
            Node temp = head;
            head = temp.next; 
            Object returnData = temp.data;  
            temp = null;
            size--;
            
            return returnData;
        }
            
        public Object remove(int k) {
            if(k == 0) {
                return removeFirst();
            }
            Node temp = findNode(k-1);
            Node willBeDeleted = temp.next;
            
            temp.next = willBeDeleted.next;	
            Object returnData = willBeDeleted.data; 
                
            if(willBeDeleted == tail) {
                tail = temp;
            }
            
            willBeDeleted = null;
            size--;
            
            return returnData;
        }
    }


    public static void main(String[] args) throws IOException {
        
        for(int t = 1; t <= 10; t++) {
            
            N = Integer.parseInt(br.readLine());
            LinkedList1 ll = new LinkedList1();
            
            st = new StringTokenizer(br.readLine());
            for(int n = 0; n < N; n++) {
                ll.addLast(Integer.parseInt(st.nextToken()));
            }

            cmdNum = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < cmdNum; i++) {
                String cmddd = st.nextToken();
                if(cmddd.equals("I")) {
                    position = Integer.parseInt(st.nextToken());
                    cnt = Integer.parseInt(st.nextToken());
                    for(int j = 0; j < cnt; j++) {
                        ll.addMiddle(position++, Integer.parseInt(st.nextToken()));
                    }
                } else if(cmddd.equals("D")) {
                    position = Integer.parseInt(st.nextToken());
                    cnt = Integer.parseInt(st.nextToken());
                    for(int j = 1; j <= cnt; j++) {
                        ll.remove(position);
                    }
                } else if(cmddd.equals("A")) {
                    cnt = Integer.parseInt(st.nextToken());
                    for(int j = 1; j <= cnt; j++) {
                        ll.addLast(Integer.parseInt(st.nextToken()));
                    }
                }
            }
            
            sb = new StringBuilder("#" + t + " ");
            for(int i = 0; i < 10; i++) {
                sb.append(ll.findNode(i).data).append(" ");
            }

            System.out.println(sb);
        }
    }
}