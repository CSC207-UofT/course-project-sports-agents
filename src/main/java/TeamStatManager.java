import java.util.ArrayList;

public class TeamStatManager {
    TeamManager teamManager;
    
    public TeamStatManager(TeamManager teamManager){
        this.teamManager = teamManager;
    }

    /**
     * Calculates the win rate percentage based of the number of games played
     * @param teamName
     * @return If team exists returns win rate percentage, otherwise returns -1
     */
    public float getWinRate(String teamName){
        ArrayList<Team> teams = teamManager.getTeams();
        Team team = findTeamWithName(teamName, teams);
        if(team != null){
            return ((HockeyTeam) team).getWins() / ((HockeyTeam) team).getTotalGamesPlayed() * 100;
        }
        return -1;
    }

    private Team findTeamWithName(String teamName, ArrayList<Team> teams){
        for(Team t : teams){
            if(t.getName() == teamName){
                return t;
            }
        }
        return null;
    }
}
