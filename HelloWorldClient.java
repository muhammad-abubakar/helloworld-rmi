
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class HelloWorldClient {
   
	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 */
	private static String HOST = "localhost";
	private static  int PORT_NO = 1099; 
	private static final String RMI_ID = "HelloWorld";
	private static String message = "Hello, How Are you?";

	
	public static void main(String[] args) throws RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		if(args.length > 1)
		{ 
			for(int i=0; i < args.length ; i++)
			{
				if(args[i].equals("-port"))
					PORT_NO = Integer.parseInt(args[i+1]);
				if(args[i].equals("-host"))
					HOST = args[i+1];
				
			}
		}
		
		Registry registry = LocateRegistry.getRegistry("ec2-54-224-236-43.compute-1.amazonaws.com", PORT_NO);
		HelloWorldInterface remote = (HelloWorldInterface) registry.lookup(RMI_ID);
	    System.out.println("Server: " + remote.greetings(message));
	}

}
