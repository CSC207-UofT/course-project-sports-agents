package SportsApp;

import commands.Command;
import member.MemberManager;
import commannds.PlayerStatManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class commandManager {

    private static final HashMap<String, Command> commandDictionary = new HashMap<String, Command>();

    static {
        commandDictionary.put("stats_player", new PlayerStatManager());
        commandDictionary.put("member_manager", new MemberManager());
    }
    public String execute(String input) throws Exception {
        if (input.equals("")) {
            return "";
        }
        ArrayList<String> split_input = parse(input);
        String command_keyword = split_input.get(0);

        Command command = commandDictionary.get(command_keyword);
        ArrayList<String> arguments = (ArrayList<String>) split_input.subList(1, split_input.size());
        return command.execute(arguments);
    }

    private ArrayList<String> parse(String input) {
        // TODO: Enhance this method by returning a custom tuple, containing the keyword argument in
        //  its first position, and a list of arguments in its second position
        String[] splited = input.split(" ");
        ArrayList<String> result = new ArrayList<String>(List.of(splited));
        return result;
    }
}
