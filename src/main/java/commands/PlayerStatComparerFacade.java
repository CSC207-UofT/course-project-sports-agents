package commands;

import constants.Exceptions;
import driversAdapters.DataContainer;
import sports.baseball.BaseballPlayerStatComparer;
import sports.hockey.HockeyPlayerStatComparer;
import sports.tennis.TennisPlayerStatComparer;

import java.util.ArrayList;

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
     *
     * @param arguments A string array of form
     *                  {"sport name", "player name 1",
     *                  "player name 2", ... , "season", "stat name"}
     * @param container A container containing the data or means to retrieve it
     * @return the players and their associated statistics
     * @throws Exception if a player does not exists, or lacks data for the
     *                   given season
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        checkArgumentLength(arguments);
        String sport = arguments.get(0);
        switch (sport) {
            case "hockey":
                return this.hockeyPlayerStatComparer.execute(arguments, container);
            case "tennis":
                return this.tennisPlayerStatComparer.execute(arguments, container);
            case "baseball":
                return this.baseballPlayerStatComparer.execute(arguments, container);
            default:
                throw new Exception(Exceptions.WRONG_SPORT);
        }
    }

    // The Facade needs to check at least one argument exists, so this is here
    // even though Single Responsibility would prefer it be in Sport-specific classes

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
