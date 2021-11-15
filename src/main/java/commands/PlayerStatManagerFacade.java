package commands;

import constants.Exceptions;
import drivers_adapters.DataContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Facade design pattern.
 * Passes a command requesting a player statistic to the appropriate sport stat manager
 */
public class PlayerStatManagerFacade implements Command {
    private final HockeyPlayerStatManager hockeyPlayerStatManager;
    private final TennisPlayerStatManager tennisPlayerStatManager;
    private final BaseballPlayerStatManager baseballPlayerStatManager;

    public PlayerStatManagerFacade(HockeyPlayerStatManager hockeyPlayerStatManager,
                                   TennisPlayerStatManager tennisPlayerStatManager,
                                   BaseballPlayerStatManager baseballPlayerStatManager) {
        this.hockeyPlayerStatManager = hockeyPlayerStatManager;
        this.tennisPlayerStatManager = tennisPlayerStatManager;
        this.baseballPlayerStatManager = baseballPlayerStatManager;
    }

    /**
     * Handle an argument requesting a player's statistics
     * @param arguments A string array of form
     *                  {"sport name", "player name",
     *                  "season", "stat name"}
     * @param container A container containing the data or means to retrieve it
     * @return the requested statistic
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String sport = arguments.get(0);
        switch(sport) {
            case "Hockey":
                return this.hockeyPlayerStatManager.execute(arguments, container);
            case "Tennis":
                return this.tennisPlayerStatManager.execute(arguments, container);
            case "Baseball":
                return this.baseballPlayerStatManager.execute(arguments, container);
            default:
                throw new Exception(Exceptions.INVALID_ARGUMENT);
        }
    }
}
