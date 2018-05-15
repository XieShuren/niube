package niube;

public class MyException extends Exception{

	@Override
	public synchronized Throwable fillInStackTrace() {
		test(new Thread());
		return this;
	}
	
	public <T extends Thread> T test(T t) {
		return null;
	}
}
