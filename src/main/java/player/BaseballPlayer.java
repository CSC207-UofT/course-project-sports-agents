package player;

public class BaseballPlayer extends Player {
    private final String team;
    private final String position;
    private final int gamesPlayed;
    private final int hits;
    private final int homeRuns;
    private final int walks;
    private final int strikeouts;
    private final double winsAboveReplacement;


    /**
     * Construct a baseball player with the given properties
     * @param name the player's name
     * @param team the team the player plays for
     * @param position the player's position on the team
     * @param gamesPlayed the number of games played by this player
     * @param hits the number of hits made by this player
     * @param homeRuns the number of home runs scored made by this player
     * @param walks the number of walks made by this player
     * @param strikeouts the number of strikeouts made by this player
     * @param winsAboveReplacement the player's wins above replacement value
     */
    public BaseballPlayer(String name, String team, String position, int gamesPlayed, int hits, int homeRuns,
                          int walks, int strikeouts, double winsAboveReplacement) {
        super(name);
        this.team = team;
        this.position = position;
        this.gamesPlayed = gamesPlayed;
        this.hits = hits;
        this.homeRuns = homeRuns;
        this.walks = walks;
        this.strikeouts = strikeouts;
        this.winsAboveReplacement = winsAboveReplacement;
    }


    /**
     * Construct a baseball player who has not participated in any games
     * @param name player's name
     * @param team player's team
     * @param position player's position
     */
    public BaseballPlayer(String name, String team, String position) {
        super(name);
        this.team = team;
        this.position = position;
        this.gamesPlayed = 0;
        this.hits = 0;
        this.homeRuns = 0;
        this.walks = 0;
        this.strikeouts = 0;
        this.winsAboveReplacement = 0.0;
    }

    /**
     * Return this player's team
     * @return player's team
     */
    public String getTeam() {
        return this.team;
    }


    /**
     * Return this player's position
     * @return player's position
     */
    public String getPosition() {
        return this.position;
    }


    /**
     * Return the number of games this player played
     * @return number of games
     */
    public int getGamesPlayed() {
        return this.gamesPlayed;
    }


    /**
     * Return the number of hits made by this player
     * @return number of hits
     */
    public int getHits() {
        return this.hits;
    }


    /**
     * Return the number of home runs made by this player
     * @return number of home runs
     */
    public int getHomeRuns() {
        return this.homeRuns;
    }


    /**
     * Return the number of walks made by this player
     * @return number of walks
     */
    public int getWalks() {
        return this.walks;
    }


    /**
     * Return the number of strikeouts made by this player
     * @return number of strikeouts
     */
    public int getStrikeouts() {
        return this.strikeouts;
    }


    /**
     * Return this player's wins above replacement value
     * @return wins above replacement
     */
    public double getWinsAboveReplacement() {
        return this.winsAboveReplacement;
    }


    /**
     * Return the given stat associated with the player. If the given stat is not valid for a baseball player,
     * throw an exception.
     * @param stat the needed stat
     * @return the value of the needed stat for this player
     * @throws Exception if the stat is not defined for this baseball player
     */
    public String getNeededStat(String stat) throws Exception {
        switch (stat) {
            case "name":
                return this.getName();
            case "team":
                return this.team;
            case "position":
                return this.position;
            case "games played":
                return String.valueOf(this.gamesPlayed);
            case "hits":
                return String.valueOf(this.hits);
            case "home runs":
                return String.valueOf(this.homeRuns);
            case "walks":
                return String.valueOf(this.walks);
            case "strikeouts":
                return String.valueOf(this.strikeouts);
            case "wins above replacement":
                return String.valueOf(this.winsAboveReplacement);
        }
        throw new Exception("The given stat was not found!");
    }


    /**
     * Return the value of the given stat. The given stat should be comparable (should be an int or double). If the
     * stat is not comparable, or is invalid, throw an exception
     * @param stat the needed stat
     * @return the value of the needed stat for this player
     * @throws Exception if the given stat was not found, or is not a comparable value
     */
    public String getComparableStat(String stat) throws Exception {
        switch (stat) {
            case "games played":
                return String.valueOf(this.gamesPlayed);
            case "hits":
                return String.valueOf(this.hits);
            case "home runs":
                return String.valueOf(this.homeRuns);
            case "walks":
                return String.valueOf(this.walks);
            case "strikeouts":
                return String.valueOf(this.strikeouts);
            case "wins above replacement":
                return String.valueOf(this.winsAboveReplacement);
        }
        throw new Exception("The given stat cannot be compared or was not found!");
    }

    /**
     * Return a string representation of this baseball player
     * @return string representation of player
     */
    @Override
    public String toString() {
        String partOne = super.toString();
        return partOne + "\nTeam: " + this.team + "\nPosition: " + this.position + "\nGames Played: " +
                this.gamesPlayed + "\nHits: " + this.hits + "\nHome Runs: " + this.homeRuns + "\nWalks: " +
                this.walks + "\nStrikeouts: " + this.strikeouts + "\nWins Above Replacement: "
                + this.winsAboveReplacement;
    }
}
