package player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Read csv file and create a hash map where the key is the name of the player and the value is a Hockey Player
 * object.
 */
public class HockeyPlayerList extends PlayerList<HockeyPlayer> {

    public HockeyPlayerList() {
        Map<String, HockeyPlayer> playerMap = new HashMap<>();
        List<String> seasons = new ArrayList<>();
        String line;
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("hockey.csv"));
            br.readLine(); //skip the first line.
            while ((line = br.readLine()) != null) {
                String[] playerInfo = line.split(splitBy);
                HockeyPlayer player = this.getPlayer(playerMap, playerInfo[0]);
                if (!(seasons.contains(playerInfo[1]))) {
                    seasons.add(playerInfo[1]);
                }
                player.addRecord(playerInfo[1],
                        playerInfo[2], playerInfo[3], playerInfo[4], Integer.parseInt(playerInfo[5]),
                        Integer.parseInt(playerInfo[6]), Integer.parseInt(playerInfo[7]),
                        Integer.parseInt(playerInfo[8]), Integer.parseInt(playerInfo[9]),
                        Double.parseDouble(playerInfo[10]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setPlayerMap(playerMap);
        Collections.reverse(seasons);
        this.setSeasons(seasons);
    }

    /**
     * A helper method for the constructor. It finds the player with the given name in playerMap if that player exists.
     * If that player does not exist, it creates the player and adds it to playerMap.
     * @param playerMap map of all the players that already exist
     * @param name the name of the needed player
     * @return a hockey player with the given name
     */
    private HockeyPlayer getPlayer(Map<String, HockeyPlayer> playerMap, String name) {
        HockeyPlayer player = new HockeyPlayer(name);
        if (!(playerMap.containsKey(name))) {
            playerMap.put(name, player);
            return player;
        } else {
            return playerMap.get(name);
        }
    }

}
