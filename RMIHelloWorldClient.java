import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RMIHelloWorldClient {
	
	public static void main(String args[])
	{
		//step 0: Get security clearance of java boss :-)
		System.setSecurityManager(new RMISecurityManager());
		
		//step 1: Locate rmi registry
		Registry registry = null;
		try {
			registry = LocateRegistry.getRegistry("ec2-54-198-195-157.compute-1.amazonaws.com");
		} catch (RemoteException e) {
			System.err.println("Failed to locate rmi registry. Dieing...");
			System.exit(-1);
		}
		
		//step 2: Lookup service of our interest
		RMIHelloWorldInterface stub = null;
		try {
			stub = (RMIHelloWorldInterface)registry.lookup(RMIHelloWorldInterface.serviceName);
		} catch (Exception e) {
			System.err.println("Failed to lookup service of interest. Dieing...");
			e.printStackTrace();
			System.exit(-1);
		}
		
		//step 3: Now I will do method calls as I used to do in old days :-)
		String chat = "";
		try {
			chat = stub.greetings("Hello");
		
			System.out.println("Client: Hello");
			System.out.println("Server: "+chat);
			
			chat = stub.greetings("What you do whole day long?");
			System.out.println("Client: What you do whole day long?");
			System.out.println("Server: "+chat);
		} catch (RemoteException e) {
			System.err.println("Nasty things happen in the life of distributed "
					+ "applications.  See what went wrong...");
			e.printStackTrace();
			
		}
		
		
		
		
	}
	
	
	

}
