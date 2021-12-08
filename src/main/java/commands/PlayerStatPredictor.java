package commands;

import constants.Exceptions;

import java.util.*;

/**
 * Predict a player's performance in season 2021-2022 in a given statistic.
 */
public abstract class PlayerStatPredictor implements Command {
    private final Set<String> allowedStatsToPredict;

    /**
     * @param allowedStatsToPredict the statistics this StatManager can Predict
     */
    public PlayerStatPredictor(Set<String> allowedStatsToPredict) {
        this.allowedStatsToPredict = allowedStatsToPredict;
    }

    /**
     * @param statistic a statistic to check if it can be predicted
     * @throws Exception if the statistic cannot be predicted
     */
    protected void checkStatistic(String statistic) throws Exception {
        if (!this.allowedStatsToPredict.contains(statistic)) {
            throw new Exception("Cannot predict statistic " + statistic + "!");
        }
    }

    /**
     * Create a map mapping a season to an integer that represents the order the season happened (e.g.
     * first season to happen will be assigned 1, the second season to happen will be assigned 2, and so on)
     *
     * @param seasons list of seasons to be included
     * @return map of seasons to integers
     */
    protected Map<String, Integer> getSeasonToIntsMap(List<String> seasons) {
        Map<String, Integer> seasonToIntsMap = new HashMap<>();
        for (int i = 0; i < seasons.size(); i++) {
            seasonToIntsMap.put(seasons.get(i), i + 1);
        }
        return seasonToIntsMap;
    }

    /**
     * Get the integer values for needed seasons (this will be the x axis for the linear regression model)
     *
     * @param playerSeasons player's seasons
     * @return list of integer values associated with seasons;
     */
    public List<Integer> getXAxis(List<String> playerSeasons) {
        Map<String, Integer> seasonsToIntsMap = this.getSeasonToIntsMap(playerSeasons);
        List<Integer> xAxis = new ArrayList<>();
        for (String playerSeason : playerSeasons) {
            xAxis.add(seasonsToIntsMap.get(playerSeason));
        }
        return xAxis;
    }

    /**
     * Perform a linear regression analysis given the two sets of data
     *
     * @param xAxis the independent variable
     * @param yAxis the dependent variable
     * @return a prediction for a next season/competition using the calculated linear model
     * @throws Exception if the given data is invalid (xAxis and yAxis do not have the same length, or do not
     *                   have a length greater than 2
     */
    protected double linearExtrapolate(List<Integer> xAxis, List<Double> yAxis) throws Exception {
        if (xAxis.size() != yAxis.size()) {
            throw new Exception(Exceptions.INVALID_DATA);
        } else if (xAxis.size() < 2) {
            throw new Exception(Exceptions.INVALID_DATA);
        }

        int n = xAxis.size();
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumXSquared = 0;
        double sumYSquared = 0;

        for (int i = 0; i < xAxis.size(); i++) {
            sumX = sumX + xAxis.get(i);
            sumY = sumY + yAxis.get(i);
            sumXY = sumXY + (xAxis.get(i) * yAxis.get(i));
            sumXSquared = sumXSquared + (Math.pow(xAxis.get(i), 2));
            sumYSquared = sumYSquared + (Math.pow(yAxis.get(i), 2));
        }

        double denominator = ((n * (sumXSquared)) - Math.pow(sumX, 2));

        double slope = ((n * sumXY) - (sumX * sumY)) / denominator;
        double intercept = (sumY - (slope * sumX)) / n;

        int xValue = xAxis.get(xAxis.size() - 1) + 1;
        return (slope * xValue) + intercept;
    }

    /**
     * Format data for printing to a terminal
     *
     * @param seasons    the seasons where past data originates from
     * @param pastStats  the past data
     * @param prediction the prediction for next season
     * @return the formatted output to display
     */
    protected String formatOut(List<String> seasons, String statName, List<Double> pastStats,
                               double prediction) {
        StringBuilder output = new StringBuilder();
        output.append("------------------------------------\n");
        output.append(String.format("%15s %20s %n", "Season", statName));
        output.append("------------------------------------\n");
        for (int i = 0; i != seasons.size(); i += 1) {
            output.append(String.format("%15s %20s %n", seasons.get(i), pastStats.get(i)));
        }
        output.append(String.format("%15s %20f", "Next Season", prediction));
        return output.toString();
    }
}