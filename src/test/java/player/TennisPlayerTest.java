package player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TennisPlayerTest {
    TennisPlayer player;

    @Before
    public void setUp() throws Exception {
        this.player = new TennisPlayer("Ashleigh Barty", "AUS", "2018",
                1, 3, 20, 11, 64.0, 69.0,
                85.0, 35.0, 35.0, 43.0);
        this.player.addRecord("2019",
                3, 5, 23, 15, 59.0, 78.0,
                65.0, 37.0, 68.0, 29.0);
    }

    @Test(timeout = 100)
    public void testGetName() {
        String name = this.player.getName();
        assertEquals("Ashleigh Barty", name);
    }

    @Test(timeout = 100)
    public void testGetCountry() {
        String country = this.player.getCountry();
        assertEquals("AUS", country);
    }

    @Test(timeout = 100)
    public void testGetStatAcesPasses() throws Exception {
        int aces2018 = this.player.getStatAces("2018");
        assertEquals(20, aces2018);
        int aces2019 = this.player.getStatAces("2019");
        assertEquals(23, aces2019);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatAcesFails() throws Exception {
        int fail = this.player.getStatAces("2020");
    }

    @Test(timeout = 100)
    public void testGetStatDoubleFaultsPasses() throws Exception{
        int doubleFaults2018 =
                this.player.getStatDoubleFaults("2018");
        assertEquals(11, doubleFaults2018);
        int doubleFaults2019 =
                this.player.getStatDoubleFaults("2019");
        assertEquals(15, doubleFaults2019);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatDoubleFaultsFails() throws Exception {
        int fail = this.player.getStatDoubleFaults("2020");
    }


    @Test
    public void testToString() {
        String playerString = this.player.toString();
        assertEquals("Tennis Player Ashleigh Barty", playerString);
    }
}