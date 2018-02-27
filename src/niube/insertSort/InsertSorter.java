package niube.insertSort;

public class InsertSorter {

	public static void sort(int[] arr) {
		for (int i=1;i<arr.length;i++) {
			int j = i-1;
			int value = arr[i];
			while (j>=0 && arr[j]>value) {
				arr[j+1] = arr[j];
				j--;
			}
			if (i != j)
				arr[j+1] = value;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,4,12,43,23,6434,1};
		sort(arr);
		for (int i : arr) {
			System.out.print(i+"\t");
		}
	}
	
}
