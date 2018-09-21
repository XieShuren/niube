package daily.d20180530;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	public static void main(String[] args) {
		test2(new ArrayList<String>());
	}

	private static void test(List<Object> list) {
		
	}
	
	private static void test2(List<?> list) {
		
	}
	
	private static void test3(List list) {
		
	}
}
