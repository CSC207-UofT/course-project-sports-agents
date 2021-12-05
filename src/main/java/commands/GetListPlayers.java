package commands;


import constants.*;
import drivers_adapters.*;
import player.*;

import java.io.*;
import java.util.*;

/**
 * Return a list of available sports, valid stats for each sport, and available users for each
 * season and sport so that the user will have a background of the program.
 */
public class GetListPlayers implements Command{

    public String execute(ArrayList<String> arguments, DataContainer container) throws Exception {
        String sportName = arguments.get(1);
        String season = arguments.get(2);
        List<String> listAllPlayers =  container.getAllPlayers(sportName, season);
        return formatGetListPlayers(listAllPlayers);
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
        return output.toString();
    }

}
