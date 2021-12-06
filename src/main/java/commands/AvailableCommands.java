package commands;

import driversAdapters.DataContainer;

import java.util.ArrayList;

public class AvailableCommands implements Command{

    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {

        StringBuilder builder = new StringBuilder();

        builder.append("These are the available commands and their arguments in our app: \n");
        builder.append("-------------------------------------------------------------------------------------------------------------------------------------------------\n");
        builder.append(String.format("%15s %65s %50s %n", "Keyword", "Description", "Arguments"));
        builder.append("-------------------------------------------------------------------------------------------------------------------------------------------------\n");
        builder.append(String.format("%15s %65s %50s %n%n", "get_player_stat",
                "get a given statistic for a given player",
                "sport, player name, season, desired statistic"));
        builder.append(String.format("%15s %65s %50s %n%n", "compare_player_stat",
                "compare two or more players based on a statistic",
                "sport, player names, season, desired statistic"));
        builder.append(String.format("%15s %65s %50s %n%n", "predict_player_stat",
                "predict a player's performance based on past performance",
                "sport, player names, desired statistic"));
        builder.append(String.format("%15s %65s %50s %n%n", "member_manager add_member",
                "add a member to your fantasy league",
                "member name"));
        builder.append(String.format("%15s %65s %50s %n%n", "member_manager create_match",
                "create a match in your fantasy league",
                "name of the match, team 1 name, team 2 name"));
        builder.append(String.format("%15s %65s %50s %n%n", "member_manager bet",
                "bet on the outcome of a given match on behalf of a member",
                "name of the member, name of the match, winning team"));
        builder.append(String.format("%15s %65s %50s %n%n", "member_manager resolve_match",
                "resolve a match based on the real-life outcome",
                "name of the match, winning team"));
        builder.append(String.format("%15s %65s %50s %n%n", "member_manager member_info",
                "get information about a player in your fantasy league",
                "name of the member"));
        builder.append(String.format("%15s %65s %50s %n%n", "save",
                "save your fantasy league for later use",
                "path where you would like to save your league"));
        builder.append(String.format("%15s %65s %50s %n%n", "load",
                "load your previous iteration of your fantasy league",
                "name of the match, winning team"));
        builder.append(String.format("%15s %65s %50s %n%n", "get_players_list",
                "get a list of available players for a sport and a season",
                "sport, season"));
        builder.append(String.format("%15s %65s %50s %n%n", "get_sports",
                "get a list of all of the sports available",
                "no arguments"));
        builder.append(String.format("%15s %65s %50s %n%n", "get_stats",
                "get a list of all of the stats available for a sport",
                "sport"));
        builder.append(String.format("%15s %65s %50s %n%n", "search",
                "search for a player with a similar name in the data",
                "name of the player"));

        builder.append("-------------------------------------------------------------------------------------------------------------------------------------------------\n");

        return builder.toString();
    }
}
