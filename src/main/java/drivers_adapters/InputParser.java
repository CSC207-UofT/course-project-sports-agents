package drivers_adapters;

import commands.Command;
import constants.CommandsInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class to parse the User's input into a readable command
 */
public class InputParser {

    private final String keyword;
    private final ArrayList<String> arguments;

    /**
     * Create an InputParser containing the keyword and command for the given
     * User input. This can have two valid forms:
     *      "[command_keyword] [argument1] [argument2] ..."
     *      "[command_keyword] --argument1-name [argument1]
     *          --argument2-name [argument2] ..."
     * Any argument of over one word should be wrapped in quotations.
     * @param input the user's input, from the command line
     */
    public InputParser(String input) {
        // The keyword should be the first word of the User input
        String[] parts = input.split(" ", 2);
        this.keyword = parts[0];

        ArrayList<String> argParts = split_args(parts[1]);

        if (isVerbose(argParts)) {
            List<String> argNames = getArgNames(keyword);
            List<String> multiArgNames = getMultiArgNames(keyword);
            argParts = parseVerbose(argParts, argNames, multiArgNames);
        }

        decorateArgs(argParts);
        arguments = argParts;
    }

    /**
     * Split the User's given arguments into their sections.
     * Each section is either one word or one phrase surrounded by double quotes.
     * @param rawArgs Given arguments, a combination of words and double-quoted phrases
     * @return List, where each item is one argument
     */
    private ArrayList<String> split_args(String rawArgs) {
        ArrayList<String> argParts = new ArrayList<>();
        StringBuilder currArgPart = new StringBuilder();
        char endPartOn = ' ';
        int currIndex = 0;
        while (currIndex < rawArgs.length()) {
            char currChar = rawArgs.charAt(currIndex);
            if (currChar == endPartOn) {
                if (currArgPart.length() > 0) {
                    argParts.add(currArgPart.toString());
                    currArgPart.delete(0, currArgPart.length());
                }
                endPartOn = ' ';
            } else {
                if (currChar == '"') { // know (endPartOn == ' ') by above if
                    if (currArgPart.length() > 0) {
                        argParts.add(currArgPart.toString());
                        currArgPart.delete(0, currArgPart.length());
                    }
                    endPartOn = '"';
                } else {
                    currArgPart.append(currChar);
                }
            }
            currIndex += 1;
        }
        if (currArgPart.length() > 0) {
            argParts.add(currArgPart.toString());
        }
        return argParts;
    }

    /**
     * Determine if a series of argument phrases is verbose (some are --argument-name)
     * @param argParts argument phrases, from split_args
     * @return true if the argument phrases are verbose
     */
    private boolean isVerbose(ArrayList<String> argParts) {
        for (String part : argParts) {
            if (part.charAt(0) == '-' && part.charAt(1) == '-') {
                return true;
            }
        }
        return false;
    }

    /**
     * Find the argument names corresponding to the command keyword
     * @param keyword Command keyword given by User
     * @return argument names for that Command
     */
    private List<String> getArgNames(String keyword) {
        switch (keyword) {
            case "get_player_stat":
                return CommandsInfo.GetPlayerStatInfo.argNames;
            case "compare_player_stat":
                return CommandsInfo.ComparePlayerStatInfo.argNames;
            case "predict_player_stat":
                return CommandsInfo.PredictPlayerStatInfo.argNames;
            case "add_member":
                return CommandsInfo.AddMemberInfo.argNames;
            case "create_match":
                return CommandsInfo.CreateMatchInfo.argNames;
            case "bet":
                return CommandsInfo.BetInfo.argNames;
            case "resolve_match":
                return CommandsInfo.ResolveMatchInfo.argNames;
            case "member_info":
                return CommandsInfo.MemberInfoInfo.argNames;
            case "save":
                return CommandsInfo.SaveInfo.argNames;
            case "load":
                return CommandsInfo.LoadInfo.argNames;
            default:
                return new ArrayList<>();
        }
    }

    /**
     * Find the multi-phrase argument names corresponding to the command keyword
     * @param keyword Command keyword given by User
     * @return multi-phrase argument names for that Command
     */
    private List<String> getMultiArgNames(String keyword) {
        switch (keyword) {
            case "get_player_stat":
                return CommandsInfo.GetPlayerStatInfo.multiArgNames;
            case "compare_player_stat":
                return CommandsInfo.ComparePlayerStatInfo.multiArgNames;
            case "predict_player_stat":
                return CommandsInfo.PredictPlayerStatInfo.multiArgNames;
            case "add_member":
                return CommandsInfo.AddMemberInfo.multiArgNames;
            case "create_match":
                return CommandsInfo.CreateMatchInfo.multiArgNames;
            case "bet":
                return CommandsInfo.BetInfo.multiArgNames;
            case "resolve_match":
                return CommandsInfo.ResolveMatchInfo.multiArgNames;
            case "member_info":
                return CommandsInfo.MemberInfoInfo.multiArgNames;
            case "save":
                return CommandsInfo.SaveInfo.multiArgNames;
            case "load":
                return CommandsInfo.LoadInfo.multiArgNames;
            default:
                return new ArrayList<>();
        }
    }

    private ArrayList<String> parseVerbose(ArrayList<String> argParts,
                                           List<String> argNames,
                                           List<String> multiArgNames) {
        ArrayList<String> parsedArgs = new ArrayList<>();
        for (String argName : argNames) {
            if (multiArgNames.contains(argName)) {
                int curr_index = argParts.indexOf(argName) + 1;
                boolean collect_phrases = true;
                while (collect_phrases) {
                    String phrase = argParts.get(curr_index);
                    if (phrase.charAt(0) == '-' && phrase.charAt(1) == '-') {
                        collect_phrases = false;
                    } else {
                        parsedArgs.add(phrase);
                    }
                }
            } else {
                parsedArgs.add(argParts.get(argParts.indexOf(argName) + 1));
            }
        }
        return parsedArgs;
    }

    private void decorateArgs(ArrayList<String> argParts) {
        if (CommandsInfo.manageLeagueKeywords.contains(keyword)) {
            argParts.add(0, keyword);
        }
    }

    /**
     * @return the command keyword (the command being invoked)
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @return the arguments for the given command
     */
    public ArrayList<String> getArguments() {
        return arguments;
    }
}
