public class HockeyTeam extends Team {
    private int totalGamesPlayed;
    private int wins;
    private int losses;
    private int ties;

    public HockeyTeam(){
        super();
        this.totalGamesPlayed = 0;
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
    }

    public HockeyTeam(int totalGamesPlayed, int wins, int losses, int ties){
        super();
        this.totalGamesPlayed = totalGamesPlayed;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

    public int getTotalGamesPlayed(){
        return this.totalGamesPlayed;
    }

    public void setName(int totalGamesPlayed){
        this.totalGamesPlayed = totalGamesPlayed;
    }

    public int getWins(){
        return this.wins;
    }

    public void setWins(int wins){
        this.wins = wins;
    }

    public int getLosses(){
        return this.losses;
    }

    public void setLosses(int losses){
        this.losses = losses;
    }

    public int getTies(){
        return this.ties;
    }

    public void setTies(int ties){
        this.ties = ties;
    }

    
}
