package niube.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServerDemo {

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.createRegistry(9999);
			registry.rebind("userHandler", new UserHandlerImpl());
			System.out.println("rmi server is ready...");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
