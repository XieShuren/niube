package daily.d20180827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BTraceTest {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int a = 0;a <10;a++) {
			reader.readLine();
			int m = (int) (Math.random()*1000);
			int n = (int) (Math.random()*1000);
			add(m, n);
		}
	}

	private static int add(int a, int b) {
		return a + b;
	}
}
