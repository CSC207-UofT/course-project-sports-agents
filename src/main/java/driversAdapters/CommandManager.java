package driversAdapters;

import commands.*;
import constants.Exceptions;

import java.util.HashMap;

public class CommandManager {

    private final HashMap<String, Command> commandDictionary;

    /**
     * CommandManager is a class used to call the right use case and pass the user's argument to the use case
     */
    public CommandManager() {
        CommandDictBuilder commandDictBuilder = new CommandDictBuilder();
        this.commandDictionary = commandDictBuilder.getCommandDict();
    }

    /**
     * Calls upon the input parser to parse the user input, and calls the right use case and passes the
     * user's arguents
     * @param input input string of the user
     * @param container data container used in this particular instance
     * @return returns the output string obtained from one of the use cases
     * @throws Exception whenever a use case throws an exception
     */

    public String execute(String input, DataContainer container) throws Exception {
        if (input.equals("")) {
            return "";
        }
        InputParser parser = new InputParser(input);
        String command_keyword = parser.getKeyword();

        Command command = commandDictionary.get(command_keyword);
        if (command == null) {
            throw new Exception(Exceptions.WRONG_COMMAND);
        }
        return command.execute(parser.getArguments(), container);

    }
}

