package commands;

import drivers_adapters.DataContainer;
import player.TennisPlayer;
import player.PlayerList;
import player.TennisPlayerComparator;

import java.util.*;


/**
 * This is a class that compare two tennis players based on the given stat
 * in a given season.
 */

public class TennisPlayerStatComparer extends PlayerStatComparer {

    public TennisPlayerStatComparer(PlayerList<TennisPlayer> tennisPlayerList) {
        super(tennisPlayerList,
                new HashSet<String>(Arrays.asList("Age", "Aces", "Double Faults",
                        "Serve Points", "First Serves", "Break Points Saved")));
    }

    /**
     * Handle an argument requesting a comparison of two or more tennis
     * players' statistics. Players are returned in descending order
     * (best first, worst last)
     * @param arguments A string array of form
     *                  {"compare_player_stat", "Tennis", "player name 1",
     *                  "player name 2", ... , "season", "stat name"}
     * @param container
     * @return the players and their associated statistics
     * @throws Exception if a player does not exist, or lacks data for the
     * given season
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        int argSize = arguments.size();
        List<String> names = arguments.subList(2, argSize - 2);
        List<?> genericPlayers = this.playerList.getPlayers(names);
        List<TennisPlayer> tennisPlayers = castToTennisPlayer(genericPlayers);

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
     * Cast a List of Players to List of TennisPlayers
     * @param genericPlayers List of Player subclass castable to TennisPlayer
     * @return List with original Players cast to TennisPlayer
     */
    private List<TennisPlayer> castToTennisPlayer(List<?> genericPlayers) {
        ArrayList<TennisPlayer> tennisPlayers = new ArrayList<TennisPlayer>();
        for (Object player : genericPlayers) {
            tennisPlayers.add((TennisPlayer) player);
        }
        return tennisPlayers;
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
            case "Age":
                return getValuesAge(players, season);
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
     * Get the age statistics in the given season for all passed players
     * @param players the list of Players to collect age statistics for
     * @param season the season to consider
     * @return the age statistics, for the list of players
     * @throws Exception if one player lacks the given season's age data
     */
    private List<String> getValuesAge(List<TennisPlayer> players,
                                      String season) throws Exception{
        ArrayList<String> ageValues = new ArrayList<String>();
        for (TennisPlayer player : players) {
            ageValues.add(player.getStatAge(season).toString());
        }
        return ageValues;
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
        ArrayList<String> acesValues = new ArrayList<String>();
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
        ArrayList<String> doubleFaultsValues = new ArrayList<String>();
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
        ArrayList<String> servePointsValues = new ArrayList<String>();
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
        ArrayList<String> firstServeValues = new ArrayList<String>();
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
        ArrayList<String> breakPointsSavedValues = new ArrayList<String>();
        for (TennisPlayer player : players) {
            breakPointsSavedValues.add(player.getStatBreakPointsSaved(season).toString());
        }
        return breakPointsSavedValues;
    }
}
