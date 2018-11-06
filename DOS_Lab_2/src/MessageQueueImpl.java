import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.Vector;

/*
 * GETTING THIS TO RUN (in cmd) , be in bin directory
 * 1. start rmiregistry
 * 2. java -Djava.security.policy=java.policy MessageQueueImpl
 * 3. java -Djava.security.policy=java.policy Client 127.0.0.1
 */

public class MessageQueueImpl extends java.rmi.server.UnicastRemoteObject implements MessageQueue {

	private Vector<String> queue;

	private int MAX_BUFFER_SIZE = 10;

	protected MessageQueueImpl() throws RemoteException {
		super();
		queue = new Vector<String>();
	}

	public static void main(String args[]) {
		System.setSecurityManager(new RMISecurityManager());

		try {
			MessageQueue server = new MessageQueueImpl();
			Naming.rebind("//127.0.0.1/MessageServer", server);
			System.out.println("Server Bound");
		} catch (Exception e) {
			System.err.println(e);
		}
	}



	public synchronized String receive() throws java.rmi.RemoteException {

		String item;

		if (queue.size() == 0) {
			return null;
		} else {
			item = queue.firstElement();
			queue.removeElementAt(0);
			System.out.println("Consumer entered " + item + "size = " + queue.size());
			return item;
		}
	}

	@Override
	public synchronized void send(String item) throws RemoteException {
		// TODO Auto-generated method stub
		queue.addElement(item);
		System.out.println("Producer entered " + item + "size = " + queue.size());
	}

}
