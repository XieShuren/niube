package daily.d20180413;

import java.io.IOException;
import java.io.InputStream;

public class LoadClassTest {

	public static void main(String[] args) throws Exception {
		ClassLoader myLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				String fileName = name.substring(0, name.lastIndexOf(".")) +".class";
				try {
					InputStream inputStream = getClass().getResourceAsStream(fileName);
					if (inputStream == null)
						return super.loadClass(name);
					byte[] buff = new byte[inputStream.available()];
					inputStream.read(buff);
					return defineClass(name, buff, 0, buff.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};
		Object obj = myLoader.loadClass("daily.d20180413.ClinitTest").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof ClinitTest);
	}
}
