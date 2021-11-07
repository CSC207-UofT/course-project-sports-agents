package player;

import org.junit.*;
import static org.junit.Assert.*;

public class TennisPlayerListTest {
    TennisPlayerList tennisPlayerList;

    @Before
    public void setUp() {
        tennisPlayerList = new TennisPlayerList();
    }

    @After
    public void tearDown() {}

    @Test(timeout = 1000)
    public void TestTrueContainsPlayer() {
        assertTrue(tennisPlayerList.containsPlayer("Australian Open", "Novak Djokovic"));

    }

    @Test(timeout = 50)
    public void TestFalseContainsPlayer() {
        assertFalse(tennisPlayerList.containsPlayer("Doha", "Serena Williams"));
    }

    @Test(timeout = 1000)
    public void testFindTennisPlayer() throws Exception {
        TennisPlayer player = tennisPlayerList.findTennisPlayer("Brisbane",
                "Kei Nishikori");
        assertEquals("Name: Kei Nishikori\n" +
                        "Age: 29\n" +
                        "Nationality: JPN\n" +
                        "Aces: 17\n" +
                        "Double Faults: 9\n" +
                        "Serve Points: 239\n" +
                        "First Serves: 156\n" +
                        "Break Points Saved: 5",
                tennisPlayerList.findTennisPlayer("Brisbane",
                "Kei Nishikori").printCompetitionData("Brisbane"));
    }

}