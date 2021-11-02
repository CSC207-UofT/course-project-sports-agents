package player;

import java.util.Map;
import java.util.Objects;

/**
 * This is an abstract class for any future players that need to be added.
 */

public abstract class Player {
    public final String name;


    /**
     * Construct a player.Player with name
     * @param name player.Player's name
     */
    public Player(String name) {
        this.name = name;
    }


    /**
     * Create a string representation of this player
     * @return player in string representation
     */
    @Override
    public String toString() {
        return "Name: " + this.name;
    }


    /**
     * Return this player's name
     * @return player's name
     */
    public String getName() {
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
        return Objects.equals(this.name, other.name);
    }


    /**
     * Return the given map of stats.
     * @param stat stat that needs to be reported
     * @return a map of the needed stat for this player
     * @throws Exception if the given stat is not a possible stat associated with the player
     */
    public abstract Map<String, Integer> getNeededStat(String stat) throws Exception;





}

