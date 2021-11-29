package commands;

import java.io.*;
import java.util.*;

/**
 * A class for searching a player through all the available players, only by
 * knowing some parts of the player's name.
 */
public class Search {
    public List<String> search(String partOfName) throws IOException {
        List<String> relatedPlayers = new ArrayList<>();
        for(String playerName: getAllPlayersForAllSports()){
            if(playerName.contains(partOfName.toLowerCase())){
                relatedPlayers.add(playerName);
            }
        }
        return relatedPlayers;

    }

    public List<String> getAllPlayersForAllSports() throws IOException {
        List<String> allNames = new ArrayList<>();
        allNames.addAll(getAllHockeyPlayers());
        allNames.addAll(getAllBaseballPlayers());
        //allNames.addAll(getAllTennisPlayers());

        return allNames;

    }
    public List<String> getAllHockeyPlayers() throws IOException {
        List<String> allHockeyNames = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("hockey.csv"));
        br.readLine(); //skip the first line.
        String line;
        String splitBy = ",";

        while((line = br.readLine()) != null) {
            String[] playerInfo = line.split(splitBy);
            if (!allHockeyNames.contains(playerInfo[0].toLowerCase()+ ": Hockey")){
                allHockeyNames.add(playerInfo[0].toLowerCase()+ ": Hockey");}
        }
        return allHockeyNames;

    }
    public List<String> getAllBaseballPlayers() throws IOException {
        List<String> allBaseballNames = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("baseball.csv"));
        br.readLine(); //skip the first line.
        String line;
        String splitBy = ",";

        while((line = br.readLine()) != null) {
            String[] playerInfo = line.split(splitBy);
            if (!allBaseballNames.contains(playerInfo[0].toLowerCase()+ ": Baseball")){
                allBaseballNames.add(playerInfo[0].toLowerCase()+ ": Baseball");}
        }
        return allBaseballNames;

    }

    public List<String> getAllTennisPlayers() throws IOException {return null;}

}
