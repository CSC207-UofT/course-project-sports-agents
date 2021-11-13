package player;

import java.util.Comparator;

/**
 * A comparator class for PlayerStatComparator. It compares and sorts the players based on
 * the values of the demanded statistics.
 */
public class GetStatsComparator implements Comparator<HockeyPlayer> {
    final String demandedStat;

    public GetStatsComparator(String demandedStat) {
        this.demandedStat = demandedStat;
    }

    public int compare(HockeyPlayer p1, HockeyPlayer p2) {
        try {
            if (Integer.parseInt(p1.getStat(this.demandedStat)) > Integer.parseInt(p2.getStat(this.demandedStat))) {
                return 1;
            } else if (Integer.parseInt(p1.getStat(this.demandedStat)) == Integer.parseInt(p2.getStat(this.demandedStat))) {
                return 0;
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}


