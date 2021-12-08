package sports.tennis;

import driversAdapters.DataContainer;
import commands.PlayerStatComparer;

import java.util.*;


/**
 * This is a class that compare two tennis players based on the given stat
 * in a given season.
 */

public class TennisPlayerStatComparer extends PlayerStatComparer {

    public TennisPlayerStatComparer() {
        super(
                new HashSet<>(Arrays.asList("rank", "matches", "aces", "double faults", "serve points won",
                        "break points saved", "serve games won", "return games won", "break points converted",
                        "return points won")));
    }

    /**
     * Handle an argument requesting a comparison of two or more tennis
     * players' statistics. Players are returned in descending order
     * (best first, worst last)
     *
     * @param arguments A string array of form
     *                  {"Tennis", "player name 1",
     *                  "player name 2", ... , "season", "stat name"}
     * @param container A container containing the data or means to retrieve it
     * @return the players and their associated statistics
     * @throws Exception if a player does not exist, or lacks data for the
     *                   given season
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        int argSize = arguments.size();
        List<String> names = arguments.subList(1, argSize - 2);

        ArrayList<TennisPlayer> tennisPlayers = new ArrayList<>();
        for (String name : names) {
            tennisPlayers.add((TennisPlayer) container.getPlayer("tennis", name));
        }

        String season = arguments.get(argSize - 2);

        String statistic = arguments.get(argSize - 1);
        checkStatistic(statistic);

        tennisPlayers.sort(new TennisPlayerComparator(statistic, season));
        Collections.reverse(tennisPlayers);
        List<String> playersStatValues = getStatValues(tennisPlayers,
                statistic, season);
        return formatCompare(tennisPlayers, statistic, playersStatValues);
    }

    /**
     * Collect the given statistic in the given season for all Players in
     * the given list, maintaining order.
     *
     * @param players   the list of Players to collect statistics for
     * @param statistic the statistic to get
     * @param season    the season to consider
     * @return the statistic for each player
     * @throws Exception if one or more statistics are not recorded
     */
    private List<String> getStatValues(List<TennisPlayer> players,
                                       String statistic, String season)
            throws Exception {
        switch (statistic) {
            case "rank":
                return getValuesRank(players, season);
            case "matches":
                return getValuesMatches(players, season);
            case "aces":
                return getValuesAces(players, season);
            case "double faults":
                return getValuesDoubleFaults(players, season);
            case "serve points won":
                return getValuesServePointsWon(players, season);
            case "break points saved":
                return getValuesBreakPointsSaved(players, season);
            case "serve games won":
                return getValuesServeGamesWon(players, season);
            case "return games won":
                return getValuesReturnGamesWon(players, season);
            case "break points converted":
                return getValuesBreakPointsConverted(players, season);
            case "return points won":
                return getValuesReturnPointsWon(players, season);
            default:
                throw new Exception("This shouldn't logically be thrown!");
        }
    }


