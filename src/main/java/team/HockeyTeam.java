package team;

import java.util.List;

import match.Match;

public class HockeyTeam extends Team {
    private int goalsFor;
    private int goalsAgainst;
    private float faceOffWinPercentage;
    private int shotsFor;
    private int shotsAgainst;
    private int regulationWins;
    private int regulationPlusOvertimeWins;
    private int shootoutGamesWon;
    private int overtimeLosses;

    public HockeyTeam(){
        super();
    }

    public HockeyTeam(String name, String homeCity, List<String> players, List<Match> playedGames, int totalGamesPlayed, int wins, int losses, int ties, int rank, int goalsFor, int goalsAgainst, float faceOffWinPercentage, int shotsFor, int shotsAgainst, int regulationWins, int regulationPlusOvertimeWins, int shootoutGamesWon, int overtimeLosses){
        super(name, homeCity, players, playedGames, totalGamesPlayed, wins, losses, ties, rank);
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.faceOffWinPercentage = faceOffWinPercentage;
        this.shotsFor = shotsFor;
        this.shotsAgainst = shotsAgainst;
        this.regulationWins = regulationWins;
        this.regulationPlusOvertimeWins = regulationPlusOvertimeWins;
        this.shootoutGamesWon = shootoutGamesWon;
        this.overtimeLosses = overtimeLosses;
    }

    /**
     * Get goals for
     * @return goalsFor
     */
    public int getGoalsFor(){
        return this.goalsFor;
    }

    /**
     * Set goals for
     * @param goalsFor goals for the team
     */
    public void setGoalsFor(int goalsFor){
        this.goalsFor = goalsFor;
    }

    /**
     * Get goals against
     * @return goalsAgainst
     */
    public int getGoalsAgainst(){
        return this.goalsAgainst;
    }

    /**
     * Set goals against
     * @param goalsAgainst goals against the team
     */
    public void setGoalsAgainst(int goalsAgainst){
        this.goalsAgainst = goalsAgainst;
    }

    /**
     * Get face off win percentage
     * @return faceOffWinPercentage
     */
    public float getFaceOffWinPercentage(){
        return this.faceOffWinPercentage;
    }

    /**
     * Set face off win percentage
     * @param faceOffWinPercentage win percentage of face offs
     */
    public void setFaceOffWinPercentage(float faceOffWinPercentage){
        this.faceOffWinPercentage = faceOffWinPercentage;
    }

    /**
     * Get shots for
     * @return shotsFor
     */
    public int getShotsFor(){
        return this.shotsFor;
    }

    /**
     * Set shots for
     * @param shotsFor shots for this team
     */
    public void setShotsFor(int shotsFor){
        this.shotsFor = shotsFor;
    }

    /**
     * Get shots against
     * @return shotsAgainst
     */
    public int getShotsAgainst(){
        return this.shotsAgainst;
    }

    /**
     * Set shots against
     * @param shotsAgainst shots against this team
     */
    public void setShotsAgainst(int shotsAgainst){
        this.shotsAgainst = shotsAgainst;
    }

    /**
     * Get regulation wins
     * @return regulationWins
     */
    public int getRegulationWins(){
        return this.regulationWins;
    }

    /**
     * Set regulation wins
     * @param regulationWins the team's regulation wins
     */
    public void setRegulationWins(int regulationWins){
        this.regulationWins = regulationWins;
    }

    /**
     * Get regulation plus overtime wins
     * @return regulationPlusOvertimeWins
     */
    public int getRegulationPlusOvertimeWins(){
        return this.regulationPlusOvertimeWins;
    }

    /**
     * Set regulation plus overtime wins
     * @param regulationPlusOvertimeWins the team's regulation and overtime wins
     */
    public void setRegulationPlusOvertimeWins(int regulationPlusOvertimeWins){
        this.regulationPlusOvertimeWins = regulationPlusOvertimeWins;
    }

    /**
     * Get shoot out games won
     * @return shootOutGamesWon
     */
    public int getShootoutGamesWon(){
        return this.shootoutGamesWon;
    }

    /**
     * Set shoot out games won
     * @param shootoutGamesWon number of shootout games won
     */
    public void setShootoutGamesWon(int shootoutGamesWon){
        this.shootoutGamesWon = shootoutGamesWon;
    }

    /**
     * Get overtime losses
     * @return overtimeLosses
     */
    public int getOvertimeLosses(){
        return this.overtimeLosses;
    }

    /**
     * Set overtime losses
     * @param overtimeLosses number of overtime losses
     */
    public void setOvertimeLosses(int overtimeLosses){
        this.overtimeLosses = overtimeLosses;
    }
}