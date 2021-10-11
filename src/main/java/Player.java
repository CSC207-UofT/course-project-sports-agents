
/**
 * This is an abstract class for any future players that need to be added.
 */

public abstract class Player {
    private String name;
    private int age;
    private String nationality;

    public Player(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    public Player() {}

    /**
     * Record this player's name
     * @param name the name of the player
     */
    public void setName(String name) {
        this.name = name;
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
     * Record this player's nationality
     * @param nationality the player's nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Return this player's nationality
     * @return player's nationality
     */
    public String getNationality() {
        return this.nationality;
    }

    // TODO: add a gamesPlayed parameter and an addGame method

}

