package daily.d20180412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadStackView {

	private static void createBusyThread() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true)
					;
			}
		}, "testBusyThread");
		thread.start();
	}
	
	public static void createLockedThread() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (this) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, "testLockedThread");
		thread.start();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(reader.readLine());
		createBusyThread();
		System.out.println(reader.readLine());
		createLockedThread();
	}
}
