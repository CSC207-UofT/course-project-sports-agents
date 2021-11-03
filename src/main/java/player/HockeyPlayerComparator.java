package player;

import java.util.Comparator;

/**
 * A comparator class for HockeyPlayerStatComparator. It compares and sorts
 * the players based on the values of the demanded statistic.
 * When instantiated, sets the statistic and season of interest.
 */
public class HockeyPlayerComparator implements Comparator<HockeyPlayer> {
    String compareBy;
    String season;

    /**
     * Create a new HockeyPlayerComparator
     * @param compareBy Compare by this statistic
     * @param season Season to compare statistics from
     */
    public HockeyPlayerComparator(String compareBy, String season) {
        this.compareBy = compareBy;
        this.season = season;
    }

    public int compare(HockeyPlayer p1, HockeyPlayer p2) {
        try {
            return switch(this.compareBy) {
                case "Skater Shoots" -> compareSkaterShoots(p1, p2);
                case "Games Played" -> compareGamesPlayed(p1, p2);
                case "Goals" -> compareGoals(p1, p2);
                case "Assists" -> compareAssists(p1, p2);
                case "Points" -> comparePoints(p1, p2);
                case "Shots" -> compareShots(p1, p2);
                case "ShootingPercentage" -> compareShootingPercentage(p1, p2);
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int compareSkaterShoots(HockeyPlayer p1, HockeyPlayer p2)
            throws Exception {
        return p1.getStatSkaterShoots(this.season) -
                p2.getStatSkaterShoots(this.season);
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
        return p1.getStatShootingPercentage(this.season) -
                p2.getStatShootingPercentage(this.season);
    }
}


