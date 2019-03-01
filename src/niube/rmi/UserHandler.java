package niube.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserHandler extends Remote {

	int getUserCount() throws RemoteException;
	
	User getUserById(int id) throws RemoteException;
}
