package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;
import ie.gmit.sw.Resultator;

public interface StringService extends Remote {
	
	public Resultator compare(String s, String t, String algo) throws RemoteException;

}
