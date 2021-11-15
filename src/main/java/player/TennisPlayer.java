package player;

import constants.Exceptions;

import java.util.HashMap;

public class TennisPlayer extends Player {

    private final String country;
    // Key is season, Value is statistic in that season
    private final HashMap<String, Integer> ageRecord;
    private final HashMap<String, Integer> acesRecord;
    private final HashMap<String, Integer> doubleFaultsRecord;
    private final HashMap<String, Integer> servePointsRecord;
    private final HashMap<String, Integer> firstServesRecord;
    private final HashMap<String, Integer> breakPointsSavedRecord;


    /**
     * Construct a tennis player who has not participated in any competitions yet
     * @param name name of tennis player
     * @param country IOC code for this player's country
     */
    public TennisPlayer(String name, String country) {
        super(name);
        this.country = country;
        this.ageRecord = new HashMap<>();
        this.acesRecord = new HashMap<>();
        this.doubleFaultsRecord = new HashMap<>();
        this.servePointsRecord = new HashMap<>();
        this.firstServesRecord = new HashMap<>();
        this.breakPointsSavedRecord = new HashMap<>();
    }


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
        this(name, country);
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
     * @param competition the new season
     * @param age the player's age in the season
     * @param aces the number of aces made
     * @param doubleFaults the number of double faults made
     * @param servePoints the number of serve points won
     * @param firstServes the number of first serves made
     * @param breakPointsSaved the number of breakpoints saved
     * @throws Exception if data for the season is already recorded
     */
    public void addRecord(String competition, int age, int aces, int doubleFaults,
                          int servePoints, int firstServes,
                          int breakPointsSaved) throws Exception {
        this.addStatAge(competition, age);
        this.addStatAces(competition, aces);
        this.addStatDoubleFaults(competition, doubleFaults);
        this.addStatServePoints(competition, servePoints);
        this.addStatFirstServes(competition, firstServes);
        this.addStatBreakPointsSaved(competition, breakPointsSaved);
        this.addSeason(competition);
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
     * Update the number of aces made by this player
     * @param competition the needed competition
     * @param aces number of new aces made by player
     */
    public void updateAces(String competition, int aces) {
        int oldAces = this.acesRecord.get(competition);
        this.acesRecord.put(competition, oldAces + aces);
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
     * Update the number of double faults made by this player
     * @param competition the needed competition
     * @param doubleFaults number of new double faults made by this player
     */
    public void updateDoubleFaults(String competition, int doubleFaults) {
        int oldDoubleFaults = this.doubleFaultsRecord.get(competition);
        this.doubleFaultsRecord.put(competition, oldDoubleFaults + doubleFaults);
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
     * Update the number of serve points won by this player
     * @param competition the needed competition
     * @param servePoints number of new serve points won by this player
     */
    public void updateServePoints(String competition, int servePoints) {
        int oldServePoints = this.servePointsRecord.get(competition);
        this.servePointsRecord.put(competition, oldServePoints + servePoints);
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
     * Update the number of first serves made by this player for a competition
     * @param competition the needed competition
     * @param firstServes number of first serves made by this player
     */
    public void updateFirstServes(String competition, int firstServes) {
        int oldFirstServes = this.firstServesRecord.get(competition);
        this.firstServesRecord.put(competition, oldFirstServes + firstServes);
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
     * Update the number of break points saved by this player
     * @param competition the needed competition
     * @param breakPointsSaved number of new break points saved
     */
    public void updateBreakPointsSaved(String competition, int breakPointsSaved) {
        int oldBreakPointsSaved = this.breakPointsSavedRecord.get(competition);
        this.breakPointsSavedRecord.put(competition, oldBreakPointsSaved + breakPointsSaved);
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


    /**
     * Update the value of all stats for a player during a competition
     * @param competition needed competition
     * @param aces number of new aces scored during competition
     * @param doubleFaults number of new double faults made during competition
     * @param servePoints number of new serve points won during competition
     * @param firstServes number of new first serves made during competition
     * @param breakPointsSaved number of new break points saved during competition
     */
    public void updateAll(String competition, int aces, int doubleFaults, int servePoints, int firstServes,
                          int breakPointsSaved) {
        this.updateAces(competition, aces);
        this.updateDoubleFaults(competition, doubleFaults);
        this.updateServePoints(competition, servePoints);
        this.updateFirstServes(competition, firstServes);
        this.updateBreakPointsSaved(competition, breakPointsSaved);
    }


    /**
     * Return this player's data for a given competition in string format (assuming player participated in given
     * competition)
     * @param competition the needed competition
     * @return string of player's data for given competition
     */
    public String printSeasonData(String competition) {
        return "Age: " + this.ageRecord.get(competition) + "\nNationality: " + this.country + "\nAces: "
                + this.acesRecord.get(competition) + "\nDouble Faults: " + this.doubleFaultsRecord.get(competition) +
                "\nServe Points: " + this.servePointsRecord.get(competition) + "\nFirst Serves: " +
                this.firstServesRecord.get(competition) + "\nBreak Points Saved: "
                + this.breakPointsSavedRecord.get(competition);
    }


    /**
     * Check whether the player contains data for the given competition. If one of the records for this player does
     * not contain the given competition, then none of the records contain the given competition.
     * @param competition needed competition
     * @throws Exception if competition could not be found
     */
    public void checkCompetition(String competition) throws Exception {
         if (!(this.ageRecord.containsKey(competition))) {
             throw new Exception(Exceptions.COMP_NOT_FOUND);
        }
    }


    @Override
    public String toString() {
        return "Tennis Player " + super.toString();
    }


}
