package drivers_adapters;

import commands.Command;
import commands.LeagueMemberManager;
import commands.HockeyPlayerStatManager;

import java.util.HashMap;

public class commandManager {

    private static final HashMap<String, Command> commandDictionary = new HashMap<>();

    static {
        commandDictionary.put("stats_player", new HockeyPlayerStatManager());
        commandDictionary.put("member_manager", new LeagueMemberManager());
    }
    public String execute(String input) throws Exception {
        if (input.equals("")) {
            return "";
        }
        inputParser parser = new inputParser(input);
        String command_keyword = parser.getKeyword();

        Command command = commandDictionary.get(command_keyword);
        return command.execute(parser.getArguments());

    }
}
