package commands;

import constants.*;
import driversAdapters.DataContainer;

import java.util.*;

public class GetListStats implements Command {
    /**
     * Return the stats for the given sport
     *
     * @param arguments a string array of form {"sport"}
     * @param container a container of sport data
     * @return the stats for the given sport
     * @throws Exception if the sport is not implemented, or no sport argument is given
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        checkArgLength(arguments);
        String sportName = arguments.get(0);
        switch (sportName.toLowerCase()) {
            case "hockey":
                return "All available Stats For " + sportName + "\n" +
                       "Team\n" + "Skater Shoots\n" + "Position\n" + "Games Played\n" +
                       "Goals\n" + "Assists\n" + "Points\n" + "Shots\n" + "Shooting Percentage\n";

            case "baseball":
                return "All available Stats For " + sportName + "\n" +
                       "Team\n" + "Position\n" + "Games Played\n" + "At Bats\n" +
                       "Runs\n" + "Hits\n" + "Home Runs\n" + "Runs Batted In\n" + "Strike Outs\n" +
                       "Average\n";

            case "tennis":
                return "All available Stats For " + sportName + "\n" +
                       "Rank\n" + "Matches n\n" + "Aces\n" + "Double Faults\n" +
                       "Serve Points Won\n" + "Breakpoints Saved\n" + "Serve Games Won\n" +
                       "Return Games Won\n" + " Break Points Converted\n" +
                       "Return Points Won\n";
        }
        throw new Exception(Exceptions.WRONG_SPORT);

    }

    /**
     * Check that only one argument is provided
     *
     * @param arguments user argument for which sport to return stats for
     * @throws Exception if the user provided more or less than one argument
     */
    private void checkArgLength(ArrayList<String> arguments) throws Exception {
        if (arguments.size() != 1) {
            throw new Exception(Exceptions.WRONG_ARGUMENT_NUMBER);
        }
    }


}
