package sports.hockey;

import sports.Team;

import java.util.HashMap;

public class HockeyTeam extends Team {

    protected final HashMap<String, Integer> gamesPlayed;
    protected final HashMap<String, Integer> points;
    protected final HashMap<String, Integer> gamesWon;
    protected final HashMap<String, Integer> gamesLost;
    protected final HashMap<String, Integer> overtimeLosses;
    protected final HashMap<String, Integer> goalsFor;
    protected final HashMap<String, Integer> goalsAgainst;
    protected final HashMap<String, Double> shotsForPerGame;
    protected final HashMap<String, Double> shotsAgainstPerGame;
    protected final HashMap<String, Double> faceOffWinPercentage;


    /**
     * Construct a hockey team who has not participated in any seasons yet
     * @param name team's name
     */
    public HockeyTeam(String name) {
        super(name);
        this.gamesPlayed = new HashMap<>();
        this.points = new HashMap<>();
        this.gamesWon = new HashMap<>();
        this.gamesLost = new HashMap<>();
        this.overtimeLosses = new HashMap<>();
        this.goalsFor = new HashMap<>();
        this.goalsAgainst = new HashMap<>();
        this.shotsForPerGame = new HashMap<>();
        this.shotsAgainstPerGame = new HashMap<>();
        this.faceOffWinPercentage = new HashMap<>();
    }

    /**
     * Create a new Hockey Team
     * @param name Team's name
     * @param season Team's first season
     * @param gamesPlayed Amount of games the team played in the given season
     * @param points Amount of points the team obtained in the given season
     * @param gamesWon Amount of games the team won in the given season
     * @param gamesLost Amount of games the team list in the given season
     * @param overtimeLosses Amount of games the team lost in overtime
     * @param goalsFor Amount of goals the team scored in the given season
     * @param goalsAgainst Amount of goals the team received in the given season
     * @param shotsForPerGame Average amount of shots scored by the team per game in the given season
     * @param shotsAgainstPerGame Average amount of shots received by the team per game in the given season
     * @param faceOffWinPercentage Percentage of face-offs won in a given season
     * @throws Exception whenever the data already exists
     */
    public HockeyTeam(String name, String season,
                        Integer gamesPlayed, Integer points,
                        Integer gamesWon, Integer gamesLost, Integer overtimeLosses,
                        Integer goalsFor, Integer goalsAgainst,
                        Double shotsForPerGame, Double shotsAgainstPerGame,
                        Double faceOffWinPercentage) throws Exception {
        this(name);
        this.addRecord(season, gamesPlayed, points, gamesWon, gamesLost,
                overtimeLosses, goalsFor, goalsAgainst, shotsForPerGame, shotsAgainstPerGame,
                faceOffWinPercentage);
    }


    /**
     * Add a new season to the hockey team
     * @param season Team's first season
     * @param gamesPlayed Amount of games the team played in the given season
     * @param points Amount of points the team obtained in the given season
     * @param gamesWon Amount of games the team won in the given season
     * @param gamesLost Amount of games the team list in the given season
     * @param overtimeLosses Amount of games the team lost in overtime
     * @param goalsFor Amount of goals the team scored in the given season
     * @param goalsAgainst Amount of goals the team received in the given season
     * @param shotsForPerGame Average amount of shots scored by the team per game in the given season
     * @param shotsAgainstPerGame Average amount of shots received by the team per game in the given season
     * @param faceOffWinPercentage Percentage of face-offs won in a given season
     * @throws Exception whenever the data already exists
     */
    public void addRecord(String season, Integer gamesPlayed, Integer points, Integer gamesWon,
                           Integer gamesLost, Integer overtimeLosses, Integer goalsFor,
                           Integer goalsAgainst, Double shotsForPerGame, Double shotsAgainstPerGame,
                           Double faceOffWinPercentage) throws Exception {
        this.addGamesPlayed(season, gamesPlayed);
        this.addPoints(season, points);
        this.addGamesWon(season, gamesWon);
        this.addGamesLost(season, gamesLost);
        this.addOvertimeLosses(season, overtimeLosses);
        this.addGoalsFor(season, goalsFor);
        this.addGoalsAgainst(season, goalsAgainst);
        this.addShotsForPerGame(season, shotsForPerGame);
        this.addShotsAgainstPerGame(season, shotsAgainstPerGame);
        this.addFaceOffWinPercentage(season, faceOffWinPercentage);
    }

    /**
     * return the faceoff win percentage of the team in a given season
     * @param season given season
     * @return faceoff win percentage during the season
     */
    public Double getFaceOffWinPercentage(String season) {
        return this.faceOffWinPercentage.get(season);
    }

