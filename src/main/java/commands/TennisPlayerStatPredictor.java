package commands;

import player.*;

import java.util.*;

/**
 * Predict a player's performance in season 2021-2022 in a given statistic.
 */
public class TennisPlayerStatPredictor implements Command {
    static final int PLAYER_NAME = 0;
    static final int STAT = 1;

    /**
     * Return a prediction for a given player's stat
     * @param arguments is a list of strings where ["player name", "stat"]
     * @return the prediction of the stat based on the past data.
     * @throws Exception when the player name is not found or the demanded stat is invalid.
     */
    @Override
    public String execute(ArrayList<String> arguments) throws Exception {
        String stat = arguments.get(STAT);
        String name = arguments.get(PLAYER_NAME);
        TennisPlayerList pL = new TennisPlayerList();

        TennisPlayer neededPlayer = pL.findTennisPlayer(name);
        Map<String, Integer> neededStats = neededPlayer.getNeededStat(stat);

        List<String> competitions = pL.getAllCompetitions();
        HashMap<String, Integer> competitionValues = new HashMap<>();
        for (int i = 0; i < competitions.size(); i ++) {
            competitionValues.put(competitions.get(i), i+1);
        }

        List<Integer> xAxis = new ArrayList<>();
        List<Double> yAxis = new ArrayList<>();

        for (String season : neededStats.keySet()){
            xAxis.add(competitionValues.get(season));
            yAxis.add((Double.valueOf(neededStats.get(season))));
        }

        LinearRegressionAnalysis lR = new LinearRegressionAnalysis(xAxis, yAxis);

        return "Predicted " + stat + " approximately in next season/competition: " + (int)(lR.makePrediction());

    }

}
