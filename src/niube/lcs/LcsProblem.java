package niube.lcs;

import java.util.HashMap;
import java.util.Map;

public class LcsProblem {

	public static void main(String[] args) {
		int[] a = new int[] {1,2,3,4};
		int[] b = new int[] {15,23,2,43,3,53,534,4};
		Map<String, Object> handle = handle(a, b);
		System.out.println("length="+handle.get("length"));
		System.out.println("lcs:");
		int[] lcs = (int[]) handle.get("lcs");
		for (int i : lcs) {
			System.out.print(i+"\t");
		}
	}
	
	public static Map<String, Object> handle(int[] a, int[] b) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		int length = 0;
		int aLength = a.length;
		int bLength = b.length;
		int[] lcsArray = new int[Math.max(aLength, bLength)];
		int[][] c = new int[aLength+1][bLength+1];
		for (int i = 0;i<aLength;i++)
			c[i][0] = 0;
		for (int j = 0;j<bLength;j++)
			c[0][j] = 0;
		for (int m = 0;m<aLength;m++) {
			for (int n = 0;n<bLength;n++) {
				if (a[m] == b[n]) {
					c[m+1][n+1] = c[m][n]+1;
					lcsArray[length] = a[m];
					length++;
				} else if (c[m+1][n]>c[m][n+1]) {
					c[m+1][n+1] = c[m+1][n];
				} else {
					c[m+1][n+1] = c[m][n+1];
				}
			}
		}
		result.put("length", length);
		result.put("lcs", lcsArray);
		return result;
	}

}
