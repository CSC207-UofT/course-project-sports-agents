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
     * @param seasons player's seasons
     * @return list of integer values associated with seasons;
     */
    public List<Integer> getXAxis(List<String> seasons) {
        Map<String, Integer> seasonsToIntsMap = this.getSeasonToIntsMap(seasons);
        List<Integer> xAxis = new ArrayList<>();
        for (String playerSeason : seasons) {
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
     * @param seasons the seasons where past data originates from
     * @param pastStats the past data
     * @param prediction the prediction for next season
     * @return the formatted output to display
     */
    protected String formatOut(List<String> seasons, List<Double> pastStats,
                               double prediction) {
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


    /*
     *
     * @param arguments is a list of strings where ["player name", "stat"]
     * @return the prediction of the stat based on the past data.
     * @throws Exception when the player name is not found or the demanded stat is invalid.
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String playerName = arguments.get(0);
        String stat = arguments.get(1);

        // Throw exception for a list of statistics that are invalid for comparison
        List<String> invalidStats = Arrays.asList( "name", "season", "team", "skater shoots","position");
        if (invalidStats.contains(stat)){
            throw new Exception("Invalid statistic for comparison!");
        }

        PlayerList p = new PlayerList();
        HashMap<String, List<HockeyPlayer>> playerMap = p.getPlayerMap();
        List<HockeyPlayer> listDemandedInfo = new ArrayList<>(); // list of player.Player objects of a specific player for each season

        for (String season: playerMap.keySet()){
            for (HockeyPlayer playerInfo : playerMap.get(season)){
                if (playerInfo.name.equals(playerName)){
                    listDemandedInfo.add(playerInfo);
                }
            }
        }
        List<Integer> xAxis = new ArrayList<>(); // x-axis of the graph = seasons
        List<Double> yAxis = new ArrayList<>(); //y-axis of the graph = demanded stat
        HashMap<String, Integer> mappingSeasonToInt = new HashMap<>(Map.of("20162017", 1,
                "20172018", 2, "20182019", 3, "20192020", 4, "20202021",5));

        for (HockeyPlayer demandStat: listDemandedInfo){
            xAxis.add(mappingSeasonToInt.get(demandStat.season));
            yAxis.add(Math.log10(Integer.parseInt(demandStat.getStat(stat))));
        }
        // plot a graph
        // ...

        // make predictions using linear and exponential regression
        // linear regression : y = m*x + b
        double xy = 0;
        double x = 0;
        double y = 0;
        double xx = 0;
        int n = xAxis.size();

        for (int k = 0; k < n; k ++){
            xy += xAxis.get(k) * yAxis.get(k);
            x += xAxis.get(k);
            y += yAxis.get(k);
            xx += Math.pow(xAxis.get(k), 2);
        }
        double m = (n * xy - x*y) / (n*xx - Math.pow(x, 2));
        double b = (y - m * x)/n;

        //Exponential regression: y = a * r^x
        double r = Math.pow(10, m);
        double a = Math.pow(10, b);

        return "Predicted " + stat + " approximately in season 2021-2022: " + (int)(a*Math.pow(r, 6));

    }
     */

}
