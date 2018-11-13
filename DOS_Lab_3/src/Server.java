import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private  int  this_port ;
	private String  next_host ;
    private int  next_port ;
    
    private Socket client;
    private CriticalRegion c;
    private ServerSocket s;
    
    
	public Server(int this_port, String next_host, int next_port) {
		// TODO Auto-generated constructor stub
		this.this_port = this_port;
		this.next_host = next_host;
		this.next_port = next_port;
		
		try
        { 
		InetAddress server_inet_address = InetAddress.getLocalHost() ; 
        String server_host_name = server_inet_address.getHostName(); 
        System.out.println ("Server hostname is " +server_host_name ) ; 
        System.out.println ("Server port is " + this_port) ;
        }
        catch (java.net.UnknownHostException e)
        { 
        	System.out.println(e); 
        	System.exit(1);
        }
		
		 try {
	            s = new ServerSocket(this_port);
	        } catch (java.io.IOException e) {
	            System.out.println(e);
	            System.exit(1);

	        } // OK, now listen for connections
		
		System.out.println("Server is listening ....");
        try {
            while (true) {
                client = s.accept();
                // create a separate thread to service the client
                InetAddress server_inet_address = InetAddress.getLocalHost() ; 
                String server_host_name = server_inet_address.getHostName();
                c = new CriticalRegion(server_host_name, this_port, next_host, next_port);
                c.start();

            }
        } catch (java.io.IOException e) {
            System.out.println(e);
        }
	}

	
	/*
	 * Run Commands
	 * cd bin
	 * java Server 7000 127.0.0.1 7001 - Member one of the ring
	 * java Server 7001 127.0.0.1 7002
	 * java Server 7002 127.0.0.1 7000
	 * 
	 * IN SEPERATE TERMINAL
	 * java Client 127.0.0.1 7000
	 * 
	 */
	public static void main(String argv[]) {

		if ((argv.length < 3) || (argv.length > 3)) {
			System.out.println("Usage: [this port][next host][next port]");
			System.out.println("Only "+argv.length+" parameters entered");
			System.exit (1) ;
			}
		
			int this_port = Integer.parseInt (argv[0]) ;
			String next_host = argv[1] ;
			int next_port = Integer.parseInt (argv[2]) ;
			Server ring_host = new Server(this_port, next_host, next_port);
			} // end main
}
