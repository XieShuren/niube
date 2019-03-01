package niube.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import niube.rmi.UserHandler;

public class RmiClientDemo {

	public static void main(String[] args){
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 9999);
			UserHandler userHandler = (UserHandler) registry.lookup("userHandler");
			System.out.println(userHandler.getUserById(21));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
