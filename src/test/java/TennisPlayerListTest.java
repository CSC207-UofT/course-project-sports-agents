import Player.TennisPlayerList;
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

    @Test(timeout = 100)
    public void TestTrueContainsPlayer() {
        assertTrue(tennisPlayerList.containsPlayer("Brisbane", "John Millman"));

    }

    @Test(timeout = 50)
    public void TestFalseContainsPlayer() {
        assertFalse(tennisPlayerList.containsPlayer("Doha", "Serena Williams"));
    }

    @Test(timeout = 100)
    public void testFindTennisPlayer() throws Exception {
        assertEquals("Name: Novak Djokovic\n" +
                        "Age: 32\n" +
                        "Nationality: SRB\n" +
                        "Aces: 45\n" +
                        "Double Faults: 13\n" +
                        "Serve Points: 519\n" +
                        "First Serves: 356\n" +
                        "Break Points Saved: 14",
                tennisPlayerList.findTennisPlayer("Australian Open",
                "Novak Djokovic").toString());
    }

}