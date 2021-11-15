package team;

import java.util.List;

import match.Match;

public class BaseballTeam extends Team {
    private int gamesStarted;
    private int completeGames;
    private int shutouts;
    private int saves;
    private int saveOpportunities;
    private int inningsPitched;
    private int hitsAllowed;
    private int runsAllowed;
    private int earnedRuns;
    private int homeRunsAllowed;
    private int hitBatsmen;
    private int atBats;
    private int runs;
    private int hits;
    private int doubles;
    private int triples;
    private int homeRuns;
    private int runBattedIn;
    private int walks;
    private int strikeouts;
    private int stolenBases;
    private int caughtStealing;


    public BaseballTeam(String name, String homeCity, List<String> players, List<Match> playedGames, int totalGamesPlayed, int wins, int losses, int ties, int rank, int gamesStarted, int completeGames, int shutouts, int saves, int saveOpportunities, int inningsPitched, int hitsAllowed, int runsAllowed, int earnedRuns, int homeRunsAllowed, int hitBatsmen, int atBats, int runs, int hits, int doubles, int triples, int homeRuns, int runBattedIn, int walks, int strikeouts, int stolenBases, int caughtStealing){
        super(name, homeCity, players, playedGames, totalGamesPlayed, wins, losses, ties, rank);
        this.gamesStarted = gamesStarted;
        this.completeGames = completeGames;
        this.shutouts = shutouts;
        this.saves = saves;
        this.saveOpportunities = saveOpportunities;
        this.inningsPitched = inningsPitched;
        this.hitsAllowed = hitsAllowed;
        this.runsAllowed = runsAllowed;
        this.earnedRuns = earnedRuns;
        this.homeRunsAllowed = homeRunsAllowed;
        this.hitBatsmen = hitBatsmen;
        this.atBats = atBats;
        this.runs = runs;
        this.hits = hits;
        this.doubles = doubles;
        this.triples = triples;
        this.homeRuns = homeRuns;
        this.runBattedIn = runBattedIn;
        this.walks = walks;
        this.strikeouts = strikeouts;
        this.stolenBases = stolenBases;
        this.caughtStealing = caughtStealing;
    }

    /**
     * Get games started
     * @return gamesStarted
     */
    public int getGamesStarted(){
        return this.gamesStarted;
    }

    /**
     * Set games started
     * @param gamesStarted number of games started by the team
     */
    public void setGamesStarted(int gamesStarted){
        this.gamesStarted = gamesStarted;
    }

    /**
     * Get complete games
     * @return completeGames
     */
    public int getCompleteGames(){
        return this.completeGames;
    }

    /**
     * Set complete games
     * @param completeGames number of games completed by the team
     */
    public void setCompleteGames(int completeGames){
        this.completeGames = completeGames;
    }

    /**
     * Get shutouts
     * @return shutouts
     */
    public int getShutouts(){
        return this.shutouts;
    }

    /**
     * Set shutouts
     * @param shutouts number of shutouts
     */
    public void setShutouts(int shutouts){
        this.shutouts = shutouts;
    }

    /**
     * Get saves
     * @return saves
     */
    public int getSaves(){
        return this.saves;
    }

    /**
     * Set saves
     * @param saves number of saves
     */
    public void setSavesGoalsFor(int saves){
        this.saves = saves;
    }

    /**
     * Get save opportunities
     * @return saveOpportunities
     */
    public int getSaveOpportunities(){
        return this.saveOpportunities;
    }

    /**
     * Set save opportunities
     * @param saveOpportunities number of opportunities
     */
    public void setSaveOpportunities(int saveOpportunities){
        this.saveOpportunities = saveOpportunities;
    }

    /**
     * Get innings pitched
     * @return inningsPitched
     */
    public int getInningsPitched(){
        return this.inningsPitched;
    }

    /**
     * Set innings pitched
     * @param inningsPitched number of innings pitched
     */
    public void setInningsPitched(int inningsPitched){
        this.inningsPitched = inningsPitched;
    }

    /**
     * Get hits allowed
     * @return hitsAllowed
     */
    public int getHitsAllowed(){
        return this.hitsAllowed;
    }

    /**
     * Set hits allowed
     * @param hitsAllowed number of hits allowed
     */
    public void setHitsAllowed(int hitsAllowed){
        this.hitsAllowed = hitsAllowed;
    }

    /**
     * Get runs allowed
     * @return runsAllowed
     */
    public int getRunsAllowed(){
        return this.runsAllowed;
    }

