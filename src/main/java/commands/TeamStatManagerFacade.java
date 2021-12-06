package commands;

import constants.Exceptions;
import driversAdapters.DataContainer;
import team.TeamConstants;
import drivers_adapters.DataContainer;

import java.util.ArrayList;

public class TeamStatManagerFacade implements Command{
    private final HockeyTeamStatManager hockeyTeamStatManager;

    public TeamStatManagerFacade(HockeyTeamStatManager hockeyTeamStatManager) {
        this.hockeyTeamStatManager = hockeyTeamStatManager;
    }

    /**
     * Handle an argument requesting a team's statistics
     * @param arguments A string array of form
     *                  {"sport name", "team name",
     *                  "season", "stat name"}
     * @param container A container containing the data or means to retrieve it
     * @return the requested statistic
     * @throws Exception if the Team or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String sport = arguments.get(0);
        switch(sport.toLowerCase()) {
            case "hockey":
                return this.hockeyTeamStatManager.execute(arguments, container);
            default:
                throw new Exception(Exceptions.WRONG_SPORT);
        }
    }
}
