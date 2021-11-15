package player;

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
     * @param compareBy Compare by this statistic
     * @param season Season to compare statistics from
     */
    public BaseballPlayerComparator(String compareBy, String season) {
        this.compareBy = compareBy;
        this.season = season;
    }

    public int compare(BaseballPlayer b1, BaseballPlayer b2) {
        try {
            switch (this.compareBy) {
                case "Games Played":
                    return compareGamesPlayed(b1, b2);
                case "At Bats":
                    return compareAtBats(b1, b2);
                case "Runs":
                    return compareRuns(b1, b2);
                case "Hits":
                    return compareHits(b1, b2);
                case "Home Runs":
                    return compareHomeRuns(b1, b2);
                case "Runs Batted In":
                    return compareRunsBattedIn(b1, b2);
                case "Strike Outs":
                    return compareStrikeOuts(b1, b2);
                case "Average":
                    return compareAverage(b1, b2);
                default:
                    return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    private int compareGamesPlayed(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return b1.getStatGamesPlayed(this.season) -
                b2.getStatGamesPlayed(this.season);
    }
    private int compareAtBats(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return b1.getStatAtBats(this.season) -
                b2.getStatAtBats(this.season);
    }
    private int compareRuns(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return b1.getStatRuns(this.season) -
                b2.getStatRuns(this.season);
    }
    private int compareHits(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return b1.getStatHits(this.season) -
                b2.getStatHits(this.season);
    }
    private int compareHomeRuns(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return b1.getStatHomeRuns(this.season) -
                b2.getStatHomeRuns(this.season);
    }
    private int compareRunsBattedIn(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return b1.getStatRunsBattedIn(this.season) -
                b2.getStatHits(this.season);
    }
    private int compareStrikeOuts(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return b1.getStatStrikeOuts(this.season) -
                b2.getStatStrikeOuts(this.season);
    }
    private int compareAverage(BaseballPlayer b1, BaseballPlayer b2)
            throws Exception {
        return (int) Math.signum(b1.getStatAvg(this.season) -
                                 b2.getStatAvg(this.season));
    }
}




