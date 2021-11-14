package commands;

import player.*;

import java.util.*;

public class BaseballPlayerStatComparer extends PlayerStatComparer{

    public BaseballPlayerStatComparer(PlayerList<BaseballPlayer> baseballPlayerList) {
        super(baseballPlayerList,
                new HashSet<String>(Arrays.asList("Games Played", "At Bats", "Runs",
                        "Hits", "Home Runs", "Runs Batted In", "Strike Outs", "Average")));
    }

    /**
     * Handle an argument requesting a comparison of two or more Baseball
     * players' statistics. Players are returned in descending order
     * (best first, worst last)
     * @param arguments A string array of form
     *                  {"compare_player_stat", "Baseball", "player name 1",
     *                  "player name 2", ... , "season", "stat name"}
     * @return the players and their associated statistics
     * @throws Exception if a player does not exists, or lacks data for the
     * given season
     */
    @Override
    public String execute(List<String> arguments) throws Exception {
        int argSize = arguments.size();
        List<String> names = arguments.subList(2, argSize - 2);
        List<?> genericPlayers = this.playerList.getPlayers(names);
        List<BaseballPlayer> baseballPlayers = castToBaseballPlayer(genericPlayers);

        String season = arguments.get(argSize - 2);

        String statistic = arguments.get(argSize - 1);
        checkStatistic(statistic);

        baseballPlayers.sort(new BaseballPlayerComparator(statistic, season));
        Collections.reverse(baseballPlayers);
        List<String> playersStatValues = getStatValues(baseballPlayers,
                statistic, season);
        return formatCompare(baseballPlayers, playersStatValues);
    }

    // TODO: Is there a better way to do this?
    /**
     * Cast a List of Players to List of HockeyPlayers
     * @param genericPlayers List of Player subclass castable to HockeyPlayer
     * @return List with original Players cast to HockeyPlayer
     */
    private List<BaseballPlayer> castToBaseballPlayer(List<?> genericPlayers) {
        ArrayList<BaseballPlayer> baseballPlayers = new ArrayList<>();
        for (Object player : genericPlayers) {
            baseballPlayers.add((BaseballPlayer) player);
        }
        return baseballPlayers;
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
    private List<String> getStatValues(List<BaseballPlayer> players,
                                       String statistic, String season)
            throws Exception {
        switch (statistic) {
            case "Games Played":
                return getValuesGamesPlayed(players, season);
            case "At Bats":
                return getValuesAtBats(players, season);
            case "Runs":
                return getValuesRuns(players, season);
            case "Hits":
                return getValuesHits(players, season);
            case "Home Runs":
                return getValuesHomeRuns(players, season);
            case "Runs Batted In":
                return getValuesRunsBattedIn(players, season);
            case "Strike Outs":
                return getValuesStrikeOuts(players, season);
            case "Average":
                return getValuesAverage(players, season);
            default:
                throw new Exception("This shouldn't logically be thrown!");
        }
    }

    /**
     * Get the games played statistic in the given season for all passed players
     * @param players the list of Players to collect games played statistics for
     * @param season the season to consider
     * @return the games played statistics, for the list of players
     * @throws Exception if one player lacks the given season's games played data
     */
    private List<String> getValuesGamesPlayed(List<BaseballPlayer> players,
                                              String season) throws Exception{
        ArrayList<String> gamesPlayedValues = new ArrayList<String>();
        for (BaseballPlayer player : players) {
            gamesPlayedValues.add(player.getStatGamesPlayed(season).toString());
        }
        return gamesPlayedValues;
    }

    /**
     * Get the goals statistic in the given season for all passed players
     * @param players the list of Players to collect at bats statistics for
     * @param season the season to consider
     * @return the at bats statistics, for the list of players
     * @throws Exception if one player lacks the given season's goals data
     */
    private List<String> getValuesAtBats(List<BaseballPlayer> players,
                                         String season) throws Exception{
        ArrayList<String> AtBatsValues = new ArrayList<String>();
        for (BaseballPlayer player : players) {
            AtBatsValues.add(player.getStatAtBats(season).toString());
        }
        return AtBatsValues;
    }

    /**
     * Get the assists statistic in the given season for all passed players
     * @param players the list of Players to collect runs statistics for
     * @param season the season to consider
     * @return the runs statistics, for the list of players
     * @throws Exception if one player lacks the given season's assists data
     */
    private List<String> getValuesRuns(List<BaseballPlayer> players,
                                       String season) throws Exception{
        ArrayList<String> RunsValues = new ArrayList<String>();
        for (BaseballPlayer player : players) {
            RunsValues.add(player.getStatRuns(season).toString());
        }
        return RunsValues;
    }

    /**
     * Get the points statistic in the given season for all passed players
     * @param players the list of Players to collect hits statistics for
     * @param season the season to consider
     * @return the hits statistics, for the list of players
     * @throws Exception if one player lacks the given season's points data
     */
    private List<String> getValuesHits(List<BaseballPlayer> players,
                                       String season) throws Exception{
        ArrayList<String> HitsValues = new ArrayList<String>();
        for (BaseballPlayer player : players) {
            HitsValues.add(player.getStatHits(season).toString());
        }
        return HitsValues;
    }

    /**
     * Get the shots statistic in the given season for all passed players
     * @param players the list of Players to collect home runs statistics for
     * @param season the season to consider
     * @return the home runs statistics, for the list of players
     * @throws Exception if one player lacks the given season's shot data
     */
    private List<String> getValuesHomeRuns(List<BaseballPlayer> players,
                                           String season) throws Exception{
        ArrayList<String> HomeRunsValues = new ArrayList<String>();
        for (BaseballPlayer player : players) {
            HomeRunsValues.add(player.getStatHomeRuns(season).toString());
        }
        return HomeRunsValues;
    }

    /**
     * Get the Shooting percentage statistic in the given season for all passed players
     * @param players the list of Players to collect runs batted in statistics for
     * @param season the season to consider
     * @return the runs batted in statistics, for the list of players
     * @throws Exception if one player lacks the given season's shooting percentage data
     */
    private List<String> getValuesRunsBattedIn(List<BaseballPlayer> players,
                                               String season) throws Exception{
        ArrayList<String> RunsBattedInValues = new ArrayList<String>();
        for (BaseballPlayer player : players) {
            RunsBattedInValues.add(player.getStatRunsBattedIn(season).toString());
        }
        return RunsBattedInValues;
    }

    /**
     * Get the Shooting percentage statistic in the given season for all passed players
     * @param players the list of Players to collect strike outs statistics for
     * @param season the season to consider
     * @return the strike outs statistics, for the list of players
     * @throws Exception if one player lacks the given season's shooting percentage data
     */
    private List<String> getValuesStrikeOuts(List<BaseballPlayer> players,
                                             String season) throws Exception{
        ArrayList<String> ShootingPercentageValues = new ArrayList<String>();
        for (BaseballPlayer player : players) {
            ShootingPercentageValues.add(player.getStatStrikeOuts(season).toString());
        }
        return ShootingPercentageValues;
    }


    /**
     * Get the Shooting percentage statistic in the given season for all passed players
     * @param players the list of Players to collect average statistics for
     * @param season the season to consider
     * @return the average statistics, for the list of players
     * @throws Exception if one player lacks the given season's shooting percentage data
     */
    private List<String> getValuesAverage(List<BaseballPlayer> players,
                                          String season) throws Exception{
        ArrayList<String> AverageValues = new ArrayList<String>();
        for (BaseballPlayer player : players) {
            AverageValues.add(player.getStatAvg(season).toString());
        }
        return AverageValues;
    }
}
