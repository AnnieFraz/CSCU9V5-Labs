package DosLab1;

import java.net.*;
import java.io.*;
public class Connection extends Thread{
    private Socket outputLine;
    public Connection(Socket s) {
        outputLine = s;

    }
    public void run() {
        System.out.println(Thread.currentThread().getName());
        // getOutputStreamrtns an OutputStream object
        // allowing ordinary file IO over the socket.
        try {
            // create a new PrintWriter with auto flushing
            PrintWriter pout = new PrintWriter(outputLine.getOutputStream(), true);
            // now send a message to the client
            pout.println("The Date and Time is " + new java.util.Date().toString());
            // now close the socket

            /*
            DataOutputStream poutdata = new DataOutputStream(outputLine.getOutputStream());

            try {poutdata.writeDouble ( 1.123456789012345 );} catch (java.io.IOException e)
            { System.out.println(e); System.exit (8) ;
            }

            pout.println(1.123456012345) ;
            ip = new DataInputStream(in);

            double local_double = 0.0 ; local_double = ip.readDouble() ;

*/



            outputLine.close();
        }catch (java.io.IOException e) {
            System.out.println(e); }


    }
}
//}
