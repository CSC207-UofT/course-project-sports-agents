package sports.tennis;

import driversAdapters.CSVDataContainer;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TennisPlayerStatPredictorTest {
    TennisPlayerStatPredictor tennisPlayerStatPredictor;
    CSVDataContainer container;
    TennisPlayer player;

    @Before
    public void setUp() throws Exception {
        tennisPlayerStatPredictor = new TennisPlayerStatPredictor();
        container = new CSVDataContainer();
        player = new TennisPlayer("Player 1", "USA", "2016", 1, 5, 6,
                7, 65.0, 80.0, 14.5,
                16.0, 17.8, 18.0 );
        player.addRecord("2017", 3, 30, 28, 48, 45.0,
                35.6, 45.4, 34.5, 67.8,
                30.3);
        player.addRecord("2018", 2, 39, 49, 38, 54.6,
                39.3, 83.2, 35.3, 59.4,
                56.3);
        player.addRecord("2019", 1, 34, 95, 34, 29.3,
                49.5, 79.3, 59.4, 90.1,
                39.3);
        container.playerMap.put("player 1", player);
    }

    @Test(timeout = 100)
    public void testExecuteRankPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 1", "rank"));
        String output = this.tennisPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(292)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "1.5";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRankNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 2", "rank"));
        String fail = this.tennisPlayerStatPredictor.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteAcesPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 1", "aces"));
        String output = this.tennisPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(290)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "116.5";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAcesNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 2", "aces"));
        String fail = this.tennisPlayerStatPredictor.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteDoubleFaultsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 1", "double faults"));
        String output = this.tennisPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(291)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "49.5";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteDoubleFaultsNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 2", "double faults"));
        String fail = this.tennisPlayerStatPredictor.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteServePointsWonPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 1", "serve points won"));
        String output = this.tennisPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(291)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "24.1";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteServePointsWonNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 2", "serve points won"));
        String fail = this.tennisPlayerStatPredictor.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteBreakPointsSavedPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 1", "break points saved"));
        String output = this.tennisPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(291)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "29.15";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsSavedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 2", "break points saved"));
        String fail = this.tennisPlayerStatPredictor.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteServeGamesWonPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 1", "serve games won"));
        String output = this.tennisPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(290)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "113.65";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteServeGamesWonNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 2", "serve games won"));
        String fail = this.tennisPlayerStatPredictor.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteReturnGamesWonPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 1", "return games won"));
        String output = this.tennisPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(291)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "69.05";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteReturnGamesWonNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 2", "return games won"));
        String fail = this.tennisPlayerStatPredictor.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteBreakPointsConvertedPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 1", "break points converted"));
        String output = this.tennisPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(292)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "110.9";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteBreakPointsConvertedNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 2", "break points converted"));
        String fail = this.tennisPlayerStatPredictor.execute(arguments, container);
    }

    @Test(timeout = 100)
    public void testExecuteReturnPointsWonPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 1", "return points won"));
        String output = this.tennisPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(291)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "58.45";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteReturnPointsWonNoPlayer() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 2", "return points won"));
        String fail = this.tennisPlayerStatPredictor.execute(arguments, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("tennis", "player 1", "goals"));
        String fail = this.tennisPlayerStatPredictor.execute(arguments, container);
    }
}
