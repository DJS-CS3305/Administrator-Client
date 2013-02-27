package net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.MessageDigest;
import log.ErrorLogger;

/**
 * Connects to the server backend and tries to access it through the
 * authenticator. Creates an AdminClientSocket if successful.
 * 
 * @author Stephen Fahy
 */
public class Connector {
    private static final String DEFAULT_IP = "localhost";
    private static final int DEFAULT_AUTH_PORT = 579;
    private static final int TIMEOUT = 500000;
    private static AdminClientSocket SOCKET;
    
    /**
     * Tries to connect to the server with the given login details.
     * 
     * @param username The user's username.
     * @param password The password for the associated username.
     * @return True if connected successfully.
     */
    public static boolean connect(String username, String password) {
        boolean output = false;
        
        try {
            Socket authSocket = new Socket(DEFAULT_IP, DEFAULT_AUTH_PORT);
            ObjectInputStream authIn = new ObjectInputStream(authSocket.getInputStream());
            ObjectOutputStream authOut = new ObjectOutputStream(authSocket.getOutputStream());
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
            byte[] digest = md.digest();
            String passhash = new String(digest);
            AuthMessage auth = new AuthMessage(0, username, passhash);
            int timer = 0;
            
            auth.send(authOut);
            
            while(authIn.available() == 0 && timer < TIMEOUT) {
                //wait until a reply from the server is received or timeout
                timer++;
            }
            
            Message reply = (Message) authIn.readObject();
            
            if(reply instanceof ConnectionMessage) {
                ConnectionMessage con = (ConnectionMessage) reply;
                int port = (Integer) con.getContent().get(ConnectionMessage.PORT);
                SOCKET = new AdminClientSocket(port, DEFAULT_IP);
            }
            else if(reply instanceof AckMessage) {
                //read nack, print error message to screen
            }
            else {
                ErrorLogger.get().log("Unknown message received from server: " +
                        reply.toString());
                //print error message to screen
            }
        }
        catch(Exception e) {
            ErrorLogger.get().log(e.toString());
            e.printStackTrace();
            //print connection failed error message to screen
        }
        
        return output;
    }
    
    //getters
    public static AdminClientSocket getSocket() {
        return SOCKET;
    }
}
