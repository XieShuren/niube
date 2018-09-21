package daily.d20180605;

import java.sql.Connection;

public class DoubleChecker {

	private volatile Connection con;
	
	private Connection initConnection() {
		//init connection
		return con;
	}
	
	public Connection connection() {
		Connection result = con;
		if (result == null) {
			synchronized (this) {
				result = con;
				if (result == null)
					result = con = initConnection();
			}
		}
		return result;
	}
}
