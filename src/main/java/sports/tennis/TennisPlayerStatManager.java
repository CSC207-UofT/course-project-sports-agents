package sports.tennis;

import constants.Exceptions;
import driversAdapters.DataContainer;
import commands.PlayerStatManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * This is a class can get statistics for Tennis Players
 */
public class TennisPlayerStatManager extends PlayerStatManager {

    public TennisPlayerStatManager() {
        super(
                new HashSet<>(Arrays.asList("country", "rank", "matches", "aces", "double faults", "serve points won",
                        "break points saved", "serve games won", "return games won", "break points converted",
                        "return points won", "all")));
    }

    /**
     * Return the specified stat for the specified player in the specified season
     * @param arguments A string array of form
     *                  { "tennis", "player name", "season", "stat name"} or
     *                  {"tennis", "player name", "country"}
     * @param container A container containing the data or means to retrieve it
     * @return the specified stat of the player
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String name = arguments.get(1);
        TennisPlayer player = (TennisPlayer) container.getPlayer("tennis", name);

        String season = arguments.get(2);

        String statistic = arguments.get(3).toLowerCase();
        checkStatistic(statistic);

        switch (statistic) {
            case "country":
                checkCountrySeason(player, season);
                return formatStat(player, statistic, player.getCountry());
            case "rank":
                return formatStat(player, statistic,
                        player.getStatRank(season).toString());
            case "matches":
                return formatStat(player, statistic,
                        player.getStatMatches(season).toString());
            case "aces":
                return formatStat(player, statistic,
                        player.getStatAces(season).toString());
            case "double faults":
                return formatStat(player, statistic,
                        player.getStatDoubleFaults(season).toString());
            case "serve points won":
                return formatStat(player, statistic,
                        player.getStatServePointsWon(season).toString());
            case "break points saved":
                return formatStat(player, statistic,
                        player.getStatBreakPointsSaved(season).toString());
            case "serve games won":
                return formatStat(player, statistic,
                        player.getStatServeGamesWon(season).toString());
            case "return games won":
                return formatStat(player, statistic,
                        player.getStatReturnGamesWon(season).toString());
            case "break points converted":
                return formatStat(player, statistic,
                        player.getStatBreakPointsConverted(season).toString());
            case "return points won":
                return formatStat(player, statistic,
                        player.getStatReturnPointsWon(season).toString());
            case "all":
                return formatStat(player, statistic, player.getSeasonData(season));
            default:
                throw new Exception("This shouldn't be thrown, logically");
        }
    }

    /**
     * Check if the player participated in the given season
     * @param player the player of interest
     * @param season the season of interest
     * @throws Exception if the player did not participate in that season
     */
    private void checkCountrySeason(TennisPlayer player, String season) throws Exception {
        if (!(player.getSeasons().contains(season))) {
            throw new Exception(Exceptions.INVALID_SEASON);
        }
    }
}
