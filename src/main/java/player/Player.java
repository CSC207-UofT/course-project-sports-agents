package player;

import java.util.*;

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
     * Return the given stat.
     * @param stat stat that needs to be reported
     * @return the needed stat of the player (as a string)
     * @throws Exception if the given stat is not a possible stat associated with the player
     */
    public abstract String getNeededStat(String stat) throws Exception;

    /**
     *
     * @return a mapping from the stats in string format as keys and the value of these stats
     * in string format as values. This mapping is used to store valid stats and throw exception in getNeededStat method
     * is the given stat is not possible.
     */
    public abstract Map<String, String> mapStats();
}

