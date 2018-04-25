package daily.d20180412;

import java.util.ArrayList;

public class HeapView {

	public static void main(String[] args) throws InterruptedException {
		ArrayList<OOMObject> list = new ArrayList<OOMObject>();
		for (int i = 0;i<1000;i++) {
			list.add(new OOMObject());
			Thread.sleep(100);
		}
		System.gc();
	}

	static class OOMObject {
		private byte[] buff = new byte[1024*64];
	}
}
