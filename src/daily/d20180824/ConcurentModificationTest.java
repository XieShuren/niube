/**
 * 
 */
package daily.d20180824;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author cilu
 *
 */
public class ConcurentModificationTest {

	
	public static void main(String[] args) {
		
		Map map = new LinkedHashMap<Integer,String>(10, 0.7f, true);
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		
		Iterator<Entry> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry entry = iterator.next();
			System.out.println(entry.getKey());
			map.put(entry.getKey(), entry.getValue());
		}
	}
	
	static class ModifyThread extends Thread {
		
		private Map map;
		
		public ModifyThread(Map map) {
			this.map = map;
		}
	}
}
