package niube.priorityQueue;

public class PriorityQueue {

	private int[] data;
	
	private int heapSize;
	
	public PriorityQueue(int[] initData) {
		if (initData == null || initData.length == 0)
			throw new RuntimeException("init failed");
		this.data = initData;
		this.heapSize = initData.length;
	}
	
	public PriorityQueue(int size) {
		this.data = new int[size];
	}
	
	public int get() {
		return data[0];
	}
	
	public int getAndExtract() {
		if (this.heapSize < 1)
			throw new RuntimeException("heap under-flow");
		int result = this.data[0];
		this.data[0] = this.data[--this.heapSize];
		heapify(this.data, 0, this.heapSize);
		return result;
		
	}
	
	public void insert(int value) {
		if (data.length <= this.heapSize)
			throw new RuntimeException("heap top-flow");
		data[this.heapSize] = value;
		int index = this.heapSize;
		
		while(index > 0) {
			int parent = index>>1;
			if (data[parent] < data[index]) {
				exchange(data, parent, index);
				index = parent;
			} else
				break;	
		}
		this.heapSize++;
	}
	
	public boolean isEmpty() {
		return this.heapSize <= 0;
	}
	private void heapify(int[] array, int i, int heapSize) {
		int left = i<<1;
		int right = left+1;
		int largest = i;
		if (left < heapSize && array[left]>array[largest])
			largest = left;
		if (right < heapSize && array[right]>array[largest])
			largest = right;
		if (largest != i) {
			exchange(array, i, largest);
			heapify(array, largest, heapSize);
		}
	}
	
	private void exchange(int[] array, int indexA, int indexB) {
		int temp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = temp;
	}
	
	private void buildHeap(int[] array) {
		int heapSize = array.length;
		for (int i=array.length/2;i >= 0;i--) {
			heapify(array, i, heapSize);
		}
	}
}
