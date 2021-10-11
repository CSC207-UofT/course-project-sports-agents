/**
 * This class represents a hockey player.
 */

public class HockeyPlayer extends Player {
    private String position;
    private String team;

    public HockeyPlayer(String name, int age, String nationality, String position, String team) {
        super(name, age, nationality);
        this.position = position;
        this.team = team;
    }

    public HockeyPlayer(String name, int age, String nationality) {
        super(name, age, nationality);
    }

    public HockeyPlayer() {}

    /**
     * Set the player's position
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

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return this.team;
    }

}

