package com.interview.linkedlist;

//Initial Template for Java
import java.util.*;

class LinkedList {
	static Node head;
	static Node lastNode;

	public static void addToTheLast(Node node) {
		if (head == null) {
			head = node;
			lastNode = node;
		} else {
			Node temp = head;
			lastNode.next = node;
			lastNode = node;
		}
	}

	/*
	 * Scanner sc = new Scanner(System.in); int t = sc.nextInt();
	 * 
	 * while (t-- > 0) { int n, K; n = sc.nextInt(); K = sc.nextInt();
	 * 
	 * Node head = null; int val = sc.nextInt(); head = new Node(val);
	 * addToTheLast(head);
	 * 
	 * for (int i = 1; i < n; i++) { val = sc.nextInt(); addToTheLast(new
	 * Node(val)); }
	 * 
	 * Node before[] = new Node[n]; addressstore(before, head);
	 * SwapKthNodeFromBegnEnd obj = new SwapKthNodeFromBegnEnd();
	 * 
	 * head = obj.swapkthnode(head, n, K);
	 * 
	 * Node after[] = new Node[n]; addressstore(after, head);
	 * 
	 * if (check(before, after, n, K) == true) System.out.println("1"); else
	 * System.out.println("0");
	 * 
	 * }
	 */

	static boolean check(Node before[], Node after[], int num, int K) {
		if (K > num)
			return true;

		return (before[K - 1] == after[num - K]) && (before[num - K] == after[K - 1]);
	}

	static void addressstore(Node arr[], Node head) {
		Node temp = head;
		int i = 0;
		while (temp != null) {
			arr[i] = temp;
			i++;
			temp = temp.next;
		}
	}

}

/*
 * This is a function problem.You only need to complete the function given below
 */
// User function Template for Java
/*
 * Linked List Node class class Node { int data; Node next; Node(int data) {
 * this.data = data; next = null; } }
 */
public class SwapKthNodeFromBegnEnd {
	// Should swap Kth node from beginning and
	// Kth node from end in list and return new head.
	Node swapkthnode(Node head, int num, int K) {
		int n = 0;
		Node n1 = null;
		Node n2 = null;
		Node n3 = null;
		Node n4 = null;
		Node n5 = null;
		Node n6 = null;
		Node temp = null;
		Node end = null;
		
		if (K>num) return head;
		
		if (K==0) return head;
		
		if (K==num) {
			K=1;
		}
			
		if (K == 1) {
			while (head != null) {
				n = n + 1;
				if (n == K) {
					n2 = head;
				}
				if (n == K + 1) {
					n3 = head;
				}
				if (n == num - K) {
					n4 = head;
				}
				if (n == num - K + 1) {
					n5 = head;
				}
				head = head.next;
			}
			n4.next = n2;
			n2.next = null;
			n5.next = n3;
			temp = n5;

		} else if (K>1) {
			temp = head;
			while (head != null) {
				n = n + 1;
				if (n == K - 1) {
					n1 = head;
				}
				if (n == K) {
					n2 = head;
				}
				if (n == K + 1) {
					n3 = head;
				}
				if (n == num - K) {
					n4 = head;
				}
				if (n == num - K + 1) {
					n5 = head;
				}
				if (n == num - K + 2) {
					n6 = head;
				}
				head = head.next;
			}
			/*
			 * System.out.println("n1:"+n1.data);
			 * System.out.println("n2:"+n2.data);
			 * System.out.println("n3:"+n3.data);
			 * System.out.println("n4:"+n4.data);
			 * System.out.println("n5:"+n5.data);
			 * System.out.println("n6:"+n6.data);
			 */
			n1.next = n5;
			n5.next = n3;
			n4.next = n2;
			n2.next = n6;
			System.out.println("temp:" + temp.data);
		}
		return temp;
	}

	public static void main(String args[]) {

/*		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);*/
		// Node n5 = new Node(5);
		
		Node n1 = new Node(239);
		Node n2 = new Node(50);
		Node n3 = new Node(219);

		n1.next = n2;
		n2.next = n3;
		//n3.next = n4;
		// n4.next = n5;

		SwapKthNodeFromBegnEnd s = new SwapKthNodeFromBegnEnd();
		Node head = s.swapkthnode(n1, 3, 3);

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

}