    /**
     * Set runs allowed
     * @param runsAllowed number of runs allowed
     */
    public void setRunsAllowed(int runsAllowed){
        this.runsAllowed = runsAllowed;
    }

    /**
     * Get earned runs
     * @return earnedRuns
     */
    public int getEarnedRuns(){
        return this.earnedRuns;
    }

    /**
     * Set earned runs
     * @param earnedRuns number of earned runs
     */
    public void setEarnedRuns(int earnedRuns){
        this.earnedRuns = earnedRuns;
    }

    /**
     * Get home runs allowed
     * @return homeRunsAllowed
     */
    public int getHomeRunsAllowed(){
        return this.homeRunsAllowed;
    }

    /**
     * Set home runs allowed
     * @param homeRunsAllowed number of home runs allowed
     */
    public void setHomeRunsAllowed(int homeRunsAllowed){
        this.homeRunsAllowed = homeRunsAllowed;
    }

    /**
     * Get hit batsmen
     * @return hitBatsmen
     */
    public int getHitBatsmen(){
        return this.hitBatsmen;
    }

    /**
     * Set hit batsmen
     * @param hitBatsmen number of hit batsmen
     */
    public void setHitBatsmen(int hitBatsmen){
        this.hitBatsmen = hitBatsmen;
    }

    /**
     * Get at bats
     * @return atBats
     */
    public int getAtBats(){
        return this.atBats;
    }

    /**
     * Set at bats
     * @param atBats number of at bats
     */
    public void setAtBats(int atBats){
        this.atBats = atBats;
    }

    /**
     * Get runs
     * @return runs
     */
    public int getRuns(){
        return this.runs;
    }

    /**
     * Set runs
     * @param runs number of runs
     */
    public void setRuns(int runs){
        this.runs = runs;
    }

    /**
     * Get hits
     * @return hits
     */
    public int getHits(){
        return this.hits;
    }

    /**
     * Set hits
     * @param hits number of hits
     */
    public void setHits(int hits){
        this.hits = hits;
    }

    /**
     * Get doubles
     * @return doubles
     */
    public int getDoubles(){
        return this.doubles;
    }

    /**
     * Set doubles
     * @param doubles number of doubles
     */
    public void setDoubles(int doubles){
        this.doubles = doubles;
    }

    /**
     * Get triples
     * @return triples
     */
    public int getTriples(){
        return this.triples;
    }

    /**
     * Set triples
     * @param triples number of triples
     */
    public void setTriples(int triples){
        this.triples = triples;
    }

    /**
     * Get home runs
     * @return homeRuns
     */
    public int getHomeRuns(){
        return this.homeRuns;
    }

    /**
     * Set home runs
     * @param homeRuns number of home runs
     */
    public void setHomeRuns(int homeRuns){
        this.homeRuns = homeRuns;
    }

    /**
     * Get run batted in
     * @return runBattedIn
     */
    public int getRunBattedIn(){
        return this.runBattedIn;
    }

    /**
     * Set run batted in
     * @param runBattedIn number of runs batted in
     */
    public void setRunBattedIn(int runBattedIn){
        this.runBattedIn = runBattedIn;
    }

    /**
     * Get walks
     * @return walks
     */
    public int getWalks(){
        return this.walks;
    }

    /**
     * Set walks
     * @param walks number of walks
     */
    public void setWalks(int walks){
        this.walks = walks;
    }

    /**
     * Get strikeouts
     * @return strikeouts
     */
    public int getStrikeouts(){
        return this.strikeouts;
    }

    /**
     * Set strikeouts
     * @param strikeouts number of strikeouts
     */
    public void setStrikeouts(int strikeouts){
        this.strikeouts = strikeouts;
    }

    /**
     * Get stolen bases
     * @return stolenBases
     */
    public int getStolenBases(){
        return this.stolenBases;
    }

    /**
     * Set stolen bases
     * @param stolenBases number of stolen bases
     */
    public void setStolenBases(int stolenBases){
        this.stolenBases = stolenBases;
    }

    /**
     * Get caught stealing
     * @return caughtStealing
     */
    public int getCaughtStealing(){
        return this.caughtStealing;
    }

    /**
     * Set caught stealing
     * @param caughtStealing number of times caught stealing bases
     */
    public void setCaughtStealing(int caughtStealing){
        this.caughtStealing = caughtStealing;
    }
}
