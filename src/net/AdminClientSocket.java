package net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import log.ErrorLogger;

/**
 * Class for a net socket from an administrator client. This will make a 
 * connection to the server's AdminServerSocket on a port and IP supplied by
 * the Connector that the server's Authenticator has verified.
 * 
 * @author Stephen Fahy
 */
public class AdminClientSocket extends Thread {
    private Socket socket;
    
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
    
    /**
     * Sends a message to the server.
     * 
     * @param msg 
     */
    public void sendMessage(Message msg) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(msg);
            out.flush();
            out.close();
        }
        catch(Exception e) {
            ErrorLogger.get().log(e.toString());
            e.printStackTrace();
        }
    }
    
    /**
     * Tries to receive a message from the server. WARNING: will hang if no
     * message comes in.
     * 
     * @return 
     */
    public Message receiveMessage() {
        Message output = null;
        
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            output = (Message) in.readObject();
            in.close();
        }
        catch(Exception e) {
            ErrorLogger.get().log(e.toString());
            e.printStackTrace();
        }
        
        return output;
    }
    
    /**
     * Tries to disconnect from the server.
     * @throws IOException 
     */
    public void disconnect() throws IOException {
        socket.close();
    }
}
