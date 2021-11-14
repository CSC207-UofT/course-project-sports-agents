package team;

import java.util.List;

import match.Match;

public class HockeyTeam extends Team {
    private int goalsFor;
    private int goalsAgainst;
    private float faceOffWinPercentage;
    private int shotsAgainst;
    private int shotsFor;
    private int regulationWins;
    private int regulationPlusOvertimeWins;
    private int shootOutGamesWon;
    private int overtimeLosses;


    public HockeyTeam(){
        super();
    }

    public HockeyTeam(String name, String homeCity, List<String> players, List<Match> playedGames, int totalGamesPlayed, int wins, int losses, int ties, int rank, int goalsFor, int goalsAgainst, float faceOffWinPercentage, int shotsAgainst, int shotsFor, int regulationWins, int regulationPlusOvertimeWins, int shootOutGamesWon, int overtimeLosses){
        super(name, homeCity, players, playedGames, totalGamesPlayed, wins, losses, ties, rank);
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.faceOffWinPercentage = faceOffWinPercentage;
        this.shotsAgainst = shotsAgainst;
        this.shotsFor = shotsFor;
        this.regulationWins = regulationWins;
        this.regulationPlusOvertimeWins = regulationPlusOvertimeWins;
        this.shootOutGamesWon = shootOutGamesWon;
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
     * @param goalsFor
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
     * @param goalsAgainst
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
     * @param faceOffWinPercentage
     */
    public void setFaceOffWinPercentage(float faceOffWinPercentage){
        this.faceOffWinPercentage = faceOffWinPercentage;
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
     * @param shotsAgainst
     */
    public void setShotsAgainst(int shotsAgainst){
        this.shotsAgainst = shotsAgainst;
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
     * @param shotsFor
     */
    public void setShotsFor(int shotsFor){
        this.shotsFor = shotsFor;
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
     * @param regulationWins
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
     * @param regulationPlusOvertimeWins
     */
    public void setRegulationPlusOvertimeWins(int regulationPlusOvertimeWins){
        this.regulationPlusOvertimeWins = regulationPlusOvertimeWins;
    }

    /**
     * Get shoot out games won
     * @return shootOutGamesWon
     */
    public int getShootOutGamesWon(){
        return this.shootOutGamesWon;
    }

    /**
     * Set shoot out games won
     * @param shootOutGamesWon
     */
    public void setShootOutGamesWon(int shootOutGamesWon){
        this.shootOutGamesWon = shootOutGamesWon;
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
     * @param overtimeLosses
     */
    public void setOvertimeLosses(int overtimeLosses){
        this.overtimeLosses = overtimeLosses;
    }
}
