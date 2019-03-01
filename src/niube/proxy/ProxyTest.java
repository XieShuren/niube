package niube.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		HelloService instance = (HelloService) Proxy.newProxyInstance(HelloService.class.getClassLoader(), new Class[] {HelloService.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//				System.out.println(proxy.getClass());\
				System.out.println(method.getName());
				return null;
			}
		});
		System.out.println(instance.getClass());
	}
}