    /**
     * return the goals scored by the team in a given season
     * @param season given season
     * @return goals scored by the team during the season
     */
    public Integer getGoalsFor(String season) {
        return this.goalsFor.get(season);
    }

    /**
     * return the goals scored against the team in a given season
     * @param season given season
     * @return goals scored against the team during the season
     */
    public Integer getGoalsAgainst(String season) {
        return this.goalsAgainst.get(season);
    }

    /**
     * return amount of shots per game by the team in a given season
     * @param season given season
     * @return amount of shots per game by the team during the season
     */
    public Double getShotsPerGame(String season) {
        return this.shotsForPerGame.get(season);
    }

    /**
     * return amount of shots received per game by the team in a given season
     * @param season given season
     * @return amount of shots received per game by the team during the season
     */
    public Double getShotsAgainstPerGame(String season) {
        return this.shotsAgainstPerGame.get(season);
    }

    /**
     * return amount of games played by the team in a given season
     * @param season given season
     * @return amount of games played by the team during the season
     */
    public Integer getGamesPlayed(String season) {
        return this.gamesPlayed.get(season);
    }

    /**
     * return amount of games won by the team in a given season
     * @param season given season
     * @return amount of games won by the team during the season
     */
    public Integer getGamesWon(String season) {
        return this.gamesWon.get(season);
    }

    /**
     * return amount of games lost by the team in a given season
     * @param season given season
     * @return amount of games lost by the team during the season
     */
    public Integer getGamesLost(String season) {
        return this.gamesLost.get(season);
    }

    /**
     * return amount of games lost in overtime by the team in a given season
     * @param season given season
     * @return amount of games lost in overtime by the team during the season
     */
    public Integer getOvertimeLosses(String season) {
        return this.overtimeLosses.get(season);
    }

    /**
     * return amount of points scored by the team in a given season
     * @param season given season
     * @return amount of points scored by the team during the season
     */
    public Integer getPoints(String season) {
        return this.points.get(season);
    }

    /**
     * add the team's faceoff win percentage during the given season to the data
     * @param season given season
     * @param faceOffWinPercentage statistic
     * @throws Exception whenever the data already exists
     */
    public void addFaceOffWinPercentage(String season, Double faceOffWinPercentage) throws Exception {
        checkForSeason(this.faceOffWinPercentage, season, false);
        this.faceOffWinPercentage.put(season, faceOffWinPercentage);
    }

    /**
     * add the team's shots against per game statistic during the given season to the data
     * @param season season
     * @param shotsAgainstPerGame statistic
     */
    public void addShotsAgainstPerGame(String season, Double shotsAgainstPerGame) {
        this.shotsAgainstPerGame.put(season, shotsAgainstPerGame);
    }

    /**
     * add the team's shots for per game statistic during the given season to the data
     * @param season season
     * @param shotsForPerGame statistic
     */
    public void addShotsForPerGame(String season, Double shotsForPerGame) {
        this.shotsForPerGame.put(season, shotsForPerGame);
    }

    /**
     * add the team's goals received statistic during the given season to the data
     * @param season season
     * @param goalsAgainst statistic
     */
    public void addGoalsAgainst(String season, Integer goalsAgainst) {
        this.goalsAgainst.put(season, goalsAgainst);
    }

    /**
     * add the team's goals scored statistic during the given season to the data
     * @param season season
     * @param goalsFor statistic
     */
    public void addGoalsFor(String season, Integer goalsFor) {
        this.goalsFor.put(season, goalsFor);
    }

    /**
     * add the team's amount of overtime losses during the given season to the data
     * @param season season
     * @param overtimeLosses statistic
     */
    public void addOvertimeLosses(String season, Integer overtimeLosses) {
        this.overtimeLosses.put(season, overtimeLosses);
    }

    /**
     * add the team's amount of games played during the given season to the data
     * @param season season
     * @param gamesPlayed statistic
     */
    public void addGamesPlayed(String season, Integer gamesPlayed) {
        this.gamesPlayed.put(season, gamesPlayed);
    }

    /**
     * add the team's amount of points during the given season to the data
     * @param season season
     * @param points statistic
     */
    public void addPoints(String season, Integer points) {
        this.points.put(season, points);
    }

    /**
     * add the team's amount of games won during the given season to the data
     * @param season season
     * @param gamesWon statistic
     */
    public void addGamesWon(String season, Integer gamesWon) {
        this.gamesWon.put(season, gamesWon);
    }

    /**
     * add the team's amount of games lost during the given season to the data
     * @param season season
     * @param gamesLost statistic
     */
    public void addGamesLost(String season, Integer gamesLost) {
        this.gamesLost.put(season, gamesLost);
    }

}