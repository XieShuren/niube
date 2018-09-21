package daily.d20180607;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

	public static void main(String[] args) {
		test3();
	}

	private static void test1() {
		DemoThread demoThread = new DemoThread(Thread.currentThread());
		demoThread.start();
		LockSupport.park("23");
		System.out.println("unpark");
	}
	
	private static void test2() {
		DemoThread1 demoThread = new DemoThread1(Thread.currentThread());
		demoThread.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LockSupport.park();
		System.out.println("not park");
	}
	
	private static void test3() {
		DemoThread2 demoThread2 = new DemoThread2(Thread.currentThread());
		demoThread2.start();
		LockSupport.park();
		System.out.println("interrupted");
	}
	
	static class DemoThread extends Thread {
		
		private Thread thread;
		
		public DemoThread(Thread thread) {
			this.thread = thread;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LockSupport.unpark(thread);
		}
	}
	
	static class DemoThread1 extends Thread {
		
		private Thread thread;
		
		public DemoThread1(Thread thread) {
			this.thread = thread;
		}
		
		@Override
		public void run() {
			LockSupport.unpark(thread);
		}
	}
	
	static class DemoThread2 extends Thread {
		
		private Thread thread;
		
		public DemoThread2(Thread thread) {
			this.thread = thread;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			thread.interrupt();
		}
	}
}
