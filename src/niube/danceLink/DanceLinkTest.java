package niube.danceLink;

import java.util.LinkedList;
import java.util.List;



public class DanceLinkTest {

	private int[][] src;
	
	private LinkNode header;
	
	private LinkNode[] colNodes;
	
	private LinkedList<DecisionStack> result;
	
	public DanceLinkTest(int[][] src) {
		this.src = src;
	}
	private int[] excute() {
		
		init();
		while(header.getRight() != header) {
			LinkNode right = header.getRight();
			LinkNode down = right.getDown();
			//result.addFirst();
			
		}
		return null;
	}
	
	private void removeRow(int row) {
		
	}
	
	private void addRow(int row) {
		
	}
	private void init() {
		header = new LinkNode();
		LinkNode curNode = header;
		int rowsize = src.length;
		int colsize = src[0].length;
		colNodes = new LinkNode[colsize];
		for (int i = 0;i<colsize;i++) {
			LinkNode linkNode = new LinkNode();
			linkNode.setLeft(curNode);
			curNode.setRight(linkNode);
			colNodes[i] = linkNode;
			curNode = linkNode;
		}
		curNode.setRight(header);
		header.setLeft(curNode);
		LinkNode[][] nodeMap = new LinkNode[colsize][rowsize];
		for (int m = 0;m<rowsize;m++) {
			curNode = null;
			LinkNode firstNode = null;
			for (int n = 0;n<colsize;n++) {
				if (src[n][m] != 0) {
					LinkNode linkNode = new LinkNode(src[n][m], n, m);
					if (curNode != null) {
						curNode.setRight(linkNode);
						linkNode.setLeft(curNode);
					} else {
						firstNode = linkNode;
						curNode = linkNode;
					}
					nodeMap[n][m] = linkNode;
					curNode = linkNode;
				}
			}
			if (firstNode != null) {
				firstNode.setLeft(curNode);
				curNode.setRight(firstNode);
			}
		}
		
		for (int p = 0;p<colsize;p++) {
			curNode = colNodes[p];
			for (int q = 0;q<rowsize;q++) {
				LinkNode linkNode = nodeMap[p][q];
				if (linkNode != null) {
					linkNode.setUp(curNode);
					curNode.setDown(linkNode);
					curNode = linkNode;
				}
			}
			colNodes[p].setUp(curNode);
			curNode.setDown(colNodes[p]);
		}
	}
	
	
	private class LinkNode {
		private int value;
		
		private LinkNode left;
		
		private LinkNode right;
		
		private LinkNode up;
		
		private LinkNode down;
		
		private int col;
		
		private int row;
		
		public LinkNode() {
		}
		
		public LinkNode(int value) {
			this.value = value;
		}
		
		public LinkNode(int value, int col, int row) {
			this.value = value;
			this.col = col;
			this.row = row;
		}
		
		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public LinkNode getLeft() {
			return left;
		}

		public void setLeft(LinkNode left) {
			this.left = left;
		}

		public LinkNode getRight() {
			return right;
		}

		public void setRight(LinkNode right) {
			this.right = right;
		}

		public LinkNode getUp() {
			return up;
		}

		public void setUp(LinkNode up) {
			this.up = up;
		}

		public LinkNode getDown() {
			return down;
		}

		public void setDown(LinkNode down) {
			this.down = down;
		}

		public int getCol() {
			return col;
		}

		public void setCol(int col) {
			this.col = col;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}
		
//		public void remove() {
//			left.setRight(right);
//			right.setLeft(left);
//			up.setDown(down);
//			down.setUp(up);
//		}
//		
//		public void add() {
//			left.setRight(this);
//			right.setLeft(this);
//			up.setDown(this);
//			down.setUp(this);
//		}
	}
	
	private class DecisionStack {
		
		private int choosedRow;
		
		private List<Integer> removedRow;

		public int getChoosedRow() {
			return choosedRow;
		}

		public void setChoosedRow(int choosedRow) {
			this.choosedRow = choosedRow;
		}

		public List<Integer> getRemovedRow() {
			return removedRow;
		}

		public void setRemovedRow(List<Integer> removedRow) {
			this.removedRow = removedRow;
		}
	}
}
