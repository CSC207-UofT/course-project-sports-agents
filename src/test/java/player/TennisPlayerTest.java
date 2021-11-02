package player;

import player.TennisPlayer;
import org.junit.*;

import static org.junit.Assert.*;

public class TennisPlayerTest {
    TennisPlayer player;

    @Before
    public void setUp() {
        player = new TennisPlayer("Serena Williams", "American");
    }

    @After
    public void tearDown() {}

    /*@Test(timeout = 50)
    public void TestAcesSetterAndGetter() {
        player.setAces(2);
        player.updateAces(4);
        assertEquals(6, player.getAces());
    }

    @Test(timeout = 50)
    public void TestDoubleFaultsSetterAndGetter() {
        player.setDoubleFaults(3);
        player.updateDoubleFaults(10);
        assertEquals(13, player.getDoubleFaults());
    }

    @Test(timeout = 50)
    public void TestServePointsSetterAndGetter() {
        player.setServePoints(8);
        player.updateServePoints(10);
        assertEquals(18, player.getServePoints());
    }

    @Test(timeout = 50)
    public void TestFirstServesSetterAndGetter() {
        player.setFirstServes(4);
        player.updateFirstServes(10);
        assertEquals(14, player.getFirstServes());
    }

    @Test(timeout = 50)
    public void TestBreakPointsSetterAndGetter() {
        player.setBreakPointsSaved(2);
        player.updateBreakPointsSaved(3);
        assertEquals(5, player.getBreakPointsSaved());
    }*/
}
