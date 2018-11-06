
import java.net.MalformedURLException;
import java.rmi.*;

public class Client {

	public static void main(String[] args) throws RemoteException, Exception  {
		/*
		String server_host = args[0] ;
		MessageQueue mb;
		
		if((args.length < 1) || (args.length > 1)){ 
			
			
			
			mb=(MessageQueue)Naming.lookup("rmi://"+server_host+"/MessageQueueImpl");
			
			
			System.out.println("Usage: [remote-host-name]") ;
			System.exit (1) ;
			
			Producer producer = new Producer(mb);
	        Consumer consumer = new Consumer(mb);

	        producer.start();
	        consumer.start();
			}*/
		
		
		
		
		
		System.setSecurityManager(new RMISecurityManager());
		
		MessageQueue mb;
		
			mb=(MessageQueue)Naming.lookup("rmi://127.0.0.1/MessageServer");
			
			System.out.println("hi");
			
			//String response = mb.send("hi");
			
			String receive = mb.receive();
			
			System.out.println(receive);
			
			Producer producer = new Producer(mb);
	        Consumer consumer = new Consumer(mb);

	        producer.start();
	        consumer.start();
	        
		
		
		/*
        String host = (args.length < 1) ? null : args[0];
        try {
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }*/
    }
}
