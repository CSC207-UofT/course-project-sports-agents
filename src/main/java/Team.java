import java.util.ArrayList;

public abstract class Team {
    private String name;
    private String homeCity;
    private ArrayList<Player> players;
    private ArrayList<Game> playedGames;

    /**
     * Get name
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Set name
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get home city
     * @return homeCity
     */
    public String getHomeCity(){
        return homeCity;
    }

    /**
     * Set home city
     * @param homeCity
     */
    public void setHomeCity(String homeCity){
        this.homeCity = homeCity;
    }

    /**
     * Get players
     * @return players
     */
    public ArrayList<Player> getPlayers(){
        return players;
    }

    /**
     * Set players
     * @param players
     */
    public void setPlayers(ArrayList<Player> players){
        this.players = players;
    }

    /**
     * Get played games
     * @return playedGames
     */
    public ArrayList<Game> getPlayedGames(){
        return playedGames;
    }
    
    /**
     * Set played games
     * @param playedGames
     */
    public void setPlayedGames(ArrayList<Game> playedGames){
        this.playedGames = playedGames;
    }
}
