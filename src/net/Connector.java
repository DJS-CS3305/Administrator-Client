package net;

import java.net.Socket;

/**
 * Connects to the server backend and tries to access it through the
 * authenticator.
 * 
 * @author Stephen Fahy
 */
public class Connector {
    private static final String DEFAULT_URL = "";
    private static final int DEFAULT_AUTH_PORT = 579;
    private static Socket SOCKET;
    
    
    /**
     * Tries to connect to the server with the given details.
     * 
     * @param username
     * @param password
     * @return True if connected successfully.
     */
    private static boolean connect(String username, String password) {
        boolean output = false;
        
        
        
        return output;
    }
    
    //getters
    public static Socket getSocket() {
        return SOCKET;
    }
}
