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

    /**
     * Get total games played
     * @return totalGamesPlayed
     */
    public int getTotalGamesPlayed(){
        return this.totalGamesPlayed;
    }

    /**
     * Set total games played
     * @param totalGamesPlayed
     */
    public void setTotalGamesPlayed(int totalGamesPlayed){
        this.totalGamesPlayed = totalGamesPlayed;
    }

    /**
     * Get wins
     * @return wins
     */
    public int getWins(){
        return this.wins;
    }

    /**
     * Set wins
     * @param wins
     */
    public void setWins(int wins){
        this.wins = wins;
    }

    /**
     * Get losses
     * @return losses
     */
    public int getLosses(){
        return this.losses;
    }

    /**
     * Set losses
     * @param losses
     */
    public void setLosses(int losses){
        this.losses = losses;
    }

    /**
     * Get ties
     * @return ties
     */
    public int getTies(){
        return this.ties;
    }

    /**
     * Set ties
     * @param ties
     */
    public void setTies(int ties){
        this.ties = ties;
    }
}
