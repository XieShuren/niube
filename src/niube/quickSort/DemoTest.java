package niube.quickSort;

public class DemoTest {
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,4,12,43,23,6434,1};
		new QuickSorter().sort(arr);
		for (int i : arr) {
			System.out.print(i+"\t");
		}
	}
}
