package niube.tree;

import org.junit.Test;

import niube.tree.utils.TreeUtils;

public class TreeTest {
	
	@Test
	public void testAdd() {
		Tree initTree = initTree();
		PrintTreeNode.prePrint(initTree.getRoot());
		TreeUtils.add(initTree, 10);
		System.out.println("===============");
		PrintTreeNode.prePrint(initTree.getRoot());
	}
	
	@Test
	public void testFind() {
		Tree initTree = initTree();
		Node find = TreeUtils.find(initTree, 5);
		System.out.println(find.getValue());
	}
	
	@Test
	public void testDelete() {
		Tree initTree = initTree();
		PrintTreeNode.prePrint(initTree.getRoot());
		TreeUtils.delete(initTree, 5);
		System.out.println("===============");
		PrintTreeNode.prePrint(initTree.getRoot());
	}
	/**
	 * 
	 * 		5
	 * 	   2  7
	 *    1 3 6 
	 * @return
	 */
	private static Tree initTree() {
		Node node1 = new Node(1, null, null);
		Node node3 = new Node(3, null, null);
		Node node2 = new Node(2, node1, node3);
		node1.setParent(node2);
		node3.setParent(node2);
		Node node6 = new Node(6, null, null);
		Node node7 = new Node(7, node6, null);
		node6.setParent(node7);
		Node node5 = new Node(5, node2, node7);
		node2.setParent(node5);
		node7.setParent(node5);
		return new Tree(node5);
	}
}
