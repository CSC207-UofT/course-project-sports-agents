package commands;

import drivers_adapters.DataContainer;
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
                return formatStat(player, player.getStatTeam(season));
            case "Skater Shoots":
                return formatStat(player, player.getStatSkaterShoots(season));
            case "Position":
                return formatStat(player, player.getStatPosition(season));
            case "Games Played":
                return formatStat(player, player.getStatGamesPlayed(season).toString());
            case "Goals":
                return formatStat(player, player.getStatGoals(season).toString());
            case "Assists":
                return formatStat(player, player.getStatAssists(season).toString());
            case "Points":
                return formatStat(player, player.getStatPoints(season).toString());
            case "Shots":
                return formatStat(player, player.getStatShots(season).toString());
            case "Shooting Percentage":
                return formatStat(player, player.getStatShootingPercentage(season).toString());
            case "All Stats":
                return formatStat(player, player.printSeasonData(season));
            default:
                throw new Exception("This shouldn't be thrown, logically");
        }
    }
}
