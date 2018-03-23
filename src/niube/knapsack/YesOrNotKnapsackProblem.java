package niube.knapsack;

public class YesOrNotKnapsackProblem {

	public static int handle(int[] weight, int[] wealth, int capcity) {
		int size = weight.length;
		int[][] maxWealth = new int[size+1][capcity+1];
		for (int i = 0;i<=capcity;i++) {
			maxWealth[0][i] = 0;
		}
		for (int j = 0;j<=size;j++) {
			maxWealth[j][0] = 0;
		}
		for (int i = 1;i<=size;i++) {
			for (int j = 1;j<=capcity;j++) {
				if (weight[i-1] > j) {
					maxWealth[i][j] = maxWealth[i-1][j];
				} else {
					maxWealth[i][j] = Math.max(maxWealth[i-1][j], maxWealth[i-1][j-weight[i-1]]+wealth[i-1]);
				}
			}
		}
		return maxWealth[size][capcity];
	}
	
	public static void main(String[] args) {
		System.out.println(handle(new int[] {10, 20, 30}, new int[] {60, 100 , 120}, 40));
	}
}
