package player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TennisPlayerTest {
    TennisPlayer player;

    @Before
    public void setUp() throws Exception {
        this.player = new TennisPlayer("Daniil Medvedev", "RUS",
                "Brisbane", 23, 8, 6, 100,
                54, 10);
        this.player.addRecord("Australian Open", 23, 7,
                4, 72, 43, 4);
    }

    @Test(timeout = 100)
    public void testGetName() {
        String name = this.player.getName();
        assertEquals("Daniil Medvedev", name);
    }

    @Test(timeout = 100)
    public void testGetCountry() {
        String country = this.player.getCountry();
        assertEquals("RUS", country);
    }

    @Test(timeout = 100)
    public void testGetStatAgePasses() throws Exception {
        int ageBrisbane = this.player.getStatAge("Brisbane");
        assertEquals(23, ageBrisbane);
        int ageAustralia = this.player.getStatAge("Australian Open");
        assertEquals(23, ageAustralia);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatAgeFails() throws Exception {
        int fail = this.player.getStatAge("Auckland");
    }

    @Test(timeout = 100)
    public void testGetStatAcesPasses() throws Exception {
        int acesBrisbane = this.player.getStatAces("Brisbane");
        assertEquals(8, acesBrisbane);
        int acesAustralia = this.player.getStatAces("Australian Open");
        assertEquals(7, acesAustralia);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatAcesFails() throws Exception {
        int fail = this.player.getStatAces("Auckland");
    }

    @Test(timeout = 100)
    public void testGetStatDoubleFaultsPasses() throws Exception{
        int doubleFaultsBrisbane =
                this.player.getStatDoubleFaults("Brisbane");
        assertEquals(6, doubleFaultsBrisbane);
        int doubleFaultsAustralia =
                this.player.getStatDoubleFaults("Australian Open");
        assertEquals(4, doubleFaultsAustralia);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatDoubleFaultsFails() throws Exception {
        int fail = this.player.getStatDoubleFaults("Auckland");
    }

    @Test(timeout = 100)
    public void testGetStatServePointsPasses() throws Exception {
        int servePointsBrisbane =
                this.player.getStatServePoints("Brisbane");
        assertEquals(100, servePointsBrisbane);
        int servePointsAustralia =
                this.player.getStatServePoints("Australian Open");
        assertEquals(72, servePointsAustralia);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatServePointsFails() throws Exception {
        int fail = this.player.getStatServePoints("Auckland");
    }

    @Test(timeout = 100)
    public void testGetStatFirstServesPasses() throws Exception {
        int firstServesBrisbane =
                this.player.getStatFirstServes("Brisbane");
        assertEquals(54, firstServesBrisbane);
        int firstServesAustralia =
                this.player.getStatFirstServes("Australian Open");
        assertEquals(43, firstServesAustralia);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatFirstServesFails() throws Exception {
        int fail = this.player.getStatFirstServes("Auckland");
    }

    @Test(timeout = 100)
    public void testGetStatBreakPointsSavedPasses() throws Exception {
        int breakPointsSavedBrisbane =
                this.player.getStatBreakPointsSaved("Brisbane");
        assertEquals(10, breakPointsSavedBrisbane);
        int breakPointsSavedAustralia =
                this.player.getStatBreakPointsSaved("Australian Open");
        assertEquals(4, breakPointsSavedAustralia);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatBreakPointsSavedFails() throws Exception {
        int fail = this.player.getStatBreakPointsSaved("Auckland");
    }

    @Test
    public void testToString() {
        String playerString = this.player.toString();
        assertEquals("Tennis Player Daniil Medvedev", playerString);
    }
}