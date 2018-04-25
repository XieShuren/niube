package daily.d20180410;

import java.util.ArrayList;

public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		//test();
		otherTest();
	}
	
	private static void test() {
		int i = 1;
		ArrayList<String> list = new ArrayList<String>();
		while(true) {
			list.add(("abc"+(i++)).intern());
		}
	}
	
	private static void otherTest() {
		String str1 = new StringBuilder("¼ÆËã»ú").append("hello").toString();
		System.out.println(str1.intern() == str1);
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}
}
