package commands;

import drivers_adapters.DataContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrintCommands implements Command {


    HashMap<String, String> DESCRIPTIONS = new HashMap<>();
    HashMap<String, String> ARGUMENTS = new HashMap<>();


    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {

        StringBuilder output = new StringBuilder();
        output.append("--------------------------------------------------------------------------------\n");
        output.append(String.format("%15s %30s %30s %n", "Command Keyword", "Description", "Arguments"));
        output.append("--------------------------------------------------------------------------------\n");

        String needed_command = arguments.get(0);


        if (arguments.get(0).equals("all")) {
            for (Map.Entry<String, String> command_entry: DESCRIPTIONS.entrySet()) {
                String current_command = command_entry.getKey();
                output.append(String.format("%15s %30s %30s %n", current_command,
                                            DESCRIPTIONS.get(current_command), ARGUMENTS.get(current_command)));
            }
            return output.toString();
        }
        output.append(String.format("%15s %30s %30s %n", arguments.get(0), DESCRIPTIONS.get(needed_command),
                                    ARGUMENTS.get(needed_command)));
        return output.toString();
    }
}
