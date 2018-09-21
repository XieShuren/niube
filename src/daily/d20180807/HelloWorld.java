package daily.d20180807;

import java.util.concurrent.locks.ReentrantLock;

public class HelloWorld {

	private static int m;
	
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		int a=1;
		int b=2;
		int c = a+b;
		m = 10;
		System.out.println(c);
		lock.unlock();
	}
}
