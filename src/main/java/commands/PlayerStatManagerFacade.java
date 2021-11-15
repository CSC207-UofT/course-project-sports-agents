package commands;

import java.util.List;

/**
 * Facade design pattern.
 * Passes a command requesting a player statistic to the appropriate sport stat manager
 */
public class PlayerStatManagerFacade implements Command {
    private final HockeyPlayerStatManager hockeyPlayerStatManager;
    private final TennisPlayerStatManager tennisPlayerStatManager;

    public PlayerStatManagerFacade(HockeyPlayerStatManager hockeyPlayerStatManager,
                                   TennisPlayerStatManager tennisPlayerStatManager, BaseballPlayerStatManager baseballPlayerStatManager) {
        this.hockeyPlayerStatManager = hockeyPlayerStatManager;
        this.tennisPlayerStatManager = tennisPlayerStatManager;
    }

    /**
     * Handle an argument requesting a player's statistics
     * @param arguments A string array of form
     *                  {"get_player_stat", "stat name", "player name",
     *                  "season", "stat name"}
     * @return the requested statistic
     * @throws Exception if the Player or season does not exist
     */
    @Override
    public String execute(List<String> arguments) throws Exception {
        String sport = arguments.get(1);
        switch(sport) {
            case "Hockey":
                return this.hockeyPlayerStatManager.execute(arguments);
            case "Tennis":
                return this.tennisPlayerStatManager.execute(arguments);
            default:
                throw new Exception("Invalid sport passed!");
        }
    }
}
