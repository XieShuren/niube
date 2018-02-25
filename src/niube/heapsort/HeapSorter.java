package niube.heapsort;


public class HeapSorter {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] {2,3,4,1,3,23,534};
		sort(arr);
		for (Integer integer : arr) {
			System.out.print(integer+"\t");
		}
	}

	public static <T extends Comparable> void sort(T[] array) {
		buildHeap(array);
		int heapSize = array.length;
		for (int i = array.length-1;i >= 1;i--) {
			exchange(array, i, 0);
			heapify(array, 0, --heapSize);
		}
	}
	
	private static <T extends Comparable> void heapify(T[] array, int i, int heapSize) {
		int left = i<<1;
		int right = left+1;
		int largest = i;
		if (left < heapSize && array[left].compareTo(array[largest]) > 0)
			largest = left;
		if (right < heapSize && array[right].compareTo(array[largest]) > 0)
			largest = right;
		if (largest != i) {
			exchange(array, i, largest);
			heapify(array, largest, heapSize);
		}
	}
	
	private static <T extends Comparable> void exchange(T[] array, int indexA, int indexB) {
		T temp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = temp;
	}
	
	private static <T extends Comparable> void buildHeap(T[] array) {
		int heapSize = array.length;
		for (int i=array.length/2;i >= 0;i--) {
			heapify(array, i, heapSize);
		}
	}
}
