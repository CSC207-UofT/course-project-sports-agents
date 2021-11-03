package commands;

import player.*;

import java.util.*;

public class HockeyPlayerStatComparer extends PlayerStatComparer {

    public HockeyPlayerStatComparer(PlayerList<HockeyPlayer> hockeyPlayerList) {
        super(hockeyPlayerList,
                new HashSet<String>(Arrays.asList("Skater Shoots",
                        "Games Played", "Goals", "Assists", "Points",
                        "Shots", "Shooting Percentage")));
    }

    /**
     * Handle an argument requesting a comparison of two or more players'
     * statistics. Each statistic may be handled differently.
     * @param arguments A string array of form
     *                  {"get_stat", "sport name", "player name 1",
     *                  "player name 2", ... , "season", "stat name"}
     * @return the requested statistic
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        int argSize = arguments.size();
        ArrayList<String> names = (ArrayList<String>) arguments.subList(2,
                argSize - 2);
        ArrayList<?> genericPlayers = this.playerList.getPlayers(names);
        ArrayList<HockeyPlayer> hockeyPlayers =
                (ArrayList<HockeyPlayer>) genericPlayers;
        String season = arguments.get(argSize - 2);
        String statistic = arguments.get(argSize - 1);
        checkStatistic(statistic);
        hockeyPlayers.sort(new HockeyPlayerComparator(statistic, season));

        ArrayList<String> playersStatValues = getStatValues(hockeyPlayers,
                statistic, season);
        return formatCompare(hockeyPlayers, playersStatValues);
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
    private ArrayList<String> getStatValues(ArrayList<HockeyPlayer> players,
                                            String statistic, String season)
            throws Exception {
        return switch (statistic) {
            case "Skater Shoots" ->
                    getValuesSkaterShoots(players, season);
            case "Games Played" ->
                    getValuesGamesPlayed(players, season);
            case "Goals" ->
                    getValuesGoals(players, season);
            case "Assists" ->
                    getValuesAssists(players, season);
            case "Points" ->
                    getValuesPoints(players, season);
            case "Shots" ->
                    getValuesShots(players, season);
            case "Shooting Percentage" ->
                    getValuesShootingPercentage(players, season);
            default -> throw new Exception("This shouldn't be thrown, logically");
        };
    }

    /**
     * Get the skater shoots statistic in the given season for all passed players
     * @param players the list of Players to collect skater shoot statistics for
     * @param season the season to consider
     * @return the skater shoot statistics, for the list of players
     * @throws Exception if one player lacks the given season's skater shoot data
     */
    private ArrayList<String> getValuesSkaterShoots(ArrayList<HockeyPlayer> players,
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
    private ArrayList<String> getValuesGamesPlayed(ArrayList<HockeyPlayer> players,
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
    private ArrayList<String> getValuesGoals(ArrayList<HockeyPlayer> players,
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
    private ArrayList<String> getValuesAssists(ArrayList<HockeyPlayer> players,
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
    private ArrayList<String> getValuesPoints(ArrayList<HockeyPlayer> players,
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
    private ArrayList<String> getValuesShots(ArrayList<HockeyPlayer> players,
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
    private ArrayList<String> getValuesShootingPercentage(ArrayList<HockeyPlayer> players,
                                                          String season) throws Exception{
        ArrayList<String> ShootingPercentageValues = new ArrayList<String>();
        for (HockeyPlayer player : players) {
            ShootingPercentageValues.add(player.getStatShootingPercentage(season).toString());
        }
        return ShootingPercentageValues;
    }
}
