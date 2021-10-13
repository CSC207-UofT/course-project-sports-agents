import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class commandManager {

    // TODO: Command should be an interface, since we have different classes like predictor, etc
    private static final HashMap<String, CommandInterface> commandDictionairy;

//    commandDictionairy.put("stats_m", new TeamStatsManager());
      // TODO: make the intrface
    public String execute(String input) {
        if (input.equals("")) {
            return "";
        }
        ArrayList<String> splited = parse(input);
        String command_keyword = splited.get(0);

        Executable command = commandDictionairy.get(command_keyword);
        String output = command.run(splited.get(1));

        return output;
    }

    private ArrayList<String> parse(String input) {
        // TODO: Enhance this method by returning a custom tuple, containing the keyword argument in
        //  its first position, and a list of arguments in its second position
        String[] splited = input.split(" ");
        ArrayList<String> result = new ArrayList<String>(List.of(splited));
        return result;
    }
}
