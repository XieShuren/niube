package niube.tree;

import java.util.LinkedList;

public class PrintTreeNode {

	public static void main(String[] args) {
		System.out.println(minlength(initTree().getRoot()));
	}
	
	public static void prePrint(Node node) {
		if (node != null) {
			System.out.println(node.getValue());
			prePrint(node.getLeft());
			prePrint(node.getRight());
		}
	}
	
	public static int maxlength(Node node) {
		if (node == null)
			return 0;
		return Math.max(maxlength(node.getLeft()), maxlength(node.getRight()))+1;
	}
	
	public static int minlength(Node node) {
		if (node == null)
			return 0;
		int left_minlength = minlength(node.getLeft());
		if (left_minlength == 0)
			return 1;
		int right_minlength = minlength(node.getRight());
		if (right_minlength == 0)
			return 1;
		return Math.min(minlength(node.getLeft()), minlength(node.getRight()))+1;
	}
	public static void printNonRecursion(Node node) {
		LinkedList<Node> linkedList = new LinkedList<Node>();
		linkedList.addFirst(node);
		while (!linkedList.isEmpty()) {
			Node first = linkedList.removeFirst();
			System.out.println(first.getValue());
			if (first.getLeft() != null)
				linkedList.addFirst(first.getLeft());
			if (first.getRight() != null)
				linkedList.addFirst(first.getRight());
		}
	}
	
	public static void prePrintNonRecursion(Node node) {
		LinkedList<Node> linkedList = new LinkedList<Node>();
		Node curNode = node;
		while (curNode != null || !linkedList.isEmpty()) {
			if (curNode == null) {
				Node removeFirst = linkedList.removeFirst();
				curNode = removeFirst.getRight();
			} else {
				System.out.println(curNode.getValue());
				linkedList.addFirst(curNode);
				curNode = curNode.getLeft();
			}
		}
	}
	/**
	 * 
	 * 		1
	 * 	   2  3
	 *       5  4
	 * @return
	 */
	private static Tree initTree() {
		Node node7 = new Node(7, null, null);
		Node node6 = new Node(6, node7, null);
		node7.setParent(node6);
		Node node5 = new Node(5, node6, null);
		node6.setParent(node5);
		Node node4 = new Node(4, null, null);
		Node node3 = new Node(3, node5, node4);
		node5.setParent(node3);
		node4.setParent(node3);
		Node node2 = new Node(2, null, null);
		Node node1 = new Node(1, node2, node3);
		node2.setParent(node1);
		node3.setParent(node1);
		return new Tree(node1);
	}
}
