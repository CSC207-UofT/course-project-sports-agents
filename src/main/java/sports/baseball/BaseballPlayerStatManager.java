package sports.baseball;

import driversAdapters.DataContainer;
import commands.PlayerStatManager;

import java.util.*;

public class BaseballPlayerStatManager extends PlayerStatManager {

    public BaseballPlayerStatManager() {
        super(
                new HashSet<>(Arrays.asList("team",
                        "position", "games played", "at bats", "runs",
                        "hits", "home runs", "runs batted in", "strike outs", "average")));
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
            case "team":
                return formatStat(player, statistic, player.getStatTeam(season));
            case "position":
                return formatStat(player, statistic, player.getStatPosition(season));
            case "games played":
                return formatStat(player, statistic, player.getStatGamesPlayed(season).toString());
            case "at bats":
                return formatStat(player, statistic, player.getStatAtBats(season).toString());
            case "runs":
                return formatStat(player, statistic, player.getStatRuns(season).toString());
            case "hits":
                return formatStat(player, statistic, player.getStatHits(season).toString());
            case "home runs":
                return formatStat(player, statistic, player.getStatHomeRuns(season).toString());
            case "runs batted in":
                return formatStat(player, statistic, player.getStatRunsBattedIn(season).toString());
            case "strike outs":
                return formatStat(player, statistic, player.getStatStrikeOuts(season).toString());
            case "average":
                return formatStat(player, statistic, player.getStatAvg(season).toString());
            default:
                throw new Exception("This shouldn't be thrown, logically");
        }
    }
}
