package net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
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
    //private static final String DEFAULT_ADDR = "djs.csproject.org";
    private static final int DEFAULT_AUTH_PORT = 40579;
    private static AdminClientSocket SOCKET;
    private static int ID;
    private static String USERNAME;
    
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
            //Socket authSocket = new Socket(InetAddress.getByName(DEFAULT_ADDR), DEFAULT_AUTH_PORT);
            Socket authSocket = new Socket(InetAddress.getLocalHost(), DEFAULT_AUTH_PORT);
            ObjectOutputStream authOut = new ObjectOutputStream(authSocket.getOutputStream());
            authOut.flush();
            String passhash = encrypt(password);
            AuthMessage auth = new AuthMessage(ID, username, passhash);
            
            auth.send(authOut);
            authOut.flush();
            
            ObjectInputStream authIn = new ObjectInputStream(authSocket.getInputStream());
            Message reply = (Message) authIn.readObject();
            
            if(reply instanceof ConnectionMessage) {
                ConnectionMessage con = (ConnectionMessage) reply;
                int port = (Integer) con.getContent().get(ConnectionMessage.PORT);
                //SOCKET = new AdminClientSocket(port, 
                //        InetAddress.getByName(DEFAULT_ADDR).getHostAddress());
                SOCKET = new AdminClientSocket(port, 
                        InetAddress.getLocalHost().getHostAddress());
                new Thread(SOCKET).start();
                USERNAME = username;
                
                output = true;
            }
            else if(reply instanceof AckMessage) {
                //read nack, print error message to screen
            }
            else {
                ErrorLogger.get().log("Unknown message received from server: " +
                        reply.toString());
            }
        }
        catch(Exception e) {
            ErrorLogger.get().log(e.toString());
            e.printStackTrace();
        }
        
        return output;
    }
    
    /**
     * Tries to disconnect from the server.
     */
    public static void disconnect() {
        try {
            SOCKET.disconnect();
        }
        catch(Exception e) {
            ErrorLogger.get().log(e.toString());
            e.printStackTrace();
        }
        
        SOCKET = null;
        ID = 0;
    }
    
    /**
     * Hashes a password in SHA-256 format.
     * 
     * @param password The password.
     * @return The password's hash.
     */
    private static String encrypt(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes("UTF-8"));
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        
        for(byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        
        return sb.toString();
    }
    
    //getters
    public static AdminClientSocket getSocket() {
        return SOCKET;
    }
    public static boolean isConnected() {
        return SOCKET != null;
    }
    public static int getNextId() {
        ID++;
        return ID;
    }
    public static String getUsername() {
        return USERNAME;
    }
}
