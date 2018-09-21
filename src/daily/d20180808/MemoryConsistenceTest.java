package daily.d20180808;

import java.util.concurrent.locks.ReentrantLock;

public class MemoryConsistenceTest {
	
	private static ReentrantLock lock = new ReentrantLock();
	public static void main(String[] args) {
		Bean bean = new Bean(0, "hello");
		new Thread(new Thread1(bean)).start();
		new Thread(new Thread2(bean)).start();
	}

	static class Thread1 implements Runnable {

		private Bean bean;
//		private int a;
		public Thread1(Bean bean) {
			this.bean = bean;
		}
		@Override
		public void run() {
			System.out.println("Running Thread start...");
			while (true) {
					
//				int b = a;
				if (bean.getId() == 1)
					break;
//				try {
//					Thread.sleep(200);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
			System.out.println("Running Thread shutdown");
//			synchronized (MemoryConsistenceTest.class) {
//				System.out.println("Running Thread start...");
//				while (!shutdown)
//					;
//				System.out.println("Running Thread shutdown");
//			}
		}
		
	}
	
	static class Thread2 implements Runnable {
		
		private Bean bean;
		
		public Thread2(Bean bean) {
			this.bean = bean;
		}
		@Override
		public void run() {
			
			try {
				synchronized (MemoryConsistenceTest.class) {
					Thread.sleep(1009);
					bean.setId(1);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
