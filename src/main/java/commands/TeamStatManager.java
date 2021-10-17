package commands;

import team.Team;
import team.TeamManager;

public class TeamStatManager {
    TeamManager teamManager;
    
    public TeamStatManager(TeamManager teamManager){
        this.teamManager = teamManager;
    }

    /**
     * Gets the number of games played
     * @param teamName
     * @return If team exists returns total games played, otherwise returns -1
     */
    public int getTotalGamesPlayed(String teamName){
        Team team = teamManager.findTeamWithName(teamName);
        if(team != null){
            return team.getTotalGamesPlayed();
        }
        return -1;
    }

    /**
     * Gets the number of wins
     * @param teamName
     * @return If team exists returns number of wins, otherwise returns -1
     */
    public int getWins(String teamName){
        Team team = teamManager.findTeamWithName(teamName);
        if(team != null){
            return team.getWins();
        }
        return -1;
    }

    /**
     * Gets the number of losses
     * @param teamName
     * @return If team exists returns number of losses, otherwise returns -1
     */
    public int getLosses(String teamName){
        Team team = teamManager.findTeamWithName(teamName);
        if(team != null){
            return team.getLosses();
        }
        return -1;
    }

    /**
     * Gets the number of ties
     * @param teamName
     * @return If team exists returns number of ties, otherwise returns -1
     */
    public int getTies(String teamName){
        Team team = teamManager.findTeamWithName(teamName);
        if(team != null){
            return team.getTies();
        }
        return -1;
    }

    /**
     * Calculates the win rate percentage based of the number of games played
     * @param teamName
     * @return If team exists returns win rate percentage, otherwise returns -1
     */
    public float getWinRate(String teamName){
        Team team = teamManager.findTeamWithName(teamName);
        if(team != null){
            if(team.getTotalGamesPlayed() == 0){
                return 0;
            }
            return (float) team.getWins() / team.getTotalGamesPlayed() * 100;
        }
        return -1;
    }

    /**
     * Calculates the loss rate percentage based of the number of games played
     * @param teamName
     * @return If team exists returns loss rate percentage, otherwise returns -1
     */
    public float getLossRate(String teamName){
        Team team = teamManager.findTeamWithName(teamName);
        if(team != null){
            if(team.getTotalGamesPlayed() == 0){
                return 0;
            }
            return (float) team.getLosses() / team.getTotalGamesPlayed() * 100; 
        }
        return -1;
    }
}
