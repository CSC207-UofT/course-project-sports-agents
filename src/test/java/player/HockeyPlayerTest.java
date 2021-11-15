package player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HockeyPlayerTest {
    HockeyPlayer player;

    @Before
    public void setUp() throws Exception {
        this.player = new HockeyPlayer("Auston Matthews","2020-2021","TOR",
                "L", "C",52,41,25,66,
                222,18.5);
        this.player.addRecord("2019-2020","EDM","L","C",
                56,33,72,105,200,16.5);
    }

    @Test(timeout = 100)
    public void testGetName() {
        String name = this.player.getName();
        assertEquals("Auston Matthews", name);
    }

    @Test(timeout = 100)
    public void testGetStatTeamPasses() throws Exception {
        String team20202021 = this.player.getStatTeam("2020-2021");
        assertEquals("TOR", team20202021);
        String team20192020 = this.player.getStatTeam("2019-2020");
        assertEquals("EDM", team20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatTeamFails() throws Exception {
        String fail = this.player.getStatTeam("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatSkaterShootsPasses() throws Exception {
        String skaterShoots20202021 = this.player.getStatSkaterShoots("2020-2021");
        assertEquals("L", skaterShoots20202021);
        String skaterShoots20192020 = this.player.getStatSkaterShoots("2019-2020");
        assertEquals("L", skaterShoots20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatSkaterShootsFails() throws Exception {
        String fail = this.player.getStatSkaterShoots("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatPositionPasses() throws Exception {
        String position20202021 = this.player.getStatPosition("2020-2021");
        assertEquals("C", position20202021);
        String position20192020 = this.player.getStatPosition("2019-2020");
        assertEquals("C", position20192020);
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
        assertEquals(56, gamesPlayed20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatGamesPlayedFails() throws Exception {
        int fail = this.player.getStatGamesPlayed("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatGoalsPasses() throws Exception {
        int goals20202021 = this.player.getStatGoals("2020-2021");
        assertEquals(41, goals20202021);
        int goals20192020 = this.player.getStatGoals("2019-2020");
        assertEquals(33, goals20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatGoalsFails() throws Exception {
        int fail = this.player.getStatGoals("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatAssists() throws Exception {
        int assists20202021 = this.player.getStatAssists("2020-2021");
        assertEquals(25, assists20202021);
        int assists20192020 = this.player.getStatAssists("2019-2020");
        assertEquals(72, assists20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatAssistsFails() throws Exception {
        int fail = this.player.getStatAssists("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatPointsPasses() throws Exception {
        int points20202021 = this.player.getStatPoints("2020-2021");
        assertEquals(66, points20202021);
        int points20192020 = this.player.getStatPoints("2019-2020");
        assertEquals(105, points20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatPointsFails() throws Exception {
        int fail = this.player.getStatPoints("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatShotsPasses() throws Exception {
        int shots20202021 = this.player.getStatShots("2020-2021");
        assertEquals(222, shots20202021);
        int shots20192020 = this.player.getStatShots("2019-2020");
        assertEquals(200, shots20192020);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatShotsFails() throws Exception {
        int fail = this.player.getStatShots("2018-2019");
    }

    @Test(timeout = 100)
    public void testGetStatShootingPercentage() throws Exception {
        double shootingPercentage20202021 =
                this.player.getStatShootingPercentage("2020-2021");
        assertEquals(18.5, shootingPercentage20202021, 0.01);
        double shootingPercentage20192020 =
                this.player.getStatShootingPercentage("2019-2020");
        assertEquals(16.5, shootingPercentage20192020, 0.01);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testGetStatShootingPercentageFails() throws Exception {
        double fail = this.player.getStatShootingPercentage("2018-2019");
    }

    @Test
    public void testToString() {
        String playerString = this.player.toString();
        assertEquals("Hockey Player Auston Matthews", playerString);
    }
}