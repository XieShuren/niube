package daily.d20180605;

import java.lang.Thread.UncaughtExceptionHandler;

public class UnCaughtException {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int[] arr = new int[0];
				arr[1] = 1;
			}
		});
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("≤∂ªÒ“Ï≥££∫"+e);
			}
		});
		thread.start();
	}

	
	private static void throwException() throws InterruptedException {
		Thread.sleep(100000);
	}
}
