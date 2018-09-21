package daily.d20180524;

import daily.d20180524.SyncTest.LockBean;

public class SyncTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LockBean lockBean = new LockBean();
		//线程1
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (lockBean) {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		//线程2
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (;;)
				System.out.println(lockBean.getId());
			}
		}).start();
	}

	public static class LockBean {
		private int id;

		public LockBean() {
			this.id = 10;
		}
		public synchronized int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		
	}
}
