package player;

import java.util.*;

/**
 * Store a list of Players
 */
public class PlayerList<T extends Player> {
    // Key is primary key for player, value is Player
    private HashMap<String, T> playerMap;

    /**
     * Create a new empty PlayerList
     */
    public PlayerList() {
        this.playerMap = new HashMap<String, T>();
    }

    /**
     * Add a Player to the PlayerList
     * @param player the player to add
     */
    public void addPlayer(T player) {
        this.playerMap.put(player.getName(), player);
    }

    /**
     * Return the Players with the given name, if one exists
     * @param name name to search for
     * @return a Players with the given name
     * @throws Exception if no such player exists
     */
    public T getPlayer(String name) throws Exception {
        if (this.playerMap.containsKey(name)) {
            return this.playerMap.get(name);
        }
        throw new Exception("The requested Player does not exist!");
    }

    /*
    private HashMap<String, List<HockeyPlayer>> playerMap = new HashMap<>();

    public PlayerList() {
        String line = "";
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("filtered_summary.csv"));
            br.readLine(); //skip the first line.
            List<String> seasons = Arrays.asList("20162017", "20172018", "20182019","20192020", "20202021");
            for (String season: seasons){
                this.playerMap.put(season, new ArrayList<>());} //adding seasons as keys with empty lists as values

            while((line = br.readLine()) != null) {
                String[] playerInfo = line.split(splitBy);
                for (String season: seasons){
                    if (playerInfo[1].equals(season)){ //adding player.Player object to the corresponding season
                        this.playerMap.get(season).add(new HockeyPlayer(playerInfo[0], playerInfo[1],
                                playerInfo[2], playerInfo[3], playerInfo[4], playerInfo[5], playerInfo[6],
                                playerInfo[7], playerInfo[8], playerInfo[9], playerInfo[10]));
                    }
                }

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public HashMap<String, List<HockeyPlayer>> getPlayerMap() {
        return this.playerMap;
    }
     */
}
