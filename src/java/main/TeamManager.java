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
     * @param totalGamesPlayed
     * @param wins
     * @param losses
     * @param ties
     */
    public void createTeam(int totalGamesPlayed, int wins, int losses, int ties){
        teams.add(new HockeyTeam(totalGamesPlayed, wins, losses, ties));
    }

    public void recordTeams(){

    }
}
