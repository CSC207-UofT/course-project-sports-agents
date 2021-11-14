package commands;


import player.*;

import java.util.*;

/**
 * Predict a player's performance in season 2021-2022 in a given statistic.
 */
public abstract class PlayerStatPredictor implements Command {
    protected PlayerList playerList;
    private final Set<String> allowedStatsToPredict;

    /**
     * @param playerList the Players this StatPredictor will get statistics for
     * @param allowedStatsToPredict the statistics this StatManager can Predict
     */
    public PlayerStatPredictor(PlayerList playerList,
                               Set<String> allowedStatsToPredict) {
        this.playerList = playerList;
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
     * Extrapolate a series of data points, at evenly spaced intervals,
     * into the future using a linear model, y = m*x + b
     * @param pastStats the past data points
     * @return the linearly extrapolated next data point in the series
     */
    protected int linearExtrapolate(List<Double> pastStats) {

        double xy = 0;
        double x = 0;
        double y = 0;
        double xx = 0;
        int n = pastStats.size();

        for (int k = 0; k < n; k ++){
            xy += (k+1) * pastStats.get(k);
            x += k+1;
            y += pastStats.get(k);
            xx += Math.pow(k+1, 2);
        }
        double m = (n * xy - x*y) / (n*xx - Math.pow(x, 2));
        double b = (y - m * x)/n;
        return (int) (m * 6 + b);
    }


    /**
     * Extrapolate a series of data points, at evenly spaced intervals,
     * into the future using an exponential model, y = a * r^x
     * @param pastStats the past data points
     * @return the exponentially extrapolated next data point in the series
     */
    protected int exponentialExtrapolate(List<Double> pastStats) {
        double xy = 0;
        double x = 0;
        double y = 0;
        double xx = 0;
        int n = pastStats.size();

        for (int k = 0; k < n; k ++){
            xy += (k+1) * pastStats.get(k);
            x += k+1;
            y += pastStats.get(k);
            xx += Math.pow(k+1, 2);
        }
        double m = (n * xy - x*y) / (n*xx - Math.pow(x, 2));
        double b = (y - m * x)/n;
        double r = Math.pow(10, m);
        double a = Math.pow(10, b);
        return (int)(a*Math.pow(r, 6));
    }

    /**
     * Format data for printing to a terminal
     * @param seasons the seasons where past data originates from
     * @param pastStats the past data
     * @param prediction the prediction for next season
     * @return the formatted output to display
     */
    protected String formatOut(List<String> seasons, List<Double> pastStats,
                               int prediction) {
        StringBuilder out = new StringBuilder("Previous Statistics:\n");
        // Precondition: seasons.size() = pastStats.size()
        for (int i = 0; i != seasons.size(); i += 1) {
            out.append(seasons.get(i));
            out.append(": ");
            out.append(pastStats.get(i));
            out.append("\n");
        }
        out.append("Prediction for next season: ");
        out.append(prediction);
        return out.toString();
    }


}

