package commands;

import constants.Exceptions;
import team.Team;
import team.TeamManager;

public class TeamStatManager {
    final TeamManager teamManager;
    
    public TeamStatManager(TeamManager teamManager){
        this.teamManager = teamManager;
    }

    /**
     * Gets the number of games played
     * @param teamName
     * @return If team exists returns total games played, otherwise returns -1
     */
    public int getTotalGamesPlayed(String teamName) throws Exception {
        Team team = teamManager.findTeamWithName(teamName);
        if(team != null){
            return team.getTotalGamesPlayed();
        }
        throw new Exception(Exceptions.TEAM_NOT_FOUND);
    }

    /**
     * Gets the number of wins
     * @param teamName
     * @return If team exists returns number of wins, otherwise returns -1
     */
    public int getWins(String teamName) throws Exception {
        Team team = teamManager.findTeamWithName(teamName);
        if(team != null){
            return team.getWins();
        }
        throw new Exception(Exceptions.TEAM_NOT_FOUND);
    }

    /**
     * Gets the number of losses
     * @param teamName
     * @return If team exists returns number of losses, otherwise returns -1
     */
    public int getLosses(String teamName) throws Exception {
        Team team = teamManager.findTeamWithName(teamName);
        if(team != null){
            return team.getLosses();
        }
        throw new Exception(Exceptions.TEAM_NOT_FOUND);
    }

    /**
     * Gets the number of ties
     * @param teamName
     * @return If team exists returns number of ties, otherwise returns -1
     */
    public int getTies(String teamName) throws Exception {
        Team team = teamManager.findTeamWithName(teamName);
        if(team != null){
            return team.getTies();
        }
        throw new Exception(Exceptions.TEAM_NOT_FOUND);
    }

    /**
     * Calculates the win rate percentage based of the number of games played
     * @param teamName
     * @return If team exists returns win rate percentage, otherwise returns -1
     */
    public float getWinRate(String teamName) throws Exception {
        Team team = teamManager.findTeamWithName(teamName);
        if(team != null){
            if(team.getTotalGamesPlayed() == 0){
                return 0;
            }
            return (float) team.getWins() / team.getTotalGamesPlayed() * 100;
        }
        throw new Exception(Exceptions.TEAM_NOT_FOUND);
    }

    /**
     * Calculates the loss rate percentage based of the number of games played
     * @param teamName
     * @return If team exists returns loss rate percentage, otherwise returns -1
     */
    public float getLossRate(String teamName) throws Exception {
        Team team = teamManager.findTeamWithName(teamName);
        if(team != null){
            if(team.getTotalGamesPlayed() == 0){
                return 0;
            }
            return (float) team.getLosses() / team.getTotalGamesPlayed() * 100; 
        }
        throw new Exception(Exceptions.TEAM_NOT_FOUND);
    }
}
