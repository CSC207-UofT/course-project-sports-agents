package commands;

public class TeamStatComparer {
    private TeamStatManager teamStatManager;

    public TeamStatComparer(TeamStatManager teamStatManager){
        this.teamStatManager = teamStatManager;
    }

    /**
     * Compares the total games played of 2 teams
     * @param team1
     * @param team2
     * @return 1 if team 1 is higher, 2 if team 2 is higher, 0 if team 1 equals team 2
     */
    public int compareTotalGamesPlayed(String team1, String team2) throws Exception {
        float t1TotalGamesPlayed = teamStatManager.getTotalGamesPlayed(team1);
        float t2TotalGamesPlayed = teamStatManager.getTotalGamesPlayed(team2);
        int out = -1;

        if(t1TotalGamesPlayed > t2TotalGamesPlayed){
            out = 1;
        }else if(t1TotalGamesPlayed < t2TotalGamesPlayed){
            out = 2;
        }else{
            out = 0;
        }
        return out;
    }

    /**
     * Compares the number of wins of 2 teams
     * @param team1
     * @param team2
     * @return 1 if team 1 is higher, 2 if team 2 is higher, 0 if team 1 equals team 2
     */
    public int compareWins(String team1, String team2) throws Exception {
        float t1Wins = teamStatManager.getWins(team1);
        float t2Wins = teamStatManager.getWins(team2);
        int out = -1;

        if(t1Wins > t2Wins){
            out = 1;
        }else if(t1Wins < t2Wins){
            out = 2;
        }else{
            out = 0;
        }
        return out;
    }

    /**
     * Compares the number of losses of 2 teams
     * @param team1
     * @param team2
     * @return 1 if team 1 is higher, 2 if team 2 is higher, 0 if team 1 equals team 2
     */
    public int compareLosses(String team1, String team2) throws Exception {
        float t1Losses = teamStatManager.getLosses(team1);
        float t2Losses = teamStatManager.getLosses(team2);
        int out = -1;

        if(t1Losses > t2Losses){
            out = 1;
        }else if(t1Losses < t2Losses){
            out = 2;
        }else{
            out = 0;
        }
        return out;
    }

    /**
     * Compares the number of ties of 2 teams
     * @param team1
     * @param team2
     * @return 1 if team 1 is higher, 2 if team 2 is higher, 0 if team 1 equals team 2
     */
    public int compareTies(String team1, String team2) throws Exception {
        float t1Ties = teamStatManager.getTies(team1);
        float t2Ties = teamStatManager.getTies(team2);
        int out = -1;

        if(t1Ties > t2Ties){
            out = 1;
        }else if(t1Ties < t2Ties){
            out = 2;
        }else{
            out = 0;
        }
        return out;
    }
    
    /**
     * Compares the win rate of 2 teams
     * @param team1
     * @param team2
     * @return 1 if team 1 is higher, 2 if team 2 is higher, 0 if team 1 equals team 2
     */
    public int compareWinRate(String team1, String team2) throws Exception {
        float t1WinRate = teamStatManager.getWinRate(team1);
        float t2WinRate = teamStatManager.getWinRate(team2);
        int out = -1;

        if(t1WinRate > t2WinRate){
            out = 1;
        }else if(t1WinRate < t2WinRate){
            out = 2;
        }else{
            out = 0;
        }
        return out;
    }

    /**
     * Compares the loss rate of 2 teams
     * @param team1
     * @param team2
     * @return 1 if team 1 is higher, 2 if team 2 is higher, 0 if team 1 equals team 2
     */
    public int compareLossRate(String team1, String team2) throws Exception {
        float t1LossRate = teamStatManager.getWinRate(team1);
        float t2LossRate = teamStatManager.getWinRate(team2);
        int out = -1;

        if(t1LossRate > t2LossRate){
            out = 1;
        }else if(t1LossRate < t2LossRate){
            out = 2;
        }else{
            out = 0;
        }
        return out;
    }
}
