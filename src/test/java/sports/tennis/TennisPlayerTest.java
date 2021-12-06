package sports.tennis;

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
    public void testGetStatRankPasses() throws Exception {
        int rank2018 = this.player.getStatRank("2018");
        assertEquals(1, rank2018);
        int rank2019 = this.player.getStatRank("2019");
        assertEquals(3, rank2019);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatRankFails() throws Exception {
        int fail = this.player.getStatRank("2020");
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
        int doubleFaults2018 = this.player.getStatDoubleFaults("2018");
        assertEquals(11, doubleFaults2018);
        int doubleFaults2019 = this.player.getStatDoubleFaults("2019");
        assertEquals(15, doubleFaults2019);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatDoubleFaultsFails() throws Exception {
        int fail = this.player.getStatDoubleFaults("2020");
    }

    @Test(timeout = 100)
    public void testGetStatServePointsWonPasses() throws Exception {
        double servePoints2018 = this.player.getStatServePointsWon("2018");
        assertEquals(64.0, servePoints2018, 0);
        double servePoints2019 = this.player.getStatServePointsWon("2019");
        assertEquals(59.0, servePoints2019, 0);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatServePointsWonFails() throws Exception {
        double fail = this.player.getStatServePointsWon("2020");
    }

    @Test(timeout = 100)
    public void testGetStatBreakPointsSavedPasses() throws Exception {
        double breakPointsSaved2018 = this.player.getStatBreakPointsSaved("2018");
        assertEquals(69.0, breakPointsSaved2018, 0);
        double breakPointsSaved2019 = this.player.getStatBreakPointsSaved("2019");
        assertEquals(78.0, breakPointsSaved2019, 0);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatBreakPointsSavedFails() throws Exception {
        double fail = this.player.getStatBreakPointsSaved("2020");
    }

    @Test(timeout = 100)
    public void testGetStatServeGamesWonPasses() throws Exception {
        double serveGamesWon2018 = this.player.getStatServeGamesWon("2018");
        assertEquals(85.0, serveGamesWon2018, 0);
        double serveGamesWon2019 = this.player.getStatServeGamesWon("2019");
        assertEquals(65.0, serveGamesWon2019, 0);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatServeGamesWonFails() throws Exception {
        double fail = this.player.getStatServeGamesWon("2020");
    }

    @Test(timeout = 100)
    public void testGetStatReturnGamesWonPasses() throws Exception {
        double returnGamesWon2018 = this.player.getStatReturnGamesWon("2018");
        assertEquals(35.0, returnGamesWon2018, 0);
        double returnGamesWon2019 = this.player.getStatReturnGamesWon("2019");
        assertEquals(37.0, returnGamesWon2019, 0);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatReturnGamesWonFails() throws Exception {
        double fail = this.player.getStatReturnGamesWon("2020");
    }

    @Test(timeout = 100)
    public void testGetStatBreakPointsConvertedPasses() throws Exception {
        double breakPointsConverted2018 = this.player.getStatBreakPointsConverted("2018");
        assertEquals(35.0, breakPointsConverted2018, 0);
        double breakPointsConverted2019 = this.player.getStatBreakPointsConverted("2019");
        assertEquals(68.0, breakPointsConverted2019, 0);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatBreakPointsConvertedFails() throws Exception {
        double fail = this.player.getStatBreakPointsConverted("2020");
    }

    @Test(timeout = 100)
    public void testGetStatReturnPointsWonPasses() throws Exception {
        double returnPointsWon2018 = this.player.getStatReturnPointsWon("2018");
        assertEquals(43.0, returnPointsWon2018, 0);
        double returnPointsWon2019 = this.player.getStatReturnPointsWon("2019");
        assertEquals(29.0, returnPointsWon2019, 0);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatReturnPointsWonFails() throws Exception {
        double fail = this.player.getStatReturnPointsWon("2020");
    }

    @Test(timeout = 200)
    public void testGetSeasonData() throws Exception {
        assertEquals("Nationality: AUS\n" +
                        "Rank: 3\n" +
                        "Matches: 5\n" +
                        "Aces: 23\n" +
                        "Double Faults: 15\n" +
                        "Percentage of Serve Points Won: 59.0\n" +
                        "Percentage of Break Points Saved: 78.0\n" +
                        "Percentage of Serve Games Won: 65.0\n" +
                        "Percentage of Return Games Won: 37.0\n" +
                        "Percentage of Break Points Converted: 68.0\n" +
                        "Percentage of Return Points Won: 29.0",
                this.player.getSeasonData("2019"));
    }


    @Test
    public void testToString() {
        String playerString = this.player.toString();
        assertEquals("Tennis Player Ashleigh Barty", playerString);
    }
}