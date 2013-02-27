package test;

import net.Connector;

/**
 * Tests connecting to the server.
 * 
 * @author Stephen Fahy
 */
public class ClientTest {
    public static void test() {
        System.out.println("Connecting...");
        System.out.println(Connector.connect("test", "test"));
    }
}
