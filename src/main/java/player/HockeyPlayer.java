package player;

import java.util.HashMap;
import java.util.Map;
/**
 * A player Class.
 */
public class HockeyPlayer extends Player {
    // Key is Season, Value is statistic in that season
    private HashMap<String, String> skaterShootsRecord;
    private HashMap<String, String> positionRecord;
    private HashMap<String, String> gamesPlayedRecord;
    private HashMap<String, String> goalsRecord;
    private HashMap<String, String> assistsRecord;
    private HashMap<String, String> pointsRecord;
    private HashMap<String, String> shotsRecord;
    private HashMap<String, String> shootingPercentageRecord;

    /**
     * Create a new Hockey Player
     * @param name Player's name
     * @param season Player's first season
     * @param team Player's team in given season
     * @param skaterShoots Player's skater shoots in the given season
     * @param position Player's position in the given season
     * @param gamesPlayed Player's total games played in the given season
     * @param goals Player's total goals in the given season
     * @param assists Player's total assists in the given season
     * @param points Player's total points in the given season
     * @param shots Player's total shots in the given season
     * @param shootingPercentage Player's shooting percentage in the given season
     * @throws Exception should not throw Exception
     */
    public HockeyPlayer(String name, String season, String team,
                        String skaterShoots, String position,
                        String gamesPlayed, String goals, String assists,
                        String points, String shots,
                        String shootingPercentage) throws Exception {
        super(name, season, team);
        this.skaterShootsRecord = new HashMap<String, String>();
        this.positionRecord = new HashMap<String, String>();
        this.gamesPlayedRecord = new HashMap<String, String>();
        this.goalsRecord = new HashMap<String, String>();
        this.assistsRecord = new HashMap<String, String>();
        this.pointsRecord = new HashMap<String, String>();
        this.shotsRecord = new HashMap<String, String>();
        this.shootingPercentageRecord = new HashMap<String, String>();

        this.addRecord(season, team, skaterShoots, position, gamesPlayed,
                goals, assists, points, shots, shootingPercentage);
    }

    /**
     * Add a new season of data for the Player
     * @param season the new season
     * @param team the Player's team in the new season
     * @param skaterShoots the Player's skater shoots in the new season
     * @param position the Player's position in the new season
     * @param gamesPlayed the Player's total games played in the new season
     * @param goals the Player's total goals in the new season
     * @param assists the Player's total assists in the new season
     * @param points the Player's total point in the new season
     * @param shots the Player's total shots in the new season
     * @param shootingPercentage the Player's shooting percentage in the new season
     * @throws Exception if data for the season is already recorded
     */
    public void addRecord(String season, String team, String skaterShoots,
                           String position, String gamesPlayed, String goals,
                           String assists, String points, String shots,
                           String shootingPercentage) throws Exception {
        this.addStatTeam(season, team);
        this.addStatSkaterShoots(season, skaterShoots);
        this.addStatPosition(season, position);
        this.addStatGamesPlayed(season, position);
        this.addStatGoals(season, goals);
        this.addStatAssists(season, assists);
        this.addStatPoints(season, points);
        this.addStatShots(season, shots);
        this.addStatShootingPercentage(season, shootingPercentage);
    }

    /**
     * Record Skater shoots data
     * @param season the season the data is from
     * @param skaterShoots the skater shoots data
     * @throws Exception if that season already has skater shoots data
     */
    public void addStatSkaterShoots(String season, String skaterShoots)
            throws Exception {
        checkForSeason(this.skaterShootsRecord, season, false);
        this.skaterShootsRecord.put(season, skaterShoots);
    }

    /**
     * @param season the season of interest
     * @return the Skater Shoots data from that season
     * @throws Exception if that season has no Skater Shoots data
     */
    public String getStatSkaterShoots(String season) throws Exception {
        checkForSeason(this.skaterShootsRecord, season, true);
        return this.skaterShootsRecord.get(season);
    }

