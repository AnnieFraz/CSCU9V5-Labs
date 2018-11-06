
public interface MessageQueue extends java.rmi.Remote {

	
	public void send (String item) throws java.rmi.RemoteException;
	
	public String receive() throws java.rmi.RemoteException;
}
