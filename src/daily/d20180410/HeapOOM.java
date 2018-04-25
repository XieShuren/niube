package daily.d20180410;

import java.util.ArrayList;

public class HeapOOM {

	static class OOMBean {
		
	}
	
	public static void main(String[] args) {
		ArrayList<OOMBean> list = new ArrayList<OOMBean>();
		while(true) {
			list.add(new OOMBean());
		}
	}
}
