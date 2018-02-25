package niube.iterator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class ArrayListRemove {
	public static void main(String[] args) {
		setTest();
	}
	
	public static void listTest() {
		List<Integer> arrayList = new LinkedList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		for (Integer integer : arrayList) {
			System.out.println(integer);
			if (integer.intValue() == 2)
				arrayList.remove(integer);
		}
	}
	
	public static void setTest() {
		Set<Integer> set = Collections.newSetFromMap(new ConcurrentHashMap<>());
		set.add(1);
		set.add(2);
		set.add(3);
		for (Integer integer : set) {
			System.out.println(integer);
			if (integer.intValue() == 1)
				set.remove(integer);
		}
	}
}
