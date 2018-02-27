package niube.quickSort;

public class QuickSorter {

	public void sort(int[] src) {
		sort(src, 0, src.length-1);
	}
	
	private void sort(int[] src, int start, int end) {
		if (end > start) {
			int r = partition(src, start, end);
			sort(src, start, r-1);
			sort(src, r+1, end);
		}
	}
	
	private int partition(int[] src, int start, int end) {
		int mainEle = src[end];
		int i = start-1;
		for (int j=start;j<end;j++) {
			if (src[j]<mainEle) {
				i++;
				exchange(src, i, j);
			}
		}
		exchange(src, i+1, end);
		return i+1;
	}
	
	private void exchange(int[] src, int a, int b) {
		if (a != b) {
			int temp = src[a];
			src[a]=src[b];
			src[b]=temp;
		}
	}
}
