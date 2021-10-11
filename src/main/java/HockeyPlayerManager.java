import java.util.ArrayList;

/**
 * A class for creating and storing hockey players.
 */

public class HockeyPlayerManager {
    private ArrayList<HockeyPlayer> HockeyPlayers;

    public HockeyPlayerManager() {
        this.HockeyPlayers = new ArrayList<>();
    }

    /**
     * Create and add a hockey player to this manager
     * @param name player's name
     * @param age player's age
     * @param nationality player's nationality
     * @param position player's position
     * @param team player's team
     */
    public void addHockeyPlayer(String name, int age, String nationality, String position, String team, int goals,
                                int assists, int points) {
        HockeyPlayer player = new HockeyPlayer(name, age, nationality, position, team, goals, assists, points);
        HockeyPlayers.add(player);
    }

    /**
     * Add a hockey player to this manager
     * @param player hockey player to be added
     */
    public void addHockeyPlayer(HockeyPlayer player) {
        HockeyPlayers.add(player);
    }


    /**
     * Return a list of hockey players.
     * @return players
     */
    public ArrayList<HockeyPlayer> getHockeyPlayers() {
        return this.HockeyPlayers;
    }
}
