import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIHelloWorldInterface extends Remote{
	
	public String greetings(String aMessage) throws RemoteException;
	public String serviceName = "GreetingServer";
}