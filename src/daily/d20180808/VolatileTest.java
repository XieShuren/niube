package daily.d20180808;

public class VolatileTest {

	private static boolean shutdown;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new RunThread().start();
		Thread.sleep(2000);
		shutdown = true;
	}

	static class RunThread extends Thread {
		@Override
		public void run() {
			System.out.println("start");
			while(!shutdown)
				;
			System.out.println("end");
		}
	}
}
