package team;

import java.util.List;
import java.util.ArrayList;

public class TeamManager {
    private List<Team> teams;

    public TeamManager(){
        teams = new ArrayList<Team>();
    }

    public TeamManager(List<Team> teams){
        this.teams = teams;
    }
    
    /**
     * Get teams
     * @return teams
     */
    public List<Team> getTeams(){
        return teams;
    }

    /**
     * Adds a new team
     * @param team
     */
    public void createTeam(Team team){
        teams.add(team);
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
