package commands;

import java.util.ArrayList;

import constants.Exceptions;
import drivers_adapters.DataContainer;
import team.TeamConstants;

public class TeamStatPredictorFacade implements Command, TeamConstants {
    private final HockeyTeamStatPredictor hockeyTeamStatPredictor;
    private final TennisTeamStatPredictor tennisTeamStatPredictor;
    private final BaseballTeamStatPredictor baseballTeamStatPredictor;

    public TeamStatPredictorFacade(HockeyTeamStatPredictor hockeyTeamStatPredictor,
                                   TennisTeamStatPredictor tennisTeamStatPredictor,
                                   BaseballTeamStatPredictor baseballTeamStatPredictor) {
        this.hockeyTeamStatPredictor = hockeyTeamStatPredictor;
        this.tennisTeamStatPredictor = tennisTeamStatPredictor;
        this.baseballTeamStatPredictor = baseballTeamStatPredictor;
    }

    /**
     * Handle an argument requesting a prediction of which team's
     * will win in an upcoming match
     * @param arguments A string array of form
     *                  {}
     * @param container A container containing the data or means to retrieve it
     * @return the predicted statistic for the next season
     * @throws Exception if the Team or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String sport = arguments.get(SPORT_SLOT);
        switch(sport.toLowerCase()) {
            case "hockey":
                return this.hockeyTeamStatPredictor.execute(arguments, container);
            case "tennis":
                return this.tennisTeamStatPredictor.execute(arguments, container);
            case "baseball":
                return this.baseballTeamStatPredictor.execute(arguments, container);
            default:
                throw new Exception(Exceptions.WRONG_SPORT);
        }
    }
}
