package daily.d20180620;

public class FinalizeEscapeGC {
	
	public static FinalizeEscapeGC SAVE_HOOK = null;
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		SAVE_HOOK = this;
	}
	
	public static void isAlive() {
		System.out.println("Yes, i am alive!");
	}
	
	public static void main(String[] args) throws Exception {
		
		SAVE_HOOK = new FinalizeEscapeGC();
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(1000);
		if (SAVE_HOOK != null)
			SAVE_HOOK.isAlive();
		else
			System.out.println("No, i am dead");
		
		//SAVE_HOOK = new FinalizeEscapeGC();
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(1000);
		if (SAVE_HOOK != null)
			SAVE_HOOK.isAlive();
		else
			System.out.println("No, i am dead");
	}
}
