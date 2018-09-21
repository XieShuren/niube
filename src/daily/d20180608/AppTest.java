package daily.d20180608;

import java.util.LinkedHashMap;
import java.util.Map;

public class AppTest {

	public static void main(String[] args) {
		test1();
	}

	
	private static void test1() {
		Map<Integer,String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		System.out.println(map.keySet());
		map.put(2, "a");
		System.out.println(map.keySet());
	}
}
