import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class HelloWorldServer {
    
	private static  int PORT_NO = 1099; 
	private static final String RMI_ID = "HelloWorld";
	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws AlreadyBoundException 
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		if(args.length > 1)
		{ 
			for(int i=0; i < args.length ; i++)
			{
				if(args[i].equals("-port"))
					PORT_NO = Integer.parseInt(args[i+1]);
				
			}
		}
		
//		System.setProperty("java.security.policy","/server.policy");
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
		  String name = "HelloWorldInterface";
          HelloWorldInterface engine;
		try {
			engine = new HelloWorld();
		
          HelloWorldInterface stub =
              (HelloWorldInterface) UnicastRemoteObject.exportObject(engine, 0);
          Registry registry = LocateRegistry.getRegistry();
          registry.rebind(name, stub);
          System.out.println("ComputeEngine bound");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
