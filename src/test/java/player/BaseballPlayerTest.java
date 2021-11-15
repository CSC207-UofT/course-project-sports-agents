package player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseballPlayerTest {
    BaseballPlayer player;

    @Before
    public void setUp() throws Exception {
        this.player = new BaseballPlayer("Player 1","2020-2021","T1",
                "L",52,41,25,66,
                222,18, 40, 21.6);
        this.player.addRecord("2019-2020","T2","L",40,
                56,33,72,105,200,16,
                24.5);
    }

    @Test(timeout = 100)
    public void testGetName() {
        String name = this.player.getName();
        assertEquals("Player 1", name);
    }

    @Test(timeout = 100)
    public void testGetStatTeamPasses() throws Exception {
        String team20202021 = this.player.getStatTeam("2020-2021");
        assertEquals("T1", team20202021);
        String team20192020 = this.player.getStatTeam("2019-2020");
        assertEquals("T2", team20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatTeamFails() throws Exception {
        String fail = this.player.getStatTeam("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatPositionPasses() throws Exception {
        String position20202021 = this.player.getStatPosition("2020-2021");
        assertEquals("L", position20202021);
        String position20192020 = this.player.getStatPosition("2019-2020");
        assertEquals("L", position20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatPositionFails() throws Exception {
        String fail = this.player.getStatPosition("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatGamesPlayedPasses() throws Exception {
        int gamesPlayed20202021 = this.player.getStatGamesPlayed("2020-2021");
        assertEquals(52, gamesPlayed20202021);
        int gamesPlayed20192020 = this.player.getStatGamesPlayed("2019-2020");
        assertEquals(40, gamesPlayed20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatGamesPlayedFails() throws Exception {
        int fail = this.player.getStatGamesPlayed("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatAtBatsPasses() throws Exception {
        int atBats20202021 = this.player.getStatAtBats("2020-2021");
        assertEquals(41, atBats20202021);
        int atBats20192020 = this.player.getStatAtBats("2019-2020");
        assertEquals(56, atBats20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatAtBatsFails() throws Exception {
        int fail = this.player.getStatAtBats("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatRunsPasses() throws Exception {
        int runs20202021 = this.player.getStatRuns("2020-2021");
        assertEquals(25, runs20202021);
        int runs20192020 = this.player.getStatRuns("2019-2020");
        assertEquals(33, runs20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatRunsFails() throws Exception {
        int fail = this.player.getStatRuns("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatHitsPasses() throws Exception {
        int hits20202021 = this.player.getStatHits("2020-2021");
        assertEquals(66, hits20202021);
        int hits20192020 = this.player.getStatAtBats("2019-2020");
        assertEquals(72, hits20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatHitsFails() throws Exception {
        int fail = this.player.getStatHits("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatHomeRunsPasses() throws Exception {
        int homeRuns20202021 = this.player.getStatHomeRuns("2020-2021");
        assertEquals(222, homeRuns20202021);
        int homeRuns20192020 = this.player.getStatAtBats("2019-2020");
        assertEquals(105, homeRuns20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatHomeRunsFails() throws Exception {
        int fail = this.player.getStatHomeRuns("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatRunsBattedInPasses() throws Exception {
        int runsBattedIn20202021 = this.player.getStatRunsBattedIn("2020-2021");
        assertEquals(18, runsBattedIn20202021);
        int runsBattedIn20192020 = this.player.getStatRunsBattedIn("2019-2020");
        assertEquals(200, runsBattedIn20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatRunsBattedInFails() throws Exception {
        int fail = this.player.getStatRunsBattedIn("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatStrikeOutsPasses() throws Exception {
        int strikeOuts20202021 = this.player.getStatStrikeOuts("2020-2021");
        assertEquals(40, strikeOuts20202021);
        int strikeOuts20192020 = this.player.getStatStrikeOuts("2019-2020");
        assertEquals(16, strikeOuts20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatStrikeOutsFails() throws Exception {
        int fail = this.player.getStatStrikeOuts("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatAvgPasses() throws Exception {
        double avg20202021 = this.player.getStatAvg("2020-2021");
        assertEquals(21.6, avg20202021, 0.01);
        double avg20192020 = this.player.getStatAvg("2019-2020");
        assertEquals(24.5, avg20192020, 0.01);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatAvgFails() throws Exception {
        double fail = this.player.getStatAvg("2018-2019");
    }

    @Test
    public void testToString() {
        String playerString = this.player.toString();
        assertEquals("Baseball Player ", playerString);
    }
}