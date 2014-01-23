import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote Interface
 */

public interface HelloWorldInterface  extends Remote{
	/**
	 * Remotely invocable method.
	 * @exception RemoteException if the remote invocation fails.
	 */
	public String greetings(String clientMessage) throws RemoteException;
}
