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
            "startTime", "description", "hits"}) {
        @Override
        public String translateForDisplay(String input, String heading) {
            String output;
            
            if(heading.equals("courseDuration")) {
                output = input + " days";
            }
            else if(heading.equals("classDuration")) {
                int minutes = Integer.parseInt(input);
                output = (minutes / 60) + " hours, " + (minutes % 60) + "minutes";
            }
            else if(heading.equals("fee")) {
                int centsTotal = Integer.parseInt(input);
                int centsAlone = centsTotal % 100;
                output = "€" + (centsTotal / 100) + "." + ((centsAlone <= 9) ?
                        "0" + centsAlone : centsAlone);
            }
            else {
                output = input;
            }
            
            return output;
        }
    }, 
    LECTURERS("SELECT * FROM Lecturers;", "Edit Lecturer Details...",
            new String[]{"name", "description"}) {
        @Override
        public String translateForDisplay(String input, String heading) {
            return input;
        }
    }, 
    USERS("SELECT * FROM Users;", "", new String[]{"username", "email", 
          "firstName", "surname", "gender", "age", "streetAddr", "townAddr",
          "stateAddr", "countryAddr", "telNo", "isAdmin", "password"}) {
        @Override
        public String translateForDisplay(String input, String heading) {
            String output;
            
            if(heading.equals("gender")) {
                int i = Integer.parseInt(input);
                output = (i > 0) ? "M" : "F";
            }
            else if(heading.equals("isAdmin")) {
                int i = Integer.parseInt(input);
                output = (i > 0) ? "Yes" : "No";
            }
            else {
                output = input;
            }
            
            return output;
        }
    }, 
    UNREPLIED_MESSAGES("SELECT * FROM UnrepliedUserMessages;", "Reply...",
            new String[]{"username", "content"}) {
        @Override
        public String translateForDisplay(String input, String heading) {
            return input;
        }
    },
    REGISTRATIONS("SELECT username, courseCode, daysRemaining, hasStarted, "
            + "hasPaid, wasRefunded FROM Registrations WHERE daysRemaining > 0;", 
            "Give Refund...", new String[]{"courseCode", "username", "hasStarted", 
            "hasPaid", "wasRefunded", "daysRemaining"}) {
        @Override
        public String translateForDisplay(String input, String heading) {
            String output;
            
            if(heading.equals("hasStarted") || heading.equals("hasPaid") ||
                    heading.equals("wasRefunded")) {
                int i = Integer.parseInt(input);
                output = (i > 0) ? "Yes" : "No";
            }
            else {
                output = input;
            }
            
            return output;
        }
    };
    
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
    
    /**
     * Alters a data input to be more understandable on the display.
     * 
     * @param input The data to alter.
     * @param heading The heading of the column the input belongs to.
     * @return The data to display.
     */
    public abstract String translateForDisplay(String input, String heading);
    
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
