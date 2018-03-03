package niube.tree;

import java.util.LinkedList;

public class PrintTreeNode {

	public static void main(String[] args) {
		printNonRecursion(initTree().getRoot());
	}
	
	private static void prePrint(Node node) {
		if (node != null) {
			System.out.println(node.getValue());
			prePrint(node.getLeft());
			prePrint(node.getRight());
		}
	}
	
	private static void printNonRecursion(Node node) {
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
	
	private static void prePrintNonRecursion(Node node) {
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
		Node node5 = new Node(5, null, null);
		Node node4 = new Node(4, null, null);
		Node node3 = new Node(3, node5, node4);
		Node node2 = new Node(2, null, null);
		Node node1 = new Node(1, node2, node3);
		return new Tree(node1);
	}
}
