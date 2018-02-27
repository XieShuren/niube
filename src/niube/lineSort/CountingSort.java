package niube.lineSort;

public class CountingSort {

	public int[] sort(int[] arr) {
		int max = findMax(arr);
		int[] arrayC = new int[max+1];
		for (int i : arr) {
			arrayC[i]++;
		}
		for (int j = 1;j<arrayC.length;j++) {
			arrayC[j] += arrayC[j-1];
		}
		int[] arrayB = new int[arr.length];
		for (int k=arr.length-1;k>=0;k--) {
			int m = arr[k];
			arrayB[arrayC[m]-1] = m;
			arrayC[m]--;
		}
		
		return arrayB;
	}
	
	private int findMax(int[] arr) {
		int maxValue = arr[0];
		for (int i=1;i<arr.length;i++) {
			if (arr[i] > maxValue)
				maxValue = arr[i];
		}
		return maxValue;
	}
}
