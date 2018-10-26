package DosLab1;

import java.net.*;
import java.io.*;
public class Client{
    public Client(String host, int port) {
        System.out.println(Thread.currentThread().getName());
        try
        {
            //Socket s = new Socket("127.0.0.1",5155);
            Socket s = new Socket(host, port);
            InputStream in = s.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            System.out.println(bin.readLine());
            //System.out.println(java.lang.Thread.getName());
            s.close();
        }catch (java.io.IOException e) {
            System.out.println(e);System.exit(1);
        }
    }

    public static void main(String argv[]) {
        if ((argv.length < 1) || (argv.length > 2))
        { System.out.println("Usage: [host] <port>") ; System.exit (1) ;
        }
        String server_host = argv[0] ;
        int server_port = 5156 ;
        //String server_host = "127.0.0.1" ; int server_port = 5156 ;
        if (argv.length == 2)
            server_port = Integer.parseInt (argv[1]) ;
        Client client = new Client(server_host, server_port); }
        /*
        Client client = new Client();
        Client client2 = new Client();*/

}

