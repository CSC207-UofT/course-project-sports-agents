package commands;

import player.PlayerList;
import player.HockeyPlayer;

import java.util.List;
import java.util.HashSet;
import java.util.Arrays;

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
     *                  {"get_player_stat", "Hockey", "player name", "season", "stat name"}
     * @return the requested statistic
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(List<String> arguments) throws Exception {
        String name = arguments.get(2);
        HockeyPlayer player = (HockeyPlayer) this.playerList.getPlayer(name);

        String season = arguments.get(3);

        String statistic = arguments.get(4);
        checkStatistic(statistic);

        switch (statistic) {
            case "Team":
                return formatStat(player, player.getStatTeam(season));
            case "Skater Shoots":
                return formatStat(player, player.getStatSkaterShoots(season).toString());
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
            default:
                throw new Exception("This shouldn't be thrown, logically");
        }
    }
}
