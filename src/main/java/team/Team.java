package team;

import player.Player;
import match.Match;

import java.util.List;

public abstract class Team {
    private String name;
    private String homeCity;
    private List<Player> players;
    private List<Match> playedGames;
    private int totalGamesPlayed;
    private int wins;
    private int losses;
    private int ties;

    public Team(){
        this.name = "";
        this.homeCity = "";
        this.totalGamesPlayed = 0;
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
    }

    public Team(String name, String homeCity, List<Player> players, List<Match> playedGames, int totalGamesPlayed, int wins, int losses, int ties){
        this.name = name;
        this.homeCity = homeCity;
        this.players = players;
        this.playedGames = playedGames;
        this.totalGamesPlayed = totalGamesPlayed;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

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
    public List<Player> getPlayers(){
        return players;
    }

    /**
     * Set players
     * @param players
     */
    public void setPlayers(List<Player> players){
        this.players = players;
    }

    /**
     * Get played games
     * @return playedGames
     */
    public List<Match> getPlayedGames(){
        return playedGames;
    }
    
    /**
     * Set played games
     * @param playedGames
     */
    public void setPlayedGames(List<Match> playedGames){
        this.playedGames = playedGames;
    }

    /**
     * Get total games played
     * @return totalGamesPlayed
     */
    public int getTotalGamesPlayed(){
        return this.totalGamesPlayed;
    }

    /**
     * Set total games played
     * @param totalGamesPlayed
     */
    public void setTotalGamesPlayed(int totalGamesPlayed){
        this.totalGamesPlayed = totalGamesPlayed;
    }

    /**
     * Get wins
     * @return wins
     */
    public int getWins(){
        return this.wins;
    }

    /**
     * Set wins
     * @param wins
     */
    public void setWins(int wins){
        this.wins = wins;
    }

    /**
     * Get losses
     * @return losses
     */
    public int getLosses(){
        return this.losses;
    }

    /**
     * Set losses
     * @param losses
     */
    public void setLosses(int losses){
        this.losses = losses;
    }

    /**
     * Get ties
     * @return ties
     */
    public int getTies(){
        return this.ties;
    }

    /**
     * Set ties
     * @param ties
     */
    public void setTies(int ties){
        this.ties = ties;
    }
}
