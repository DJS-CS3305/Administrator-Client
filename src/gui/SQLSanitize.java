/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 * Sanitized SQL statements.
 * 
 * @author saf3
 */
public class SQLSanitize {
    /**
     * Sanitized a String for an SQL statement.
     * 
     * Uses code from wiki.vnetpublishing.com/Java_Mysql_Real_Escape_String
     * 
     * @param input
     * @return 
     */
    public static String sanitize(String input) {
        String output = input;
        
        if(output == null) {
            return null;
        }
        else {
            output = output.replaceAll("\\\\", "\\\\\\\\");
            output = output.replaceAll("\\n", "\\\\n");
            output = output.replaceAll("\\r", "\\\\r");
            output = output.replaceAll("\\t", "\\\\t");
            output = output.replaceAll("\\00", "\\\\0");
            output = output.replaceAll("'", "\\\\'");
            output = output.replaceAll("\\\"", "\\\\\"");
        }
        
        return output;
    }
}
