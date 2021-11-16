package commands;

import java.util.ArrayList;

import constants.Exceptions;
import drivers_adapters.DataContainer;
import team.TeamConstants;

public class TeamStatComparerFacade implements Command, TeamConstants {
    private final HockeyTeamStatComparer hockeyTeamStatComparer;
    private final TennisTeamStatComparer tennisTeamStatComparer;
    private final BaseballTeamStatComparer baseballTeamStatComparer;

    public TeamStatComparerFacade(HockeyTeamStatComparer hockeyTeamStatComparer,
                                   TennisTeamStatComparer tennisTeamStatComparer,
                                   BaseballTeamStatComparer baseballTeamStatComparer) {
        this.hockeyTeamStatComparer = hockeyTeamStatComparer;
        this.tennisTeamStatComparer = tennisTeamStatComparer;
        this.baseballTeamStatComparer = baseballTeamStatComparer;
    }

    /**
     * Handle an argument requesting a comparison of two or more hockey
     * teams' statistics. Teams are returned in descending order
     * (best first, worst last)
     * @param arguments A string array of form
     *                  {}
     * @param container A container containing the data or means to retrieve it
     * @return the teams and their associated statistics
     * @throws Exception if a team does not exists, or lacks data for the
     * given season
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String sport = arguments.get(SPORT_SLOT);
        switch(sport.toLowerCase()) {
            case "hockey":
                return this.hockeyTeamStatComparer.execute(arguments, container);
            case "tennis":
                return this.tennisTeamStatComparer.execute(arguments, container);
            case "baseball":
                return this.baseballTeamStatComparer.execute(arguments, container);
            default:
                throw new Exception(Exceptions.WRONG_SPORT);
        }
    }
}
