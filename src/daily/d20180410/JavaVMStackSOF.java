package daily.d20180410;

public class JavaVMStackSOF {
	
	private static int length;
	
	private static void add() {
		length++;
		add();
	}
	
	public static void main(String[] args) {
		try {
			add();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("length:"+length);
			e.printStackTrace();
		}
	}
}
