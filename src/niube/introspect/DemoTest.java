package niube.introspect;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class DemoTest {

	public static void main(String[] args) throws Exception {
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		Person person = new Person();
//		person.setId(1);
//		person.setName("ac");
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			System.out.println(propertyDescriptor.getName());
			Method readMethod = propertyDescriptor.getReadMethod();
			System.out.println(readMethod);
//			System.out.println(readMethod.invoke(person));
//			if ("name".equals(propertyDescriptor.getName())) {
//				Method writeMethod = propertyDescriptor.getWriteMethod();
//				writeMethod.invoke(person, "xsr");
//			}
		}
//		System.out.println(person.getName());
		
		MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
		for (MethodDescriptor methodDescriptor : methodDescriptors) {
			System.out.println(methodDescriptor.getMethod().getName());
		}
	}
}
