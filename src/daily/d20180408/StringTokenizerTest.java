package daily.d20180408;

import java.util.StringTokenizer;

import org.junit.Test;

public class StringTokenizerTest {

	@Test
	public void test1() {
		StringTokenizer stringTokenizer = new StringTokenizer("nihao\thelo\nfds");
		while(stringTokenizer.hasMoreTokens()) {
			String nextToken = stringTokenizer.nextToken();
			System.out.println("Token:"+nextToken);
		}
	}
	
	@Test
	public void test2() {
		StringTokenizer stringTokenizer = new StringTokenizer("nihao\thelo\nfds", "h\t");
		while(stringTokenizer.hasMoreTokens()) {
			String nextToken = stringTokenizer.nextToken();
			System.out.println("Token:"+nextToken);
		}
	}
	
	@Test
	public void test3() {
		StringTokenizer stringTokenizer = new StringTokenizer("nihao\thelo\nfds", "h\t", true);
		while(stringTokenizer.hasMoreTokens()) {
			String nextToken = stringTokenizer.nextToken();
			System.out.println("Token:"+nextToken);
		}
	}
}
