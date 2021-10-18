package sportsApp;

import commands.Command;
import commands.LeagueMemberManager;
import commands.PlayerStatManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class commandManager {

    private static final HashMap<String, Command> commandDictionary = new HashMap<String, Command>();

    static {
        commandDictionary.put("stats_player", new PlayerStatManager());
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
