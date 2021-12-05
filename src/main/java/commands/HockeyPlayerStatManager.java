package commands;

import driversAdapters.DataContainer;
import player.HockeyPlayer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

public class HockeyPlayerStatManager extends PlayerStatManager {

    public HockeyPlayerStatManager() {
        super(
                new HashSet<>(Arrays.asList("Team", "Skater Shoots",
                        "Position", "Games Played", "Goals", "Assists",
                        "Points", "Shots", "Shooting Percentage")));
    }

    /**
     * Handle an argument requesting a player's statistics
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
            case "Team":
                return formatStat(player, statistic, player.getStatTeam(season));
            case "Skater Shoots":
                return formatStat(player, statistic, player.getStatSkaterShoots(season));
            case "Position":
                return formatStat(player, statistic, player.getStatPosition(season));
            case "Games Played":
                return formatStat(player, statistic, player.getStatGamesPlayed(season).toString());
            case "Goals":
                return formatStat(player, statistic, player.getStatGoals(season).toString());
            case "Assists":
                return formatStat(player, statistic, player.getStatAssists(season).toString());
            case "Points":
                return formatStat(player, statistic, player.getStatPoints(season).toString());
            case "Shots":
                return formatStat(player, statistic, player.getStatShots(season).toString());
            case "Shooting Percentage":
                return formatStat(player, statistic, player.getStatShootingPercentage(season).toString());
            case "All Stats":
                return formatStat(player, statistic, player.printSeasonData(season));
            default:
                throw new Exception("This shouldn't be thrown, logically");
        }
    }
}
