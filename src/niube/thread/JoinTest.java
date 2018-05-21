package niube.thread;

public class JoinTest {

	public static void main(String[] args){
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new ChildThread(Thread.currentThread()));
		thread.start();
		try {
			thread.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		System.out.println("花费时间："+(System.currentTimeMillis()-start));
	}

	static class ChildThread extends Thread {

		private Thread parent;
		public ChildThread(Thread parent) {
			this.parent = parent;
		}
		@Override
		public void run() {
			try {
				for (int i = 0;i<5;i++) {
					Thread.sleep(2000);
					parent.interrupt();
//					synchronized (this) {
//						this.notifyAll();
//					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
