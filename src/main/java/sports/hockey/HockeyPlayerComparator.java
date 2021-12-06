package sports.hockey;

import java.util.Comparator;

/**
 * A comparator class for HockeyPlayerStatComparator. It compares and sorts
 * the players based on the values of the demanded statistic.
 * When instantiated, sets the statistic and season of interest.
 */
public class HockeyPlayerComparator implements Comparator<HockeyPlayer> {
    private final String compareBy;
    private final String season;

    /**
     * Create a new HockeyPlayerComparator
     * Precondition: compareBy is one of "Games Played", "Goals", "Assists",
     * "Points", "Shots", or "Shooting Percentage"
     * @param compareBy Compare by this statistic
     * @param season Season to compare statistics from
     */
    public HockeyPlayerComparator(String compareBy, String season) {
        this.compareBy = compareBy;
        this.season = season;
    }

    public int compare(HockeyPlayer p1, HockeyPlayer p2) {
        try {
            switch(this.compareBy) {
                case "games played":
                    return compareGamesPlayed(p1, p2);
                case "goals":
                    return compareGoals(p1, p2);
                case "assists":
                    return compareAssists(p1, p2);
                case "points":
                    return comparePoints(p1, p2);
                case "shots":
                    return compareShots(p1, p2);
                case "shooting percentage":
                    return compareShootingPercentage(p1, p2);
                default:
                    return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    private int compareGamesPlayed(HockeyPlayer p1, HockeyPlayer p2)
            throws Exception {
        return p1.getStatGamesPlayed(this.season) -
                p2.getStatGamesPlayed(this.season);
    }

    private int compareGoals(HockeyPlayer p1, HockeyPlayer p2)
            throws Exception {
        return p1.getStatGoals(this.season) -
                p2.getStatGoals(this.season);
    }

    private int compareAssists(HockeyPlayer p1, HockeyPlayer p2)
            throws Exception {
        return p1.getStatAssists(this.season) -
                p2.getStatAssists(this.season);
    }

    private int comparePoints(HockeyPlayer p1, HockeyPlayer p2)
            throws Exception {
        return p1.getStatPoints(this.season) -
                p2.getStatPoints(this.season);
    }

    private int compareShots(HockeyPlayer p1, HockeyPlayer p2)
            throws Exception {
        return p1.getStatShots(this.season) -
                p2.getStatShots(this.season);
    }

    private int compareShootingPercentage(HockeyPlayer p1, HockeyPlayer p2)
            throws Exception {
        return (int) Math.signum(p1.getStatShootingPercentage(this.season) -
                                 p2.getStatShootingPercentage(this.season));
    }
}


