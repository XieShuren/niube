package niube.lineSort;

public class RadixSort {

	public int[] sort(int[] arr) {
		for (int i=0;i<=7;i++) {
			arr = sort(arr, i);
		}
		return arr;
	}
	
	public int[] sort(int[] arr, int radix) {
		int[] arrayC = new int[16];
		for (int i : arr) {
			arrayC[radixValue(i, radix)]++;
		}
		for (int j = 1;j<arrayC.length;j++) {
			arrayC[j] += arrayC[j-1];
		}
		int[] arrayB = new int[arr.length];
		for (int k=arr.length-1;k>=0;k--) {
			int m = arr[k];
			int radixValue = radixValue(m, radix);
			arrayB[arrayC[radixValue]-1] = m;
			arrayC[radixValue]--;
		}
		return arrayB;
	}
	
	private int radixValue(int value, int radix) {
		return value>>>(radix*4) & 0x000f;
	}
}
