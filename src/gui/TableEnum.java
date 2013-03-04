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
    COURSES("SELECT * FROM Courses;", "Edit Course Details..."), 
    LECTURERS("SELECT * FROM Lecturers;", "Edit Lecturer Details..."), 
    USERS("SELECT * FROM Users;", ""), 
    UNREPLIED_MESSAGES("SELECT * FROM UnrepliedUserMessages;", "Reply..."),
    REGISTRATIONS("SELECT * FROM Registrations WHERE daysRemaining > 0;", 
            "Give Refund...");
    
    private String query;
    private String buttonText;
    private boolean buttonEnabled;
    
    /**
     * Constructor.
     * @param query The default query to get this table.
     * @param buttonText Text of the context-sensitive button; null for disabled.
     */
    private TableEnum(String query, String buttonText) {
        this.query = query;
        this.buttonText = buttonText;
        this.buttonEnabled = !(buttonText.equals(""));
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
}
