import java.util.ArrayList;

/**
 * This class represents a tennis player.
 */

public class TennisPlayer extends Player {
    private int setsWon;
    private int setsLost;
    private int gamesWon;
    private int gamesLost;

    /**
     * Construct a tennis player with the following information specified
     * @param name player's name
     * @param age player's age
     * @param nationality player's nationality
     * @param setsWon number of sets won by player
     * @param setsLost number of sets lost by player
     * @param gamesWon number of games won by player
     * @param gamesLost number of games lost by player
     */
    public TennisPlayer(String name, int age, String nationality, int setsWon, int setsLost,
                        int gamesWon, int gamesLost) {
        super(name, age, nationality);
        this.setsWon = setsWon;
        this.setsLost = setsLost;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
    }


    /**
     * Construct a tennis player who has participated in 0 rounds, and has 0 sets won and lost,
     * and 0 games won and lost
     * @param name player's name
     * @param age player's age
     * @param nationality player's nationality
     */
    public TennisPlayer(String name, int age, String nationality) {
        super(name, age, nationality);
        this.setsWon = 0;
        this.setsLost = 0;
        this.gamesWon = 0;
        this.gamesLost = 0;
    }


    /**
     * Record the number of sets won by this player
     * @param setsWon number of sets won
     */
    public void setSetsWon(int setsWon) {
        this.setsWon = this.setsWon + setsWon;
    }


    /**
     * Update the number of sets won by this player
     * @param sets number of new sets won by player
     */
    public void updateSetsWon(int sets) {
        this.setsWon = this.setsWon + sets;
    }


    /**
     * Return the number of sets won by this player
     * @return number of sets won
     */
    public int getSetsWon() {
        return this.setsWon;
    }


    /**
     * Update the number of sets lost by this player
     * @param sets number of new sets lost by this player
     */
    public void updateSetsLost(int sets) {
        this.setsLost = this.setsLost + sets;
    }

    /**
     * Record the number of sets lost by this player
     * @param setsLost number of sets lost
     */
    public void setSetsLost(int setsLost) {
        this.setsLost = setsLost;
    }


    /**
     * Return the number of sets lost by this player
     * @return number of sets lost
     */
    public int getSetsLost() {
        return this.setsLost;
    }


    /**
     * Update the number of games won by this player
     * @param games number of new games won by this player
     */
    public void updateGamesWon(int games) {
        this.gamesWon = this.gamesWon + games;
    }


    /**
     * Record the number of games won by this player
     * @param gamesWon number of games won
     */
    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }


    /**
     * Return the number of games won by this player
     * @return number of games won
     */
    public int getGamesWon() {
        return this.gamesWon;
    }


    /**
     * Update the number of games lost by this player
     * @param games number of new games lost by this player
     */
    public void updateGamesLost(int games) {
        this.gamesLost = this.gamesLost + games;
    }


    /**
     * Record the number of games lost by this player
     * @param gamesLost number of games lost
     */
    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }


    /**
     * Return the number of games lost by this player
     * @return number of games lost
     */
    public int getGamesLost() {
        return this.gamesLost;
    }


    /**
     * Return a string representation of this tennis player
     * @return tennis player string
     */
    @Override
    public String toString() {
        String partOne = super.toString();
        return partOne + "\nSets Won: " + this.setsWon + "\nSets Lost: " + this.setsLost +
                "\nGames Won: " + this.gamesWon + "\nGames Lost: " + this.gamesLost;
    }

}