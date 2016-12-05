package ie.gmit.sw;
import java.rmi.Remote;
import java.rmi.RemoteException;

/* 
 * Resultator is a remote object reference that is returned when compare() is called
 * Stored in the OUT-QUEUE(Map)
 */
public interface Resultator extends Remote{
	 /*
	  * setResult() -- used by the service provider to update the state of the returned "pass-by-reference" object
	  * 				with a relevant string response(distance or optimal alignment)
	  * 
	  * getResult() -- should return this text to the caller
	  * 
	  * setProcessed() -- called by service provider to flag the Resultator object as processed
	  * 
	  * isProcessed() -- return whether or not the process is complete
	  */
	public String getResult() throws RemoteException;
	public void setResult(int result) throws RemoteException;
	public boolean isProcessed() throws RemoteException;
	public void setProcessed(int pr) throws RemoteException;

}
