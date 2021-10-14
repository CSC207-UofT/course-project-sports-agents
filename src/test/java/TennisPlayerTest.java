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

    @Test(timeout = 50)
    public void TestUpdateSetsWonAndLost() {
        player.setSetsWon(6);
        player.setSetsLost(3);
        player.updateSetsWon(2);
        player.updateSetsLost(4);
        assertEquals(8, player.getSetsWon());
        assertEquals(7, player.getSetsLost());
    }

    @Test(timeout = 50)
    public void TestUpdateGamesWonAndLost() {
        player.setGamesWon(10);
        player.setGamesLost(2);
        player.updateGamesWon(4);
        player.updateGamesLost(3);
        assertEquals(14, player.getGamesWon());
        assertEquals(5, player.getGamesLost());
    }

}
