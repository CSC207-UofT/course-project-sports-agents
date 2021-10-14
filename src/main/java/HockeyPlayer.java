import java.util.ArrayList;

/**
 * This class represents a hockey player.
 */

public class HockeyPlayer extends Player {
    private String position;
    private String team;
    private int goals;
    private int assists;
    private int points;


    /**
     * Create a Hockey player with the following information specified
     * @param name player's name
     * @param age player's age
     * @param nationality player's nationality
     * @param position player's position
     * @param team player's team
     * @param goals player's number of goals
     * @param assists player's number of assists
     * @param points player's number of points
     */
    public HockeyPlayer(String name, int age, String nationality, String position, String team, int goals,
                        int assists, int points) {
        super(name, age, nationality);
        this.position = position;
        this.team = team;
        this.goals = goals;
        this.assists = assists;
        this.points = points;
    }


    /**
     * Create a Hockey Player with 0 points and 0 matches
     * @param name Player's name
     * @param age Player's age
     * @param nationality Player's nationality
     */
    public HockeyPlayer(String name, int age, String nationality) {
        super(name, age, nationality);
        this.goals = 0;
        this.assists = 0;
        this.points = 0;
    }


    /**
     * Return a string representation of this hockey player
     * @return hockey player in string representation
     */
    @Override
    public String toString() {
        String partOne = super.toString();
        return partOne + "\nGoals: " + this.goals + "\nAssists: " + this.assists + "\nPoints: " + this.points;
    }


    /**
     * Record the player's position
     * @param position player's position on team
     */
    public void setPosition(String position) {
        this.position = position;
    }


    /**
     * Return this player's position on the HockeyTeam
     * @return player's position
     */
    public String getPosition() {
        return this.position;
    }


    /**
     * Record this player's team
     * @param team player's team
     */
    public void setTeam(String team) {
        this.team = team;
    }


    /**
     * Return this player's team
     * @return player's team
     */
    public String getTeam() {
        return this.team;
    }


    /**
     * Update the player's number of points to equal number of goals plus number of assists
     */
    private void updatePoints() {
        this.points = this.goals + this.assists;
    }


    /**
     * Increase the player's number of goals by 1 when the player has shot a goal
     * Update points accordingly
     */
    public void setGoals(int goals) {
        this.goals = goals;
        this.updatePoints();
    }


    /**
     * Increase the player's number of assists by 1 when the player has made an assist
     * Update points accordingly
     */
    public void setAssists(int assists) {
        this.assists = assists;
        this.updatePoints();
    }


    /**
     * Return the number of goals made by this player
     * @return number of goals
     */
    public int getGoals() {
        return this.goals;
    }


    /**
     * Return the number of assists made by this player
     * @return number of assists
     */
    public int getAssists() {
        return this.assists;
    }


    /**
     * Return the total number of points this player has
     * @return number of points
     */
    public int getPoints() {
        return this.points;
    }

}

