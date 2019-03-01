package niube.classLoader;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {
		
		ClassLoader classLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
					InputStream inputStream = getClass().getResourceAsStream(fileName);
					if (inputStream == null)
						return super.loadClass(name);
					byte[] buff = new byte[inputStream.available()];
					inputStream.read(buff);
					return defineClass(name, buff, 0, buff.length);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new ClassNotFoundException(name);
				}
			}
		};
		
		Object obj = classLoader.loadClass("niube.classLoader.ClassLoaderTest").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof ClassLoaderTest);
	}

}
