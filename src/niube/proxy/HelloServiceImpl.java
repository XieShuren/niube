package niube.proxy;

public class HelloServiceImpl implements HelloService{

	@Override
	public void talk(String msg) {
		System.out.println("hello,"+msg);
	}

}
