package commands;

import drivers_adapters.DataContainer;
import player.*;

import java.util.*;

public class BaseballPlayerStatManager extends PlayerStatManager {

    public BaseballPlayerStatManager() {
        super(
                new HashSet<String>(Arrays.asList("Team",
                        "Position", "Games Played", "At Bats", "Runs",
                        "Hits", "Home Runs", "Runs Batted In", "Strike Outs", "Average")));
    }

    /**
     * Handle an argument requesting a player's statistics
     * @param arguments A string array of form
     *                  {"get_player_stat", "Baseball", "player name", "season", "stat name"}
     * @return the requested statistic
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String name = arguments.get(2);
        BaseballPlayer player = (BaseballPlayer) container.getPlayer("baseball", name);

        String season = arguments.get(3);

        String statistic = arguments.get(4);
        checkStatistic(statistic);

        switch (statistic) {
            case "Team":
                return formatStat(player, player.getStatTeam(season));
            case "position":
                return formatStat(player, player.getStatPosition(season));
            case "Games Played":
                return formatStat(player, player.getStatGamesPlayed(season).toString());
            case "At Bats":
                return formatStat(player, player.getStatAtBats(season).toString());
            case "Runs":
                return formatStat(player, player.getStatRuns(season).toString());
            case "Hits":
                return formatStat(player, player.getStatHits(season).toString());
            case "Home Runs":
                return formatStat(player, player.getStatHomeRuns(season).toString());
            case "Runs Batted In":
                return formatStat(player, player.getStatRunsBattedIn(season).toString());
            case "Strike Outs":
                return formatStat(player, player.getStatStrikeOuts(season).toString());
            case "Average":
                return formatStat(player, player.getStatAvg(season).toString());
            default:
                throw new Exception("This shouldn't be thrown, logically");
        }
    }
}
