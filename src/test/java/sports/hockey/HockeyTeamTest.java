package sports.hockey;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HockeyTeamTest {
    private HockeyTeam team;


    @Before
    public void setUp() {
        team = new HockeyTeam("team");
    }

    @Test
    public void testAddRecord() {
        team.addRecord("2018-2019", 0, 1, 2, 3, 4,
                5, 6, 7.0, 8.0, 9.0);
        assertTrue(team.gamesPlayed.containsKey("2018-2019"));
        assertTrue(team.points.containsKey("2018-2019"));
        assertTrue(team.gamesWon.containsKey("2018-2019"));
        assertTrue(team.gamesLost.containsKey("2018-2019"));
        assertTrue(team.overtimeLosses.containsKey("2018-2019"));
        assertTrue(team.goalsFor.containsKey("2018-2019"));
        assertTrue(team.goalsAgainst.containsKey("2018-2019"));
        assertTrue(team.shotsForPerGame.containsKey("2018-2019"));
        assertTrue(team.shotsAgainstPerGame.containsKey("2018-2019"));
        assertTrue(team.faceOffWinPercentage.containsKey("2018-2019"));
    }

    @Test
    public void testAddFaceoffWinPercentage() {
        team.addFaceOffWinPercentage("2018-2019", 9.0);
        assertTrue(team.faceOffWinPercentage.containsKey("2018-2019"));
        double faceOffWinPercentage = team.faceOffWinPercentage.get("2018-2019");
        assertEquals(9, (int) faceOffWinPercentage);
    }


    @Test
    public void testAddGoalsAgainstPerGame() {
        team.addShotsAgainstPerGame("2018-2019", 8.0);
        assertTrue(team.shotsAgainstPerGame.containsKey("2018-2019"));
        double goalsAgainstPerGame = team.shotsAgainstPerGame.get("2018-2019");
        assertEquals(8, (int) goalsAgainstPerGame);
    }


    @Test
    public void testAddGoalsForPerGame() {
        team.addShotsForPerGame("2018-2019", 7.0);
        assertTrue(team.shotsForPerGame.containsKey("2018-2019"));
        double goalsForPerGame = team.shotsForPerGame.get("2018-2019");
        assertEquals(7, (int) goalsForPerGame);
    }


    @Test
    public void testAddGoalsAgainst() {
        team.addGoalsAgainst("2018-2019", 6);
        assertTrue(team.goalsAgainst.containsKey("2018-2019"));
        int goalsAgainst = team.goalsAgainst.get("2018-2019");
        assertEquals(6, goalsAgainst);
    }

    @Test
    public void testAddGoalsFor() {
        team.addGoalsFor("2018-2019", 5);
        assertTrue(team.goalsFor.containsKey("2018-2019"));
        int goalsFor = team.goalsFor.get("2018-2019");
        assertEquals(5, goalsFor);
    }


    @Test
    public void testAddOvertimeLosses() {
        team.addOvertimeLosses("2018-2019", 4);
        assertTrue(team.overtimeLosses.containsKey("2018-2019"));
        int ol = team.overtimeLosses.get("2018-2019");
        assertEquals(4, ol);
    }


    @Test
    public void testAddPoints() {
        team.addPoints("2018-2019", 3);
        assertTrue(team.points.containsKey("2018-2019"));
        int points = team.points.get("2018-2019");
        assertEquals(3, points);
    }


    @Test
    public void testAddGamesPlayed() {
        team.addGamesPlayed("2018-2019", 0);
        assertTrue(team.gamesPlayed.containsKey("2018-2019"));
        int gamesPlayed = team.gamesPlayed.get("2018-2019");
        assertEquals(0, gamesPlayed);
    }

    @Test
    public void testAddGamesWon() {
        team.addGamesWon("2018-2019", 1);
        assertTrue(team.gamesWon.containsKey("2018-2019"));
        int gamesWon = team.gamesWon.get("2018-2019");
        assertEquals(1, gamesWon);
    }

    @Test
    public void testAddGamesLost() {
        team.addGamesLost("2018-2019", 2);
        assertTrue(team.gamesLost.containsKey("2018-2019"));
        int gamesLost = team.gamesLost.get("2018-2019");
        assertEquals(2, gamesLost);
    }



}
