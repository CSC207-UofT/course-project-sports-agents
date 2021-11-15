package commands;

import drivers_adapters.CSVDataContainer;
import drivers_adapters.DataContainer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import player.TennisPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TennisPlayerStatManagerTest {
    TennisPlayerStatManager tennisPlayerStatManager;
    DataContainer container;

    @Before
    public void setUp() throws Exception {
        tennisPlayerStatManager = new TennisPlayerStatManager();
        TennisPlayer player1 = new TennisPlayer("Player 1", "CAN",
                "20202021", 20, 20, 15, 15,
                10, 10);
        TennisPlayer player2 = new TennisPlayer("Player 2", "CAN",
                "20202021", 20, 15, 20, 10,
                15, 20);
        TennisPlayer player3 = new TennisPlayer("Player 3", "CAN",
                "20202021", 20, 10, 10, 20,
                20, 15);

        CSVDataContainer container = new CSVDataContainer();
        container.playerMap.put("Player 1", player1);
        container.playerMap.put("Player 2", player2);
        container.playerMap.put("Player 3", player3);
        this.container = container;
    }

    @Test(timeout = 100)
    public void testExecuteAgePasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat",
                "Tennis", "Player 1", "20202021", "Age");
        String output1 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments1, container);
        String expected1 = "Player 1: 20";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat",
                "Tennis", "Player 2", "20202021", "Age");
        String output2 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments2, container);
        String expected2 = "Player 2: 20";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat",
                "Tennis", "Player 3", "20202021", "Age");
        String output3 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments3, container);
        String expected3 = "Player 3: 20";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAgeNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat",
                "Tennis", "Paul Gries", "20202021", "Age");
        String fail = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAgeNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat",
                "Tennis", "Player 1", "20192020", "Age");
        String fail = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteAcesPasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat",
                "Tennis", "Player 1", "20202021", "Aces");
        String output1 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments1, container);
        String expected1 = "Player 1: 20";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat",
                "Tennis", "Player 2", "20202021", "Aces");
        String output2 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments2, container);
        String expected2 = "Player 2: 15";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat",
                "Tennis", "Player 3", "20202021", "Aces");
        String output3 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments3, container);
        String expected3 = "Player 3: 10";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat",
                "Tennis", "Paul Gries", "20202021", "Aces");
        String fail = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat",
                "Tennis", "Player 1", "20192020", "Aces");
        String fail = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteDoubleFaultsPasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat",
                "Tennis", "Player 1", "20202021", "Double Faults");
        String output1 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments1, container);
        String expected1 = "Player 1: 15";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat",
                "Tennis", "Player 2", "20202021", "Double Faults");
        String output2 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments2, container);
        String expected2 = "Player 2: 20";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat",
                "Tennis", "Player 3", "20202021", "Double Faults");
        String output3 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments3, container);
        String expected3 = "Player 3: 10";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat",
                "Tennis", "Paul Gries", "20202021", "Double Faults");
        String fail = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat",
                "Tennis", "Player 1", "20192020", "Double Faults");
        String fail = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteServePointsPasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat",
                "Tennis", "Player 1", "20202021", "Serve Points");
        String output1 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments1, container);
        String expected1 = "Player 1: 15";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat",
                "Tennis", "Player 2", "20202021", "Serve Points");
        String output2 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments2, container);
        String expected2 = "Player 2: 10";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat",
                "Tennis", "Player 3", "20202021", "Serve Points");
        String output3 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments3, container);
        String expected3 = "Player 3: 20";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteServePointsNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat",
                "Tennis", "Paul Gries", "20202021", "Serve Points");
        String fail = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteServePointsNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat",
                "Tennis", "Player 1", "20192020", "Serve Points");
        String fail = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteFirstServesPasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat",
                "Tennis", "Player 1", "20202021", "First Serves");
        String output1 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments1, container);
        String expected1 = "Player 1: 10";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat",
                "Tennis", "Player 2", "20202021", "First Serves");
        String output2 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments2, container);
        String expected2 = "Player 2: 15";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat",
                "Tennis", "Player 3", "20202021", "First Serves");
        String output3 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments3, container);
        String expected3 = "Player 3: 20";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteFirstServesNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat",
                "Tennis", "Paul Gries", "20202021", "First Serves");
        String fail = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteFirstServesNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat",
                "Tennis", "Player 1", "20192020", "First Serves");
        String fail = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteBreakPointsSavedPointsPasses() throws Exception {
        List<String> arguments1 = Arrays.asList("get_player_stat",
                "Tennis", "Player 1", "20202021", "Break Points Saved");
        String output1 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments1, container);
        String expected1 = "Player 1: 10";
        assertEquals(expected1, output1);

        List<String> arguments2 = Arrays.asList("get_player_stat",
                "Tennis", "Player 2", "20202021", "Break Points Saved");
        String output2 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments2, container);
        String expected2 = "Player 2: 20";
        assertEquals(expected2, output2);

        List<String> arguments3 = Arrays.asList("get_player_stat",
                "Tennis", "Player 3", "20202021", "Break Points Saved");
        String output3 = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments3, container);
        String expected3 = "Player 3: 15";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoPlayer() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat",
                "Tennis", "Paul Gries", "20202021", "Break Points Saved");
        String fail = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoSeason() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat",
                "Tennis", "Player 1", "20192020", "Break Points Saved");
        String fail = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        List<String> arguments = Arrays.asList("get_player_stat",
                "Tennis", "Player 1", "20192020", "Goals");
        String fail = this.tennisPlayerStatManager.execute((ArrayList<String>) arguments, container);
    }
}