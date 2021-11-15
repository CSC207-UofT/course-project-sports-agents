package player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TennisPlayerComparatorTest {
    TennisPlayer player1;
    TennisPlayer player2;
    TennisPlayer player3;


    @Before
    public void setUp() throws Exception {
        this.player1 = new TennisPlayer("The Greatest 1", "CAN",
                "20202021", 26, 10, 10, 10,
                10, 10);
        this.player2 = new TennisPlayer("The Greatest 2", "USA",
                "20202021", 26, 10, 10, 10,
                10, 10);
        this.player3 = new TennisPlayer("The Worst", "ENG",
                "20202021", 22, 5, 5, 5,
                5, 5);
    }

    @Test(timeout = 100)
    public void testCompareAge() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("Age", "20202021");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareAces() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("Aces", "20202021");
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
                new TennisPlayerComparator("Double Faults", "20202021");
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
                new TennisPlayerComparator("Serve Points", "20202021");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareFirstServes() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("First Serves", "20202021");
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
                new TennisPlayerComparator("Break Points Saved", "20202021");
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
                new TennisPlayerComparator("Age", "20192020");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater == 0);
        int compareLesser = tennisPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser == 0);
    }

}