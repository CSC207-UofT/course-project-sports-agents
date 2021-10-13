import org.junit.*;

import static org.junit.Assert.*;

public class TennisPlayerTest {
    TennisPlayer player;

    @Before
    public void setUp() {
        player = new TennisPlayer("Serena Williams", 40, "American");
    }

    @After
    public void tearDown() {}

    @Test(timeout = 50)
    public void TestSetsWonAndLost() {
        player.setSetsWon(2);
        player.setSetsLost(1);
        assertEquals(2, player.getSetsWon());
        assertEquals(1, player.getSetsLost());
    }

    @Test(timeout = 50)
    public void TestGamesWonAndLost() {
        player.setGamesWon(6);
        player.setGamesLost(3);
        assertEquals(6, player.getGamesWon());
        assertEquals(3, player.getGamesLost());
    }

}
