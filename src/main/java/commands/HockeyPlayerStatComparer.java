package commands;

import player.PlayerList;
import player.HockeyPlayer;
import player.HockeyPlayerComparator;

import java.util.List;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;

public class HockeyPlayerStatComparer extends PlayerStatComparer {

    public HockeyPlayerStatComparer(PlayerList<HockeyPlayer> hockeyPlayerList) {
        super(hockeyPlayerList,
                new HashSet<String>(Arrays.asList("Skater Shoots",
                        "Games Played", "Goals", "Assists", "Points",
                        "Shots", "Shooting Percentage")));
    }

    /**
     * Handle an argument requesting a comparison of two or more hockey
     * players' statistics. Players are returned in descending order
     * (best first, worst last)
     * @param arguments A string array of form
     *                  {"compare_player_stat", "Hockey", "player name 1",
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
        List<HockeyPlayer> hockeyPlayers = castToHockeyPlayer(genericPlayers);

        String season = arguments.get(argSize - 2);

        String statistic = arguments.get(argSize - 1);
        checkStatistic(statistic);

        hockeyPlayers.sort(new HockeyPlayerComparator(statistic, season));
        List<String> playersStatValues = getStatValues(hockeyPlayers,
                statistic, season);
        return formatCompare(hockeyPlayers, playersStatValues);
    }

    // TODO: Is there a better way to do this?
    /**
     * Cast a List of Players to List of HockeyPlayers
     * @param genericPlayers List of Player subclass castable to HockeyPlayer
     * @return List with original Players cast to HockeyPlayer
     */
    private List<HockeyPlayer> castToHockeyPlayer(List<?> genericPlayers) {
        ArrayList<HockeyPlayer> hockeyPlayers = new ArrayList<HockeyPlayer>();
        for (Object player : genericPlayers) {
            hockeyPlayers.add((HockeyPlayer) player);
        }
        return hockeyPlayers;
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
    private List<String> getStatValues(List<HockeyPlayer> players,
                                            String statistic, String season)
            throws Exception {
        switch (statistic) {
            case "Skater Shoots":
                return getValuesSkaterShoots(players, season);
            case "Games Played":
                return getValuesGamesPlayed(players, season);
            case "Goals":
                return getValuesGoals(players, season);
            case "Assists":
                return getValuesAssists(players, season);
            case "Points":
                return getValuesPoints(players, season);
            case "Shots":
                return getValuesShots(players, season);
            case "Shooting Percentage":
                return getValuesShootingPercentage(players, season);
            default:
                throw new Exception("This shouldn't logically be thrown!");
        }
    }

    /**
     * Get the skater shoots statistic in the given season for all passed players
     * @param players the list of Players to collect skater shoot statistics for
     * @param season the season to consider
     * @return the skater shoot statistics, for the list of players
     * @throws Exception if one player lacks the given season's skater shoot data
     */
    private List<String> getValuesSkaterShoots(List<HockeyPlayer> players,
                                                    String season) throws Exception{
        ArrayList<String> skaterShootsValues = new ArrayList<String>();
        for (HockeyPlayer player : players) {
            skaterShootsValues.add(player.getStatSkaterShoots(season).toString());
        }
        return skaterShootsValues;
    }

    /**
     * Get the games played statistic in the given season for all passed players
     * @param players the list of Players to collect games played statistics for
     * @param season the season to consider
     * @return the games played statistics, for the list of players
     * @throws Exception if one player lacks the given season's games played data
     */
    private List<String> getValuesGamesPlayed(List<HockeyPlayer> players,
                                                   String season) throws Exception{
        ArrayList<String> gamesPlayedValues = new ArrayList<String>();
        for (HockeyPlayer player : players) {
            gamesPlayedValues.add(player.getStatGamesPlayed(season).toString());
        }
        return gamesPlayedValues;
    }

    /**
     * Get the goals statistic in the given season for all passed players
     * @param players the list of Players to collect goals statistics for
     * @param season the season to consider
     * @return the goals statistics, for the list of players
     * @throws Exception if one player lacks the given season's goals data
     */
    private List<String> getValuesGoals(List<HockeyPlayer> players,
                                             String season) throws Exception{
        ArrayList<String> goalsValues = new ArrayList<String>();
        for (HockeyPlayer player : players) {
            goalsValues.add(player.getStatGoals(season).toString());
        }
        return goalsValues;
    }

    /**
     * Get the assists statistic in the given season for all passed players
     * @param players the list of Players to collect assists statistics for
     * @param season the season to consider
     * @return the assists statistics, for the list of players
     * @throws Exception if one player lacks the given season's assists data
     */
    private List<String> getValuesAssists(List<HockeyPlayer> players,
                                               String season) throws Exception{
        ArrayList<String> assistsValues = new ArrayList<String>();
        for (HockeyPlayer player : players) {
            assistsValues.add(player.getStatAssists(season).toString());
        }
        return assistsValues;
    }

    /**
     * Get the points statistic in the given season for all passed players
     * @param players the list of Players to collect points statistics for
     * @param season the season to consider
     * @return the points statistics, for the list of players
     * @throws Exception if one player lacks the given season's points data
     */
    private List<String> getValuesPoints(List<HockeyPlayer> players,
                                              String season) throws Exception{
        ArrayList<String> pointsValues = new ArrayList<String>();
        for (HockeyPlayer player : players) {
            pointsValues.add(player.getStatPoints(season).toString());
        }
        return pointsValues;
    }

    /**
     * Get the shots statistic in the given season for all passed players
     * @param players the list of Players to collect shot statistics for
     * @param season the season to consider
     * @return the shot statistics, for the list of players
     * @throws Exception if one player lacks the given season's shot data
     */
    private List<String> getValuesShots(List<HockeyPlayer> players,
                                             String season) throws Exception{
        ArrayList<String> ShotsValues = new ArrayList<String>();
        for (HockeyPlayer player : players) {
            ShotsValues.add(player.getStatShots(season).toString());
        }
        return ShotsValues;
    }

    /**
     * Get the Shooting percentage statistic in the given season for all passed players
     * @param players the list of Players to collect shooting percentage statistics for
     * @param season the season to consider
     * @return the shooting percentage statistics, for the list of players
     * @throws Exception if one player lacks the given season's shooting percentage data
     */
    private List<String> getValuesShootingPercentage(List<HockeyPlayer> players,
                                                          String season) throws Exception{
        ArrayList<String> ShootingPercentageValues = new ArrayList<String>();
        for (HockeyPlayer player : players) {
            ShootingPercentageValues.add(player.getStatShootingPercentage(season).toString());
        }
        return ShootingPercentageValues;
    }
}
