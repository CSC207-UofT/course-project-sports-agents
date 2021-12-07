package sports.tennis;

import sports.Player;

import java.util.HashMap;

public class TennisPlayer extends Player {

    private final String country;
    // Key is season, Value is statistic in that season
    private final HashMap<String, Integer> rankRecord;
    private final HashMap<String, Integer> matchesRecord;
    private final HashMap<String, Integer> acesRecord;
    private final HashMap<String, Integer> doubleFaultsRecord;
    private final HashMap<String, Double> servePointsWonRecord;
    private final HashMap<String, Double> breakPointsSavedRecord;
    private final HashMap<String, Double> serveGamesWonRecord;
    private final HashMap<String, Double> returnGamesWonRecord;
    private final HashMap<String, Double> breakPointsConvertedRecord;
    private final HashMap<String, Double> returnPointsWonRecord;


    /**
     * Construct a tennis player who has not participated in any competitions yet
     * @param name name of tennis player
     * @param country IOC code for this player's country
     */
    public TennisPlayer(String name, String country) {
        super(name);
        this.country = country;
        this.rankRecord = new HashMap<>();
        this.matchesRecord = new HashMap<>();
        this.acesRecord = new HashMap<>();
        this.doubleFaultsRecord = new HashMap<>();
        this.servePointsWonRecord = new HashMap<>();
        this.breakPointsSavedRecord = new HashMap<>();
        this.serveGamesWonRecord = new HashMap<>();
        this.returnGamesWonRecord = new HashMap<>();
        this.breakPointsConvertedRecord = new HashMap<>();
        this.returnPointsWonRecord = new HashMap<>();
    }


    /**
     * Construct a tennis player with the following information from one season
     * @param name player's name
     * @param country IOC code for player's home country
     * @param season the season the player participated in
     * @param rank player's rank during season
     * @param matches number of matches played during season
     * @param aces number of aces made during season
     * @param doubleFaults number of double faults made during season
     * @param servePointsWon percentage of serve points won during season
     * @param breakPointsSaved percentage of break points saved during season
     * @param serveGamesWon percentage of serve games won during season
     * @param returnGamesWon percentage of return games won during season
     * @param breakPointsConverted percentage of break points converted during season
     * @param returnPointsWon percentage of return points won during season
     * @throws Exception if data for any of the above stats has already been recorded for given season
     */
    public TennisPlayer(String name, String country, String season, int rank, int matches, int aces, int doubleFaults,
                        double servePointsWon, double breakPointsSaved, double serveGamesWon, double returnGamesWon,
                        double breakPointsConverted, double returnPointsWon) throws Exception {
        this(name, country);
        this.addRecord(season, rank, matches, aces, doubleFaults, servePointsWon, breakPointsSaved, serveGamesWon,
                returnGamesWon, breakPointsConverted, returnPointsWon);
    }


    /**
     * @return Player's country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Record the all data for this player during the given season
     * @param season the new season to be added
     * @param rank the player's rank during season
     * @param matches the number of matches the player played in during season
     * @param aces the number of aces player made during season
     * @param doubleFaults the number of double faults player made during season
     * @param servePointsWon the percentage of serve points won by player during season
     * @param breakPointsSaved the percentage of break points saved by player during season
     * @param serveGamesWon the percentage of serve games player won during season
     * @param returnGamesWon the percentage of return games player won during season
     * @param breakPointsConverted the percentage of break points converted by player during season
     * @param returnPointsWon the percentage of return points won by player during season
     * @throws Exception if given season already has data for any of the above stats
     */
    public void addRecord(String season, int rank, int matches, int aces, int doubleFaults, double servePointsWon,
                          double breakPointsSaved, double serveGamesWon, double returnGamesWon,
                          double breakPointsConverted, double returnPointsWon) throws Exception {
        this.addStatRank(season, rank);
        this.addStatMatches(season, matches);
        this.addStatAces(season, aces);
        this.addStatDoubleFaults(season, doubleFaults);
        this.addStatServePointsWon(season, servePointsWon);
        this.addStatBreakPointsSaved(season, breakPointsSaved);
        this.addStatServeGamesWon(season, serveGamesWon);
        this.addStatReturnGamesWon(season, returnGamesWon);
        this.addStatBreakPointsConverted(season, breakPointsConverted);
        this.addStatReturnPointsWon(season, returnPointsWon);
        this.addSeason(season);
    }

    /**
     * Record rank data
     * @param season the season the data is from
     * @param rank the player's rank in that season
     * @throws Exception if data is already recorded for that season
     */
    public void addStatRank(String season, Integer rank) throws Exception {
        checkForSeason(this.rankRecord, season, false);
        this.rankRecord.put(season, rank);
    }

    /**
     * Return the player's rank during the given season
     * @param season the season of interest
     * @return the player's rank during the given season
     * @throws Exception if that season has no rank data
     */
    public Integer getStatRank(String season) throws Exception {
        checkForSeason(this.rankRecord, season, true);
        return this.rankRecord.get(season);
    }

    /**
     * Record the number of matches played for the given season
     * @param season the new season the data is from
     * @param matches number of matches won during given season
     * @throws Exception if data is already recorded for that season
     */
    public void addStatMatches(String season, Integer matches) throws Exception {
        checkForSeason(this.matchesRecord, season, false);
        this.matchesRecord.put(season, matches);
    }

