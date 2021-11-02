package commands;

import player.*;

import java.util.*;

public class HockeyPlayerStatManager extends PlayerStatManager {

    public HockeyPlayerStatManager(PlayerList<HockeyPlayer> hockeyPlayerList) {
        super(hockeyPlayerList,
                new HashSet<String>(Arrays.asList("Team", "Skater Shoots",
                        "Position", "Games Played", "Goals", "Assists",
                        "Points", "Shots", "Shooting Percentage")));
    }

    /**
     * Handle an argument requesting a player's statistics
     * @param arguments A string array of form
     *                  {"get_stat", "sport name", "player name",
     *                  "season", "stat name"}
     * @return the requested statistic
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String name = arguments.get(2);
        HockeyPlayer player = (HockeyPlayer) this.playerList.getPlayer(name);
        String season = arguments.get(3);
        String statistic = arguments.get(4);
        checkStatistic(statistic);
        return switch (statistic) {
            case "Team" -> player.getName() + ": " +
                    player.getStatTeam(season);
            case "Skater Shoots" -> player.getName() + ": " +
                    player.getStatSkaterShoots(season);
            case "Position" -> player.getName() + ": " +
                    player.getStatPosition(season);
            case "Games Played" -> player.getName() + ": " +
                    player.getStatGamesPlayed(season);
            case "Goals" -> player.getName() + ": " +
                    player.getStatGoals(season);
            case "Assists" -> player.getName() + ": " +
                    player.getStatAssists(season);
            case "Points" -> player.getName() + ": " +
                    player.getStatPoints(season);
            case "Shots" -> player.getName() + ": " +
                    player.getStatShots(season);
            case "Shooting Percentage" -> player.getName() + ": " +
                    player.getStatShootingPercentage(season);
            default -> throw new Exception("This shouldn't be thrown, logically");
        };
    }
}
