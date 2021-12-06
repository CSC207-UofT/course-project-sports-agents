package sports.tennis;

import driversAdapters.CSVDataContainer;
import driversAdapters.DataContainer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TennisPlayerStatManagerTest {
    TennisPlayerStatManager tennisPlayerStatManager;
    DataContainer container;

    @Before
    public void setUp() throws Exception {
        tennisPlayerStatManager = new TennisPlayerStatManager();
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
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "2018", "aces"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                           "      Name                 aces \n" +
                           "-------------------------------------------\n" +
                           "The Greatest 1         20 \n" +
                           "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Tennis",
                "player 2", "2018", "aces"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                           "      Name                 aces \n" +
                           "-------------------------------------------\n" +
                           "The Greatest 2         12 \n" +
                           "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("tennis",
                "player 3", "2018", "aces"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                           "      Name                 aces \n" +
                           "-------------------------------------------\n" +
                           " The Worst         10 \n" +
                           "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul gries", "2018", "aces"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "20192020", "aces"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteDoubleFaultsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "2018", "double faults"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                           "      Name        double faults \n" +
                           "-------------------------------------------\n" +
                           "The Greatest 1         11 \n" +
                           "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("tennis",
                "player 2", "2018", "double faults"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                           "      Name        double faults \n" +
                           "-------------------------------------------\n" +
                           "The Greatest 2         17 \n" +
                           "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("tennis",
                "player 3", "2018", "double faults"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                           "      Name        double faults \n" +
                           "-------------------------------------------\n" +
                           " The Worst         23 \n" +
                           "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul gries", "2018", "double faults"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "20192020", "double faults"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteServePointsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "2018", "serve points won"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                           "      Name     serve points won \n" +
                           "-------------------------------------------\n" +
                           "The Greatest 1       64.0 \n" +
                           "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("tennis",
                "player 2", "2018", "serve points won"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                           "      Name     serve points won \n" +
                           "-------------------------------------------\n" +
                           "The Greatest 2       56.0 \n" +
                           "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("tennis",
                "player 3", "2018", "serve points won"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                           "      Name     serve points won \n" +
                           "-------------------------------------------\n" +
                           " The Worst       54.0 \n" +
                           "-------------------------------------------";
        assertEquals(expected3, output3);
    }


    @Test(timeout = 100)
    public void testExecuteBreakPointsSavedPointsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "2018", "break points saved"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String expected1 = "-------------------------------------------\n" +
                           "      Name   break points saved \n" +
                           "-------------------------------------------\n" +
                           "The Greatest 1       69.0 \n" +
                           "-------------------------------------------";
        assertEquals(expected1, output1);

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("tennis",
                "player 2", "2018", "break points saved"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        String expected2 = "-------------------------------------------\n" +
                           "      Name   break points saved \n" +
                           "-------------------------------------------\n" +
                           "The Greatest 2       67.0 \n" +
                           "-------------------------------------------";
        assertEquals(expected2, output2);

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("tennis",
                "player 3", "2018", "break points saved"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        String expected3 = "-------------------------------------------\n" +
                           "      Name   break points saved \n" +
                           "-------------------------------------------\n" +
                           " The Worst       10.0 \n" +
                           "-------------------------------------------";
        assertEquals(expected3, output3);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul gries", "2018", "break points saved"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "20192020", "break points saved"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "20192020", "goals"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }
}