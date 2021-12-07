package sports.hockey;

import driversAdapters.CSVDataContainer;
import driversAdapters.DataContainer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class HockeyPlayerStatComparerTest {
    HockeyPlayerStatComparer hockeyPlayerStatComparer;
    DataContainer container;

    @Before
    public void setUp() throws Exception {
        HockeyPlayer player1 = new HockeyPlayer("Player 1",
                "20202021", "TOR","L", "C",
                50,40,60,50,40,
                50.0);
        HockeyPlayer player2 = new HockeyPlayer("Player 2",
                "20202021", "COL", "L", "R",
                50,50,50,40,60,
                60.0);
        HockeyPlayer player3 = new HockeyPlayer("Player 3",
                "20202021", "STL", "L", "C",
                50,60,40,60,50,
                40.0);

        this.hockeyPlayerStatComparer = new HockeyPlayerStatComparer();

        CSVDataContainer container = new CSVDataContainer();
        container.playerMap.put("player 1", player1);
        container.playerMap.put("player 2", player2);
        container.playerMap.put("player 3", player3);
        this.container = container;

    }

    @Test(timeout = 100)
    public void testExecuteGamesPlayedPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "player 1", "player 2",
                "player 3", "20202021", "games played"));
        String output = this.hockeyPlayerStatComparer.execute(arguments, container);
        String outputPlayer3 = output.substring(176, 184);
        String expectedPlayer3 = "Player 3";
        String outputPlayer2 = output.substring(226, 234);
        String expectedPlayer2 = "Player 2";
        String outputPlayer1 = output.substring(276, 284);
        String expectedPlayer1 = "Player 1";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGamesPlayedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "paul gries", "player 2",
                "player 3", "20202021", "games played"));
        String fail = this.hockeyPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGamesPlayedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "player 1", "player 2",
                "player 3", "20192020", "games played"));
        String fail = this.hockeyPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteGoalsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "player 1", "player 2",
                "player 3", "20202021", "goals"));
        String output = this.hockeyPlayerStatComparer.execute(arguments, container);
        String outputPlayer3 = output.substring(176, 184);
        String expectedPlayer3 = "Player 3";
        String outputPlayer2 = output.substring(226, 234);
        String expectedPlayer2 = "Player 2";
        String outputPlayer1 = output.substring(276, 284);
        String expectedPlayer1 = "Player 1";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGoalsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "paul gries", "player 2",
                "player 3", "20202021", "goals"));
        String fail = this.hockeyPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGoalsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "player 1", "player 2",
                "player 3", "20192020", "goals"));
        String fail = this.hockeyPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteAssistsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "player 1", "player 2",
                "player 3", "20202021", "assists"));
        String output = this.hockeyPlayerStatComparer.execute(arguments, container);
        String outputPlayer1 = output.substring(176, 184);
        String expectedPlayer1 = "Player 1";
        String outputPlayer2 = output.substring(226, 234);
        String expectedPlayer2 = "Player 2";
        String outputPlayer3 = output.substring(276, 284);
        String expectedPlayer3 = "Player 3";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAssistsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "paul gries", "player 2",
                "player 3", "20202021", "assists"));
        String fail = this.hockeyPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAssistsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "player 1", "player 2",
                "player 3", "20192020", "assists"));
        String fail = this.hockeyPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecutePointsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "player 1", "player 2",
                "player 3", "20202021", "points"));
        String output = this.hockeyPlayerStatComparer.execute(arguments, container);
        String outputPlayer3 = output.substring(176, 184);
        String expectedPlayer3 = "Player 3";
        String outputPlayer1 = output.substring(226, 234);
        String expectedPlayer1 = "Player 1";
        String outputPlayer2 = output.substring(276, 284);
        String expectedPlayer2 = "Player 2";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);

    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePointsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "paul gries", "player 2",
                "player 3", "20202021", "points"));
        String fail = this.hockeyPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePointsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "player 1", "player 2",
                "player 3", "20192020", "points"));
        String fail = this.hockeyPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteShotsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "player 1", "player 2",
                "player 3", "20202021", "shots"));
        String output = this.hockeyPlayerStatComparer.execute(arguments, container);
        String outputPlayer2 = output.substring(176, 184);
        String expectedPlayer2 = "Player 2";
        String outputPlayer3 = output.substring(226, 234);
        String expectedPlayer3 = "Player 3";
        String outputPlayer1 = output.substring(276, 284);
        String expectedPlayer1 = "Player 1";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShotsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "paul gries", "player 2",
                "player 3", "20202021", "shots"));
        String fail = this.hockeyPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 200, expected = Exception.class)
    public void testExecuteShotsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "player 1", "player 2",
                "player 3", "20192020", "shots"));
        String fail = this.hockeyPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteShootingPercentagePasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "player 1", "player 2",
                "player 3", "20202021", "shooting percentage"));
        String output = this.hockeyPlayerStatComparer.execute(arguments, container);
        String outputPlayer2 = output.substring(176, 184);
        String expectedPlayer2 = "Player 2";
        String outputPlayer1 = output.substring(226, 234);
        String expectedPlayer1 = "Player 1";
        String outputPlayer3 = output.substring(276, 284);
        String expectedPlayer3 = "Player 3";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShootingPercentageNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "paul gries", "player 2",
                "player 3", "20202021", "shooting percentage"));
        String fail = this.hockeyPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShootingPercentageNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "player 1", "player 2",
                "player 3", "20192020", "shooting percentage"));
        String fail = this.hockeyPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("hockey", "player 1", "player 2",
                "player 3", "20202021", "name"));
        String fail = this.hockeyPlayerStatComparer.execute(arguments, container);
    }
}