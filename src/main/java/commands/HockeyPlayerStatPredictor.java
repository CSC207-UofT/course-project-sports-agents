package commands;

import drivers_adapters.DataContainer;
import player.HockeyPlayer;
import player.Player;

import java.util.*;

public class HockeyPlayerStatPredictor extends PlayerStatPredictor {

    public HockeyPlayerStatPredictor() {
        super(new HashSet<>(Arrays.asList("Goals", "Assists",
                "Points", "Shots", "Shooting Percentage")));
    }

    /**
     * Handle an argument requesting a prediction of a player's
     * future statistic. Uses only requested seasons and assumes
     * the seasons were played in the order provided. Uses linear
     * regression.
     * @param arguments A string array of form
     *                  {"Hockey", "player name", "stat name"}
     * @param container A container containing the data or means to retrieve it
     * @return the predicted statistic for the next season
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String name = arguments.get(1);
        HockeyPlayer player = (HockeyPlayer) container.getPlayer("hockey", name);

        String statistic = arguments.get(2);
        checkStatistic(statistic);

        double prediction = this.getLinearPrediction((Player) player, statistic);
        List<String> playerSeasons = player.getSeasons();
        List<Double> pastStats = getPastStats(player, statistic, playerSeasons);
        return formatOut(playerSeasons, pastStats, prediction);
    }

    /**
     * Collect the player's past statistics for the seasons they participated in, maintaining order.
     * @param player the player to get statistics for
     * @param statistic the statistic to get
     * @param seasons the list of seasons to get
     * @return the player's statistics for the given seasons
     * @throws Exception if one statistic is not recorded
     */
    @Override
    protected List<Double> getPastStats(Player player, String statistic,
                                        List<String> seasons)
            throws Exception {
        HockeyPlayer hockeyPlayer = (HockeyPlayer) player;
        switch (statistic) {
            case "Goals":
                return getPastGoals(hockeyPlayer, seasons);
            case "Assists":
                return getPastAssists(hockeyPlayer, seasons);
            case "Points":
                return getPastPoints(hockeyPlayer, seasons);
            case "Shots":
                return getPastShots(hockeyPlayer, seasons);
            case "Shooting Percentage":
                return getPastShootingPercentage(hockeyPlayer, seasons);
            default:
                throw new Exception("this shouldn't logically be thrown!");
        }
    }

    /**
     * Get the Goals statistics for the given player for list of given seasons
     * @param player the Player to get Goals statistics for
     * @param seasons the list of seasons to consider
     * @return the Goals statistics, for all given seasons
     * @throws Exception if one season lacks recorded Goals data
     */
    private List<Double> getPastGoals(HockeyPlayer player, List<String> seasons) throws Exception {
        ArrayList<Double> pastGoals = new ArrayList<>();
        for (String season : seasons) {
            pastGoals.add((double) player.getStatGoals(season));
        }
        return pastGoals;
    }

    /**
     * Get the Assists statistics for the given player for list of given seasons
     * @param player the Player to get Assists statistics for
     * @param seasons the list of seasons to consider
     * @return the Assists statistics, for all given seasons
     * @throws Exception if one season lacks recorded Assists data
     */
    private List<Double> getPastAssists(HockeyPlayer player, List<String> seasons) throws Exception {
        ArrayList<Double> pastAssists = new ArrayList<>();
        for (String season : seasons) {
            pastAssists.add((double) player.getStatAssists(season));
        }
        return pastAssists;
    }

    /**
     * Get the Points statistics for the given player for list of given seasons
     * @param player the Player to get Points statistics for
     * @param seasons the list of seasons to consider
     * @return the Points statistics, for all given seasons
     * @throws Exception if one season lacks recorded Points data
     */
    private List<Double> getPastPoints(HockeyPlayer player, List<String> seasons) throws Exception {
        ArrayList<Double> pastPoints = new ArrayList<>();
        for (String season : seasons) {
            pastPoints.add((double) player.getStatPoints(season));
        }
        return pastPoints;
    }

    /**
     * Get the Shots statistics for the given player for list of given seasons
     * @param player the Player to get Shots statistics for
     * @param seasons the list of seasons to consider
     * @return the Shots statistics, for all given seasons
     * @throws Exception if one season lacks recorded Shots data
     */
    private List<Double> getPastShots(HockeyPlayer player, List<String> seasons) throws Exception {
        ArrayList<Double> pastShots = new ArrayList<>();
        for (String season : seasons) {
            pastShots.add((double) player.getStatShots(season));
        }
        return pastShots;
    }

    /**
     * Get the Shooting Percentage statistics for the given player for list of given seasons
     * @param player the Player to get Shooting Percentage statistics for
     * @param seasons the list of seasons to consider
     * @return the Shooting Percentage statistics, for all given seasons
     * @throws Exception if one season lacks recorded Shooting Percentage data
     */
    private List<Double> getPastShootingPercentage(HockeyPlayer player, List<String> seasons) throws Exception {
        ArrayList<Double> pastShootingPercentage = new ArrayList<>();
        for (String season : seasons) {
            pastShootingPercentage.add(player.getStatShootingPercentage(season));
        }
        return pastShootingPercentage;
    }
}
