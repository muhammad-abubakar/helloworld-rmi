import java.rmi.RemoteException;


public class HelloWorld implements HelloWorldInterface{
	String reply_message = "I am Fine";
	protected HelloWorld() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String greetings(String clientMessage) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Client: "+ clientMessage);
		return "I am Fine";
	}


}
