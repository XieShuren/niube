package daily.d20180528;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		HashMap<Integer,Integer> map = new LinkedHashMap<Integer, Integer>(10, 0.75f, true);
		map.put(4, 4);
		map.put(5, 5);
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		printMap(map);
		map.put(4, 4);
		printMap(map);
	}

	private static void printMap(Map map) {
		System.out.println(map.keySet());
	}
}
