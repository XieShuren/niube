package daily.d20180412;

import java.util.LinkedHashMap;

public class DeadLockView {

	private LinkedHashMap map;
	static class ProduceThread extends Thread {
		
		private int a;
		
		private int b;
		
		public ProduceThread(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public void run() {
			synchronized (Integer.valueOf(a)) {
				synchronized (Integer.valueOf(b)) {
					System.out.println(a+b);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		for (int i = 0;i<50;i++) {
			new ProduceThread(1,2).start();
			new ProduceThread(2,1).start();
		}
	}

}
