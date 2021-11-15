package player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseballPlayerComparatorTest {
    BaseballPlayer player1;
    BaseballPlayer player2;
    BaseballPlayer player3;

    @Before
    public void setUp() throws Exception {
        this.player1 = new BaseballPlayer("The Greatest 1",
                "20202021", "COL", "L", 60,
                70,30,36,66,177,
                24, 22.0);
        this.player2 = new BaseballPlayer("The Greatest 2",
                "20202021", "LOC", "R", 60,
                70, 30, 36, 66, 177,
                24, 22.0);
        this.player3 = new BaseballPlayer("The Worst",
                "20202021", "OCL", "R", 30,
                20, 5, 7, 24, 30,
                20, 21.9);
    }

    @Test(timeout = 100)
    public void testCompareGamesPlayed() {
        BaseballPlayerComparator baseballPlayerComparator =
                new BaseballPlayerComparator("Games Played", "20202021");
        int compareEquals = baseballPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = baseballPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = baseballPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareAtBats() {
        BaseballPlayerComparator baseballPlayerComparator =
                new BaseballPlayerComparator("At Bats", "20202021");
        int compareEquals = baseballPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = baseballPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = baseballPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareRuns() {
        BaseballPlayerComparator baseballPlayerComparator =
                new BaseballPlayerComparator("Runs", "20202021");
        int compareEquals = baseballPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = baseballPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = baseballPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareHits() {
        BaseballPlayerComparator baseballPlayerComparator =
                new BaseballPlayerComparator("Hits", "20202021");
        int compareEquals = baseballPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = baseballPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = baseballPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareHomeRuns() {
        BaseballPlayerComparator baseballPlayerComparator =
                new BaseballPlayerComparator("Home Runs", "20202021");
        int compareEquals = baseballPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = baseballPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = baseballPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareRunsBattedIn() {
        BaseballPlayerComparator baseballPlayerComparator =
                new BaseballPlayerComparator("Runs Batted In", "20202021");
        int compareEquals = baseballPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = baseballPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = baseballPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareStrikeOuts() {
        BaseballPlayerComparator baseballPlayerComparator =
                new BaseballPlayerComparator("Strike Outs", "20202021");
        int compareEquals = baseballPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = baseballPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = baseballPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareAverage() {
        BaseballPlayerComparator baseballPlayerComparator =
                new BaseballPlayerComparator("Average", "20202021");
        int compareEquals = baseballPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = baseballPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = baseballPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareNoStat() {
        BaseballPlayerComparator baseballPlayerComparator =
                new BaseballPlayerComparator("Games Played", "20192020");
        int compareEquals = baseballPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = baseballPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater == 0);
        int compareLesser = baseballPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser == 0);
    }
}