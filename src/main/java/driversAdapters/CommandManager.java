package driversAdapters;

import commands.*;
import constants.Exceptions;

import java.util.HashMap;

public class CommandManager {

    private final HashMap<String, Command> commandDictionary;

    public CommandManager() {
        CommandDictBuilder commandDictBuilder = new CommandDictBuilder();
        this.commandDictionary = commandDictBuilder.getCommandDict();
    }

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

