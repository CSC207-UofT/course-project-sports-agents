package commands;

import player.*;

import java.util.*;

public class BaseballPlayerStatPredictor implements Command {
    /**
     *
     * @param arguments is a list of strings where ["player name", "stat"]
     * @return the prediction of the stat based on the past data.
     * @throws Exception when the player name is not found or the demanded stat is invalid.
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String playerName = arguments.get(0);
        String stat = arguments.get(1);

        // Throw exception for a list of statistics that are invalid for comparison
        ExceptionForInvalidStatInPrediction(stat);


        List<BaseballPlayer> listDemandedInfo = getBaseballPlayersFromFile(playerName);

        List<Integer> xAxis = new ArrayList<>(); // x-axis of the graph = seasons
        List<Double> yAxis = new ArrayList<>(); //y-axis of the graph = demanded stat
        addDataToGraph(stat, listDemandedInfo, xAxis, yAxis);
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

    private void addDataToGraph(String stat, List<BaseballPlayer> listDemandedInfo, List<Integer> xAxis, List<Double> yAxis) throws Exception {
        HashMap<String, Integer> mappingSeasonToInt = new HashMap<>(Map.of("2016-2017", 1,
                "2017-2018", 2, "2018-2019", 3, "2019-2020", 4, "2020-2021",5));

        for (BaseballPlayer demandStat: listDemandedInfo){
            xAxis.add(mappingSeasonToInt.get(demandStat.season));
            yAxis.add(Math.log10(Integer.parseInt(demandStat.getNeededStat(stat))));
        }
    }

    private List<BaseballPlayer> getBaseballPlayersFromFile(String playerName) {
        BaseballPlayerList bList = new BaseballPlayerList();
        HashMap<String, List<BaseballPlayer>> playerMap = bList.getPlayerMap();
        List<BaseballPlayer> listDemandedInfo = new ArrayList<>(); // list of player.Player objects of a specific player for each season

        for (String season: playerMap.keySet()){
            for (BaseballPlayer playerInfo : playerMap.get(season)){
                if (playerInfo.name.equals(playerName)){
                    listDemandedInfo.add(playerInfo);
                }
            }
        }
        return listDemandedInfo;
    }

    private void ExceptionForInvalidStatInPrediction(String stat) throws Exception {
        List<String> invalidStats = Arrays.asList( "name", "season", "team","position");
        if (invalidStats.contains(stat)){
            throw new Exception("Invalid statistic for comparison!");
        }
    }
}
