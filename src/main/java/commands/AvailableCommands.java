package commands;

import constants.CommandsInfo;
import driversAdapters.DataContainer;

import java.util.ArrayList;

public class AvailableCommands implements Command {

    /**
     * Outputs a table showing all of the available commands when run
     * @param arguments an ArrayList of Strings containing arguments for the command. If this command was called,
     *                  the list will be empty.
     * @param container data container used in order to retrieve data. Not used by this command.
     * @return returns a string, which is a table displaying available commands.
     * @throws Exception in case of an unexpected error
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {

        StringBuilder builder = new StringBuilder();

        builder.append("These are the available commands and their arguments in our app: \n");
        addSeparator(builder);
        builder.append(String.format("%-25s %100s %n", "Keyword", "Description"));
        builder.append("\n");
        builder.append("Usage\n");
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.AvailableCommandsInfo.keyword,
                CommandsInfo.AvailableCommandsInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.AvailableCommandsInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.GetListPlayersInfo.keyword,
                CommandsInfo.GetListPlayersInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.GetListPlayersInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.GetListSportsInfo.keyword,
                CommandsInfo.GetListSportsInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.GetListSportsInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.GetListStatsInfo.keyword,
                CommandsInfo.GetListStatsInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.GetListStatsInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.SearchInfo.keyword,
                CommandsInfo.SearchInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.SearchInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.GetPlayerStatInfo.keyword,
                CommandsInfo.GetPlayerStatInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.GetPlayerStatInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.ComparePlayerStatInfo.keyword,
                CommandsInfo.ComparePlayerStatInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.ComparePlayerStatInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.PredictPlayerStatInfo.keyword,
                CommandsInfo.PredictPlayerStatInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.PredictPlayerStatInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.GetTeamStatInfo.keyword,
                CommandsInfo.GetTeamStatInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.GetTeamStatInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.AddMemberInfo.keyword,
                CommandsInfo.AddMemberInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.AddMemberInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.CreateMatchInfo.keyword,
                CommandsInfo.CreateMatchInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.CreateMatchInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.BetInfo.keyword,
                CommandsInfo.BetInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.BetInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.ResolveMatchInfo.keyword,
                CommandsInfo.ResolveMatchInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.ResolveMatchInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.MemberInfoInfo.keyword,
                CommandsInfo.MemberInfoInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.MemberInfoInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.SaveInfo.keyword,
                CommandsInfo.SaveInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.SaveInfo.usage));
        addSeparator(builder);

        builder.append(String.format("%-25s %100s %n%n",
                CommandsInfo.LoadInfo.keyword,
                CommandsInfo.LoadInfo.description));
        builder.append(String.format("Usage: %s %n", CommandsInfo.LoadInfo.usage));
        addSeparator(builder);

        return builder.toString();
    }

    /**
     * Add a line to easily distinguish rows in a table
     * @param builder currently used builder to build the output string
     */
    private void addSeparator(StringBuilder builder) {
        builder.append("-----------------------------------------------------------------------------------------------------------------------------\n");
    }
}
