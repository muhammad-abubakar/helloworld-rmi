import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class HelloWorldServer {
    
	private static  int PORT_NO = 1099; 
	private static final String RMI_ID = "HelloWorld";
	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws AlreadyBoundException 
	 */
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		// TODO Auto-generated method stub
		if(args.length > 1)
		{ 
			for(int i=0; i < args.length ; i++)
			{
				if(args[i].equals("-port"))
					PORT_NO = Integer.parseInt(args[i+1]);
				
			}
		}
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
		HelloWorld helloWorld = new HelloWorld(); 
		Registry registory = LocateRegistry.getRegistry();
	    registory.rebind(RMI_ID, helloWorld);	
	    System.out.println("Listening");
	}

}
