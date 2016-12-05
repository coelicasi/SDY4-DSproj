package ie.gmit.sw;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;

import ie.gmit.sw.Levenshtein;
import ie.gmit.sw.Resultator;
import ie.gmit.sw.ResultatorImpl;

public class StringServiceImpl  implements StringService, Remote {
	
	private ResultatorImpl r;
	public String s1 = "string";
	public String s2 = "ping";
	public String algo;
	
	public StringServiceImpl(){
		super();
		//this.service = ss;
		
	}
	
	@Override
	public Resultator compare(String one, String two, String algo) throws RemoteException {
		this.s1 = one;
		this.s2 = two;
		this.algo = algo;
		/*Thread t = new Thread();
		try {
			t.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		Levenshtein ls = new Levenshtein();
		int levenDis = ls.distance(s1, s2);
		r = new ResultatorImpl();
		r.setResult(levenDis);
		r.setProcessed(1);
		return r;
	}
	
	public static void main (String args[]){
		try{
			String name = "StringService";
			StringService service = new StringServiceImpl();
			StringService stub = (StringService) UnicastRemoteObject.exportObject(service, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name, stub);
			System.out.println("StringService bound");
		} catch(Exception e){
			System.err.println("StringService Exception:");
			e.printStackTrace();
		}
	}

}
