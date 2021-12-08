package sports.baseball;

import driversAdapters.CSVDataContainer;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BaseballPlayerStatPredictorTest {
    BaseballPlayerStatPredictor baseballPlayerStatPredictor;
    CSVDataContainer container;
    BaseballPlayer player;

    @Before
    public void setUp() throws Exception {
        container = new CSVDataContainer();
        baseballPlayerStatPredictor = new BaseballPlayerStatPredictor();
        player = new BaseballPlayer("Player 1", "2020-2021", "BOS", "2B", 43,
                35, 24, 19, 488, 58, 25, 0.345);
        player.addRecord("2019-2020", "BOS", "3B", 294, 39, 38,
                58, 56, 84, 39, 0.483);
        player.addRecord("2018-2019", "BOS", "3B", 39, 48, 39,
                56, 93, 48, 24, 0.234);
        player.addRecord("2017-2018", "BOS", "3B", 49, 30, 56, 39,
        49, 58, 27, 0.673);

        container.playerMap.put(player.getName(), player);
    }

    @Test(timeout = 100)
    public void executeAtBatsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Baseball", "Player 1", "at bats"));
        String output = baseballPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(291)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "39.5";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAtBatsNoPlayer() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Baseball",
                "player 2", "at bats"));
        String fail = this.baseballPlayerStatPredictor.execute(arguments1, container);
    }

    @Test(timeout = 100)
    public void executeRunsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Baseball", "Player 1", "runs"));
        String output = baseballPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(291)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "15";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRunsNoPlayer() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Baseball",
                "player 2", "runs"));
        String fail = this.baseballPlayerStatPredictor.execute(arguments1, container);
    }

    @Test(timeout = 100)
    public void executeHitsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Baseball", "Player 1", "hits"));
        String output = baseballPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(291)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "28.5";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteHitsNoPlayer() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Baseball",
                "player 2", "hits"));
        String fail = this.baseballPlayerStatPredictor.execute(arguments1, container);
    }

    @Test(timeout = 100)
    public void executeHomeRunsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Baseball", "Player 1", "home runs"));
        String output = baseballPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(290)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "491.5";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteHomeRunsNoPlayer() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Baseball",
                "player 2", "home runs"));
        String fail = this.baseballPlayerStatPredictor.execute(arguments1, container);
    }

    @Test(timeout = 100)
    public void executeRunsBattedInPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Baseball", "Player 1", "runs batted in"));
        String output = baseballPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(291)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "71";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteRunsBattedInNoPlayer() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Baseball",
                "player 2", "runs batted in"));
        String fail = this.baseballPlayerStatPredictor.execute(arguments1, container);
    }

    @Test(timeout = 100)
    public void executeStrikeOutsPasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Baseball", "Player 1", "strike outs"));
        String output = baseballPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(291)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "31";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteStrikeOutsNoPlayer() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Baseball",
                "player 2", "strike outs"));
        String fail = this.baseballPlayerStatPredictor.execute(arguments1, container);
    }

    @Test(timeout = 100)
    public void executeAveragePasses() throws Exception {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList("Baseball", "Player 1", "average"));
        String output = baseballPlayerStatPredictor.execute(arguments, container);
        BigDecimal outputValue = new BigDecimal(output.substring(292)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "0.25";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAverageNoPlayer() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Baseball",
                "player 2", "average"));
        String fail = this.baseballPlayerStatPredictor.execute(arguments1, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Baseball",
                "player 1", "aces"));
        String fail = this.baseballPlayerStatPredictor.execute(arguments1, container);
    }








}
