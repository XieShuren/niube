package niube.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListRemove {
	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();

		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		for (Integer integer : arrayList) {
			if (integer.intValue() == 1)
				arrayList.remove(integer);
		}
		
		Iterator<Integer> iterator = arrayList.iterator();
		while(iterator.hasNext()) {
			Integer next = iterator.next();
			if (next.intValue() == 1)
				iterator.remove();
		}
	}
}
