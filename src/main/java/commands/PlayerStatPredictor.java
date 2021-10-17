package commands;

import player.HockeyPlayer;
import player.PlayerList;

import java.util.*;

/**
 * Predict a player's performance in season 2021-2022 in a given statistic.
 */
public class PlayerStatPredictor implements Command {

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

}
