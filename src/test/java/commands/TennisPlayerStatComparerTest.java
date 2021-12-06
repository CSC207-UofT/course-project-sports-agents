package commands;

import driversAdapters.CSVDataContainer;
import driversAdapters.DataContainer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import player.TennisPlayer;
import sports.tennis.TennisPlayerStatComparer;

import java.util.ArrayList;
import java.util.Arrays;

public class TennisPlayerStatComparerTest {
    TennisPlayerStatComparer tennisPlayerStatComparer;
    DataContainer container;

    @Before
    public void setUp() throws Exception {
        this.tennisPlayerStatComparer = new TennisPlayerStatComparer();
        TennisPlayer player1 = new TennisPlayer("The Greatest 1", "CAN","2018",
                1, 3, 20, 11, 64.0, 69.0,
                85.0, 35.0, 35.0, 43.0);
        TennisPlayer player2 = new TennisPlayer("The Greatest 2", "USA", "2018",
                20, 2, 12, 17, 56.0, 67.0,
                81.0, 23.0, 32.0, 33.0);
        TennisPlayer player3 = new TennisPlayer("The Worst", "ENG", "2018",
                30, 1, 10, 23, 54.0, 10.0,
                32.0, 10.0, 8.0, 9.0);
        CSVDataContainer container = new CSVDataContainer();
        container.playerMap.put("player 1", player1);
        container.playerMap.put("player 2", player2);
        container.playerMap.put("player 3", player3);
        this.container = container;

    }

    @Test(timeout = 100)
    public void testExecuteAcesPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2018", "aces"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String expected = "-----------------------------------------------------\n" +
                          " Rank                 Name                 aces \n" +
                          "-----------------------------------------------------\n" +
                          "    1       The Greatest 1                   20 \n" +
                          "    2       The Greatest 2                   12 \n" +
                          "    3            The Worst                   10 \n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul Gries", "player 2", "player 3", "2018", "aces"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "20192020", "aces"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteDoubleFaultsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2018", "double faults"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String expected = "-----------------------------------------------------\n" +
                          " Rank                 Name        double faults \n" +
                          "-----------------------------------------------------\n" +
                          "    1            The Worst                   23 \n" +
                          "    2       The Greatest 2                   17 \n" +
                          "    3       The Greatest 1                   11 \n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul gries", "player 2", "player 3", "2018", "double faults"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "20192020", "double faults"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteBreakPointsSavedPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2018", "break points saved"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String expected = "-----------------------------------------------------\n" +
                          " Rank                 Name   break points saved \n" +
                          "-----------------------------------------------------\n" +
                          "    1       The Greatest 1                 69.0 \n" +
                          "    2       The Greatest 2                 67.0 \n" +
                          "    3            The Worst                 10.0 \n";
        assertEquals(expected, output);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul Gries", "player 2", "player 3", "2018", "break points saved"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "20192020", "break points saved"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2018", "goals"));
        String fail = this.tennisPlayerStatComparer.execute(arguments, container);
    }

}