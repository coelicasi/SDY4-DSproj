package ie.gmit.sw;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ResultatorImpl implements Resultator, Serializable, Remote{
	
	private static final long serialVersionUID = 1L;
	private int distance;
	private String result = null;
	private int process = 0;
	

	@Override
	public String getResult() throws RemoteException {
		// TODO Auto-generated method stub
		return this.result;
	}

	@Override
	public void setResult(int dis) throws RemoteException {
		// TODO Auto-generated method stub
		this.distance = dis;
		this.result = Integer.toString(distance);
	}

	@Override
	public boolean isProcessed() throws RemoteException {
		if(this.process == 1){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public void setProcessed(int pr) throws RemoteException {
		this.process = pr;
	}

}