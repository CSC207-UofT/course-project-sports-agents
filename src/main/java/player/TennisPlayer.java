package player;

import java.util.HashMap;

/**
 * This class represents a tennis player.
 */

public class TennisPlayer extends Player {
    private final String country;
    // Key is season, Value is statistic in that season
    // TODO: Do we want to record age? Is it a stat people want?
    private HashMap<String, Integer> ageRecord;
    private HashMap<String, Integer> acesRecord;
    private HashMap<String, Integer> doubleFaultsRecord;
    private HashMap<String, Integer> servePointsRecord;
    private HashMap<String, Integer> firstServesRecord;
    private HashMap<String, Integer> breakPointsSavedRecord;

    /**
     * Construct a tennis player with the following information from one season
     * @param name player's name
     * @param country IOC code for this player's country
     * @param season the season data is from
     * @param age player's age
     * @param aces number of aces made by this player
     * @param servePoints number of serve points won by this player
     * @param firstServes number of first serves made by this player
     * @param breakPointsSaved number of break points saved
     * @throws Exception should not throw exception
     */
    public TennisPlayer(String name, String country, String season, int age,
                        int aces, int doubleFaults, int servePoints,
                        int firstServes, int breakPointsSaved) throws Exception {
        super(name);
        this.country = country;
        this.ageRecord = new HashMap<String, Integer>();
        this.acesRecord = new HashMap<String, Integer>();
        this.doubleFaultsRecord = new HashMap<String, Integer>();
        this.servePointsRecord = new HashMap<String, Integer>();
        this.firstServesRecord = new HashMap<String, Integer>();
        this.breakPointsSavedRecord = new HashMap<String, Integer>();

        // TODO: Implement team functions
        //  Are tennis players on a team by themself? What about doubles tennis?

        this.addRecord(season, age, aces, doubleFaults, servePoints, firstServes,
                breakPointsSaved);
    }

    /**
     * @return Player's country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Record a new season of data for this player
     * @param season the new season
     * @param age the player's age in the season
     * @param aces the number of aces made
     * @param doubleFaults the number of double faults made
     * @param servePoints the number of serve points won
     * @param firstServes the number of first serves made
     * @param breakPointsSaved the number of breakpoints saved
     * @throws Exception if data for the season is already recorded
     */
    public void addRecord(String season, int age, int aces, int doubleFaults,
                           int servePoints, int firstServes,
                           int breakPointsSaved) throws Exception {
        this.addStatAge(season, age);
        this.addStatAces(season, aces);
        this.addStatDoubleFaults(season, doubleFaults);
        this.addStatServePoints(season, servePoints);
        this.addStatFirstServes(season, firstServes);
        this.addStatBreakPointsSaved(season, breakPointsSaved);
    }

    /**
     * Record age data
     * @param season the season the data is from
     * @param age the player's age in that season
     * @throws Exception if that season already has age data
     */
    public void addStatAge(String season, Integer age)
            throws Exception {
        checkForSeason(this.ageRecord, season, false);
        this.ageRecord.put(season, age);
    }

    /**
     * @param season the season of interest
     * @return the Player's age in that season
     * @throws Exception if that season has no age data
     */
    public Integer getStatAge(String season) throws Exception {
        checkForSeason(this.ageRecord, season, true);
        return this.ageRecord.get(season);
    }

    /**
     * Record aces data
     * @param season the season the data is from
     * @param aces the aces data in that season
     * @throws Exception if that season already has aces data
     */
    public void addStatAces(String season, Integer aces)
            throws Exception {
        checkForSeason(this.acesRecord, season, false);
        this.acesRecord.put(season, aces);
    }

    /**
     * @param season the season of interest
     * @return the Player's aces in that season
     * @throws Exception if that season has no aces data
     */
    public Integer getStatAces(String season) throws Exception {
        checkForSeason(this.acesRecord, season, true);
        return this.acesRecord.get(season);
    }

    /**
     * Record double faults data
     * @param season the season the data is from
     * @param doubleFaults the player's double faults data in that season
     * @throws Exception if that season already has double faults data
     */
    public void addStatDoubleFaults(String season, Integer doubleFaults)
            throws Exception {
        checkForSeason(this.doubleFaultsRecord, season, false);
        this.doubleFaultsRecord.put(season, doubleFaults);
    }

    /**
     * @param season the season of interest
     * @return the Player's double faults data in that season
     * @throws Exception if that season has no double faults data
     */
    public Integer getStatDoubleFaults(String season) throws Exception {
        checkForSeason(this.doubleFaultsRecord, season, true);
        return this.doubleFaultsRecord.get(season);
    }

    /**
     * Record serve point data
     * @param season the season the data is from
     * @param servePoints the player's serve point data in that season
     * @throws Exception if that season already has serve point data
     */
    public void addStatServePoints(String season, Integer servePoints)
            throws Exception {
        checkForSeason(this.servePointsRecord, season, false);
        this.servePointsRecord.put(season, servePoints);
    }

    /**
     * @param season the season of interest
     * @return the Player's serve point data in that season
     * @throws Exception if that season has no serve point data
     */
    public Integer getStatServePoints(String season) throws Exception {
        checkForSeason(this.servePointsRecord, season, true);
        return this.servePointsRecord.get(season);
    }

    /**
     * Record first serves data
     * @param season the season the data is from
     * @param firstServes the player's first serve data in that season
     * @throws Exception if that season already has first serve data
     */
    public void addStatFirstServes(String season, Integer firstServes)
            throws Exception {
        checkForSeason(this.firstServesRecord, season, false);
        this.firstServesRecord.put(season, firstServes);
    }

    /**
     * @param season the season of interest
     * @return the Player's first serves in that season
     * @throws Exception if that season has no first serves data
     */
    public Integer getStatFirstServes(String season) throws Exception {
        checkForSeason(this.firstServesRecord, season, true);
        return this.firstServesRecord.get(season);
    }

    /**
     * Record break points saved data
     * @param season the season the data is from
     * @param breakPointsSaved the player's break points saved in that season
     * @throws Exception if that season already has break points saved data
     */
    public void addStatBreakPointsSaved(String season, Integer breakPointsSaved)
            throws Exception {
        checkForSeason(this.breakPointsSavedRecord, season, false);
        this.breakPointsSavedRecord.put(season, breakPointsSaved);
    }

    /**
     * @param season the season of interest
     * @return the Player's break points saved in that season
     * @throws Exception if that season has no break points saved data
     */
    public Integer getStatBreakPointsSaved(String season) throws Exception {
        checkForSeason(this.breakPointsSavedRecord, season, true);
        return this.breakPointsSavedRecord.get(season);
    }

    @Override
    public String toString() {
        return "Tennis Player " + super.toString();
    }

}
