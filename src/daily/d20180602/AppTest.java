package daily.d20180602;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr =  {1,2,3};
		List<int[]> asList = Arrays.asList(arr);
		testIdentityHashMap();
	}
	
	private static void testBigDecimal() {
//		float f1 = 1.02f;
//		float f2 = 1.2f;
//		System.out.println(f1 * 3 - f2);
		
		BigDecimal d1 = new BigDecimal("1.02");
		BigDecimal d2 = new BigDecimal("1.2");
		System.out.println(d1.multiply(new BigDecimal("3")).subtract(d2).floatValue());
	}

	private static void testBigDecimal2() {
		BigDecimal d1 = new BigDecimal("1.1111111111111111111111111111111111111111111111111111111111111111111");
		System.out.println(d1.intValue());
		BigDecimal d2 = new BigDecimal("1.2222222222222222222222222222222222222222222222222222222222222222222");
		System.out.println(d1.add(d2).toString());
	}
	
	public static void testIdentityHashMap() {
		Map<Integer,String> map = new IdentityHashMap<Integer, String>();
		map.put(1000, "1");
		map.put(1000, "2");
		System.out.println(map.size());
	}
}
