package gui;

/**
 * An interface for GUI panes that accept input from the Insert windows.
 * 
 * @author Stephen Fahy
 */
public interface AcceptsInsertions {
    /**
     * Inserts the given string into the GUI.
     * 
     * @param insertion 
     */
    public void insert(String insertion);
}
