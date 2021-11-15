package commands;

import player.PlayerList;
import player.TennisPlayerComparator;
import player.TennisPlayer;

import java.lang.reflect.Array;
import java.util.*;

/**
 * A class that compare two tennis players, who played in a given competition, based on the given stat.
 */
public class TennisPlayerStatComparer extends PlayerStatComparer {
    private final PlayerList<TennisPlayer> tennisPlayerList;


    public TennisPlayerStatComparer(PlayerList<TennisPlayer> tennisPlayerList) {
        super(new HashSet<>(Arrays.asList("Aces", "Double Faults", "Break Points", "First Serves",
                "Break Points Saved", "Serve Points")));
        this.tennisPlayerList = tennisPlayerList;
    }


    /**
     * Return the player with the highest specified stat (e.g. aces, double faults, first serves, serve points,
     * and break points saved)
     * @param arguments a list in the format: ["command", "sport", "player one", "player two",...., "stat",
     *                  "competition"]
     * @return the player with the higher stat, reported as maximum, and the player with the lower stat, reported
     * as minimum
     * @throws Exception if the players cannot be found, the competition cannot be found, or the specified stat cannot
     * be compared
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        int argSize = arguments.size();
        List<String> names = arguments.subList(2, argSize - 2);
        List<TennisPlayer> tennisPlayers = this.tennisPlayerList.getPlayers(names);

        String season = arguments.get(argSize - 2);

        String statistic = arguments.get(argSize - 1);
        checkStatistic(statistic);

        tennisPlayers.sort(new TennisPlayerComparator(statistic, season));
        Collections.reverse(tennisPlayers);
        List<String> playersStatValues = getStatValues(tennisPlayers,
                statistic, season);
        return formatCompare(tennisPlayers, playersStatValues);
    }

    /**
     * Collect the given statistic in the given season for all Players in
     * the given list, maintaining order.
     * @param players the list of Players to collect statistics for
     * @param statistic the statistic to get
     * @param season the season to consider
     * @return the statistic for each player
     * @throws Exception if one or more statistics are not recorded
     */
    private List<String> getStatValues(List<TennisPlayer> players,
                                       String statistic, String season)
            throws Exception {
        switch (statistic) {
            case "Aces":
                return getValuesAces(players, season);
            case "Double Faults":
                return getValuesDoubleFaults(players, season);
            case "Serve Points":
                return getValuesServePoints(players, season);
            case "First Serves":
                return getValuesFirstServes(players, season);
            case "Break Points Saved":
                return getValuesBreakPointsSaved(players, season);
            default:
                throw new Exception("This shouldn't logically be thrown!");
        }
    }

    /**
     * Get the aces statistics in the given season for all passed players
     * @param players the list of Players to collect aces statistics for
     * @param season the season to consider
     * @return the aces statistics, for the list of players
     * @throws Exception if one player lacks the given season's aces data
     */
    private List<String> getValuesAces(List<TennisPlayer> players,
                                       String season) throws Exception{
        ArrayList<String> acesValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            acesValues.add(player.getStatAces(season).toString());
        }
        return acesValues;
    }

    /**
     * Get the double faults statistics in the given season for all passed players
     * @param players the list of Players to collect double faults statistics for
     * @param season the season to consider
     * @return the double faults statistics, for the list of players
     * @throws Exception if one player lacks the given season's double faults data
     */
    private List<String> getValuesDoubleFaults(List<TennisPlayer> players,
                                               String season) throws Exception{
        ArrayList<String> doubleFaultsValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            doubleFaultsValues.add(player.getStatDoubleFaults(season).toString());
        }
        return doubleFaultsValues;
    }

    /**
     * Get the serve points statistics in the given season for all passed players
     * @param players the list of Players to collect serve points statistics for
     * @param season the season to consider
     * @return the serve points statistics, for the list of players
     * @throws Exception if one player lacks the given season's serve points data
     */
    private List<String> getValuesServePoints(List<TennisPlayer> players,
                                              String season) throws Exception{
        ArrayList<String> servePointsValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            servePointsValues.add(player.getStatServePoints(season).toString());
        }
        return servePointsValues;
    }

    /**
     * Get the first serve statistics in the given season for all passed players
     * @param players the list of Players to collect first serve statistics for
     * @param season the season to consider
     * @return the first serve statistics, for the list of players
     * @throws Exception if one player lacks the given season's first serve data
     */
    private List<String> getValuesFirstServes(List<TennisPlayer> players,
                                              String season) throws Exception{
        ArrayList<String> firstServeValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            firstServeValues.add(player.getStatFirstServes(season).toString());
        }
        return firstServeValues;
    }

    /**
     * Get the break points saved statistics in the given season for all passed players
     * @param players the list of Players to collect break points saved statistics for
     * @param season the season to consider
     * @return the break points saved statistics, for the list of players
     * @throws Exception if one player lacks the given season's break points saved data
     */
    private List<String> getValuesBreakPointsSaved(List<TennisPlayer> players,
                                                   String season) throws Exception{
        ArrayList<String> breakPointsSavedValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            breakPointsSavedValues.add(player.getStatBreakPointsSaved(season).toString());
        }
        return breakPointsSavedValues;
    }
}
