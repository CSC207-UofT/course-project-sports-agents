package player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is an abstract class for any future players that need to be added.
 */

public abstract class Player {
    protected final String name;
    // Keys are seasons, values are Team name
    protected HashMap<String, String> teamRecord;

    /**
     * @param name the Player's name
     */
    public Player(String name) {
        this.name = name;
        this.teamRecord = new HashMap<>();
    }

    /**
     * Return this player's name
     * @return player's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Record the Player played under a given team in the given season
     * @param season the season the Player played in
     * @param team the team the Player played with
     * @throws Exception if information on that season is already recorded
     */
    public void addStatTeam(String season, String team) throws Exception {
        checkForSeason(this.teamRecord, season, false);
        this.teamRecord.put(season, team);
    }

    /**
     * @param season the season of interest
     * @return the Player's team for the season of interest
     * @throws Exception if the Player did not perform in that season
     */
    public String getStatTeam(String season) throws Exception {
        checkForSeason(this.teamRecord, season, true);
        return this.teamRecord.get(season);
    }

    /**
     * Check if a map containing statistics has a record for a given season
     * @param dataMap the map to check
     * @param season the season to check for
     * @param expected the expectation for if data is stored
     * @throws Exception if the expectation is violated
     */
    public void checkForSeason(Map dataMap, String season,
                               boolean expected) throws Exception {
        if (dataMap.containsKey(season) != expected) {
            // We expect data, but there is none
            if (expected) {
                throw new Exception("Information on " + season +
                        " is not recorded!");
            }
            // We expect nothing, but there is data
            else {
                throw new Exception("Information on " + season +
                        " already exists!");
            }
        }
    }

    /**
     * Create a string representation of this player
     * @return player in string representation
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Compare two players to check if they are equal
     * @param obj another player
     * @return true if the two players are the same, and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Player other = (Player) obj;
        return this.name.equals(other.name);
    }

    /**
     * Implement hashCode, for using Players in hashmaps
     * @return hashCode of player name
     */
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }



}

