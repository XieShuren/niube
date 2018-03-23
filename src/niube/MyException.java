package niube;

public class MyException extends Exception{

	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}
}
