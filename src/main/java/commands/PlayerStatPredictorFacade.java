package commands;

import constants.Exceptions;
import driversAdapters.DataContainer;

import java.util.ArrayList;

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
     *                  {"sport name", "player name",
     *                  "season 1", "season 2", ..., "stat name"}
     * @param container A container containing the data or means to retrieve it
     * @return the predicted statistic for the next season
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        checkArgumentLength(arguments);
        String sport = arguments.get(0);
        switch(sport) {
            case "Hockey":
                return this.hockeyPlayerStatPredictor.execute(arguments, container);
            case "Tennis":
                return this.tennisPlayerStatPredictor.execute(arguments, container);
            case "Baseball":
                return this.baseballPlayerStatPredictor.execute(arguments, container);
            default:
                throw new Exception(Exceptions.WRONG_SPORT);
        }
    }

    /**
     * @param arguments user arguments for comparing players
     * @throws Exception if insufficiently many arguments are provided (here, 5)
     */
    private void checkArgumentLength(ArrayList<String> arguments) throws Exception {
        if (arguments.size() < 5) {
            throw new Exception(Exceptions.WRONG_ARGUMENT_NUMBER);
        }
    }
}
