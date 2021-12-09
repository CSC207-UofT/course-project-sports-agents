package sports.hockey;

import driversAdapters.CSVDataContainer;
import driversAdapters.DataContainer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class HockeyTeamStatManagerTest {
    private HockeyTeamStatManager hockeyTeamStatManager;
    private DataContainer container;

    @Before
    public void setUp() throws Exception {
        HockeyTeam team1 = new HockeyTeam("Red Team");
        team1.addRecord("2020-2021", 10, 40, 7, 3,
                1, 17, 3, 2.07, 2.09,
                26.3);
        CSVDataContainer container = new CSVDataContainer();
        container.teamMap.put(team1.getName().toLowerCase(), team1);
        this.container = container;

        hockeyTeamStatManager = new HockeyTeamStatManager();
    }

    @Test
    public void testExecuteGamesPlayed() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("hockey", "red team",
                "2020-2021", "games played"));
        String output = hockeyTeamStatManager.execute(command, container);
        String outputSub = output.substring(140, 142);
        String expected = "10";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteGamesWon() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("hockey", "red team",
                "2020-2021", "games won"));
        String output = hockeyTeamStatManager.execute(command, container);
        String outputSub = output.substring(141, 142);
        String expected = "7";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteGamesLost() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("hockey", "red team",
                "2020-2021", "games lost"));
        String output = hockeyTeamStatManager.execute(command, container);
        String outputSub = output.substring(141, 142);
        String expected = "3";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteOvertimeLosses() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("hockey", "red team",
                "2020-2021", "overtime losses"));
        String output = hockeyTeamStatManager.execute(command, container);
        String outputSub = output.substring(141, 142);
        String expected = "1";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecutePoints() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("hockey", "red team",
                "2020-2021", "points"));
        String output = hockeyTeamStatManager.execute(command, container);
        String outputSub = output.substring(140, 142);
        String expected = "40";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteGoalsFor() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("hockey", "red team",
                "2020-2021", "goals for"));
        String output = hockeyTeamStatManager.execute(command, container);
        String outputSub = output.substring(140, 142);
        String expected = "17";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteGoalsAgainst() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("hockey", "red team",
                "2020-2021", "goals against"));
        String output = hockeyTeamStatManager.execute(command, container);
        String outputSub = output.substring(141, 142);
        String expected = "3";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteShotsForPerGame() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("hockey", "red team",
                "2020-2021", "shots for per game"));
        String output = hockeyTeamStatManager.execute(command, container);
        String outputSub = output.substring(138, 142);
        String expected = "2.07";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteShotsAgainstPerGame() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("hockey", "red team",
                "2020-2021", "shots against per game"));
        String output = hockeyTeamStatManager.execute(command, container);
        String outputSub = output.substring(140, 144);
        String expected = "2.09";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteFaceoffWinPercentage() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("hockey", "red team",
                "2020-2021", "faceoff win percentage"));
        String output = hockeyTeamStatManager.execute(command, container);
        String outputSub = output.substring(140, 144);
        String expected = "26.3";
        assertEquals(expected, outputSub);
    }
}