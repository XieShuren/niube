package niube.thread;

import sun.nio.ch.Interruptible;

public class InterruptDemo {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		sun.misc.SharedSecrets.getJavaLangAccess().blockedOn(myThread, new MyInterruptHandler());
		myThread.start();
		myThread.interrupt();
	}

	static class MyThread extends Thread {
		static volatile boolean flag = true;
		@Override
		public void run() {
			while (flag)
				yield();
		}
	}
	static class MyInterruptHandler implements Interruptible {

		@Override
		public void interrupt(Thread thread) {
			if (thread instanceof MyThread) {
				((MyThread) thread).flag = false;
				System.out.println("thread is interrupted");
			}
		}
		
	}
}