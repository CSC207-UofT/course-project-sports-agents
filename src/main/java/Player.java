import java.util.ArrayList;
import java.util.Objects;

/**
 * This is an abstract class for any future players that need to be added.
 */

public abstract class Player {
    private final String name;
    private int age;
    private final String nationality;


    /**
     * Construct a Player with name, age, and nationality
     * @param name Player's name
     * @param age Player's age
     * @param nationality Player's nationality
     */
    public Player(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }


    /**
     * Create a string representation of this player
     * @return player in string representation
     */
    @Override
    public String toString() {
        return "Name: " + this.name + "\nAge: " + this.age + "\nNationality: " + this.nationality;
    }


    /**
     * Return this player's name
     * @return player's name
     */
    public String getName() {
        return this.name;
    }


    /**
     * Record this player's age
     * @param age the player's age
     */
    public void setAge(int age) {
        this.age = age;
    }


    /**
     * Return this player's age
     * @return player's age
     */
    public int getAge() {
        return this.age;
    }

    
    /**
     * Return this player's nationality
     * @return player's nationality
     */
    public String getNationality() {
        return this.nationality;
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        } else if (!Objects.equals(this.nationality, other.nationality)) {
            return false;
        } else return this.age == other.age;
    }
}

