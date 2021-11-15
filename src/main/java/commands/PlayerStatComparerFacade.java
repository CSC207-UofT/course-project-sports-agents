package commands;

import drivers_adapters.DataContainer;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatComparerFacade implements Command {
    private final HockeyPlayerStatComparer hockeyPlayerStatComparer;
    private final TennisPlayerStatComparer tennisPlayerStatComparer;
    private final BaseballPlayerStatComparer baseballPlayerStatComparer;

    public PlayerStatComparerFacade(HockeyPlayerStatComparer hockeyPlayerStatComparer,
                                    TennisPlayerStatComparer tennisPlayerStatComparer,
                                    BaseballPlayerStatComparer baseballPlayerStatComparer) {
        this.hockeyPlayerStatComparer = hockeyPlayerStatComparer;
        this.tennisPlayerStatComparer = tennisPlayerStatComparer;
        this.baseballPlayerStatComparer = baseballPlayerStatComparer;
    }

    /**
     * Handle an argument requesting a comparison of two or more hockey
     * players' statistics. Players are returned in descending order
     * (best first, worst last)
     * @param arguments A string array of form
     *                  {"compare_player_stat", "sport name", "player name 1",
     *                  "player name 2", ... , "season", "stat name"}
     * @return the players and their associated statistics
     * @throws Exception if a player does not exists, or lacks data for the
     * given season
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String sport = arguments.get(1);
        switch(sport) {
            case "Hockey":
                return this.hockeyPlayerStatComparer.execute(arguments, container);
            case "Tennis":
                return this.tennisPlayerStatComparer.execute(arguments, container);
            case "Baseball":
                return this.baseballPlayerStatComparer.execute(arguments, container);
            default:
                throw new Exception("Invalid sport passed!");
        }
    }
}
