package daily.d20180413;

public class ClinitTest {

	static class DeadLoopClazz {
		static {
			if (true) {
				System.out.println(Thread.currentThread().getName()+":I am in Dead Loop ,hahhahahaha");
				while(true)
					;
			}
		}
	}
	
	public static void main(String[] args) {
		Runnable script = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread()+":thread start");
				DeadLoopClazz deadLoopClazz = new DeadLoopClazz();
				System.out.println(Thread.currentThread()+":thread end");
			}
		};
		
		Thread thread1 = new Thread(script);
		Thread thread2 = new Thread(script);
		thread1.start();
		thread2.start();
	}
}
