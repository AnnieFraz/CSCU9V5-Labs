import java.net.*;

public class Connection extends Thread{
	
	private Socket outputLine; 
	
	public Connection (Socket s){
		outputLine = s;
		
		//Take in port of next node?
		
	}
	
	public void run(){
		
		//System.out.println("Ring Node" + Thread.getName() + "now realsing the token");
		//Maybe call critical section here 
		
		//System.out.println("Ring Node" + Thread.getName() + "has reased the token");
	}

}
