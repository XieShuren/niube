package niube.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		HelloService instance = (HelloService) Proxy.newProxyInstance(HelloService.class.getClassLoader(), new Class[] {HelloService2.class, HelloService.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println(method.getDeclaringClass());
				return null;
			}
		});
		instance.talk("");
	}
}
