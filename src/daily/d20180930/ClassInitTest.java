package daily.d20180930;

public class ClassInitTest {

	
	public ClassInitTest(int a) {
		System.out.println("create new ClassInitTest"+a);
	}
	
	public static void main(String[] args) {
		int a = SubClass.a;
		ClassLoader.getSystemClassLoader();
	}

	static class SupClass {
		public static final ClassInitTest bean = new ClassInitTest(1);
		
		static {
			System.out.println("init SupClass");
		}
	}
	
	static class SubClass extends SupClass implements Inter {
		static {
			System.out.println("init SubClass");
		}
		public static int a = 1;
	}
	
	static interface Inter {
		public static final ClassInitTest bean1 = new ClassInitTest(2);
	}
}
