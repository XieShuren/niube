package daily.d20180930;

import java.util.Date;

public class AnonymousInnerClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		new Thread() {
			public void run() {
				System.out.println(date);
			};
		};
//		date = new Date();
	}

}
