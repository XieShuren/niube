package daily.d20180525;

import java.util.HashMap;
import java.util.Map;

public class KeySetTest {

	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(2, 2);
		map.keySet().remove(1);
		System.out.println(map.size());
	}
}
