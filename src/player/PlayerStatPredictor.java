package player;

import commands.*;

import java.util.*;

/**
 * Predict a player's performance in season 2021-2022 in a given statistic.
 */
public class PlayerStatPredictor implements Command {
    protected String playerName;
    protected String stat;

    public PlayerStatPredictor(String playerName, String stat) {
        this.playerName = playerName;
        this.stat = stat;
    }

    public String execute() throws Exception {
        // Throw exception for a list of statistics that are invalid for comparison
        List<String> invalidStats = Arrays.asList( "name", "season", "team", "skater shoots","position");
        if (invalidStats.contains(this.stat)){
            throw new Exception("Invalid statistic for comparison!");
        }

        PlayerList p = new PlayerList();
        HashMap<String, List<HockeyPlayer>> playerMap = p.getPlayerMap();
        List<HockeyPlayer> listDemandedInfo = new ArrayList<>(); // list of Player objects of a specific player for each season

        for (String season: playerMap.keySet()){
            for (HockeyPlayer playerInfo : playerMap.get(season)){
                if (playerInfo.name.equals(this.playerName)){
                    listDemandedInfo.add(playerInfo);
                }
            }
        }
        List<Integer> xAxis = new ArrayList<>(); // x-axis of the graph = seasons
        List<Integer> yAxis = new ArrayList<>(); //y-axis of the graph = demanded stat
        for (HockeyPlayer demandStat: listDemandedInfo){
            xAxis.add(Integer.valueOf(demandStat.season));
            yAxis.add(Integer.valueOf(demandStat.getStat(this.stat)));
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

        return "Predicted " + this.stat + ": " + a*Math.pow(r, 20202021);

    }


}
