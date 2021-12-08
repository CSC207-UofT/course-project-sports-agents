package commands;


import constants.Exceptions;
import driversAdapters.DataContainer;
import java.util.*;

/**
 * Return a list of available sports, valid stats for each sport, and available users for each
 * season and sport so that the user will have a background of the program.
 */
public class GetListPlayers implements Command{

    /**
     * Return the players for the given season
     * @param arguments a String Array of form {"sport", "season"}
     * @param container a container with player and team data
     * @return the appropriate players for the given sport and season
     * @throws Exception if the given sport or season is invalid
     */
    @Override
    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        checkArgumentLength(arguments);
        String sportName = arguments.get(0);
        String season = arguments.get(1);
        List<String> listAllPlayers =  container.getAllPlayers(sportName, season);
        return formatGetListPlayers(listAllPlayers);
    }

    /**
     * @param arguments user arguments for returning all players
     * @throws Exception if the number of arguments provided is not 2
     */
    private void checkArgumentLength(ArrayList<String> arguments) throws Exception {
        if (arguments.size() != 2) {
            throw new Exception(Exceptions.WRONG_ARGUMENT_NUMBER);
        }
    }

    private String formatGetListPlayers(List<String> listAllPlayers) {
        StringBuilder output = new StringBuilder();
        output.append("All available players for the demanded sport and season:\n");
        for (int i = 0; i < listAllPlayers.size(); i++){
            if(i % 10 == 0){
                output.append("\n");
            }
            output.append(listAllPlayers.get(i));
            output.append(", ");
        }
        output.delete(output.length() - 2, output.length());
        output.append("\n");
        return output.toString();
    }

}
