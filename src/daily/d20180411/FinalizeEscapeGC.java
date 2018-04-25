package daily.d20180411;

public class FinalizeEscapeGC {
	
	private static FinalizeEscapeGC SAVE_HOOK = null;
	
	public static void isAlive() {
		System.out.println("Yes,I am Alive");
	}
	public static void main(String[] args) throws Exception {
		SAVE_HOOK = new FinalizeEscapeGC();
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("No, I am Dead");
		}
		/** 同一段代码再执行一遍 */
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("No, I am Dead");
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed");
		SAVE_HOOK = this;
	}
}
