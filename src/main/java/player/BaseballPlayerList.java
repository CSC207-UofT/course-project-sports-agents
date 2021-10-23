package player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A class that stores a list of baseball players that participated in specific seasons.
 */

public class BaseballPlayerList {
    private final HashMap<String, ArrayList<BaseballPlayer>> seasonToPlayers;
    static final int SEASON = 0;
    static final int NAME = 1;
    static final int TEAM = 2;
    static final int POSITION = 3;
    static final int GAMES_PLAYED = 4;
    static final int HITS = 5;
    static final int HOME_RUNS = 6;
    static final int WALKS = 7;
    static final int STRIKEOUTS = 8;
    static final int WINS_ABOVE_REPLACEMENT = 9;


    /**
     * Construct a map that maps seasons to a list of baseball players using the data in the sample data file.
     */
    public BaseballPlayerList() {
        seasonToPlayers = new HashMap<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Baseball_Player_Sample_Data.csv"));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!(seasonToPlayers.containsKey(data[SEASON]))) {
                    seasonToPlayers.put(data[SEASON], new ArrayList<>());
                }
                seasonToPlayers.get(data[SEASON]).add(new BaseballPlayer(data[NAME].trim(), data[TEAM], data[POSITION],
                Integer.parseInt(data[GAMES_PLAYED]), Integer.parseInt(data[HITS]), Integer.parseInt(data[HOME_RUNS]),
                        Integer.parseInt(data[WALKS]), Integer.parseInt(data[STRIKEOUTS]),
                        Double.parseDouble(data[WINS_ABOVE_REPLACEMENT])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Return the baseball player with the given name, who participated in the given season
     * @param season the needed season
     * @param name the needed player's name
     * @return the baseball player
     * @throws Exception if the player is not found, or the season is not found
     */
    public BaseballPlayer findBaseballPlayer(String season, String name) throws Exception {
        if (!(seasonToPlayers.containsKey(season))) {
            throw new Exception("Season not found!");
        }
        for(BaseballPlayer player : seasonToPlayers.get(season)) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        throw new Exception("Player not found!");
    }


    /**
     * Return true if the player with the given name participated in the given season, and false otherwise
     * @param neededSeason the needed season
     * @param name name of the needed player
     * @return true if the player is found, and false otherwise
     */
    public boolean seasonContainsPlayer(String neededSeason, String name) {
        for (BaseballPlayer player : seasonToPlayers.get(neededSeason)) {
            if (player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Finds all the seasons the player with the given name participated in, and returns a list of the player's stats
     * for each season (as separate player objects of the same player)
     * @param name the name of the needed player
     * @return a list of a baseball player in different seasons
     * @throws Exception if the player was not found
     */
    public List<BaseballPlayer> findAllSeasons(String name) throws Exception {
        List<BaseballPlayer> neededPlayers = new ArrayList<>();
        for (String season : seasonToPlayers.keySet()) {
            if (seasonContainsPlayer(season, name)) {
                neededPlayers.add(findBaseballPlayer(season, name));
            }
        }
        return neededPlayers;
    }
}
