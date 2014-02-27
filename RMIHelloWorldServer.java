import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;




public class RMIHelloWorldServer implements RMIHelloWorldInterface{

	@Override
	public String greetings(String aMessage) {
		String serverMessage = "Sorry what did you say?";
		if(0 == aMessage.compareToIgnoreCase("Hello"))
		{
			serverMessage = "Hey RMI client, greetings from RMI server!";
		}
		return serverMessage;
	}
	
	
	
	
	
	
	
	public RMIHelloWorldServer()
	{
		
	}
	
	
	
	
	public static void main(String args[])
	{
		
		//step 0: Add an appropriate security manager
		System.setSecurityManager(new RMISecurityManager());
				
		//step 1: Instantiate an object of server		
		RMIHelloWorldServer serverObj = new RMIHelloWorldServer();
		
		//step 1.5: Prepare a stub for clients of this server
		RMIHelloWorldInterface stub = null;
		try {
			stub = (RMIHelloWorldInterface) UnicastRemoteObject.exportObject(serverObj, 4000);
		} catch (RemoteException e1) {
			System.err.println("Failed to create stub for clients. Dieing...");
			System.exit(-1);
		}
		
		//step 2: Locate RMI registry
		Registry registry = null;
		try {
			registry= LocateRegistry.getRegistry();			
		} catch (RemoteException e) {
			System.err.println("Failed to locate rmi registry. Dieing...");
			System.exit(-1);
		}
		
		//step 3: register server created stub object with registry
		try {
			registry.rebind(RMIHelloWorldInterface.serviceName, stub);
		} catch (RemoteException e) {
			System.err.println("Failed to register server object with  rmi registry. Dieing...");
			e.printStackTrace();
			System.exit(-1);
		}
		
		//step 4: I am done with the hard work.  Now I will sit back
		// and relax and wait for clients to come.
		System.out.println("done...");			
	}

}
