package sports.hockey;

import commands.PlayerStatManager;
import driversAdapters.DataContainer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

public class HockeyPlayerStatManager extends PlayerStatManager {

    public HockeyPlayerStatManager() {
        super(
                new HashSet<>(Arrays.asList("team", "skater shoots",
                        "position", "games played", "goals", "assists",
                        "points", "shots", "shooting percentage", "all stats")));
    }

    /**
     * Handle an argument requesting a player's statistics
     *
     * @param arguments A string array of form
     *                  {"Hockey", "player name", "season", "stat name"}
     * @param container A container containing the data or means to retrieve it
     * @return the requested statistic
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String name = arguments.get(1);
        HockeyPlayer player = (HockeyPlayer) container.getPlayer("hockey", name);

        String season = arguments.get(2);

        String statistic = arguments.get(3);
        checkStatistic(statistic);

        switch (statistic) {
            case "team":
                return formatStat(player, statistic, player.getStatTeam(season));
            case "skater shoots":
                return formatStat(player, statistic, player.getStatSkaterShoots(season));
            case "position":
                return formatStat(player, statistic, player.getStatPosition(season));
            case "games played":
                return formatStat(player, statistic, player.getStatGamesPlayed(season).toString());
            case "goals":
                return formatStat(player, statistic, player.getStatGoals(season).toString());
            case "assists":
                return formatStat(player, statistic, player.getStatAssists(season).toString());
            case "points":
                return formatStat(player, statistic, player.getStatPoints(season).toString());
            case "shots":
                return formatStat(player, statistic, player.getStatShots(season).toString());
            case "shooting percentage":
                return formatStat(player, statistic, player.getStatShootingPercentage(season).toString());
            case "all stats":
                return formatStat(player, statistic, player.getSeasonData(season));
            default:
                throw new Exception("This shouldn't be thrown, logically");
        }
    }
}
