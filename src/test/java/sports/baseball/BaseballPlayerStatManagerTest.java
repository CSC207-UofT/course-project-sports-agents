package sports.baseball;

import driversAdapters.CSVDataContainer;
import driversAdapters.DataContainer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BaseballPlayerStatManagerTest {
    private BaseballPlayerStatManager baseballPlayerStatManager;
    private DataContainer container;

    @Before
    public void setUp() throws Exception {
        BaseballPlayer player1 = new BaseballPlayer("Player 1", "2020-2021", "Red Team",
                "C", 20, 50, 25, 10, 2, 5,
                3, 0.207);
        CSVDataContainer container = new CSVDataContainer();
        container.playerMap.put(player1.getName().toLowerCase(), player1);
        this.container = container;
        baseballPlayerStatManager = new BaseballPlayerStatManager();
    }

    @Test
    public void testExecuteTeam() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("baseball", "player 1",
                "2020-2021", "team"));
        String output = baseballPlayerStatManager.execute(command, container);
        String outputSub = output.substring(134, 142);
        String expected = "Red Team";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecutePosition() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("baseball", "player 1",
                "2020-2021", "position"));
        String output = baseballPlayerStatManager.execute(command, container);
        String outputSub = output.substring(141, 142);
        String expected = "C";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteGamesPlayed() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("baseball", "player 1",
                "2020-2021", "games played"));
        String output = baseballPlayerStatManager.execute(command, container);
        String outputSub = output.substring(140, 142);
        String expected = "20";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteAtBats() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("baseball", "player 1",
                "2020-2021", "at bats"));
        String output = baseballPlayerStatManager.execute(command, container);
        String outputSub = output.substring(140, 142);
        String expected = "50";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteRuns() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("baseball", "player 1",
                "2020-2021", "runs"));
        String output = baseballPlayerStatManager.execute(command, container);
        String outputSub = output.substring(140, 142);
        String expected = "25";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteHits() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("baseball", "player 1",
                "2020-2021", "hits"));
        String output = baseballPlayerStatManager.execute(command, container);
        String outputSub = output.substring(140, 142);
        String expected = "10";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteHomeRuns() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("baseball", "player 1",
                "2020-2021", "home runs"));
        String output = baseballPlayerStatManager.execute(command, container);
        String outputSub = output.substring(141, 142);
        String expected = "2";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteRunsBattedIn() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("baseball", "player 1",
                "2020-2021", "runs batted in"));
        String output = baseballPlayerStatManager.execute(command, container);
        String outputSub = output.substring(141, 142);
        String expected = "5";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteStrikeOuts() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("baseball", "player 1",
                "2020-2021", "strike outs"));
        String output = baseballPlayerStatManager.execute(command, container);
        String outputSub = output.substring(141, 142);
        String expected = "3";
        assertEquals(expected, outputSub);
    }

    @Test
    public void testExecuteAverage() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("baseball", "player 1",
                "2020-2021", "average"));
        String output = baseballPlayerStatManager.execute(command, container);
        String outputSub = output.substring(137, 142);
        String expected = "0.207";
        assertEquals(expected, outputSub);
    }

    @Test(expected = Exception.class)
    public void testExecuteInvalidCommand() throws Exception {
        ArrayList<String> command = new ArrayList<>(Arrays.asList("baseball", "player 1",
                "2020-2021", "teammates"));
        baseballPlayerStatManager.execute(command, container);
    }
}