    /**
     * Record position data
     * @param season the season the data is from
     * @param position the position data
     * @throws Exception if that season already has position data
     */
    public void addStatPosition(String season, String position)
            throws Exception {
        checkForSeason(this.positionRecord, season, false);
        this.positionRecord.put(season, position);
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
     * Record games played data
     * @param season the season the data is from
     * @param gamesPlayed the games played data
     * @throws Exception if that season already has games played data
     */
    public void addStatGamesPlayed(String season, String gamesPlayed)
            throws Exception {
        checkForSeason(this.gamesPlayedRecord, season, false);
        this.gamesPlayedRecord.put(season, gamesPlayed);
    }

    /**
     * @param season the season of interest
     * @return the games played data from that season
     * @throws Exception if that season has no games played data
     */
    public String getStatGamesPlayed(String season) throws Exception {
        checkForSeason(this.gamesPlayedRecord, season, true);
        return this.gamesPlayedRecord.get(season);
    }

    /**
     * Record goals data
     * @param season the season the data is from
     * @param goals the games goals data
     * @throws Exception if that season already has goals data
     */
    public void addStatGoals(String season, String goals)
            throws Exception {
        checkForSeason(this.goalsRecord, season, false);
        this.goalsRecord.put(season, goals);
    }

    /**
     * @param season the season of interest
     * @return the goals data from that season
     * @throws Exception if that season has no goals data
     */
    public String getStatGoals(String season) throws Exception {
        checkForSeason(this.goalsRecord, season, true);
        return this.goalsRecord.get(season);
    }

    /**
     * Record assists data
     * @param season the season the data is from
     * @param assists the assists data
     * @throws Exception if that season already has assists data
     */
    public void addStatAssists(String season, String assists)
            throws Exception {
        checkForSeason(this.assistsRecord, season, false);
        this.assistsRecord.put(season, assists);
    }

    /**
     * @param season the season of interest
     * @return the assists data from that season
     * @throws Exception if that season has no assists data
     */
    public String getStatAssists(String season) throws Exception {
        checkForSeason(this.assistsRecord, season, true);
        return this.assistsRecord.get(season);
    }

    /**
     * Record points data
     * @param season the season the data is from
     * @param points the points data
     * @throws Exception if that season already has points data
     */
    public void addStatPoints(String season, String points)
            throws Exception {
        checkForSeason(this.pointsRecord, season, false);
        this.pointsRecord.put(season, points);
    }

    /**
     * @param season the season of interest
     * @return the points data from that season
     * @throws Exception if that season has no points data
     */
    public String getStatPoints(String season) throws Exception {
        checkForSeason(this.pointsRecord, season, true);
        return this.pointsRecord.get(season);
    }

    /**
     * Record shots data
     * @param season the season the data is from
     * @param shots the shots data
     * @throws Exception if that season already has shots data
     */
    public void addStatShots(String season, String shots)
            throws Exception {
        checkForSeason(this.shotsRecord, season, false);
        this.shotsRecord.put(season, shots);
    }

    /**
     * @param season the season of interest
     * @return the shots data from that season
     * @throws Exception if that season has no shots data
     */
    public String getStatShots(String season) throws Exception {
        checkForSeason(this.shotsRecord, season, true);
        return this.shotsRecord.get(season);
    }

    /**
     * Record shooting percentage data
     * @param season the season the data is from
     * @param shootingPercentage the shooting percentage data
     * @throws Exception if that season already has shooting percentage data
     */
    public void addStatShootingPercentage(String season, String
            shootingPercentage) throws Exception {
        checkForSeason(this.shootingPercentageRecord, season, false);
        this.shootingPercentageRecord.put(season, shootingPercentage);
    }

    /**
     * @param season the season of interest
     * @return the shooting percentage data from that season
     * @throws Exception if that season has no shooting percentage data
     */
    public String getStatShootingPercentage(String season) throws Exception {
        checkForSeason(this.shootingPercentageRecord, season, true);
        return this.shootingPercentageRecord.get(season);
    }

    /*

    public String season;
    public String team;
    public String skaterShoots;
    public String position;
    public String gamesPlayed;
    public String goals;
    public String assists;
    public String points;
    public String shots;
    public String shootingPercentage;

    public HockeyPlayer(String name, String season, String team, String skaterShoots, String position,
                        String gamesPlayed, String goals, String assists, String points, String shots,
                        String shootingPercentage) {
        super(name);
        this.season = season;
        this.team = team;
        this.skaterShoots = skaterShoots;
        this.position = position;
        this.gamesPlayed = gamesPlayed;
        this.goals = goals;
        this.assists = assists;
        this.points = points;
        this.shots = shots;
        this.shootingPercentage = shootingPercentage;
    }

    public String getStat(String stat) throws Exception {
        Map<String, String> listAllSats = this.mapStats();
        if (!listAllSats.containsKey(stat)) {
            throw new Exception("Demanded statistics not found!");
        } else {
            return listAllSats.get(stat);
        }
    }

    public Map<String, String> mapStats() {
        Map<String, String> listAllStats = new HashMap<>(Map.of("name",
                this.name, "season", this.season, "team", this.team,
                "skater shoots", this.skaterShoots, "position", this.position,
                "games played", this.gamesPlayed, "goals", this.goals, "assists",
                this.assists, "points", this.points, "shots", this.shots));
        listAllStats.put("shooting percentage", this.shootingPercentage);
        return listAllStats;
    }

    @Override
    public String toString() {
        return "name: " + this.name + "\nseason: " + this.season + "\nteam: " +
                this.team + "\nskater shoots: " + this.skaterShoots + "\nposition: " +
                this.position + "\ngames played: " + this.gamesPlayed + "\ngoals: " +
                this.goals + "\nassists: " + this.assists + "\npoints: " + this.points +
                "\nshots: " + this.shots + "\nshooting percentage: " + this.shootingPercentage + "\n";
    }
    */
}
