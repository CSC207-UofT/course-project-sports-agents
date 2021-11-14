package commands;


import java.util.*;

public class PlayerStatPredictorFacade implements Command {
    private final HockeyPlayerStatPredictor hockeyPlayerStatPredictor;
    private final BaseballPlayerStatPredictor baseballPlayerStatPredictor;

    public PlayerStatPredictorFacade(HockeyPlayerStatPredictor hockeyPlayerStatPredictor,
                                     BaseballPlayerStatPredictor baseballPlayerStatPredictor) {
        this.hockeyPlayerStatPredictor = hockeyPlayerStatPredictor;
        this.baseballPlayerStatPredictor = baseballPlayerStatPredictor;
    }

    /**
     * Handle an argument requesting a prediction of a player's
     * future statistic. Uses only requested seasons and assumes
     * the seasons were played in the order provided. Uses linear
     * regression.
     * @param arguments A string array of form
     *                  {"predict_player_stat", "sport name", "player name",
     *                  "season 1", "season 2", ..., "stat name"}
     * @return the predicted statistic for the next season
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(List<String> arguments) throws Exception {
        String sport = arguments.get(1);
        switch(sport) {
            case "Hockey":
                return this.hockeyPlayerStatPredictor.execute(arguments);
            case "Baseball":
                return this.baseballPlayerStatPredictor.execute(arguments);
            default:
                throw new Exception("Invalid sport passed!");
        }
    }
}

