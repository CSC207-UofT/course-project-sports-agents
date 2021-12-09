package sports.hockey;

import org.junit.Before;
import org.junit.Test;

public class HockeyPlayerComparatorTest {
    HockeyPlayer player1;
    HockeyPlayer player2;
    HockeyPlayer player3;

    @Before
    public void setUp() throws Exception {
        this.player1 = new HockeyPlayer("The Greatest 1",
                "20202021", "COL", "L", "R",
                70, 30, 36, 66, 177,
                24.0);
        this.player2 = new HockeyPlayer("The Greatest 2",
                "20202021", "LOC", "R", "L",
                70, 30, 36, 66, 177,
                24.0);
        this.player3 = new HockeyPlayer("The Worst",
                "20202021", "OCL", "R", "C",
                20, 5, 7, 24, 30,
                23.9);
    }

    @Test(timeout = 100)
    public void testCompareGamesPlayed() {
        HockeyPlayerComparator hockeyPlayerComparator =
                new HockeyPlayerComparator("games played", "20202021");
        int compareEquals = hockeyPlayerComparator.compare(this.player1, this.player2);
        assert (compareEquals == 0);
        int compareGreater = hockeyPlayerComparator.compare(this.player1, this.player3);
        assert (compareGreater > 0);
        int compareLesser = hockeyPlayerComparator.compare(this.player3, this.player2);
        assert (compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareGoals() {
        HockeyPlayerComparator hockeyPlayerComparator =
                new HockeyPlayerComparator("goals", "20202021");
        int compareEquals = hockeyPlayerComparator.compare(this.player1, this.player2);
        assert (compareEquals == 0);
        int compareGreater = hockeyPlayerComparator.compare(this.player1, this.player3);
        assert (compareGreater > 0);
        int compareLesser = hockeyPlayerComparator.compare(this.player3, this.player2);
        assert (compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareAssists() {
        HockeyPlayerComparator hockeyPlayerComparator =
                new HockeyPlayerComparator("assists", "20202021");
        int compareEquals = hockeyPlayerComparator.compare(this.player1, this.player2);
        assert (compareEquals == 0);
        int compareGreater = hockeyPlayerComparator.compare(this.player1, this.player3);
        assert (compareGreater > 0);
        int compareLesser = hockeyPlayerComparator.compare(this.player3, this.player2);
        assert (compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testComparePoints() {
        HockeyPlayerComparator hockeyPlayerComparator =
                new HockeyPlayerComparator("points", "20202021");
        int compareEquals = hockeyPlayerComparator.compare(this.player1, this.player2);
        assert (compareEquals == 0);
        int compareGreater = hockeyPlayerComparator.compare(this.player1, this.player3);
        assert (compareGreater > 0);
        int compareLesser = hockeyPlayerComparator.compare(this.player3, this.player2);
        assert (compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareShots() {
        HockeyPlayerComparator hockeyPlayerComparator =
                new HockeyPlayerComparator("shots", "20202021");
        int compareEquals = hockeyPlayerComparator.compare(this.player1, this.player2);
        assert (compareEquals == 0);
        int compareGreater = hockeyPlayerComparator.compare(this.player1, this.player3);
        assert (compareGreater > 0);
        int compareLesser = hockeyPlayerComparator.compare(this.player3, this.player2);
        assert (compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareShootingPercentage() {
        HockeyPlayerComparator hockeyPlayerComparator =
                new HockeyPlayerComparator("shooting percentage", "20202021");
        int compareEquals = hockeyPlayerComparator.compare(this.player1, this.player2);
        assert (compareEquals == 0);
        int compareGreater = hockeyPlayerComparator.compare(this.player1, this.player3);
        assert (compareGreater > 0);
        int compareLesser = hockeyPlayerComparator.compare(this.player3, this.player2);
        assert (compareLesser < 0);
    }

    @Test(timeout = 200)
    public void testCompareNoData() {
        HockeyPlayerComparator hockeyPlayerComparator =
                new HockeyPlayerComparator("games played", "20192020");
        int compareEquals = hockeyPlayerComparator.compare(this.player1, this.player2);
        assert (compareEquals == 0);
        int compareGreater = hockeyPlayerComparator.compare(this.player1, this.player3);
        assert (compareGreater == 0);
        int compareLesser = hockeyPlayerComparator.compare(this.player3, this.player2);
        assert (compareLesser == 0);
    }
}