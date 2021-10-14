package commands;

public interface Command {

    /**
     * Run the given command
     * @param command a String Array where the first string is the command
     *                name and following items are the arguments
     * @return the output of processing the command
     * @throws Exception if the command is invalid
     */
    public String execute(String[] command) throws Exception;

}
