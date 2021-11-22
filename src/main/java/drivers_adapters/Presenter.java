package drivers_adapters;

public interface Presenter {

    /**
     * Prompt the User for an input
     * @return the User's input command
     */
    String getInput();

    /**
     * Display the given output to the User
     * @param output output to display
     */
    void presentOutput(String output);

    /**
     * Close the output stream.
     * Called when the program quits.
     */
    void closeOutput();

}
