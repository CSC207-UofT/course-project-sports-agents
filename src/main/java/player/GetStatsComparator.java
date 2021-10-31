package player;

import java.util.Comparator;

/**
 * A comparator class for PlayerStatComparator. It compares and sorts the players based on
 * the values of the demanded statistics.
 */
public class GetStatsComparator implements Comparator<Player> {
    String demandedStat;

    public GetStatsComparator(String demandedStat) {
        this.demandedStat = demandedStat;
    }

    public int compare(Player p1, Player p2) {
        try {
            return Integer.compare(Integer.parseInt(p1.getNeededStat(this.demandedStat)),
                    Integer.parseInt(p2.getNeededStat(this.demandedStat)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}


