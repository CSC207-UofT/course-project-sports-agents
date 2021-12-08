package sports.tennis;

import driversAdapters.CSVDataContainer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TennisPlayerStatComparerTest {
    TennisPlayerStatComparer tennisPlayerStatComparer;
    CSVDataContainer container;

    @Before
    public void setUp() throws Exception {
        this.tennisPlayerStatComparer = new TennisPlayerStatComparer();
        this.container = new CSVDataContainer();

        TennisPlayer player1 = new TennisPlayer("Player 1", "CAN", "2016",
                1, 5, 6, 7, 65.0, 80.0, 14.5,
                16.0, 17.0, 18.0);
        TennisPlayer player2 = new TennisPlayer("Player 2", "GBR", "2016",
                2, 6, 15, 13, 33.0, 29.5, 34.2,
                23.3, 27.2, 21.6);
        TennisPlayer player3 = new TennisPlayer("Player 3", "FRA", "2016",
                3, 18, 3, 8, 89.0, 30.0, 9.6,
                17.3, 16.5, 22.0);

        container.playerMap.put(player1.getName().toLowerCase(), player1);
        container.playerMap.put(player2.getName().toLowerCase(), player2);
        container.playerMap.put(player3.getName().toLowerCase(), player3);
    }

    @Test(timeout = 100)
    public void testExecuteRankPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2016", "rank"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String outputPlayer1 = output.substring(175, 183);
        String expectedPlayer1 = "Player 1";
        String outputPlayer2 = output.substring(224, 232);
        String expectedPlayer2 = "Player 2";
        String outputPlayer3 = output.substring(273, 281);
        String expectedPlayer3 = "Player 3";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRankNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul gries", "player 1", "player 2", "2016", "rank"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRankNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2040", "rank"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteMatchesPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2016", "matches"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String outputPlayer1 = output.substring(175, 183);
        String expectedPlayer1 = "Player 3";
        String outputPlayer2 = output.substring(224, 232);
        String expectedPlayer2 = "Player 2";
        String outputPlayer3 = output.substring(273, 281);
        String expectedPlayer3 = "Player 1";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteMatchesNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul gries", "player 1", "player 2", "2016", "matches"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteMatchesNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2040", "matches"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }


    @Test(timeout = 100)
    public void testExecuteAcesPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2016", "aces"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String outputPlayer2 = output.substring(175, 183);
        String expectedPlayer2 = "Player 2";
        String outputPlayer1 = output.substring(224, 232);
        String expectedPlayer1 = "Player 1";
        String outputPlayer3 = output.substring(273, 281);
        String expectedPlayer3 = "Player 3";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul gries", "player 1", "player 2", "2016", "aces"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2040", "aces"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteDoubleFaultsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2016", "double faults"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String outputPlayer2 = output.substring(175, 183);
        String expectedPlayer2 = "Player 1";
        String outputPlayer1 = output.substring(224, 232);
        String expectedPlayer1 = "Player 3";
        String outputPlayer3 = output.substring(273, 281);
        String expectedPlayer3 = "Player 2";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul gries", "player 2", "player 3", "2016", "double faults"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2040", "double faults"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteServePointsWonPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2016", "serve points won"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String outputPlayer3 = output.substring(175, 183);
        String expectedPlayer3 = "Player 3";
        String outputPlayer1 = output.substring(224, 232);
        String expectedPlayer1 = "Player 1";
        String outputPlayer2 = output.substring(273, 281);
        String expectedPlayer2 = "Player 2";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteServePointsWonNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul gries", "player 2", "player 3", "2016", "serve points won"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteServePointsWonNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2040", "serve points won"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteBreakPointsSavedPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2016", "break points saved"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String outputPlayer1 = output.substring(175, 183);
        String expectedPlayer1 = "Player 1";
        String outputPlayer3 = output.substring(224, 232);
        String expectedPlayer3 = "Player 3";
        String outputPlayer2 = output.substring(273, 281);
        String expectedPlayer2 = "Player 2";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul gries", "player 2", "player 3", "2016", "break points saved"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2040", "break points saved"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteServeGamesWonPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2016", "serve games won"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String outputPlayer1 = output.substring(175, 183);
        String expectedPlayer1 = "Player 2";
        String outputPlayer2 = output.substring(224, 232);
        String expectedPlayer2 = "Player 1";
        String outputPlayer3 = output.substring(273, 281);
        String expectedPlayer3 = "Player 3";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteServeGamesWonNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul gries", "player 2", "player 3", "2016", "serve games won"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteServeGamesWonNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2040", "serve games won"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteReturnGamesWonPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2016", "return games won"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String outputPlayer2 = output.substring(175, 183);
        String expectedPlayer2 = "Player 2";
        String outputPlayer3 = output.substring(224, 232);
        String expectedPlayer3 = "Player 3";
        String outputPlayer1 = output.substring(273, 281);
        String expectedPlayer1 = "Player 1";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteReturnGamesWonNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul gries", "player 2", "player 3", "2016", "return games won"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteReturnGamesWonNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2040", "return games won"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteBreakPointsConvertedPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2016", "break points converted"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String outputPlayer2 = output.substring(177, 185);
        String expectedPlayer2 = "Player 2";
        String outputPlayer1 = output.substring(226, 234);
        String expectedPlayer1 = "Player 1";
        String outputPlayer3 = output.substring(275, 283);
        String expectedPlayer3 = "Player 3";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsConvertedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul gries", "player 2", "player 3", "2016", "break points converted"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsConvertedNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2040", "break points converted"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteReturnPointsWonPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2016", "return points won"));
        String output = this.tennisPlayerStatComparer.execute(arguments, container);
        String outputPlayer3 = output.substring(175, 183);
        String expectedPlayer3 = "Player 3";
        String outputPlayer2 = output.substring(224, 232);
        String expectedPlayer2 = "Player 2";
        String outputPlayer1 = output.substring(273, 281);
        String expectedPlayer1 = "Player 1";

        assertEquals(expectedPlayer3, outputPlayer3);
        assertEquals(expectedPlayer2, outputPlayer2);
        assertEquals(expectedPlayer1, outputPlayer1);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteReturnPointsWonNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "paul gries", "player 2", "player 3", "2016", "return points won"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteReturnPointsWonNoSeason() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "player 1", "player 2", "player 3", "2040", "return points won"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis",
                "Jasmine Paolini", "Madison Brengle", "Anastasia Potapova", "2017", "goals"));
        this.tennisPlayerStatComparer.execute(arguments, container);
    }

}