package player;

import java.util.*;

public class BaseballPlayer extends Player {
    private final HashMap<String, String> positionRecord;
    private final HashMap<String, Integer> gamesPlayedRecord;
    private final HashMap<String, Integer> atBatsRecord;
    private final HashMap<String, Integer> runsRecord;
    private final HashMap<String, Integer> hitsRecord;
    private final HashMap<String, Integer> homeRunsRecord;
    private final HashMap<String, Integer> runsBattedInRecord;
    private final HashMap<String, Integer> strikeOutsRecord;
    private final HashMap<String, Double> avgRecord;


    /**
     * Create a new Baseball Player.
     *
     * @param name player's name
     * @param season Player's first season
     * @param team Player's team in given season
     * @param position player's position in the team.
     * @param gamesPlayed The number of games the player has played in the season.
     * @param atBats trips to the plate that don't result in a walk, hit by patch, sacrifice, or reach on interference.
     * @param runs number of runs whenever a base runner safely reaches home plate and scores
     * @param hits number of ball hits.
     * @param homeRuns number of runs whenever a bat reaches on a hit, touches all bases, and scores a run whithout a
     * *                putout recorded or the benefit of error.
     * @param runsBattedIn number of runs that are scored because of the batter's safe hit.
     * @param strikeOuts number when the umpire calls three strikes on the batter.
     * @param avg the rate of hits per at bat.
     * @throws Exception should not throw Exception
     */
    public BaseballPlayer(String name, String season, String team,
                          String position, int gamesPlayed,
                          int atBats, int runs,
                          int hits, int homeRuns,
                          int runsBattedIn, int strikeOuts,
                          double avg) throws Exception {
        super(name);

        this.positionRecord = new HashMap<String, String>();
        this.gamesPlayedRecord = new HashMap<String, Integer>();
        this.atBatsRecord = new HashMap<String, Integer>();
        this.runsRecord = new HashMap<String, Integer>();
        this.hitsRecord = new HashMap<String, Integer>();
        this.homeRunsRecord = new HashMap<String, Integer>();
        this.runsBattedInRecord = new HashMap<String, Integer>();
        this.strikeOutsRecord = new HashMap<String, Integer>();
        this.avgRecord = new HashMap<String, Double>();

        this.addRecord(season, team, position, gamesPlayed,
                atBats, runs, hits, homeRuns, runsBattedIn, strikeOuts, avg);

    }

    /**
     * Add a new season of data for this baseball player.
     *
     * @param season the new season
     * @param team the player's team in the new season
     * @param position the player's position in the new season
     * @param gamesPlayed the player's number of games played in the new season
     * @param atBats the player's times at bat in the new season
     * @param runs the player's total runs in the new season
     * @param hits the player's total in the new season
     * @param homeRuns the player's total home runs in the new season
     * @param runsBattedIn the player's total runs batted in for the new season
     * @param strikeOuts the player's total strike outs in the new season
     * @param avg the player's batting average in the new season
     * @throws Exception if data for the given season is already recorded
     */
    public void addRecord(String season, String team, String position,
                          int gamesPlayed, int atBats, int runs, int hits,
                          int homeRuns, int runsBattedIn, int strikeOuts,
                          double avg) throws Exception {
        this.addStatTeam(season, team);
        this.addPosition(season, position);
        this.addGamesPlayed(season, gamesPlayed);
        this.addAtBats(season, atBats);
        this.addRuns(season, runs);
        this.addHits(season, hits);
        this.addHomeRuns(season, homeRuns);
        this.addRunsBattedIn(season, runsBattedIn);
        this.addStrikeOuts(season, strikeOuts);
        this.addAvg(season, avg);
    }

    /**
     * Record position data
     * @param season the season the data is from
     * @param position player's position in the team.
     * @throws Exception if that season already has position data
     */
    public void addPosition(String season, String position)
            throws Exception {
        checkForSeason(this.positionRecord, season, false);
        this.positionRecord.put(season, position);
    }


    /**
     * Record games played data
     * @param season the season the data is from
     * @param gamesPlayed The number of games the player has played in the season.
     * @throws Exception if that season already has games played data
     */
    public void addGamesPlayed(String season, int gamesPlayed)
            throws Exception {
        checkForSeason(this.gamesPlayedRecord, season, false);
        this.gamesPlayedRecord.put(season, gamesPlayed);
    }


    /**
     * Record at bats data
     * @param season the season the data is from
     * @param atBats trips to the plate that don't result in a walk,
     *               hit by patch, sacrifice, or reach on interference.
     * @throws Exception if that season already has at bats data
     */
    public void addAtBats(String season, int atBats)
            throws Exception {
        checkForSeason(this.atBatsRecord, season, false);
        this.atBatsRecord.put(season, atBats);
    }

