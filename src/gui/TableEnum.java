package gui;

import java.util.LinkedList;

/**
 * Enumerator for different tables in the View Pane. These types hold the
 * text for the context-sensitive button, the code for that button, the
 * basic select all query for that table, and whether or not the button
 * should be enabled.
 * 
 * @author Stephen Fahy
 */
public enum TableEnum {
    COURSES("SELECT * FROM Courses;", "Edit Course Details...", 
            new String[]{"code", "name", "lecturer", "location", "fee", 
            "startDate", "courseDuration", "classDuration", "capacity", 
            "startTime", "description", "hits"}), 
    LECTURERS("SELECT * FROM Lecturers;", "Edit Lecturer Details...",
            new String[]{"name", "description"}), 
    USERS("SELECT * FROM Users;", "", new String[]{"username", "email", 
          "firstName", "surname", "gender", "age", "streetAddr", "townAddr",
          "stateAddr", "countryAddr", "telNo", "isAdmin", "password"}), 
    UNREPLIED_MESSAGES("SELECT * FROM UnrepliedUserMessages;", "Reply...",
            new String[]{"username", "content"}),
    REGISTRATIONS("SELECT username, courseCode, daysRemaining, hasStarted, "
            + "hasPaid, wasRefunded FROM Registrations WHERE daysRemaining > 0;", 
            "Give Refund...", new String[]{"courseCode", "username", "hasStarted", 
            "hasPaid", "wasRefunded", "daysRemaining"});
    
    private String query;
    private String buttonText;
    private boolean buttonEnabled;
    private String[] ordering;
    
    /**
     * Constructor.
     * @param query The default query to get this table.
     * @param buttonText Text of the context-sensitive button; null for disabled.
     * @param key A key of the table that will be the first column in the display.
     */
    private TableEnum(String query, String buttonText, String[] ordering) {
        this.query = query;
        this.buttonText = buttonText;
        this.buttonEnabled = !(buttonText.equals(""));
        this.ordering = ordering;
    }
    
    //getters
    public String getButtonText() {
        return buttonText;
    }
    public String getQuery() {
        return query;
    }
    public boolean isButtonEnabled() {
        return buttonEnabled;
    }
    public LinkedList<String> getHeadingsOrder() {
        LinkedList<String> output = new LinkedList<String>();
        
        for(String heading : ordering) {
            output.add(heading);
        }
        
        return output;
    }
}
