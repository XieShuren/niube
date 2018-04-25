package daily.d20180418;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

public class TryCloseSource {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		try (
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("abc.txt"));
				){
			int read = in.read();
		}
	}

}
