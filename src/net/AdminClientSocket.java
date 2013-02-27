package net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import log.ErrorLogger;

/**
 * Class for a net socket from an administrator client. This will make a 
 * connection to the server's AdminServerSocket on a port and IP supplied by
 * the Connector that the server's Authenticator has verified.
 * 
 * @author Stephen Fahy
 */
public class AdminClientSocket extends Thread implements Runnable{
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    /**
     * Constructor.
     * 
     * @param port The port number of an AdminServerSocket.
     * @param ip The IP address of the server.
     */
    public AdminClientSocket(int port, String ip) {
        try {
            socket = new Socket(ip, port);
        }
        catch(Exception e) {
            ErrorLogger.get().log(e.toString());
            e.printStackTrace();
        }
    }
    
    public void run() {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(socket.getInputStream());
        }
        catch(Exception e) {
            ErrorLogger.get().log(e.toString());
            e.printStackTrace();
        }
    }
}
