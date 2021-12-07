package sports.tennis;

import org.junit.Before;
import org.junit.Test;

public class TennisPlayerComparatorTest {
    TennisPlayer player1;
    TennisPlayer player2;
    TennisPlayer player3;


    @Before
    public void setUp() throws Exception {
        this.player1 = new TennisPlayer("Player One", "CAN","2018",
                1, 10, 20, 11, 64.0, 67.0,
                32.0, 35.0, 12.0, 43.0);
        this.player2 = new TennisPlayer("Player Two", "USA", "2018",
                1, 2, 12, 11, 43.0, 67.0,
                81.0, 35.0, 32.0, 68.0);
        this.player3 = new TennisPlayer("Player Three", "ENG", "2018",
                30, 2, 20, 23, 64.0, 10.0,
                81.0, 10.0, 32.0, 43.0);
    }

    @Test(timeout = 100)
    public void testCompareRank() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("rank", "2018");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareMatches() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("matches", "2018");
        int compareEquals = tennisPlayerComparator.compare(this.player2, this.player3);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player2, this.player1);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareAces() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("aces", "2018");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player2, this.player3);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareDoubleFaults() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("double faults", "2018");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player2, this.player3);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player3, this.player1);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareServePointsWon() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("serve points won", "2018");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player3, this.player2);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player2, this.player1);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareBreakPointsSaved() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("break points saved", "2018");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player2, this.player3);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player3, this.player1);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareServeGamesWon() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("serve games won", "2018");
        int compareEquals = tennisPlayerComparator.compare(this.player2, this.player3);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player2, this.player1);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareReturnGamesWon() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("return games won", "2018");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player2, this.player3);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player3, this.player1);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareBreakPointsConverted() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("break points converted", "2018");
        int compareEquals = tennisPlayerComparator.compare(this.player2, this.player3);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player2, this.player1);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareReturnPointsWon() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("return points won", "2018");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player2, this.player3);
        assert(compareGreater > 0);
        int compareLesser = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareLesser < 0);
    }

    @Test(timeout = 100)
    public void testCompareNoData() {
        TennisPlayerComparator tennisPlayerComparator =
                new TennisPlayerComparator("rank", "2020");
        int compareEquals = tennisPlayerComparator.compare(this.player1, this.player2);
        assert(compareEquals == 0);
        int compareGreater = tennisPlayerComparator.compare(this.player1, this.player3);
        assert(compareGreater == 0);
        int compareLesser = tennisPlayerComparator.compare(this.player3, this.player2);
        assert(compareLesser == 0);
    }

}