    /**
     * Return the number of matches played during given season
     * @param season the season of interest
     * @return number of matches player played during given season
     * @throws Exception if given season has no matches data
     */
    public Integer getStatMatches(String season) throws Exception {
        checkForSeason(this.matchesRecord, season, true);
        return this.matchesRecord.get(season);
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
     * Record the percentage of serve points won during the given season
     * @param season the new season the data is from
     * @param servePointsWon percentage of serve points player won for given season
     * @throws Exception if the given season already has serve points won data
     */
    public void addStatServePointsWon(String season, Double servePointsWon) throws Exception {
        checkForSeason(this.servePointsWonRecord, season, false);
        this.servePointsWonRecord.put(season, servePointsWon);
    }

    /**
     * Return the percentage of serve points won by this player during the given season
     * @param season the season of interest
     * @return percentage of serve points won
     * @throws Exception if the given season does not have serve points won data
     */
    public Double getStatServePointsWon(String season) throws Exception {
        checkForSeason(this.servePointsWonRecord, season, true);
        return this.servePointsWonRecord.get(season);
    }

    /**
     * Record percentage of break points saved data
     * @param season the season the data is from
     * @param breakPointsSaved the percentage of break points saved by player during given season
     * @throws Exception if that season already has break points saved data
     */
    public void addStatBreakPointsSaved(String season, double breakPointsSaved)
            throws Exception {
        checkForSeason(this.breakPointsSavedRecord, season, false);
        this.breakPointsSavedRecord.put(season, breakPointsSaved);
    }


    /**
     * Return the percentage of break points saved during given season
     * @param season the season of interest
     * @return the Player's percentage of break points saved
     * @throws Exception if that season has no break points saved data
     */
    public Double getStatBreakPointsSaved(String season) throws Exception {
        checkForSeason(this.breakPointsSavedRecord, season, true);
        return this.breakPointsSavedRecord.get(season);
    }

    /**
     * Record percentage of serve games won during given season
     * @param season the new season to be added
     * @param serveGamesWon percentage of serve games won during season
     * @throws Exception if serve games won data is already recorded for given season
     */
    public void addStatServeGamesWon(String season, double serveGamesWon) throws Exception {
        checkForSeason(this.serveGamesWonRecord, season, false);
        this.serveGamesWonRecord.put(season, serveGamesWon);
    }

    /**
     * Return the percentage of serve games won during given season
     * @param season the season of interest
     * @return percentage of serve games won during season
     * @throws Exception if the given season does not have serve games won data
     */
    public Double getStatServeGamesWon(String season) throws Exception {
        checkForSeason(this.serveGamesWonRecord, season, true);
        return this.serveGamesWonRecord.get(season);

    }

    /**
     * Record the percentage of return games won during the given season
     * @param season new season to be added
     * @param returnGamesWon percentage of return games won during season
     * @throws Exception if return games won data already exists for the given season
     */
    public void addStatReturnGamesWon(String season, double returnGamesWon) throws Exception {
        checkForSeason(this.returnGamesWonRecord, season, false);
        this.returnGamesWonRecord.put(season, returnGamesWon);
    }

    /**
     * Return the percentage of return games won during given season
     * @param season the season of interest
     * @return percentage of return games won during season
     * @throws Exception if given season does not have return games won data
     */
    public Double getStatReturnGamesWon(String season) throws Exception {
        checkForSeason(this.returnGamesWonRecord, season, true);
        return this.returnGamesWonRecord.get(season);
    }

    /**
     * Record the percentage of break points converted for the given season
     * @param season new season to be added
     * @param breakPointsConverted percentage of break points converted
     * @throws Exception if the given season already has break points converted data
     */
    public void addStatBreakPointsConverted(String season, double breakPointsConverted) throws Exception {
        checkForSeason(this.breakPointsConvertedRecord, season, false);
        this.breakPointsConvertedRecord.put(season, breakPointsConverted);
    }

    /**
     * Return the percentage of breakpoints converted for the given season
     * @param season the season of interest
     * @return percentage of breakpoints converted during given season
     * @throws Exception if given season does not have break points converted data
     */
    public Double getStatBreakPointsConverted(String season) throws Exception {
        checkForSeason(this.breakPointsConvertedRecord, season, true);
        return this.breakPointsConvertedRecord.get(season);
    }

    /**
     * Record the percentage of return points won during given season
     * @param season new season to be added
     * @param returnPointsWon percentage of return points won during given season
     * @throws Exception if given season already has return points won data
     */
    public void addStatReturnPointsWon(String season, double returnPointsWon) throws Exception {
        checkForSeason(this.returnPointsWonRecord, season, false);
        this.returnPointsWonRecord.put(season, returnPointsWon);
    }

    /**
     * Return the percentage of return points won during the given season
     * @param season season of interest
     * @return percentage of return points won during season
     * @throws Exception if given season does not have return points won data
     */
    public Double getStatReturnPointsWon(String season) throws Exception {
        checkForSeason(this.returnPointsWonRecord, season, true);
        return this.returnPointsWonRecord.get(season);
    }


    public String getSeasonData(String season) throws Exception {
        return "Nationality: " + this.country + "\nRank: " + this.getStatRank(season) + "\nMatches: "
                + this.getStatMatches(season) + "\nAces: " + this.getStatAces(season) +
                "\nDouble Faults: " + this.getStatDoubleFaults(season) + "\nPercentage of Serve Points Won: " +
                this.getStatServePointsWon(season) + "\nPercentage of Break Points Saved: " +
                this.getStatBreakPointsSaved(season) + "\nPercentage of Serve Games Won: " +
                this.getStatServeGamesWon(season) + "\nPercentage of Return Games Won: " +
                this.getStatReturnGamesWon(season) + "\nPercentage of Break Points Converted: " +
                this.getStatBreakPointsConverted(season) + "\nPercentage of Return Points Won: " +
                this.getStatReturnPointsWon(season);
    }

    @Override
    public String toString() {
        return "Tennis Player " + super.toString();
    }


}
