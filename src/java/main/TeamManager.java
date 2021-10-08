import java.util.ArrayList;

public class TeamManager {
    private ArrayList<HockeyTeam> teams;

    public TeamManager(){
        teams = new ArrayList<HockeyTeam>();
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
