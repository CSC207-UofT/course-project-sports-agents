package player;

import java.util.Comparator;

/**
 * A comparator class for HockeyPlayerStatComparator. It compares and sorts
 * the players based on the values of the demanded statistic.
 * When instantiated, sets the statistic and season of interest.
 */
public class TennisPlayerComparator implements Comparator<TennisPlayer> {
    String compareBy;
    String season;

    /**
     * Create a new HockeyPlayerComparator
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
                case "Age":
                    return compareAge(p1, p2);
                case "Aces":
                    return compareAces(p1, p2);
                case "Double Faults":
                    return compareDoubleFaults(p1, p2);
                case "Serve Points":
                    return compareServePoints(p1, p2);
                case "First Serves":
                    return compareFirstServes(p1, p2);
                case "Break Points Saved":
                    return compareBreakPointsSaved(p1, p2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int compareAge(TennisPlayer p1, TennisPlayer p2) throws Exception {
        return p1.getStatAge(this.season) - p2.getStatAge(this.season);
    }

    private int compareAces(TennisPlayer p1, TennisPlayer p2) throws Exception {
        return p1.getStatAces(this.season) - p2.getStatAces(this.season);
    }

    private int compareDoubleFaults(TennisPlayer p1, TennisPlayer p2)
            throws Exception {
        return p1.getStatDoubleFaults(this.season) -
                p2.getStatDoubleFaults(this.season);
    }

    private int compareServePoints(TennisPlayer p1, TennisPlayer p2)
            throws Exception {
        return p1.getStatServePoints(this.season) -
                p2.getStatServePoints(this.season);
    }

    private int compareFirstServes(TennisPlayer p1, TennisPlayer p2)
            throws Exception {
        return p1.getStatFirstServes(this.season) -
                p2.getStatFirstServes(this.season);
    }

    private int compareBreakPointsSaved(TennisPlayer p1, TennisPlayer p2)
            throws Exception {
        return p1.getStatBreakPointsSaved(this.season) -
                p2.getStatBreakPointsSaved(this.season);
    }

}