    /**
     * Get the rank statistics in the given season for all given players
     *
     * @param players the list of players to collect ranks for
     * @param season  the season of interest
     * @return the ranks for the list of players
     * @throws Exception if a player does not have a rank for the given season
     */
    private List<String> getValuesRank(List<TennisPlayer> players, String season) throws Exception {
        List<String> rankValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            rankValues.add(player.getStatRank(season).toString());
        }
        return rankValues;
    }

    /**
     * Get the number of matches played in the given season for all given players
     *
     * @param players the list of players to collect number of matches for
     * @param season  the season of interest
     * @return the number of matches played by the players in the list of players in the given season
     * @throws Exception if a player does not have matches data for the given season
     */
    private List<String> getValuesMatches(List<TennisPlayer> players, String season) throws Exception {
        List<String> matchValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            matchValues.add(player.getStatMatches(season).toString());
        }
        return matchValues;
    }

    /**
     * Get the aces statistics in the given season for all passed players
     *
     * @param players the list of Players to collect aces statistics for
     * @param season  the season to consider
     * @return the aces statistics, for the list of players
     * @throws Exception if one player lacks the given season's aces data
     */
    private List<String> getValuesAces(List<TennisPlayer> players,
                                       String season) throws Exception {
        ArrayList<String> acesValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            acesValues.add(player.getStatAces(season).toString());
        }
        return acesValues;
    }

    /**
     * Get the double faults statistics in the given season for all passed players
     *
     * @param players the list of Players to collect double faults statistics for
     * @param season  the season to consider
     * @return the double faults statistics, for the list of players
     * @throws Exception if one player lacks the given season's double faults data
     */
    private List<String> getValuesDoubleFaults(List<TennisPlayer> players,
                                               String season) throws Exception {
        ArrayList<String> doubleFaultsValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            doubleFaultsValues.add(player.getStatDoubleFaults(season).toString());
        }
        return doubleFaultsValues;
    }

    /**
     * Get the serve points won statistics in the given season for all passed players
     *
     * @param players the list of Players to collect serve points statistics for
     * @param season  the season to consider
     * @return the serve points won statistics, for the list of players
     * @throws Exception if one player lacks the given season's serve points won data
     */
    private List<String> getValuesServePointsWon(List<TennisPlayer> players,
                                                 String season) throws Exception {
        ArrayList<String> servePointsValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            servePointsValues.add(player.getStatServePointsWon(season).toString());
        }
        return servePointsValues;
    }


    /**
     * Get the break points saved statistics in the given season for all passed players
     *
     * @param players the list of Players to collect break points saved statistics for
     * @param season  the season to consider
     * @return the break points saved statistics, for the list of players
     * @throws Exception if one player lacks the given season's break points saved data
     */
    private List<String> getValuesBreakPointsSaved(List<TennisPlayer> players,
                                                   String season) throws Exception {
        ArrayList<String> breakPointsSavedValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            breakPointsSavedValues.add(player.getStatBreakPointsSaved(season).toString());
        }
        return breakPointsSavedValues;
    }

    /**
     * Get the percentage of serve games won for all given players
     *
     * @param players the list of needed players
     * @param season  the season of interest
     * @return list of percentage of serve games won for given players
     * @throws Exception if a player does not have serve games won data for the given season
     */
    private List<String> getValuesServeGamesWon(List<TennisPlayer> players, String season) throws Exception {
        List<String> serveGamesWonValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            serveGamesWonValues.add(player.getStatServeGamesWon(season).toString());
        }
        return serveGamesWonValues;
    }

    /**
     * Get the percentage of return games won for all given players
     *
     * @param players the list of needed players
     * @param season  the season of interest
     * @return list of percentage of return games won for the given players
     * @throws Exception if a player does not have return games won data for the given season
     */
    private List<String> getValuesReturnGamesWon(List<TennisPlayer> players, String season) throws Exception {
        List<String> returnGamesWonValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            returnGamesWonValues.add(player.getStatReturnGamesWon(season).toString());
        }
        return returnGamesWonValues;
    }

    /**
     * Get the percentage of break points converted for all given players
     *
     * @param players the list of needed players
     * @param season  the season of interest
     * @return list of percentage of break points converted for the given players
     * @throws Exception if a player does not have break points converted data for the given season
     */
    private List<String> getValuesBreakPointsConverted(List<TennisPlayer> players, String season) throws Exception {
        List<String> breakPointsConvertedValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            breakPointsConvertedValues.add(player.getStatBreakPointsConverted(season).toString());
        }
        return breakPointsConvertedValues;
    }

    /**
     * Get the percentage of return points won for all given players
     *
     * @param players the list of needed players
     * @param season  the season of interest
     * @return list of percentage of return points won for the given players
     * @throws Exception if a player does not have return points on data for the given season
     */
    private List<String> getValuesReturnPointsWon(List<TennisPlayer> players, String season) throws Exception {
        List<String> returnPointsWonValues = new ArrayList<>();
        for (TennisPlayer player : players) {
            returnPointsWonValues.add(player.getStatReturnPointsWon(season).toString());
        }
        return returnPointsWonValues;
    }
}
