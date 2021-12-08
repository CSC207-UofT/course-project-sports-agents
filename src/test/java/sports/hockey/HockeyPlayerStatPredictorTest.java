package sports.hockey;

import driversAdapters.CSVDataContainer;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class HockeyPlayerStatPredictorTest {
    HockeyPlayerStatPredictor hockeyPlayerStatPredictor;
    CSVDataContainer container;

    @Before
    public void setUp() throws Exception {
        this.container = new CSVDataContainer();
        HockeyPlayer player = new HockeyPlayer("Player 1", "2020-2021", "TOR",
                "L", "C", 52, 41, 25, 66,
                222, 18.5);
        player.addRecord("2019-2020", "EDM", "L", "C",
                56, 33, 72, 105, 200, 16.5);
        player.addRecord("2017-2018", "TOR", "L", "C", 34, 43,
                24, 84, 34, 56.0);
        player.addRecord("2016-2017", "TOR", "L", "C", 45,
                68, 29, 184, 58, 28.3);

        this.hockeyPlayerStatPredictor = new HockeyPlayerStatPredictor();
        CSVDataContainer container = new CSVDataContainer();
        container.playerMap.put("player 1", player);
        this.container = container;
    }

    @Test(timeout = 200)
    public void testExecuteGoalsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "player 1", "goals"));
        String output = this.hockeyPlayerStatPredictor.execute(arguments1, container);
        BigDecimal outputValue = new BigDecimal(output.substring(291)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "23.5";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteGoalsNoPlayer() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "player 2", "goals"));
        this.hockeyPlayerStatPredictor.execute(arguments1, container);
    }

    @Test(timeout = 200)
    public void testExecuteAssistsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "player 1", "assists"));
        String output = this.hockeyPlayerStatPredictor.execute(arguments1, container);
        BigDecimal outputValue = new BigDecimal(output.substring(291)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "46.5";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteAssistsNoPlayer() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "player 2", "assists"));
        this.hockeyPlayerStatPredictor.execute(arguments1, container);
    }

    @Test(timeout = 200)
    public void testExecutePointsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "player 1", "points"));
        String output = this.hockeyPlayerStatPredictor.execute(arguments1, container);
        BigDecimal outputValue = new BigDecimal(output.substring(291)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "26.5";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecutePointsNoPlayer() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "player 2", "points"));
        this.hockeyPlayerStatPredictor.execute(arguments1, container);
    }


    @Test(timeout = 200)
    public void testExecuteShotsPasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "player 1", "shots"));
        String output = this.hockeyPlayerStatPredictor.execute(arguments1, container);
        BigDecimal outputValue = new BigDecimal(output.substring(290)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "293";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShotsNoPlayer() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "player 2", "shots"));
        this.hockeyPlayerStatPredictor.execute(arguments1, container);
    }

    @Test(timeout = 200)
    public void testExecuteShootingPercentagePasses() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "player 1", "shooting percentage"));
        String output = this.hockeyPlayerStatPredictor.execute(arguments1, container);
        BigDecimal outputValue = new BigDecimal(output.substring(291)).stripTrailingZeros();
        String actual = outputValue.toString();
        String expected = "12.6";
        assertEquals(expected, actual);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteShootingPercentageNoPlayer() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "player 2", "shooting percentage"));
        this.hockeyPlayerStatPredictor.execute(arguments1, container);
    }

    @Test(timeout = 100, expected = Exception.class)
    public void testExecuteInvalidStat() throws Exception {
        ArrayList<String> arguments1 = new ArrayList<>(Arrays.asList("Hockey",
                "player 1", "aces"));
        this.hockeyPlayerStatPredictor.execute(arguments1, container);
    }


}
