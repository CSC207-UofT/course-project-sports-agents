package sports.baseball;

import org.junit.Before;
import org.junit.Test;

public class BaseballPlayerComparatorTest {
    BaseballPlayer playerOne;
    BaseballPlayer playerTwo;
    BaseballPlayer playerThree;

    @Before
    public void setUp() throws Exception {
        playerOne = new BaseballPlayer("PlayerOne", "2019-2020", "KC", "2B",
                21, 7, 89, 29, 48, 68, 29, 0.935);
        playerTwo = new BaseballPlayer("PlayerTwo", "2019-2020", "KC", "3B",
                21, 57, 73, 29, 23, 36, 29, 0.692);
        playerThree = new BaseballPlayer("PlayerThree", "2019-2020", "BOS", "2B",
                5, 7, 73, 15, 48, 36, 72, 0.935);
    }

    @Test(timeout = 100)
    public void testCompareGamesPlayed() {
        BaseballPlayerComparator comparator = new BaseballPlayerComparator("games played",
                "2019-2020");
        int compareEquals = comparator.compare(this.playerOne, this.playerTwo);
        assert(compareEquals == 0);
        int compareGreater = comparator.compare(this.playerThree, this.playerTwo);
        assert(compareGreater > 0);
        int compareLess = comparator.compare(this.playerOne, this.playerThree);
        assert(compareLess < 0);
    }

    @Test(timeout = 100)
    public void testCompareAtBats() {
        BaseballPlayerComparator comparator = new BaseballPlayerComparator("At Bats",
                "2019-2020");
        int compareEquals = comparator.compare(this.playerOne, this.playerThree);
        assert(compareEquals == 0);
        int compareGreater = comparator.compare(this.playerOne, this.playerTwo);
        assert(compareGreater > 0);
        int compareLess = comparator.compare(this.playerTwo, this.playerThree);
        assert(compareLess < 0);
    }

    @Test(timeout = 100)
    public void testCompareRuns() {
        BaseballPlayerComparator comparator = new BaseballPlayerComparator("runs",
                "2019-2020");
        int compareEquals = comparator.compare(this.playerTwo, this.playerThree);
        assert(compareEquals == 0);
        int compareGreater = comparator.compare(this.playerTwo, this.playerOne);
        assert(compareGreater > 0);
        int compareLess = comparator.compare(this.playerOne, this.playerThree);
        assert(compareLess < 0);
    }

    @Test(timeout = 100)
    public void testCompareHits() {
        BaseballPlayerComparator comparator = new BaseballPlayerComparator("Hits",
                "2019-2020");
        int compareEquals = comparator.compare(this.playerOne, this.playerTwo);
        assert(compareEquals == 0);
        int compareGreater = comparator.compare(this.playerThree, this.playerTwo);
        assert(compareGreater > 0);
        int compareLess = comparator.compare(this.playerOne, this.playerThree);
        assert(compareLess < 0);
    }

    @Test(timeout = 100)
    public void testCompareHomeRuns() {
        BaseballPlayerComparator comparator = new BaseballPlayerComparator("home Runs",
                "2019-2020");
        int compareEquals = comparator.compare(this.playerOne, this.playerThree);
        assert(compareEquals == 0);
        int compareGreater = comparator.compare(this.playerTwo, this.playerOne);
        assert(compareGreater > 0);
        int compareLess = comparator.compare(this.playerThree, this.playerTwo);
        assert(compareLess < 0);
    }

    @Test(timeout = 100)
    public void testCompareRunsBattedIn() {
        BaseballPlayerComparator comparator = new BaseballPlayerComparator("Runs Batted In",
                "2019-2020");
        int compareEquals = comparator.compare(this.playerTwo, this.playerThree);
        assert(compareEquals == 0);
        int compareGreater = comparator.compare(this.playerTwo, this.playerOne);
        assert(compareGreater > 0);
        int compareLess = comparator.compare(this.playerOne, this.playerThree);
        assert(compareLess < 0);
    }

    @Test(timeout = 100)
    public void testCompareStrikeOuts() {
        BaseballPlayerComparator comparator = new BaseballPlayerComparator("strike outs",
                "2019-2020");
        int compareEquals = comparator.compare(this.playerOne, this.playerTwo);
        assert(compareEquals == 0);
        int compareGreater = comparator.compare(this.playerOne, this.playerThree);
        assert(compareGreater > 0);
        int compareLess = comparator.compare(this.playerThree, this.playerTwo);
        assert(compareLess < 0);
    }

    @Test(timeout = 100)
    public void testCompareAverage() {
        BaseballPlayerComparator comparator = new BaseballPlayerComparator("average",
                "2019-2020");
        double compareEquals = comparator.compare(this.playerOne, this.playerThree);
        assert(compareEquals == 0);
    }
}
