package sports.baseball;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseballPlayerTest {
    BaseballPlayer player;

    @Before
    public void setUp() throws Exception {
        this.player = new BaseballPlayer("Trevor Story", "2019-2020", "COL", "SS",
                59, 235, 43, 65, 34, 12, 97, 0.289);
        this.player.addRecord("2020-2021", "BOS", "2B", 35, 87, 90,
                14, 54, 39, 18, 0.894);
    }

    @Test(timeout = 100)
    public void testGetName() {
        String name = this.player.getName();
        assertEquals("Trevor Story", name);
    }

    @Test(timeout = 100)
    public void testGetStatTeamPasses() throws Exception {
        String team20192020 = this.player.getStatTeam("2019-2020");
        assertEquals("COL", team20192020);
        String team20202021 = this.player.getStatTeam("2020-2021");
        assertEquals("BOS", team20202021);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatTeamFails() throws Exception {
        String fail = this.player.getStatTeam("1990-1991");
    }

    @Test(timeout = 100)
    public void testGetStatPositionPasses() throws Exception {
        String position20192020 = this.player.getStatPosition("2019-2020");
        assertEquals("SS", position20192020);
        String position20202021 = this.player.getStatPosition("2020-2021");
        assertEquals("2B", position20202021);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatPositionFails() throws Exception {
        String fail = this.player.getStatPosition("1991-1992");
    }

    @Test(timeout = 100)
    public void testGetStatGamesPlayedPasses() throws Exception {
        int gamesPlayed20192020 = this.player.getStatGamesPlayed("2019-2020");
        assertEquals(59, gamesPlayed20192020);
        int gamesPlayed20202021 = this.player.getStatGamesPlayed("2020-2021");
        assertEquals(35, gamesPlayed20202021);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatGamesPlayedFails() throws Exception {
        int fail = this.player.getStatGamesPlayed("1992-1993");
    }

    @Test(timeout = 100)
    public void testGetStatAtBatsPasses() throws Exception {
        int atBats20192020 = this.player.getStatAtBats("2019-2020");
        assertEquals(235, atBats20192020);
        int atBats20202021 = this.player.getStatAtBats("2020-2021");
        assertEquals(87, atBats20202021);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatAtBatsFails() throws Exception {
        int fail = this.player.getStatAtBats("1993-1994");
    }

    @Test(timeout = 100)
    public void testGetStatRunsPasses() throws Exception {
        int runs20192020 = this.player.getStatRuns("2019-2020");
        assertEquals(43, runs20192020);
        int runs20202021 = this.player.getStatRuns("2020-2021");
        assertEquals(90, runs20202021);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatRunsFails() throws Exception {
        int fail = this.player.getStatRuns("1994-1995");
    }

    @Test(timeout = 100)
    public void testGetStatHitsPasses() throws Exception {
        int hits20192020 = this.player.getStatHits("2019-2020");
        assertEquals(65, hits20192020);
        int hits20202021 = this.player.getStatHits("2020-2021");
        assertEquals(14, hits20202021);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatHitsFails() throws Exception {
        int fail = this.player.getStatHits("1995-1996");
    }

    @Test(timeout = 100)
    public void testGetStatHomeRunsPasses() throws Exception {
        int homeRuns20192020 = this.player.getStatHomeRuns("2019-2020");
        assertEquals(34, homeRuns20192020);
        int homeRuns20202021 = this.player.getStatHomeRuns("2020-2021");
        assertEquals(54, homeRuns20202021);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatHomeRunsFails() throws Exception {
        int fail = this.player.getStatHomeRuns("1996-1997");
    }

    @Test(timeout = 100)
    public void testGetStatRunsBattedInPasses() throws Exception {
        int runsBattedIn20192020 = this.player.getStatRunsBattedIn("2019-2020");
        assertEquals(12, runsBattedIn20192020);
        int runsBattedIn20202021 = this.player.getStatRunsBattedIn("2020-2021");
        assertEquals(39, runsBattedIn20202021);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatRunsBattedInFails() throws Exception {
        int fail = this.player.getStatRunsBattedIn("1997-1998");
    }

    @Test(timeout = 100)
    public void testGetStatStrikeOutsPasses() throws Exception {
        int strikeOuts20192020 = this.player.getStatStrikeOuts("2019-2020");
        assertEquals(97, strikeOuts20192020);
        int strikeOuts20202021 = this.player.getStatStrikeOuts("2020-2021");
        assertEquals(18, strikeOuts20202021);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatStrikeOutsFails() throws Exception {
        int fail = this.player.getStatStrikeOuts("1998-1999");
    }

    @Test(timeout = 100)
    public void testGetStatAvgPasses() throws Exception {
        double avg20192020 = this.player.getStatAvg("2019-2020");
        assertEquals(0.289, avg20192020, 0);
        double avg20202021 = this.player.getStatAvg("2020-2021");
        assertEquals(0.894, avg20202021, 0);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatAvgFails() throws Exception {
        double fail = this.player.getStatAvg("1999-2000");
    }

    @Test(timeout = 200)
    public void testGetSeasonData() throws Exception {
        assertEquals("Team: BOS\n" +
                "Position: 2B\n" +
                "Games Played: 35\n" +
                "At Bats: 87\n" +
                "Runs: 90\n" +
                "Hits: 14\n" +
                "Home Runs: 54\n" +
                "Runs Batted In: 39\n" +
                "Strike Outs: 18\n" +
                "Average Hits per at Bat: 0.894", this.player.getSeasonData("2020-2021"));
    }

    @Test(timeout = 100)
    public void testToString() {
        String playerString = this.player.toString();
        assertEquals("Baseball Player Trevor Story", playerString);
    }

}