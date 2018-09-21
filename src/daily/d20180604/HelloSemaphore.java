package daily.d20180604;

import java.util.concurrent.Semaphore;

public class HelloSemaphore {

	private static final Semaphore semaphore = new Semaphore(6, true);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0;i<10;i++) {
			new WaitThread().start();
		}
	}

	private static void test() {
		try {
			semaphore.acquire(2);
			Thread.sleep(5000);
			semaphore.release(2);
			System.out.println(Thread.currentThread().getName()+" finished");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static class WaitThread extends Thread {
		@Override
		public void run() {
			test();
		}
	}
}
