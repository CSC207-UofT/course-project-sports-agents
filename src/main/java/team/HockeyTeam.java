package team;

import java.util.HashMap;

public class HockeyTeam extends Team {

    protected final HashMap<String, Integer> gamesPlayed;
    protected final HashMap<String, Integer> points;
    protected final HashMap<String, Integer> gamesWon;
    protected final HashMap<String, Integer> gamesLost;
    protected final HashMap<String, Integer> overtimeLosses;
    protected final HashMap<String, Integer> goalsFor;
    protected final HashMap<String, Integer> goalsAgainst;
    protected final HashMap<String, Double> goalsForPerGame;
    protected final HashMap<String, Double> goalsAgainstPerGame;
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
        this.goalsForPerGame = new HashMap<>();
        this.goalsAgainstPerGame = new HashMap<>();
        this.faceOffWinPercentage = new HashMap<>();
    }

    /**
     * Create a new Hockey Player
     * @param name Team's name
     * @param season Team's first season
     * @param gamesPlayed Amount of games the team played in the given season
     * @param points Amount of points the team obtained in the given season
     * @param gamesWon Amount of games the team won in the given season
     * @param gamesLost Amount of games the team list in the given season
     * @param overtimeLosses Amount of games the team lost in overtime
     * @param goalsFor Amount of goals the team scored in the given season
     * @param goalsAgainst Amount of goals the team received in the given season
     * @param goalsForPerGame Average amount of goals scored by the team per game in the given season
     * @param goalsAgainstPerGame Average amount of goals received by the team per game in the given season
     * @param faceOffWinPercentage Percentage of face-offs won in a given season
     * @throws Exception should not throw Exception
     */
    public HockeyTeam(String name, String season,
                        Integer gamesPlayed, Integer points,
                        Integer gamesWon, Integer gamesLost, Integer overtimeLosses,
                        Integer goalsFor, Integer goalsAgainst,
                        Double goalsForPerGame, Double goalsAgainstPerGame,
                        Double faceOffWinPercentage) throws Exception {
        this(name);
        this.addRecord(season, gamesPlayed, points, gamesWon, gamesLost,
                overtimeLosses, goalsFor, goalsAgainst, goalsForPerGame, goalsAgainstPerGame,
                faceOffWinPercentage);
    }

    public void addRecord(String season, Integer gamesPlayed, Integer points, Integer gamesWon,
                           Integer gamesLost, Integer overtimeLosses, Integer goalsFor,
                           Integer goalsAgainst, Double goalsForPerGame, Double goalsAgainstPerGame,
                           Double faceOffWinPercentage) {
        this.addGamesPlayed(season, gamesPlayed);
        this.addPoints(season, points);
        this.addGamesWon(season, gamesWon);
        this.addGamesLost(season, gamesLost);
        this.addOvertimeLosses(season, overtimeLosses);
        this.addGoalsFor(season, goalsFor);
        this.addGoalsAgainst(season, goalsAgainst);
        this.addGoalsForPerGame(season, goalsForPerGame);
        this.addGoalsAgainstPerGame(season, goalsAgainstPerGame);
        this.addFaceOffWinPercentage(season, faceOffWinPercentage);
    }

    public Double getFaceOffWinPercentage(String season) {
        return this.faceOffWinPercentage.get(season);
    }

    public Integer getGoalsFor(String season) {
        return this.goalsFor.get(season);
    }

    public Integer getGoalsAgainst(String season) {
        return this.goalsAgainst.get(season);
    }

    public Double getGoalsForPerGame(String season) {
        return this.goalsForPerGame.get(season);
    }

    public Double getGoalsAgainstPerGame(String season) {
        return this.goalsAgainstPerGame.get(season);
    }


    public Integer getGamesPlayed(String season) {
        return this.gamesPlayed.get(season);
    }

    public Integer getGamesWon(String season) {
        return this.gamesWon.get(season);
    }

    public Integer getGamesLost(String season) {
        return this.gamesLost.get(season);
    }

    public Integer getOvertimeLosses(String season) {
        return this.overtimeLosses.get(season);
    }

    public Integer getPoints(String season) {
        return this.points.get(season);
    }

    public void addFaceOffWinPercentage(String season, Double faceOffWinPercentage) {
        this.faceOffWinPercentage.put(season, faceOffWinPercentage);
    }

    public void addGoalsAgainstPerGame(String season, Double goalsAgainstPerGame) {
        this.goalsAgainstPerGame.put(season, goalsAgainstPerGame);
    }

    public void addGoalsForPerGame(String season, Double goalsForPerGame) {
        this.goalsForPerGame.put(season, goalsForPerGame);
    }


    public void addGoalsAgainst(String season, Integer goalsAgainst) {
        this.goalsAgainst.put(season, goalsAgainst);
    }

    public void addGoalsFor(String season, Integer goalsFor) {
        this.goalsFor.put(season, goalsFor);
    }

    public void addOvertimeLosses(String season, Integer overtimeLosses) {
        this.overtimeLosses.put(season, overtimeLosses);
    }

    public void addGamesPlayed(String season, Integer gamesPlayed) {
        this.gamesPlayed.put(season, gamesPlayed);
    }

    public void addPoints(String season, Integer points) {
        this.points.put(season, points);
    }

    public void addGamesWon(String season, Integer gamesWon) {
        this.gamesWon.put(season, gamesWon);
    }

    public void addGamesLost(String season, Integer gamesLost) {
        this.gamesLost.put(season, gamesLost);
    }

}