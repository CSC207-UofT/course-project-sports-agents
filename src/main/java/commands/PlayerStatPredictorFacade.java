package commands;

import drivers_adapters.DataContainer;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatPredictorFacade implements Command {
    private final HockeyPlayerStatPredictor hockeyPlayerStatPredictor;
    private final TennisPlayerStatPredictor tennisPlayerStatPredictor;
    private final BaseballPlayerStatPredictor baseballPlayerStatPredictor;

    public PlayerStatPredictorFacade(HockeyPlayerStatPredictor hockeyPlayerStatPredictor,
                                     TennisPlayerStatPredictor tennisPlayerStatPredictor,
                                     BaseballPlayerStatPredictor baseballPlayerStatPredictor) {
        this.hockeyPlayerStatPredictor = hockeyPlayerStatPredictor;
        this.tennisPlayerStatPredictor = tennisPlayerStatPredictor;
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
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String sport = arguments.get(1);
        switch(sport) {
            case "Hockey":
                return this.hockeyPlayerStatPredictor.execute(arguments, container);
            case "Tennis":
                return this.tennisPlayerStatPredictor.execute(arguments, container);
            case "Baseball":
                return this.baseballPlayerStatPredictor.execute(arguments, container);
            default:
                throw new Exception("Invalid sport passed!");
        }
    }
}
