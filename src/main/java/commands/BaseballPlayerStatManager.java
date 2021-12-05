package commands;

import driversAdapters.DataContainer;
import player.*;

import java.util.*;

public class BaseballPlayerStatManager extends PlayerStatManager {

    public BaseballPlayerStatManager() {
        super(
                new HashSet<>(Arrays.asList("Team",
                        "Position", "Games Played", "At Bats", "Runs",
                        "Hits", "Home Runs", "Runs Batted In", "Strike Outs", "Average")));
    }

    /**
     * Handle an argument requesting a player's statistics
     * @param arguments A string array of form
     *                  {"Baseball", "player name", "season", "stat name"}
     * @param container A container containing the data or means to retrieve it
     * @return the requested statistic
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String name = arguments.get(1);
        BaseballPlayer player = (BaseballPlayer) container.getPlayer("baseball", name);

        String season = arguments.get(2);

        String statistic = arguments.get(3);
        checkStatistic(statistic);

        switch (statistic) {
            case "Team":
                return formatStat(player, statistic, player.getStatTeam(season));
            case "position":
                return formatStat(player, statistic, player.getStatPosition(season));
            case "Games Played":
                return formatStat(player, statistic, player.getStatGamesPlayed(season).toString());
            case "At Bats":
                return formatStat(player, statistic, player.getStatAtBats(season).toString());
            case "Runs":
                return formatStat(player, statistic, player.getStatRuns(season).toString());
            case "Hits":
                return formatStat(player, statistic, player.getStatHits(season).toString());
            case "Home Runs":
                return formatStat(player, statistic, player.getStatHomeRuns(season).toString());
            case "Runs Batted In":
                return formatStat(player, statistic, player.getStatRunsBattedIn(season).toString());
            case "Strike Outs":
                return formatStat(player, statistic, player.getStatStrikeOuts(season).toString());
            case "Average":
                return formatStat(player, statistic, player.getStatAvg(season).toString());
            default:
                throw new Exception("This shouldn't be thrown, logically");
        }
    }
}
