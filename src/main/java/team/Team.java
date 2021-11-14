package team;

import match.Match;
import player.*;

import java.util.ArrayList;

public abstract class Team {
    private String name;
    private String homeCity;
    private ArrayList<Player> players;
    private ArrayList<Match> playedGames;
    private int totalGamesPlayed;
    private int wins;
    private int losses;
    private int ties;

    public Team() {
        this.name = "";
        this.homeCity = "";
        this.totalGamesPlayed = 0;
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
    }

    public Team(String name, String homeCity,
                ArrayList<Player> players, ArrayList<Match> playedGames,
                int totalGamesPlayed, int wins, int losses, int ties) {
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
     * @param name team name
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
     * @param homeCity team's home city
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
     * @param players players on the team
     */
    public void setPlayers(ArrayList<Player> players){
        this.players = players;
    }

    /**
     * Get played games
     * @return playedGames
     */
    public ArrayList<Match> getPlayedGames(){
        return playedGames;
    }

    /**
     * Set played games
     * @param playedGames number of played games
     */
    public void setPlayedGames(ArrayList<Match> playedGames){
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
     * @param totalGamesPlayed number of played games
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
     * @param wins number of wins
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
     * @param losses number of losses
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
     * @param ties number of ties
     */
    public void setTies(int ties){
        this.ties = ties;
    }

    /**
     * @return a string representation of the team
     */
    @Override
    public String toString() {
        return "Team " + this.name + " in " + this.homeCity +
                " with record " + this.wins + "-" + this.losses + "-" + this.ties;
    }

    /**
     * @param other an object to compare this to
     * @return true if other is a Team with the same name, home city,
     * wins, losses, and ties
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Team otherTeam = (Team) other;
        return (this.name.equals(otherTeam.name) &&
                this.homeCity.equals(otherTeam.homeCity) &&
                this.wins == otherTeam.wins &&
                this.losses == otherTeam.losses &&
                this.ties == otherTeam.ties);
    }

    /**
     * Implement hashCode, for using Players in hashMaps
     * @return sum of name hashCode, homeCity hashCode, wins, losses, and ties
     */
    @Override
    public int hashCode() {
        return this.name.hashCode() + this.homeCity.hashCode() +
                this.wins + this.losses + this.ties;
    }
}
