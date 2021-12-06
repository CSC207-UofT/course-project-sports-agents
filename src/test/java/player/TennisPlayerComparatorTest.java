package player;

import org.junit.Before;
import org.junit.Test;

public class TennisPlayerComparatorTest {
    TennisPlayer player1;
    TennisPlayer player2;
    TennisPlayer player3;


    @Before
    public void setUp() throws Exception {
        this.player1 = new TennisPlayer("The Greatest 1", "CAN","2018",
                1, 3, 20, 11, 64.0, 69.0,
                85.0, 35.0, 35.0, 43.0);
        this.player2 = new TennisPlayer("The Greatest 2", "USA", "2018",
                20, 3, 20, 11, 64.0, 69.0,
                85.0, 35.0, 35.0, 43.0);
        this.player3 = new TennisPlayer("The Worst", "ENG", "2018",
                30, 1, 10, 10, 54.0, 10.0,
                32.0, 10.0, 8.0, 9.0);
    }

    @Test(timeout = 200)
    public void testCompareAces() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("aces", "2018");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareDoubleFaults() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("double faults", "2018");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareServePoints() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("serve points won", "2018");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareBreakPointsSaved() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("break points saved", "2018");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareNoData() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("age", "20192020");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater == 0);
        int compareLesser = tennisPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser == 0);
    }

}