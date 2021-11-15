package commands;

import drivers_adapters.DataContainer;
import player.PlayerList;
import player.HockeyPlayer;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class HockeyPlayerStatPredictor extends PlayerStatPredictor {

    public HockeyPlayerStatPredictor(PlayerList<HockeyPlayer> playerList) {
        super(playerList, new HashSet<String>(Arrays.asList("Goals", "Assists",
                "Points", "Shots", "Shooting Percentage")));
    }

    /**
     * Handle an argument requesting a prediction of a player's
     * future statistic. Uses only requested seasons and assumes
     * the seasons were played in the order provided. Uses linear
     * regression.
     * @param arguments A string array of form
     *                  {"predict_player_stat", "Hockey", "player name",
     *                  "season 1", "season 2", ..., "stat name"}
     * @return the predicted statistic for the next season
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String name = arguments.get(2);
        HockeyPlayer player = (HockeyPlayer) container.getPlayer("hockey", name);

        int argSize = arguments.size();
        List<String> seasons = arguments.subList(3, argSize - 1);

        String statistic = arguments.get(argSize);
        checkStatistic(statistic);

        List<Double> pastStats = getPastStats(player, statistic, seasons);
        int prediction = linearExtrapolate(pastStats);
        return formatOut(seasons, pastStats, prediction);
    }

    /**
     * Collect the player's past statistics for the given seasons, maintaining order.
     * @param player the player to get statistics for
     * @param statistic the statistic to get
     * @param seasons the list of seasons to get
     * @return the player's statistics for the given seasons
     * @throws Exception if one statistic is not recorded
     */
    private List<Double> getPastStats(HockeyPlayer player, String statistic,
                                       List<String> seasons)
            throws Exception {
        switch (statistic) {
            case "Goals":
                return getPastGoals(player, seasons);
            case "Assists":
                return getPastAssists(player, seasons);
            case "Points":
                return getPastPoints(player, seasons);
            case "Shots":
                return getPastShots(player, seasons);
            case "Shooting Percentage":
                return getPastShootingPercentage(player, seasons);
            default:
                throw new Exception("this shouldn't logically be thrown!");
        }
    }

    /**
     * Get the Goals statistics for the given player in all given seasons
     * @param player the Player to get Goals statistics for
     * @param seasons the list of seasons to consider
     * @return the Goals statistics, for all given seasons
     * @throws Exception if one season lacks recorded Goals data
     */
    private List<Double> getPastGoals(HockeyPlayer player,
                                       List<String> seasons)
            throws Exception {
        ArrayList<Double> pastGoals = new ArrayList<>();
        for (String season : seasons) {
            pastGoals.add((double) player.getStatGoals(season));
        }
        return pastGoals;
    }

    /**
     * Get the Assists statistics for the given player in all given seasons
     * @param player the Player to get Assists statistics for
     * @param seasons the list of seasons to consider
     * @return the Assists statistics, for all given seasons
     * @throws Exception if one season lacks recorded Assists data
     */
    private List<Double> getPastAssists(HockeyPlayer player,
                                         List<String> seasons)
            throws Exception {
        ArrayList<Double> pastAssists = new ArrayList<>();
        for (String season : seasons) {
            pastAssists.add((double) player.getStatAssists(season));
        }
        return pastAssists;
    }

    /**
     * Get the Points statistics for the given player in all given seasons
     * @param player the Player to get Points statistics for
     * @param seasons the list of seasons to consider
     * @return the Points statistics, for all given seasons
     * @throws Exception if one season lacks recorded Points data
     */
    private List<Double> getPastPoints(HockeyPlayer player,
                                        List<String> seasons)
            throws Exception {
        ArrayList<Double> pastPoints = new ArrayList<>();
        for (String season : seasons) {
            pastPoints.add((double) player.getStatPoints(season));
        }
        return pastPoints;
    }

    /**
     * Get the Shots statistics for the given player in all given seasons
     * @param player the Player to get Shots statistics for
     * @param seasons the list of seasons to consider
     * @return the Shots statistics, for all given seasons
     * @throws Exception if one season lacks recorded Shots data
     */
    private List<Double> getPastShots(HockeyPlayer player,
                                       List<String> seasons)
            throws Exception {
        ArrayList<Double> pastShots = new ArrayList<>();
        for (String season : seasons) {
            pastShots.add((double) player.getStatShots(season));
        }
        return pastShots;
    }

    /**
     * Get the Shooting Percentage statistics for the given player in all given seasons
     * @param player the Player to get Shooting Percentage statistics for
     * @param seasons the list of seasons to consider
     * @return the Shooting Percentage statistics, for all given seasons
     * @throws Exception if one season lacks recorded Shooting Percentage data
     */
    private List<Double> getPastShootingPercentage(HockeyPlayer player,
                                                    List<String> seasons)
            throws Exception {
        ArrayList<Double> pastShootingPercentage = new ArrayList<>();
        for (String season : seasons) {
            pastShootingPercentage.add(player.getStatShootingPercentage(season));
        }
        return pastShootingPercentage;
    }
}
