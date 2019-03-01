package niube.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import niube.rmi.User;
import niube.rmi.UserHandler;

public class UserHandlerImpl extends UnicastRemoteObject implements UserHandler{

	protected UserHandlerImpl() throws RemoteException {
		super();
	}

	@Override
	public int getUserCount() throws RemoteException {
		return 10;
	}

	@Override
	public User getUserById(int id) throws RemoteException {
		return new User(id, "haha");
	}

}
