package team;

import match.Match;
import player.*;

import java.util.ArrayList;

public class TeamManager {
    private ArrayList<Team> teams;

    public TeamManager(){
        teams = new ArrayList<Team>();
    }

    public TeamManager(ArrayList<Team> teams){
        this.teams = teams;
    }

    /**
     * Get teams
     * @return teams
     */
    public ArrayList<Team> getTeams(){
        return teams;
    }

    /**
     * Adds a new team
     */
    public void createTeam(){
        teams.add(new HockeyTeam());
    }

    /**
     * Adds a new team
     * @param type Hockey, Tennis
     * @param name
     * @param homeCity
     * @param players
     * @param playedGames
     * @param totalGamesPlayed
     * @param wins
     * @param losses
     * @param ties
     */
    public void createTeam(String type, String name, String homeCity, ArrayList<Player> players, ArrayList<Match> playedGames, int totalGamesPlayed, int wins, int losses, int ties){
        type = type.toLowerCase();
        switch(type){
            case("hockey"):
                teams.add(new HockeyTeam(name, homeCity, players, playedGames, totalGamesPlayed, wins, losses, ties));
            case("tennis"):
                teams.add(new TennisTeam(name, homeCity, players, playedGames, totalGamesPlayed, wins, losses, ties));
        }
    }

    /**
     * Finds a team with the requested name
     * @param teamName
     * @return If team exists returns the team, otherwise returns null
     */
    public Team findTeamWithName(String teamName){
        for(Team t : teams){
            if(t.getName() == teamName){
                return t;
            }
        }
        return null;
    }
}
