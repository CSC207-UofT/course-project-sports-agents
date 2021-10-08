import java.util.ArrayList;

public abstract class Team {
    private String name;
    private String homeCity;
    private ArrayList<Player> players;
    private ArrayList<Integer> playedGames;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getHomeCity(){
        return homeCity;
    }

    public void setHomeCity(String homeCity){
        this.homeCity = homeCity;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public void setPlayers(List<Player> players){
        this.players = players;
    }

    public ArrayList<Integer> getGamesPlayed(){
        return playedGames;
    }
    
    public void setPlayers(ArrayList<Integer> playerGames){
        this.playedGames = playerGames;
    }
}
