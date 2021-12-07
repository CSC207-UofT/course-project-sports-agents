package sports.tennis;

import java.util.Comparator;

/**
 * A comparator class for HockeyPlayerStatComparator. It compares and sorts
 * the players based on the values of the demanded statistic.
 * When instantiated, sets the statistic and season of interest.
 */
public class TennisPlayerComparator implements Comparator<TennisPlayer> {
    final String compareBy;
    final String season;

    /**
     * Create a new TennisPlayerComparator
     * Precondition: compareBy is one of "Age", "Aces", "Double Faults",
     * "Serve Points", "First Serves", "Break Points Saved"
     * @param compareBy Compare by this statistic
     * @param season Season to compare statistics from
     */
    public TennisPlayerComparator(String compareBy, String season) {
        this.compareBy = compareBy;
        this.season = season;
    }

    public int compare(TennisPlayer p1, TennisPlayer p2) {
        try {
            switch(this.compareBy) {
                case "rank":
                    return compareRank(p1, p2);
                case "matches":
                    return compareMatches(p1, p2);
                case "aces":
                    return compareAces(p1, p2);
                case "double faults":
                    return compareDoubleFaults(p1, p2);
                case "serve points won":
                    return compareServePointsWon(p1, p2);
                case "break points saved":
                    return compareBreakPointsSaved(p1, p2);
                case "serve games won":
                    return compareServeGamesWon(p1, p2);
                case "return games won":
                    return compareReturnGamesWon(p1, p2);
                case "break points converted":
                    return compareBreakPointsConverted(p1, p2);
                case "return points won":
                    return compareReturnPointsWon(p1, p2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * Compare two players based on their rank
     * @param p1 player 1
     * @param p2 player 2
     * @return the different in the ranking of the players
     * @throws Exception whenever the appropriate data doesn't exist
     */
    private int compareRank(TennisPlayer p1, TennisPlayer p2) throws Exception {
        return p1.getStatRank(this.season) - p2.getStatRank(this.season);
    }

    /**
     * Compare two players based on their matches
     * @param p1 player 1
     * @param p2 player 2
     * @return the difference in the amount of matches played by the players
     * @throws Exception whenever the appropriate data doesn't exist
     */
    private int compareMatches(TennisPlayer p1, TennisPlayer p2) throws Exception {
        return p1.getStatMatches(this.season) -
                p2.getStatMatches(this.season);
    }

    /**
     * Compare two players based on their aces
     * @param p1 player 1
     * @param p2 player 2
     * @return the difference in the amount of aces by the players
     * @throws Exception whenever the appropriate data doesn't exist
     */
    private int compareAces(TennisPlayer p1, TennisPlayer p2) throws Exception {
        return p1.getStatAces(this.season) -
                p2.getStatAces(this.season);
    }

    /**
     * Compare two players based on their double faults
     * @param p1 player 1
     * @param p2 player 2
     * @return the difference in the amount of double faults by the players
     * @throws Exception whenever the appropriate data doesn't exist
     */
    private int compareDoubleFaults(TennisPlayer p1, TennisPlayer p2) throws Exception {
        return p1.getStatDoubleFaults(this.season) -
                p2.getStatDoubleFaults(this.season);
    }

    /**
     * Compare two players based on their serve points
     * @param p1 player 1
     * @param p2 player 2
     * @return the difference in the amount of serve points won by the players
     * @throws Exception whenever the appropriate data doesn't exist
     */
    private int compareServePointsWon(TennisPlayer p1, TennisPlayer p2) throws Exception {
        return (int) Math.signum(p1.getStatServePointsWon(this.season) -
                p2.getStatServePointsWon(this.season));
    }

    /**
     * Compare two players based on their break points
     * @param p1 player 1
     * @param p2 player 2
     * @return the difference in the amount of break points by the players
     * @throws Exception whenever the appropriate data doesn't exist
     */
    private int compareBreakPointsSaved(TennisPlayer p1, TennisPlayer p2) throws Exception {
        return (int) Math.signum(p1.getStatBreakPointsSaved(this.season) -
                p2.getStatBreakPointsSaved(this.season));
    }

    /**
     * Compare two players based on their serve games
     * @param p1 player 1
     * @param p2 player 2
     * @return the difference in the amount of serve games won by the players
     * @throws Exception whenever the appropriate data doesn't exist
     */
    private int compareServeGamesWon(TennisPlayer p1, TennisPlayer p2) throws Exception {
        return (int) Math.signum(p1.getStatServeGamesWon(this.season) -
                p2.getStatServeGamesWon(this.season));
    }

    /**
     * Compare two players based on their return games
     * @param p1 player 1
     * @param p2 player 2
     * @return the difference in the amount of return games won by the players
     * @throws Exception whenever the appropriate data doesn't exist
     */
    private int compareReturnGamesWon(TennisPlayer p1, TennisPlayer p2) throws Exception {
        return (int) Math.signum(p1.getStatReturnGamesWon(this.season) -
                p2.getStatReturnGamesWon(this.season));
    }

    /**
     * Compare two players based on their break points
     * @param p1 player 1
     * @param p2 player 2
     * @return the difference in the amount of break points converted by the players
     * @throws Exception whenever the appropriate data doesn't exist
     */

    private int compareBreakPointsConverted(TennisPlayer p1, TennisPlayer p2) throws Exception {
        return (int) Math.signum(p1.getStatBreakPointsConverted(this.season) -
                p2.getStatBreakPointsConverted(this.season));
    }

    /**
     * Compare two players based on their return points
     * @param p1 player 1
     * @param p2 player 2
     * @return the difference in the amount of return points won by the players
     * @throws Exception whenever the appropriate data doesn't exist
     */
    private int compareReturnPointsWon(TennisPlayer p1, TennisPlayer p2) throws Exception {
        return (int) Math.signum(p1.getStatReturnPointsWon(this.season) -
                p2.getStatReturnPointsWon(this.season));
    }

}



