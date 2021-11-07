package commands;

import player.*;
import java.util.*;

/**
 * A class that will predict a tennis player's future performance for a given stat.
 */
public class TennisPlayerStatPredictor implements Command {
    private final HashSet<String> allowedStats;
    static final int PLAYER_NAME = 1;
    static final int STAT = 2;

    public TennisPlayerStatPredictor() {
        this.allowedStats = new HashSet<>(Arrays.asList("aces", "double faults", "break points", "first serves",
                "break points saved", "serve points"));
    }

    /**
     * Make a prediction for the given player on the given stat using linear regression
     * @param arguments is a list of strings in the format ["sport", "player name", "stat"]
     * @return the prediction of the stat based on historical data
     * @throws Exception when the player name is not found or the demanded stat is invalid.
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String stat = arguments.get(STAT);
        String name = arguments.get(PLAYER_NAME);
        TennisPlayerList pL = new TennisPlayerList();

        if (!(allowedStats.contains(stat))) {
            throw new Exception("Invalid stat!");
        }

        TennisPlayer neededPlayer = pL.findTennisPlayer(name);
        Map<String, Integer> neededStats = neededPlayer.getNeededStat(stat);

        List<String> competitions = pL.getAllCompetitions();
        List<Integer> competitionInts = new ArrayList<>();
        List<Double> stats = new ArrayList<>();

        updateAxis(competitions, competitionInts, stats, neededStats);

        return "Predicted " + stat + " in next season/competition: " +
                (int)(conductLinearRegression(competitionInts, stats));

    }


    /**
     * A helper method for execute method. It creates a map assigning an int to a competition in the competitions
     * based on the order competitions is in (e.g. 1 : competitions.index(0), 2 : competitions.index(1)). It adds
     * the ints to the seasons list, and the value of a stat for that season (retrieved from neededStats) to the stats
     * list.
     * @param competitions a list of all the competitions in TennisPlayerList
     * @param competitionInts a list of the int values for a competition
     * @param stats a list of stats for each competition (parallel to competitionInts list)
     * @param neededStats a map containing the player's stat for each competition
     */
    private void updateAxis(List<String> competitions, List<Integer> competitionInts, List<Double> stats,
                            Map<String, Integer> neededStats) {
        HashMap<String, Integer> competitionValues = new HashMap<>();
        for (int i = 0; i < competitions.size(); i ++) {
            competitionValues.put(competitions.get(i), i+1);
        }
        for (String season : neededStats.keySet()){
            competitionInts.add(competitionValues.get(season));
            stats.add(((Double.valueOf(neededStats.get(season)))));
        }
    }


    /**
     * A helper method for the execute method. It performs a linear regression analysis given two lists of data.
     * It returns a prediction using the linear model calculated.
     * @param xAxis data for the independent variable
     * @param yAxis data for the dependent variable
     * @return a prediction, using the linear model calculated, of the y-value for the next highest x-value
     * @throws Exception if xAxis and yAxis are not equal lengths, or both lists have a length of 0 or 1
     */
    private double conductLinearRegression(List<Integer> xAxis, List<Double> yAxis) throws Exception {

        if (xAxis.size() != yAxis.size()) {
            throw new Exception("Invalid data!");
        } else if (xAxis.size() < 2) {
            throw new Exception("Not enough data to make a prediction!");
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
}
