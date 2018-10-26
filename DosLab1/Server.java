package DosLab1;

import java.net.*;

public class Server {
    private ServerSocket s;
    private Socket client;
    private Connection c;
    public Server() {
        // create the socket the server will listen to
        //System.out.println(Thread.currentThread().getName());
        try
        { InetAddress server_inet_address = InetAddress.getLocalHost() ; String server_host_name = server_inet_address.getHostName(); System.out.println ("Server hostname is " +server_host_name ) ; System.out.println ("Server port is xxxx") ;
        }
        catch (java.net.UnknownHostException e)
        { System.out.println(e); System.exit(1);
        }

        try {
            s = new ServerSocket(5155);
        } catch (java.io.IOException e) {
            System.out.println(e);
            System.exit(1);

        } // OK, now listen for connections
        System.out.println("Server is listening ....");
        try {
            while (true) {
                client = s.accept();
                // create a separate thread to service the client
                c = new Connection(client);
                c.start();

            }
        } catch (java.io.IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]){
        Server timeOfDayServer = new Server();

    }

}

