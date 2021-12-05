package commands;

import java.util.ArrayList;

import constants.Exceptions;
import driversAdapters.DataContainer;
import team.TeamConstants;

public class TeamStatManagerFacade implements Command, TeamConstants {
    private final HockeyTeamStatManager hockeyTeamStatManager;
    private final TennisTeamStatManager tennisTeamStatManager;
    private final BaseballTeamStatManager baseballTeamStatManager;

    public TeamStatManagerFacade(HockeyTeamStatManager hockeyTeamStatManager,
                                   TennisTeamStatManager tennisTeamStatManager,
                                   BaseballTeamStatManager baseballTeamStatManager) {
        this.hockeyTeamStatManager = hockeyTeamStatManager;
        this.tennisTeamStatManager = tennisTeamStatManager;
        this.baseballTeamStatManager = baseballTeamStatManager;
    }

    /**
     * Handle an argument requesting a team's statistics
     * @param arguments A string array of form
     *                  {}
     * @param container A container containing the data or means to retrieve it
     * @return the requested statistic
     * @throws Exception if the Team or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String sport = arguments.get(SPORT_SLOT);
        switch(sport.toLowerCase()) {
            case "hockey":
                return this.hockeyTeamStatManager.execute(arguments, container);
            case "tennis":
                return this.tennisTeamStatManager.execute(arguments, container);
            case "baseball":
                return this.baseballTeamStatManager.execute(arguments, container);
            default:
                throw new Exception(Exceptions.WRONG_SPORT);
        }
    }
}
