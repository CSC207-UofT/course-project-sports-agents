package sports.baseball;

import java.util.*;

/**
 * A comparator class for BaseballPlayerStatComparator. It compares and sorts
 * the players based on the values of the demanded statistic.
 * When instantiated, sets the statistic and season of interest.
 */

public class BaseballPlayerComparator implements Comparator<BaseballPlayer> {

    private final String compareBy;
    private final String season;

    /**
     * Create a new BaseballPlayerComparator
     * Precondition: compareBy is one of "Games Played", "At Bats", "Runs",
     * "Hits", "Home Runs", "Runs Batted In", "Strike Outs", or "Average"
     *
     * @param compareBy Compare by this statistic
     * @param season    Season to compare statistics from
     */
    public BaseballPlayerComparator(String compareBy, String season) {
        this.compareBy = compareBy;
        this.season = season;
    }

    public int compare(BaseballPlayer b1, BaseballPlayer b2) {
        try {
            switch (this.compareBy.toLowerCase()) {
                case "games played":
                    return compareGamesPlayed(b1, b2);
                case "at bats":
                    return compareAtBats(b1, b2);
                case "runs":
                    return compareRuns(b1, b2);
                case "hits":
                    return compareHits(b1, b2);
                case "home runs":
                    return compareHomeRuns(b1, b2);
                case "runs batted in":
                    return compareRunsBattedIn(b1, b2);
                case "strike outs":
                    return compareStrikeOuts(b1, b2);
                case "average":
                    return compareAverage(b1, b2);
                default:
                    return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Compare two baseball players based on the amount of games played
     *
     * @param b1 player 1
     * @param b2 player 2
     * @return the difference in the amount of games played between the two players
     * @throws Exception whenever the appropriate data doesn't exist.
     */
    private int compareGamesPlayed(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return b2.getStatGamesPlayed(this.season) -
               b1.getStatGamesPlayed(this.season);
    }


    /**
     * Compare two baseball players based on the amount of time at bat
     *
     * @param b1 player 1
     * @param b2 player 2
     * @return the difference in the amount of times at bat between the two players
     * @throws Exception whenever the appropriate data doesn't exist.
     */
    private int compareAtBats(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return b2.getStatAtBats(this.season) -
               b1.getStatAtBats(this.season);
    }


    /**
     * Compare two baseball players based on the amount of runs
     *
     * @param b1 player 1
     * @param b2 player 2
     * @return the difference in the amount of runs between the two players
     * @throws Exception whenever the appropriate data doesn't exist.
     */
    private int compareRuns(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return b2.getStatRuns(this.season) -
               b1.getStatRuns(this.season);
    }


    /**
     * Compare two baseball players based on the amount of hits
     *
     * @param b1 player 1
     * @param b2 player 2
     * @return the difference in the amount of hits between the two players
     * @throws Exception whenever the appropriate data doesn't exist.
     */
    private int compareHits(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return b2.getStatHits(this.season) -
               b1.getStatHits(this.season);
    }


    /**
     * Compare two baseball players based on the amount of home runs
     *
     * @param b1 player 1
     * @param b2 player 2
     * @return the difference in the amount of home runs between the two players
     * @throws Exception whenever the appropriate data doesn't exist.
     */
    private int compareHomeRuns(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return b2.getStatHomeRuns(this.season) -
               b1.getStatHomeRuns(this.season);
    }


    /**
     * Compare two baseball players based on the amount of runs batted in
     *
     * @param b1 player 1
     * @param b2 player 2
     * @return the difference in the amount of runs batted in between the two players
     * @throws Exception whenever the appropriate data doesn't exist.
     */
    private int compareRunsBattedIn(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return b2.getStatRunsBattedIn(this.season) -
               b1.getStatRunsBattedIn(this.season);
    }


    /**
     * Compare two baseball players based on the amount of strike-outs
     *
     * @param b1 player 1
     * @param b2 player 2
     * @return the difference in the amount of strike-outs between the two players
     * @throws Exception whenever the appropriate data doesn't exist.
     */
    private int compareStrikeOuts(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return b2.getStatStrikeOuts(this.season) -
               b1.getStatStrikeOuts(this.season);
    }


    /**
     * Compare two baseball players based on the average
     *
     * @param b1 player 1
     * @param b2 player 2
     * @return the difference in the averagw between the two players
     * @throws Exception whenever the appropriate data doesn't exist.
     */
    private int compareAverage(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return (int) Math.signum(b2.getStatAvg(this.season) -
                                 b1.getStatAvg(this.season));
    }
}
