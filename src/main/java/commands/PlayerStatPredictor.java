package commands;

import player.PlayerList;

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
     * into the future using a linear model
     * @param pastStats the past data points
     * @return the linearly extrapolated next data point in the series
     */
    protected int linearExtrapolate(List<Integer> pastStats) {
        // TODO: Implement linear extrapolation
        return 0;
    }

    /**
     * Format data for printing to a terminal
     * @param seasons the seasons where past data originates from
     * @param pastStats the past data
     * @param prediction the prediction for next season
     * @return the formatted output to display
     */
    protected String formatOut(List<String> seasons, List<Integer> pastStats,
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
