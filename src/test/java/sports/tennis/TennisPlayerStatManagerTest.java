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
    CSVDataContainer container;

    @Before
    public void setUp() throws Exception {
        tennisPlayerStatManager = new TennisPlayerStatManager();
        this.container = new CSVDataContainer();

        TennisPlayer player1 = new TennisPlayer("player 1", "Canada", "2016",
                1, 5, 6, 7, 0.65, 0.8, 14.5,
                16.0, 17.0, 18.0);
        TennisPlayer player2 = new TennisPlayer("player 2", "England", "2016",
                2, 6, 15, 13, 0.33, 29.5, 34.2,
                23.3, 27.2, 21.6);
        TennisPlayer player3 = new TennisPlayer("player 3", "France", "2016",
                3, 18, 3, 8, 0.89, 30.0, 9.6,
                17.3, 16.5, 22.0);

        container.playerMap.put(player1.getName(), player1);
        container.playerMap.put(player2.getName(), player2);
        container.playerMap.put(player3.getName(), player3);

    }

    @Test(timeout = 100)
    public void testExecuteRankPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "player 2", "2016", "Rank"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        char outputChar1 = output1.charAt(142);
        char expected1 = '2';
        assertEquals(expected1, outputChar1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRankNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2020", "Rank"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRankNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "2020", "Rank"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteAcesPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "player 1", "2016", "Aces"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        char outputChar1 = output1.charAt(142);
        char expected1 = '6';
        assertEquals(expected1, outputChar1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2016", "Aces"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "2020", "Aces"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteDoubleFaultsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "player 2", "2016", "Double Faults"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(141, 143);
        String expected1 = "13";
        assertEquals(expected1, outputSub1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2016", "Double Faults"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "1990", "Double Faults"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteServePointsWonPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "player 3", "2016", "Serve Points won"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(139, 143);
        String expected1 = "0.89";
        assertEquals(expected1, outputSub1);
    }


    @Test(timeout = 100)
    public void testExecuteBreakPointsSavedPointsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "player 1", "2016", "Break Points Saved"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(140, 143);
        String expected1 = "0.8";
        assertEquals(expected1, outputSub1);

    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "20202021", "Break Points Saved"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "20192020", "Break Points Saved"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "20192020", "Goals"));
        String fail = this.tennisPlayerStatManager.execute(arguments, container);
    }
}