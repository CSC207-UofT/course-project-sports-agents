public class TeamStatComparer {
    private TeamStatManager teamStatManager;

    public TeamStatComparer(TeamStatManager teamStatManager){
        this.teamStatManager = teamStatManager;
    }

    /**
     * Compares the win rate of 2 teams
     * @param team1
     * @param team2
     * @return A message of the compared teams
     */
    public String compareWinRate(String team1, String team2){
        float t1WinRate = teamStatManager.getWinRate(team1);
        float t2WinRate = teamStatManager.getWinRate(team2);
        String msg = "";

        if(t1WinRate > t2WinRate){
            msg = team1 + " has a higher win rate compared to " + team2;
        }else if(t1WinRate < t2WinRate){
            msg = team2 + " has a higher win rate compared to " + team1;
        }else{
            msg = team1 + " and " + team2 + " have the same win rate";
        }
        return msg;
    }
}
