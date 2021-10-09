import java.util.ArrayList;

public class TeamManager {
    private ArrayList<Team> teams;

    public TeamManager(){
        //teams = (ArrayList<Team>) new ArrayList<HockeyTeam>();
    }

    public TeamManager(ArrayList<Team> teams){
        this.teams = teams;
    }

    public ArrayList<Team> getTeams(){
        return teams;
    }

    public void createTeam(){
        teams.add(new HockeyTeam());
    }

    public void createTeam(int totalGamesPlayed, int wins, int losses, int ties){
        teams.add(new HockeyTeam(totalGamesPlayed, wins, losses, ties));
    }

    public void recordTeams(){

    }
}
