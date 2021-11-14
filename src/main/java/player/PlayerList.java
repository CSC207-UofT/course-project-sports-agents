package player;


import team.*;

import java.util.*;

/**
 * Store a list of Players
 */
public class  PlayerList<T extends Player> {
    // Key is primary key for player, value is Player
    protected HashMap<String, T> playerMap;



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

    public List<T> getPlayers(List<String> names) throws Exception {
        List<T> players = new ArrayList<T>();
        for (String name : names) {
            players.add(this.getPlayer(name));
        }
        return players;
    }

    public HashMap<String, T> getPlayerMap() {
        return playerMap;
    }



}

