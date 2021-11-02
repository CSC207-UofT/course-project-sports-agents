package player;
import java.util.Comparator;

/**
 * A comparator class for PlayerStatComparator. It compares and sorts the players based on
 * the values of the demanded statistics.
 */
public class GetStatsComparator implements Comparator<Player> {
    String demandedStat;
    String demandedSeason;

    public GetStatsComparator(String demandedStat, String demandedSeason) {
        this.demandedStat = demandedStat;
        this.demandedSeason = demandedSeason;
    }

    public int compare(Player p1, Player p2) {
        try {
            return p1.getNeededStat(this.demandedStat).get(demandedSeason).compareTo(p2.getNeededStat(this.demandedStat).get(demandedSeason));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}


