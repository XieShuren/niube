package niube.tree.utils;

import niube.tree.Node;
import niube.tree.Tree;

public class TreeUtils {

	public static void add(Tree tree, int newValue) {
		if (tree.getRoot() == null)
			tree.setRoot(new Node(newValue));
		else {
			Node node = tree.getRoot();
			while(true) {
				if (newValue == node.getValue())
					break;
				if (newValue < node.getValue()) {
					if (node.getLeft() == null) {
						node.setLeft(new Node(newValue));
						node.getLeft().setParent(node);
						break;
					}else {
						node = node.getLeft();
					}
				} else {
					if (node.getRight() == null) {
						node.setRight(new Node(newValue));
						node.getRight().setParent(node);
						break;
					}else {
						node = node.getRight();
					}
				}
			}
		}
	}
	
	public static Node find(Tree tree, int value) {
		Node node = tree.getRoot();
		while (node != null) {
			if (node.getValue() == value)
				return node;
			else if (value < node.getValue())
				node = node.getLeft();
			else
				node = node.getRight();
		}
		return null;
	}
	
	public static void delete(Tree tree, int value) {
		Node targetNode = find(tree, value);
		if (targetNode == null)
			return;
		if (targetNode.getLeft() == null)
			transplant(tree, targetNode, targetNode.getRight());
		else if (targetNode.getRight() == null)
			transplant(tree, targetNode, targetNode.getLeft());
		else {
			Node minNode = findMin(targetNode.getRight());
			if (minNode.getParent() != targetNode) {
				transplant(tree, minNode, minNode.getRight());
				minNode.setRight(targetNode.getRight());
				minNode.getRight().setParent(minNode);
			}
			minNode.setLeft(targetNode.getLeft());
			minNode.getLeft().setParent(minNode);
			transplant(tree, targetNode, minNode);
		}
			
	}
	
	private static Node findMin(Node node) {
		Node minNode = null;
		while(node != null) {
			minNode = node;
			node = node.getLeft();
		}
		return minNode;
	}
	
	private static void transplant(Tree tree, Node oldNode, Node newNode) {
		if (oldNode.getParent() == null)
			tree.setRoot(newNode);
		else if (oldNode.getParent().getLeft() == oldNode)
			oldNode.getParent().setLeft(newNode);
		else
			oldNode.getParent().setRight(newNode);
		if (newNode != null)
			newNode.setParent(oldNode.getParent());
	}
}
