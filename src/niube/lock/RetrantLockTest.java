package niube.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RetrantLockTest {

	private static ReentrantLock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		Condition condition = lock.newCondition();
		new Thread() {
			public void run() {
				awaitNanos(condition, lock);
			};
		}.start();
		
		new Thread() {
			public void run() {
				awaitNanos(condition, lock);
			};
		}.start();
		
		new Thread() {
			public void run() {
				signalAll(condition, lock);
			};
		}.start();
		
	}

	public static void signalAll(Condition condition, ReentrantLock lock) {
		
		lock.lock();
		try {
			Thread.sleep(3000);
			condition.signalAll();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public static void awaitNanos(Condition condition, ReentrantLock lock) {
		
		lock.lock();
		try {
			long start = System.currentTimeMillis();
			//condition.awaitNanos(1000);
			condition.await();
			System.out.println(Thread.currentThread().getName()+"к╞ак:"+(System.currentTimeMillis()-start));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
