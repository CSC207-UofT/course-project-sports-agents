package commands;

import java.util.List;

public class PlayerStatComparerFacade implements Command {
    private final HockeyPlayerStatComparer hockeyPlayerStatComparer;
    private final TennisPlayerStatComparer tennisPlayerStatComparer;

    public PlayerStatComparerFacade(HockeyPlayerStatComparer hockeyPlayerStatComparer,
                                   TennisPlayerStatComparer tennisPlayerStatComparer) {
        this.hockeyPlayerStatComparer = hockeyPlayerStatComparer;
        this.tennisPlayerStatComparer = tennisPlayerStatComparer;
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
    public String execute(List<String> arguments) throws Exception {
        String sport = arguments.get(1);
        switch(sport) {
            case "Hockey":
                return this.hockeyPlayerStatComparer.execute(arguments);
            case "Tennis":
                return this.tennisPlayerStatComparer.execute(arguments);
            default:
                throw new Exception("Invalid sport passed!");
        }
    }
}
