package gui;

//import java.util.List;
//import java.util.Iterator;

/**
 * Enumerator for different tables in the View Pane. These types hold the
 * text for the context-sensitive button, the code for that button, the
 * basic select all query for that table, and whether or not the button
 * should be enabled.
 * 
 * @author Stephen Fahy
 */
public enum TableEnum {
    COURSES("SELECT * FROM Courses;", "Edit Course Details...", "code"), 
    LECTURERS("SELECT * FROM Lecturers;", "Edit Lecturer Details...", "name"), 
    USERS("SELECT * FROM Users;", "", "username"), 
    UNREPLIED_MESSAGES("SELECT * FROM UnrepliedUserMessages;", "Reply...", "username"),
    REGISTRATIONS("SELECT * FROM Registrations WHERE daysRemaining > 0;", 
            "Give Refund...", "courseCode");
    
    private String query;
    private String buttonText;
    private boolean buttonEnabled;
    private String key;
    
    /**
     * Constructor.
     * @param query The default query to get this table.
     * @param buttonText Text of the context-sensitive button; null for disabled.
     * @param key A key of the table that will be the first column in the display.
     */
    private TableEnum(String query, String buttonText, String key) {
        this.query = query;
        this.buttonText = buttonText;
        this.buttonEnabled = !(buttonText.equals(""));
        this.key = key;
    }
    
    /**
     * Performs the action for the context-sensitive button.
     */
    //public abstract void action(List<String> arguments);
    
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
    public String getKey() {
        return key;
    }
}
