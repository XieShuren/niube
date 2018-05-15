package niube.sudo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class SudoCaculate {

	public void caculate(int[][] src) {
		if (src.length != 9 && src[0].length != 9)
			throw new RuntimeException("Data Error");
		int row = src.length;
		int col = src[0].length;
		List<MyEle> list = new ArrayList<MyEle>();
		for (int i = 0;i<row;i++) {
			for (int j = 0;j<col;j++) {
				int index = getIndex(i,j);
				if (src[i][j] <= 0) {
					MyEle myEle = new MyEle(index);
					myEle.setPossibleDatas(getPossibleData(getIndexParam(src, index)));
					list.add(myEle);
				}
			}
		}
		System.out.println(execute(src, list));
	}
	
	public boolean execute(int[][] src, List<MyEle> waitConfirmEle) {
		if (waitConfirmEle.isEmpty())
			return true;
		Optional<MyEle> min = waitConfirmEle.stream().min((t1,t2) -> t1.getPossibleDatas().size()-t2.getPossibleDatas().size());
		MyEle myEle = min.get();
		ArrayList<Integer> possibleDatas = myEle.getPossibleDatas();
		int index = myEle.getIndex();
		int row = index/9;
		int col = index%9;
		for (Integer value : possibleDatas) {
			src[row][col] = value;
			waitConfirmEle.remove(myEle);
			if (refresh(src, waitConfirmEle) && execute(src, waitConfirmEle)) {
				return true;
			} else {
				src[row][col] = 0;
				waitConfirmEle.add(myEle);
			}
				
		}
		return false;
	}
	
	private boolean refresh(int[][] src, List<MyEle> waitConfirmEle) {
		for (MyEle ele : waitConfirmEle) {
			int indexParam = getIndexParam(src, ele.getIndex());
			if (indexParam == 0)
				return false;
			ele.setPossibleDatas(getPossibleData(getIndexParam(src, ele.getIndex())));
		}
		return true;
	}
	
	private int getIndexParam(int[][] src, int index) {
		return ~(rowData(src, index) | colData(src, index) | areaData(src, index));
	}
	
	private int getIndex(int row, int col) {
		return row*9+col;
	}
	
	private int rowData(int[][] src, int index) {
		int result = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int row = index/9;
		for (int i = 0;i<9;i++) {
			int data = src[row][i];
			if (data > 0)
				result = result | (1 << (data-1));
		}
		return result;
	}
	
	private int colData(int[][] src, int index) {
		int result = 0;
		int col = index%9;
		for (int i = 0;i<9;i++) {
			int data = src[i][col];
			if (data > 0)
				result = result | (1 << (data-1));
		}
		return result;
	}
	
	private int areaData(int[][] src, int index) {
		int result = 0;
		int row = index/9;
		int col = index%9;
		int areaRowStart = (row/3)*3;
		int areaColStart = (col/3)*3;
		for (int i = areaRowStart;i<areaRowStart+3;i++) {
			for (int j = areaColStart;j<areaColStart+3;j++) {
				int data = src[i][j];
				if (data > 0)
					result = result | (1 << (data-1));
			}
		}
		return result;
	}
	
	private ArrayList<Integer> getPossibleData(int indexParam) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 1;i<=9;i++) {
			if ((indexParam & (1 << (i-1))) > 0) {
				result.add(i);
			}
		}
		return result;
	}
	class MyEle{
		
		private int index;
		
		private ArrayList<Integer> possibleDatas;

		MyEle(int index) {
			this.index = index;
		}
		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public ArrayList<Integer> getPossibleDatas() {
			return possibleDatas;
		}

		public void setPossibleDatas(ArrayList<Integer> possibleDatas) {
			this.possibleDatas = possibleDatas;
		}
	}
	
	public static void main(String[] args) {
		int[] arr1 = new int[] {8, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] arr2 = new int[] {0, 0, 3, 6, 0, 0, 0, 0, 0};
		int[] arr3 = new int[] {0, 7, 0, 0, 9, 0, 2, 0, 0};
		int[] arr4 = new int[] {0, 5, 0, 0, 0, 7, 0, 0, 0};
		int[] arr5 = new int[] {0, 0, 0, 0, 4, 5, 7, 0, 0};
		int[] arr6 = new int[] {0, 0, 0, 1, 0, 0, 0, 3, 0};
		int[] arr7 = new int[] {0, 0, 1, 0, 0, 0, 0, 6, 8};
		int[] arr8 = new int[] {0, 0, 8, 5, 0, 0, 0, 1, 0};
		int[] arr9 = new int[] {0, 9, 0, 0, 0, 0, 4, 0, 0};
		int[][] src = new int[][] {arr1,arr2,arr3,arr4,arr5,arr6,arr7,arr8,arr9};
		long start = System.currentTimeMillis();
		new SudoCaculate().caculate(src);
		System.out.println("花费时间："+(System.currentTimeMillis()-start)+"毫秒");
		for (int i = 0;i<9;i++) {
			for (int j = 0;j<9;j++) {
				System.out.print(src[i][j]+"\t");
			}
			System.out.println();
		}
	}
}