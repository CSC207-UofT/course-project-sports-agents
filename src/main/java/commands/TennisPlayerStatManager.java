package commands;

import drivers_adapters.DataContainer;
import player.PlayerList;
import player.TennisPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * This is a class can get statistics for Tennis Players
 */

public class TennisPlayerStatManager extends PlayerStatManager {

    public TennisPlayerStatManager(PlayerList<TennisPlayer> tennisPlayerList) {
        super(tennisPlayerList,
                new HashSet<String>(Arrays.asList("Age", "Aces", "Double Faults",
                        "Serve Points", "First Serves", "Break Points Served")));
    }

    /**
     * Return the specified stat for the specified player in the specified season
     * @param arguments A string array of form
     *                  {"get_player_stat", "Tennis", "player name", "season", "stat name"} or
     *                  {"get_player_stat", "Tennis", "player name", "Country"}
     * @param container
     * @return the specified stat of the player
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String name = arguments.get(2);
        TennisPlayer player = (TennisPlayer) this.playerList.getPlayer(name);

        // TODO: It'd be nice to have all stats as cases, but this is different
        // because it doesn't need the season.
        if (arguments.size() == 4 && arguments.get(3).equals("Country")) {
            return formatStat(player, player.getCountry());
        }

        String season = arguments.get(3);

        String statistic = arguments.get(4);
        checkStatistic(statistic);

        switch(statistic) {
            case "Age":
                return formatStat(player,
                        player.getStatAge(season).toString());
            case "Aces":
                return formatStat(player,
                        player.getStatAces(season).toString());
            case "Double Faults":
                return formatStat(player,
                        player.getStatDoubleFaults(season).toString());
            case "Serve Points":
                return formatStat(player,
                        player.getStatServePoints(season).toString());
            case "First Serves":
                return formatStat(player,
                        player.getStatFirstServes(season).toString());
            case "Break Points Saved":
                return formatStat(player,
                        player.getStatBreakPointsSaved(season).toString());
            default:
                throw new Exception("This shouldn't be thrown, logically");
        }
    }
}