    /**
     * Record runs data
     * @param season the season the data is from
     * @param runs number of runs whenever a base runner safely reaches home
     *             plate and scores
     * @throws Exception if that season already has runs data
     */
    public void addRuns(String season, int runs)
            throws Exception {
        checkForSeason(this.runsRecord, season, false);
        this.runsRecord.put(season, runs);
    }

    /**
     * Record hits data
     * @param season the season the data is from
     * @param hits number of ball hits.
     * @throws Exception if that season already has hits data
     */
    public void addHits(String season, int hits)
            throws Exception {
        checkForSeason(this.hitsRecord, season, false);
        this.hitsRecord.put(season, hits);
    }

    /**
     * Record home runs data
     * @param season the season the data is from
     * @param homeRuns number of runs whenever a bat reaches on a hit,
     *                 touches all bases, and scores a run without
     *                 putout recorded or the benefit of error.
     * @throws Exception if that season already has home runs data
     */
    public void addHomeRuns(String season, int homeRuns)
            throws Exception {
        checkForSeason(this.homeRunsRecord, season, false);
        this.homeRunsRecord.put(season, homeRuns);
    }

    /**
     * Record runs batted in data
     * @param season the season the data is from
     * @param runsBattedIn number of runs that are scored because of the
     *                     batter's safe hit.
     * @throws Exception if that season already has runs batted in data
     */
    public void addRunsBattedIn(String season, int runsBattedIn)
            throws Exception {
        checkForSeason(this.runsBattedInRecord, season, false);
        this.runsBattedInRecord.put(season, runsBattedIn);
    }

    /**
     * Record strike out data
     * @param season the season the data is from
     * @param strikeOuts number when the umpire calls three strikes on the
     *                   batter.
     * @throws Exception if that season already has strike out data
     */
    public void addStrikeOuts(String season, int strikeOuts)
            throws Exception {
        checkForSeason(this.strikeOutsRecord, season, false);
        this.strikeOutsRecord.put(season, strikeOuts);
    }

    /**
     * Record batting average data
     * @param season the season the data is from
     * @param avg the rate of hits per at bat.
     * @throws Exception if that season already has batting average data
     */
    public void addAvg(String season, double avg)
            throws Exception {
        checkForSeason(this.avgRecord, season, false);
        this.avgRecord.put(season, avg);
    }


    /**
     * @param season the season of interest
     * @return the position data from that season
     * @throws Exception if that season has no position data
     */
    public String getStatPosition(String season) throws Exception {
        checkForSeason(this.positionRecord, season, true);
        return this.positionRecord.get(season);
    }


    /**
     * @param season the season of interest
     * @return the games played data from that season
     * @throws Exception if that season has no games played data
     */
    public Integer getStatGamesPlayed(String season) throws Exception {
        checkForSeason(this.gamesPlayedRecord, season, true);
        return this.gamesPlayedRecord.get(season);
    }


    /**
     * @param season the season of interest
     * @return the at bats data from that season
     * @throws Exception if that season has no at bats data
     */
    public Integer getStatAtBats(String season) throws Exception {
        checkForSeason(this.atBatsRecord, season, true);
        return this.atBatsRecord.get(season);
    }


    /**
     * @param season the season of interest
     * @return the runs data from that season
     * @throws Exception if that season has no runs data
     */
    public Integer getStatRuns(String season) throws Exception {
        checkForSeason(this.runsRecord, season, true);
        return this.runsRecord.get(season);
    }


    /**
     * @param season the season of interest
     * @return the hits data from that season
     * @throws Exception if that season has no hits data
     */
    public Integer getStatHits(String season) throws Exception {
        checkForSeason(this.hitsRecord, season, true);
        return this.hitsRecord.get(season);
    }


    /**
     * @param season the season of interest
     * @return the home runs data from that season
     * @throws Exception if that season has no home runs data
     */
    public Integer getStatHomeRuns(String season) throws Exception {
        checkForSeason(this.homeRunsRecord, season, true);
        return this.homeRunsRecord.get(season);
    }


    /**
     * @param season the season of interest
     * @return the runs batted in data from that season
     * @throws Exception if that season has no runs batted in data
     */
    public Integer getStatRunsBattedIn(String season) throws Exception {
        checkForSeason(this.runsBattedInRecord, season, true);
        return this.runsBattedInRecord.get(season);
    }


    /**
     * @param season the season of interest
     * @return the strike out data from that season
     * @throws Exception if that season has no strike out data
     */
    public Integer getStatStrikeOuts(String season) throws Exception {
        checkForSeason(this.strikeOutsRecord, season, true);
        return this.strikeOutsRecord.get(season);
    }


    /**
     * @param season the season of interest
     * @return the batting average data from that season
     * @throws Exception if that season has no batting average data
     */
    public Double getStatAvg(String season) throws Exception {
        checkForSeason(this.avgRecord, season, true);
        return this.avgRecord.get(season);
    }

    @Override
    public String toString() {
        return "Baseball Player " + super.toString();
    }





}

