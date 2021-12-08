package commands;


import driversAdapters.DataContainer;

import java.io.*;
import java.util.*;

/**
 * A class for searching a player through all the available players, only by
 * knowing some parts of the player's name.
 */
public class Search implements Command {
    public String execute(ArrayList<String> arguments, DataContainer container) throws IOException {
        String partOfName = arguments.get(0);
        List<String> relatedPlayers = new ArrayList<>();
        for (String playerName : container.getAllPlayersForAllSports()) {
            if (playerName.toLowerCase().contains(partOfName.toLowerCase())) {
                relatedPlayers.add(playerName);
            }
        }
        return formatSearch(relatedPlayers);

    }

    private String formatSearch(List<String> relatedPlayers) {
        if (relatedPlayers.isEmpty()) {
            return "No results found!";
        }
        StringBuilder output = new StringBuilder();
        for (String relatedPlayer : relatedPlayers) {
            output.append(relatedPlayer);
            output.append("\n");
        }
        return output.toString();
    }


}
