package player;

import constants.Exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Store a list of Players
 */
public class PlayerList<T extends Player> {
    // Key is primary key for player, value is Player
    private Map<String, T> playerMap;
    private List<String> seasons;

    /**
     * Create a new empty PlayerList
     */
    public PlayerList() {
        this.playerMap = new HashMap<>();
        this.seasons = new ArrayList<>();
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
        throw new Exception(Exceptions.PLAYER_NOT_FOUND);
    }

    public List<T> getPlayers(List<String> names) throws Exception {
        List<T> players = new ArrayList<>();
        for (String name : names) {
            players.add(this.getPlayer(name));
        }
        return players;
    }

    /**
     * Set the playerMap for this PlayerList
     * @param playerMap map of players
     */
    public void setPlayerMap(Map<String, T> playerMap) {
        this.playerMap = playerMap;
    }


    /**
     * Set the seasons included in this PlayerList
     * @param seasons list of seasons
     */
    public void setSeasons(List<String> seasons) {
        this.seasons = seasons;
    }


    /**
     * Return the seasons included in this PlayerList
     * @return list of seasons
     */
    public List<String> getSeasons() {
        return this.seasons;
    }


    /**
     * Return the map of players in this PlayerList
     * @return map of players
     */
    public Map<String, T> getPlayerMap() {
        return this.playerMap;
    }
}