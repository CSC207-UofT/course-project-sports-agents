package commands;

import player.TennisPlayer;
import player.TennisPlayerList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * A class that can report a stat for a tennis player who played at a competition.
 */
public class TennisPlayerStatManager extends PlayerStatManager {
    final TennisPlayerList tennisPlayerList;


    public TennisPlayerStatManager(TennisPlayerList tennisPlayerList) {
        super(new HashSet<>(Arrays.asList("Age", "Country", "Aces", "Double Faults",
                "Serve Points", "First Serves", "Break Points Saved", "All Stats")));
        this.tennisPlayerList = tennisPlayerList;
    }


    /**
     * Return the specified stat for the specified player, who participated in the specified competition
     *
     * @param arguments a list in the format ["command", "sport", "player name", "stat", "competition one"]
     * @return the specified stat of the player
     * @throws Exception if the competition or player could not be found
     */
    @Override
    public String execute(List<String> arguments) throws Exception {
        String name = arguments.get(2);
        TennisPlayer player = this.tennisPlayerList.getPlayer(name);


        if (arguments.size() == 4 && arguments.get(3).equals("Country")) {
            return formatStat(player, player.getCountry());
        }

        String season = arguments.get(3);

        String statistic = arguments.get(4);
        checkStatistic(statistic);

        switch (statistic) {
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
            case "All Stats":
                return formatStat(player, player.printSeasonData(season));
            default:
                throw new Exception("This shouldn't be thrown, logically");
        }
    }
}
