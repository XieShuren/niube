package niube.danceLink;

import java.util.ArrayList;
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
		result = new LinkedList<DecisionStack>();
		ArrayList<Integer> choice = new ArrayList<Integer>();
		DecisionStack backDecision = null;
		while(header.getRight() != header) {
			LinkNode right = header.getRight();
			LinkNode down = right.getDown();
			
			while (backDecision != null && down != right && down.getRow() <= backDecision.getChoosedRow()) {
				down = down.getDown();
			}
			
			if (down == right) {
				if (!result.isEmpty()) {
					backDecision = result.removeFirst();
					addCols(backDecision.getRemovedCols());
					continue;
				} else
					break;
			}
			backDecision = null;
			choice.add(down.getRow());
			ArrayList<Integer> removedCols = new ArrayList<Integer>();
			removedCols.add(down.getCol());
			LinkNode curNode = down.getRight();
			while(curNode != down) {
				removedCols.add(curNode.getCol());
				curNode = curNode.getRight();
			}
			DecisionStack decisionStack = new DecisionStack();
			decisionStack.setChoosedRow(down.getRow());
			decisionStack.setRemovedCols(removedCols);
			removeCols(removedCols);
			result.addFirst(decisionStack);
		}
//		return result.stream().mapToInt(t -> t.getChoosedRow()).toArray();
		return null;
	}
	
	private void removeCols(List<Integer> cols) {
		ArrayList<Integer> removedRows = new ArrayList<Integer>();
		for (Integer col : cols) {
			colNodes[col].getLeft().setRight(colNodes[col].getRight());
			colNodes[col].getRight().setLeft(colNodes[col].getLeft());
			LinkNode curNode = colNodes[col].getDown();
			while (curNode != colNodes[col]) {
				if (!removedRows.contains(curNode.getRow())) {
					LinkNode innerCurNode = curNode.getRight();
					while(innerCurNode != curNode) {
						if (!cols.contains(innerCurNode.getCol())) {
							innerCurNode.getUp().setDown(innerCurNode.getDown());
							innerCurNode.getDown().setUp(innerCurNode.getUp());
						}
						innerCurNode = innerCurNode.getRight();
					}
					removedRows.add(curNode.getRow());
				}
				curNode = curNode.getDown();
			}
		}
	}
	
	private void addCols(List<Integer> cols) {
		ArrayList<Integer> addRows = new ArrayList<Integer>();
		for (Integer col : cols) {
			colNodes[col].getLeft().setRight(colNodes[col]);
			colNodes[col].getRight().setLeft(colNodes[col]);
			LinkNode curNode = colNodes[col].getDown();
			while (curNode != colNodes[col]) {
				if (!addRows.contains(curNode.getRow())) {
					LinkNode innerCurNode = curNode.getRight();
					while(innerCurNode != curNode) {
						if (!cols.contains(innerCurNode.getCol())) {
							innerCurNode.getUp().setDown(innerCurNode);
							innerCurNode.getDown().setUp(innerCurNode);
						}
						innerCurNode = innerCurNode.getRight();
					}
					addRows.add(curNode.getRow());
				}
				curNode = curNode.getDown();
			}
		}
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
		LinkNode[][] nodeMap = new LinkNode[rowsize][colsize];
		for (int m = 0;m<rowsize;m++) {
			curNode = null;
			LinkNode firstNode = null;
			for (int n = 0;n<colsize;n++) {
				if (src[m][n] != 0) {
					LinkNode linkNode = new LinkNode(src[m][n], n, m);
					if (curNode != null) {
						curNode.setRight(linkNode);
						linkNode.setLeft(curNode);
					} else {
						firstNode = linkNode;
						curNode = linkNode;
					}
					nodeMap[m][n] = linkNode;
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
				LinkNode linkNode = nodeMap[q][p];
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
	}
	
	private class DecisionStack {
		
		private int choosedRow;
		
		private List<Integer> removedCols;

		public int getChoosedRow() {
			return choosedRow;
		}

		public void setChoosedRow(int choosedRow) {
			this.choosedRow = choosedRow;
		}

		public List<Integer> getRemovedCols() {
			return removedCols;
		}

		public void setRemovedCols(List<Integer> removedCols) {
			this.removedCols = removedCols;
		}

		
	}
	
	public static void main(String[] args) {
		int[] arr1 = new int[]{0,0,1,0,1,1,0};
		int[] arr2 = new int[]{1,0,0,1,0,0,1};
		int[] arr3 = new int[]{0,1,1,0,0,1,0};
		int[] arr4 = new int[]{1,0,0,1,0,0,0};
		int[] arr5 = new int[]{0,1,0,0,0,0,1};
		int[] arr6 = new int[]{0,0,0,1,1,0,1};
		int[][] src = new int[][] {arr1, arr2, arr3, arr4, arr5, arr6};
		//System.out.println(src[1][6]);
		int[] excute = new DanceLinkTest(src).excute();
		for (int value : excute) {
			System.out.print(value + "\t");
		}
	}
}
