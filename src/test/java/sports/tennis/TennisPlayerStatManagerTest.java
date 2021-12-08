package sports.tennis;

import driversAdapters.CSVDataContainer;
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
        String outputSub1 = output1.substring(142, 143);
        String expected1 = "2";
        assertEquals(expected1, outputSub1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRankNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2020", "Rank"));
        this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRankNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "2020", "Rank"));
        this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteAcesPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "player 1", "2016", "Aces"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(142, 143);
        String expected1 = "6";
        assertEquals(expected1, outputSub1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Paul Gries", "2016", "Aces"));
        this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "2020", "Aces"));
        this.tennisPlayerStatManager.execute(arguments, container);
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
        this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "1990", "Double Faults"));
        this.tennisPlayerStatManager.execute(arguments, container);
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
        this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "20192020", "Break Points Saved"));
        this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Tennis",
                "Player 1", "20192020", "Goals"));
        this.tennisPlayerStatManager.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteCountryPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "player 1", "2016", "country"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(137, 143);
        String expected1 = "Canada";
        assertEquals(expected1, outputSub1);
    }

    @Test(timeout = 100)
    public void testExecuteMatchesPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "player 1", "2016", "matches"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(142, 143);
        String expected1 = "5";
        assertEquals(expected1, outputSub1);
    }

    @Test(timeout = 100)
    public void testExecuteServeGamesWonPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "player 1", "2016", "serve games won"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(139, 143);
        String expected1 = "14.5";
        assertEquals(expected1, outputSub1);
    }

    @Test(timeout = 100)
    public void testExecuteReturnGamesWonPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "player 1", "2016", "return games won"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(139, 143);
        String expected1 = "16.0";
        assertEquals(expected1, outputSub1);
    }

    @Test(timeout = 100)
    public void testExecuteBreakPointsConvertedPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "player 1", "2016", "break points converted"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(141, 145);
        String expected1 = "17.0";
        assertEquals(expected1, outputSub1);
    }

    @Test(timeout = 100)
    public void testExecuteReturnPointsWonPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "player 1", "2016", "return points won"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        String outputSub1 = output1.substring(139, 143);
        String expected1 = "18.0";
        assertEquals(expected1, outputSub1);
    }

    @Test(timeout = 100)
    public void testExecuteWithPlayersInCsvFile() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Tennis",
                "Barbora Krejcikova", "2016", "country"));
        String output1 = this.tennisPlayerStatManager.execute(arguments1, container);
        assertTrue(output1.contains("Barbora Krejcikova"));
        assertTrue(output1.contains("CZE"));

        ArrayList<String> arguments2 = new ArrayList<>(Arrays.asList("Tennis",
                "Naomi Osaka", "2016", "rank"));
        String output2 = this.tennisPlayerStatManager.execute(arguments2, container);
        assertTrue(output2.contains("Naomi Osaka"));
        assertTrue(output2.contains("13"));

        ArrayList<String> arguments3 = new ArrayList<>(Arrays.asList("Tennis",
                "Angelique Kerber", "2016", "aces"));
        String output3 = this.tennisPlayerStatManager.execute(arguments3, container);
        assertTrue(output3.contains("Angelique Kerber"));
        assertTrue(output3.contains("104"));
    }
}