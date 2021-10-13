import java.util.ArrayList;

/**
 * This is an abstract class for any future players that need to be added.
 */

public abstract class Player {
    private final String name;
    private int age;
    private final String nationality;
    private ArrayList<Match> matches;


    /**
     * Construct a Player with name, age, nationality, and matches they have participated in
     * @param name Player's name
     * @param age Player's age
     * @param nationality Player's nationality
     */
    public Player(String name, int age, String nationality, ArrayList<Match> matches) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.matches = matches;
    }


    /**
     * Construct a player who has not participated in any matches
     * @param name player's name
     * @param age player's age
     * @param nationality player's nationality
     */
    public Player(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.matches = new ArrayList<>();
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
     * Record the matches this player has participated in
     * @param matches player's matches
     */
    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

}

