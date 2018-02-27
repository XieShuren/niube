package niube.lineSort;

public class LineSortTest {
	public static void main(String[] args) {
		radixSort();
	}
	
	private static void radixSort() {
		RadixSort radixSort = new RadixSort();
		int[] arr = new int[] {2,3,4,12,43,23,6434,1};
		int[] sort = radixSort.sort(arr);
		for (int i : sort) {
			System.out.print(i+"\t");
		}
	}
	
	private static void countingSort() {
		CountingSort countingSort = new CountingSort();
		int[] arr = new int[] {2,3,4,12,43,23,6434,1};
		int[] sort = countingSort.sort(arr);
		for (int i : sort) {
			System.out.print(i+"\t");
		}
	}
}
