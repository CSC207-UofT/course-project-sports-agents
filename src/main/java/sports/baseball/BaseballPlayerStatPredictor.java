package sports.baseball;

import commands.PlayerStatPredictor;
import driversAdapters.DataContainer;

import java.util.*;

public class BaseballPlayerStatPredictor extends PlayerStatPredictor {
    public BaseballPlayerStatPredictor() {
        super(new HashSet<>(Arrays.asList("at bats", "runs",
                "hits", "home runs", "runs batted in", "strike outs", "average")));
    }

    /**
     * Handle an argument requesting a prediction of a player's
     * future statistic. Uses only requested seasons and assumes
     * the seasons were played in the order provided. Uses linear
     * regression.
     * @param arguments A string array of form
     *                  {"Baseball", "player name", "stat name"}
     * @param container A container with the necessary data and the means to get it
     * @return the predicted statistic for the next season
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String name = arguments.get(1);
        BaseballPlayer player = (BaseballPlayer) container.getPlayer("baseball", name);
        List<String> playerSeasons = player.getSeasons();

        String statistic = arguments.get(2);
        checkStatistic(statistic);

        List<Double> pastStats = getPastStats(player, statistic, playerSeasons);
        List<Integer> seasonInts = this.getXAxis(playerSeasons);

        double prediction = linearExtrapolate(seasonInts, pastStats);
        return formatOut(playerSeasons, statistic, pastStats, prediction);
    }

    /**
     * Collect the player's past statistics for the given seasons, maintaining order.
     * @param player the player to get statistics for
     * @param statistic the statistic to get
     * @param seasons the list of seasons to get
     * @return the player's statistics for the given seasons
     * @throws Exception if one statistic is not recorded
     */
    private List<Double> getPastStats(BaseballPlayer player, String statistic,
                                      List<String> seasons)
            throws Exception {
        switch (statistic) {
            case "at bats":
                return getPastAtBats(player, seasons);
            case "runs":
                return getPastRuns(player, seasons);
            case "hits":
                return getPastHits(player, seasons);
            case "home runs":
                return getPastHomeRuns(player, seasons);
            case "runs batted in":
                return getPastRunsBattedIn(player, seasons);
            case "strike outs":
                return getPastStrikeOuts(player, seasons);
            case "average":
                return getPastAverage(player, seasons);
            default:
                throw new Exception("this shouldn't logically be thrown!");
        }
    }

    /**
     * Get the at bats statistics for the given player in given seasons
     * @param player the Player to get at bats statistics for
     * @param seasons the list of seasons to consider
     * @return the at bats statistics, for given seasons
     * @throws Exception if one season lacks recorded At Bats data
     */
    private List<Double> getPastAtBats(BaseballPlayer player,
                                       List<String> seasons)
            throws Exception {
        ArrayList<Double> pastAtBats = new ArrayList<>();
        for (String season : seasons) {
            pastAtBats.add((double) player.getStatAtBats(season));
        }
        return pastAtBats;
    }

    /**
     * Get the runs statistics for the given player in given seasons
     * @param player the Player to get runs statistics for
     * @param seasons the list of seasons to consider
     * @return the runs statistics, for given seasons
     * @throws Exception if one season lacks recorded runs data
     */
    private List<Double> getPastRuns(BaseballPlayer player,
                                     List<String> seasons)
            throws Exception {
        ArrayList<Double> pastRuns = new ArrayList<>();
        for (String season : seasons) {
            pastRuns.add((double) player.getStatRuns(season));
        }
        return pastRuns;
    }

    /**
     * Get the Hits statistics for the given player in given seasons
     * @param player the Player to get Hits statistics for
     * @param seasons the list of seasons to consider
     * @return the Hits statistics, for given seasons
     * @throws Exception if one season lacks recorded Hots data
     */
    private List<Double> getPastHits(BaseballPlayer player,
                                     List<String> seasons)
            throws Exception {
        ArrayList<Double> pastHits = new ArrayList<>();
        for (String season : seasons) {
            pastHits.add((double) player.getStatHits(season));
        }
        return pastHits;
    }

    /**
     * Get the Home Runs statistics for the given player in given seasons
     * @param player the Player to get Home Runs statistics for
     * @param seasons the list of seasons to consider
     * @return the Home Runs statistics, for given seasons
     * @throws Exception if one season lacks recorded Home Runs data
     */
    private List<Double> getPastHomeRuns(BaseballPlayer player,
                                         List<String> seasons)
            throws Exception {
        ArrayList<Double> pastHomeRuns = new ArrayList<>();
        for (String season : seasons) {
            pastHomeRuns.add((double) player.getStatHomeRuns(season));
        }
        return pastHomeRuns;
    }

    /**
     * Get the Runs Batted In statistics for the given player in given seasons
     * @param player the Player to get Runs Batted In statistics for
     * @param seasons the list of seasons to consider
     * @return the Runs Batted In statistics, for given seasons
     * @throws Exception if one season lacks recorded Runs Batted In data
     */
    private List<Double> getPastRunsBattedIn(BaseballPlayer player,
                                             List<String> seasons)
            throws Exception {
        ArrayList<Double> pastRunsBattedIn = new ArrayList<>();
        for (String season : seasons) {
            pastRunsBattedIn.add((double)player.getStatRunsBattedIn(season));
        }
        return pastRunsBattedIn;
    }

    /**
     * Get the Strike Outs statistics for the given player in given seasons
     * @param player the Player to get Strike Outs statistics for
     * @param seasons the list of seasons to consider
     * @return the Strike Outs statistics, for given seasons
     * @throws Exception if one season lacks recorded Strike Outs data
     */
    private List<Double> getPastStrikeOuts(BaseballPlayer player,
                                           List<String> seasons)
            throws Exception {
        ArrayList<Double> pastStrikeOuts = new ArrayList<>();
        for (String season : seasons) {
            pastStrikeOuts.add((double) player.getStatStrikeOuts(season));
        }
        return pastStrikeOuts;
    }

    /**
     * Get the Home Runs statistics for the given player in given seasons
     * @param player the Player to get Home Runs statistics for
     * @param seasons the list of seasons to consider
     * @return the Home Runs statistics, for given seasons
     * @throws Exception if one season lacks recorded Home Runs data
     */
    private List<Double> getPastAverage(BaseballPlayer player,
                                        List<String> seasons)
            throws Exception {
        ArrayList<Double> pastAverage = new ArrayList<>();
        for (String season : seasons) {
            pastAverage.add(player.getStatAvg(season));
        }
        return pastAverage;
    }


}
